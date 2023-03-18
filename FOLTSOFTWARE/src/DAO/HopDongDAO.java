/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.HopDong;
import JDBC.JdbcHelper;
import MODEL.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HopDongDAO {
    public void insert(HopDong model) {
        String sql = "INSERT INTO hopDong(MaHD, MaNV, loaiHD, ngayBD, ngayKT) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaHD(),
                model.getMaNV(),
                model.getLoaiHD(),
                model.getNgayBD(),
                model.getNgayKT()
                
               );
    }

    public void update(HopDong model) {
        String sql = "UPDATE hopDong SET MaNV=?, loaiHD=?, ngayBD=?, ngayKT=? WHERE MaHD=?";
        JdbcHelper.executeUpdate(sql,
                 
                model.getMaNV(),
                model.getLoaiHD(),
                model.getNgayBD(),
                model.getNgayKT(),
                model.getMaHD()
            
               );
    }

    public void delete(String MaHD) {
        String sql = "DELETE FROM hopDong WHERE MaHD=?";
        JdbcHelper.executeUpdate(sql, MaHD);
    }

    public List<HopDong> select() {
        String sql = "SELECT * FROM hopDong";
        return select(sql);
    }
    public List<HopDong> select1(String manv) {
        String sql = "SELECT * FROM hopDong hd, nhanVien nv where hd.MaNV = ? and nv.MaNV = hd.MaNV";
        return select(sql, manv);
    }
    
    public List<HopDong> select2() {
        String sql = "select hd.MaNV from nhanVien nv, (select nhanVien.MaNV from nhanVien EXCEPT select hopDong.MaNV from hopDong) as tmp where hd.MaNV = tmp.MaNV";
        return select3(sql);
    }

    public HopDong findById(String MaHD) {
        String sql = "SELECT * FROM hopDong WHERE MaHD=?";
        List<HopDong> list = select(sql, MaHD);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<HopDong> select(String sql, Object... args) {
        List<HopDong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HopDong model = readFromResultSet(rs);
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
private List<HopDong> select3(String sql, Object... args) {
        List<HopDong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HopDong model = readFromResultSet3(rs);
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
    private HopDong readFromResultSet(ResultSet rs) throws SQLException {
        HopDong model = new HopDong();
        model.setMaHD(rs.getString("MaHD"));
        model.setMaNV(rs.getString("MaNV"));
        model.setLoaiHD(rs.getString("loaiHD"));
        model.setNgayBD(rs.getString("ngayBD"));
        model.setNgayKT(rs.getString("ngayKT"));
        return model;
    }
    
    private HopDong readFromResultSet3(ResultSet rs) throws SQLException {
        HopDong model = new HopDong();
        model.setMaNV(rs.getString("MaNV"));
        
        return model;
    }
}
