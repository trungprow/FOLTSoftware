/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.JdbcHelper;
import MODEL.Luong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class LuongDAO {
    
    public void insert(Luong model) {
        String sql = "INSERT INTO luong(MaLuong, MaNV, heSoLuong, luongCoBan, tongLuong) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaLuong(),
                model.getMaNV(),
                model.getHeSoluong(),
                model.getLuongCoBan(),
                model.getTongLuong()
        );
    }
    
    public void update(Luong model) {
        String sql = "UPDATE luong SET MaNV=?, heSoLuong=?, luongCoBan=?, tongLuong=? WHERE MaLuong=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaNV(),
                model.getHeSoluong(),
                model.getLuongCoBan(),
                model.getTongLuong(),
                model.getMaLuong()
        );
    }
    
    public void delete(String MaLuong) {
        String sql = "DELETE FROM luong WHERE MaLuong=?";
        JdbcHelper.executeUpdate(sql, MaLuong);
    }
    
    public List<Luong> select() {
        String sql = "SELECT * FROM luong";
        return select(sql);
    }
    
    public Luong findById(String MaLuong) {
        String sql = "SELECT * FROM luong WHERE MaLuong=?";
        List<Luong> list = select(sql, MaLuong);
        return list.size() > 0 ? list.get(0) : null;
    }
    public List<Luong> find(String tk){
        String sql = "select * from nhanVien nv, hopDong hd, luong l where nv.Username = ? and nv.MaNV = hd.MaNV and nv.MaNV = l.MaNV";
        return select2(sql, tk);
    }
    
    private List<Luong> select(String sql, Object... args) {
        List<Luong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Luong model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
      private List<Luong> select2(String sql, Object... args) {
        List<Luong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Luong model = readFromResultSet2(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    private Luong readFromResultSet(ResultSet rs) throws SQLException {
        Luong model = new Luong();
        model.setMaLuong(rs.getString("MaLuong"));
        model.setMaNV(rs.getString("MaNV"));
        model.setHeSoluong(rs.getFloat("heSoLuong"));
        model.setLuongCoBan(rs.getFloat("luongCoBan"));
        model.setTongLuong(rs.getFloat("tongLuong"));
        return model;
    }
     private Luong readFromResultSet2(ResultSet rs) throws SQLException {
        Luong model = new Luong();
        model.setMaLuong(rs.getString("MaLuong"));
        model.setMaNV(rs.getString("MaNV"));
        model.setHeSoluong(rs.getFloat("heSoLuong"));
        model.setLuongCoBan(rs.getFloat("luongCoBan"));
        model.setTongLuong(rs.getFloat("tongLuong"));
        return model;
    }
}
