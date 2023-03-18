/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.JdbcHelper;
import MODEL.HopDong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class HopDongNV {

    public List<HopDong> select(String tk) {
        String sql = "SELECT * FROM HOPDONG where MANV = ?";
        return select(sql, tk);
    }
    public void delete(String MaNV) {
        String sql = "DELETE FROM hopDong WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }

    public List<HopDong> selectByKeyword(String hd) {
        String sql = "  SELECT HD.MAHD, HD.TENHD, HD.LOAIHD, HD.TAIKHOAN, HD.MANV, NV.HOVATEN, HD.NGAYBD, HD.NGAYKT, HD.GHICHU\n"
                + "  FROM HOPDONG HD, NHANVIEN NV\n"
                + "  WHERE NV.MANV=HD.MANV AND HD.MANV=?";
        return select(sql, hd);
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

    private HopDong readFromResultSet(ResultSet rs) throws SQLException {
        HopDong model = new HopDong();
        model.setMaHD(rs.getString("MAHD"));
        model.setLoaiHD(rs.getString("LOAIHD"));
        model.setMaNV(rs.getString("MANV"));
        model.setNgayBD(rs.getString("NGAYBD"));
        model.setNgayKT(rs.getString("NGAYKT"));
        return model;
    }
}
