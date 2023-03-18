/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.JdbcHelper;
import MODEL.HopDong;
import MODEL.Luong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class LuongNV {
    
    public List<Luong> select(String tk) {
        String sql = "SELECT * FROM LUONG where TAIKHOAN = ?";
        return select(sql, tk);
    }
    
    public List<Luong> selectByKeyword(String l){
     String sql="SELECT L.MANV, NV.HOVATEN, L.LUONGCOBAN, L.HESOLUONG, L.NGAYBD, L.NGAYKT, CV.PHUCAP, L.GHICHU\n"
                + "              FROM LUONG L, CHUCVU CV, NHANVIEN NV\n"
                + "              WHERE L.MANV=NV.MANV AND CV.MACV=NV.MACV AND NV.MANV=?";
     return select(sql, l);
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

    private Luong readFromResultSet(ResultSet rs) throws SQLException {
        Luong model = new Luong();
        model.setMaLuong(rs.getString("MaLuong"));
        model.setMaNV(rs.getString("MaNV"));
        model.setHeSoluong(rs.getFloat("heSoLuong"));
        model.setLuongCoBan(rs.getFloat("luongCoBan"));
        model.setTongLuong(rs.getFloat("tongLuong"));
        return model;
    }
}
