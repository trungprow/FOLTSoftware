/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.JdbcHelper;
import MODEL.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class HoaDonDAO {
    public void insert(HoaDon model) {
        String sql = "INSERT INTO hoaDon(MaHDon, MaSP, tenSP, soLuong, gia, thanhTien, khachHang, soDT, Username) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaHDon(),
                model.getMaSP(),
                model.getTenSP(),
                model.getSoLuong(),
                model.getGia(),
                model.getThanhTien(),
                model.getKhachHang(),
                model.getSDT(),
                model.getUsername()
               );
    
    }
    public void update(HoaDon model) {
         String sql = "UPDATE hoaDon set MaSP=?, tenSP=?, soLuong=?, gia=?, thanhtien=?, khachHang=?, soDT=?, Username = ? where MaHDon = ?";
        JdbcHelper.executeUpdate(sql,              
                model.getMaSP(),
                model.getTenSP(),
                model.getSoLuong(),
                model.getGia(),
                model.getThanhTien(),
                model.getKhachHang(),
                model.getSDT(),
                model.getUsername(),
                model.getMaHDon()
               );
    }
    
    public void delete(String MaHDon) {
        String sql = "DELETE FROM hoaDon WHERE MaHDon=?";
        JdbcHelper.executeUpdate(sql, MaHDon);
    }

    public List<HoaDon> select() {
        String sql = "SELECT * FROM hoaDon";
        return select(sql);
    }
    
   public HoaDon findById(String MaHDon){
        String sql = "SELECT * FROM hoaDon WHERE MaHDon=?";
        List<HoaDon> list = select(sql, MaHDon);
        return list.size() > 0 ? list.get(0) : null;
    }
    private List<HoaDon> select(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
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

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();        
        model.setMaHDon(rs.getString("MaHDon"));
        model.setMaSP(rs.getString("MaSP"));
        model.setTenSP(rs.getString("tenSP"));
        model.setSoLuong(rs.getString("soLuong"));  
        model.setGia(rs.getDouble("gia"));
        model.setThanhTien(rs.getDouble("thanhtien"));
        model.setKhachHang(rs.getString("khachHang"));
        model.setSDT(rs.getString("soDT"));
        model.setUsername(rs.getString("Username"));
        return model;
    }


}
