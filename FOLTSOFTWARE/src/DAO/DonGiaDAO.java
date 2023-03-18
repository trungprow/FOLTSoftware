/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.JdbcHelper;
import MODEL.DonGia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class DonGiaDAO {
    public void insert(DonGia model) {
        String sql = "INSERT INTO giaSP(MaSP, ngay, gia) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaSP(),
                model.getNgay(),
                model.getGia()               
               );
    }
    public void update(DonGia model) {
        String sql = "UPDATE giaSP SET ngay=?, gia=? WHERE MaSP=?";
        JdbcHelper.executeUpdate(sql,                
                model.getNgay(),
                model.getGia(),
                model.getMaSP()           
               );
    }
    public void delete(String MaSP) {
        String sql = "delete from giaSP WHERE MaSP=?";
        JdbcHelper.executeUpdate(sql, MaSP);
    }
    public DonGia findById(String MaSP) {
        String sql = "SELECT * FROM sanPham s, giaSP g where s.MaSP=? and s.MaSP = g.MaSP";
        List<DonGia> list = select(sql, MaSP);
        return list.size() > 0 ? list.get(0) : null;
    }
    private List<DonGia> select(String sql, Object... args) {
        List<DonGia> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DonGia model = readFromResultSet(rs);
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

    private DonGia readFromResultSet(ResultSet rs) throws SQLException {
        DonGia model = new DonGia();
        model.setMaSP(rs.getString("MaSP"));
        model.setNgay(rs.getString("ngay"));
        model.setGia(rs.getDouble("gia"));
        return model;
    }

    public List<DonGia> select() {
        String sql = "SELECT * FROM giaSP";
        return select(sql);
    }
}
