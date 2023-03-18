/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.JdbcHelper;
import MODEL.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class NhanVienNV {

//    public List<NhanVien> selectByKeyword(String keyword) {
//        String sql = "SELECT NV.MaNV, CV.TENCV, PB.TENPB, NV.HOVATEN, NV.GIOITINH, NV.NGAYSINH, NV.SODT, NV.TRANGTHAI, NV.HONNHAN, NV.CMND, NV.HOCVAN, NV.HOCVI, NV.DIACHI, NV.GHICHU, NV.HINH\n"
//                + "  FROM NHANVIEN NV, PHONGBAN PB, CHUCVU CV\n"
//                + "  WHERE NV.MACV=CV.MACV AND NV.MAPB=PB.MAPB AND MANV LIKE ?";
//        return select(sql, "%" + keyword + "%");
//    }
//    
//    public List<NhanVien> selectByKeyword1(String nv) {
//        String sql = "SELECT NV.MaNV, CV.TENCV, PB.TENPB, NV.HOVATEN, NV.GIOITINH, NV.NGAYSINH, NV.SODT, NV.HONNHAN, NV.CMND, NV.HOCVAN, NV.HOCVI, NV.DIACHI, PX.TENPHUONG_XA, QH.TENQUAN_HUYEN, T.TENTINH, NV.GHICHU, NV.HINH\n" +
//"                FROM NHANVIEN NV, PHONGBAN PB, CHUCVU CV, TINH T, PHUONG_XA PX, QUAN_HUYEN QH\n" +
//"                WHERE NV.MACV=CV.MACV AND NV.MAPB=PB.MAPB AND T.MATINH=QH.MATINH AND PX.MAQUAN_HUYEN=QH.MAQUAN_HUYEN AND MANV=?";
//        return select(sql, nv);
//    }
//
//    private List<NhanVien> select(String sql, Object... args) {
//        List<NhanVien> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//
//            try {
//                rs = JdbcHelper.executeQuery(sql, args);
//                while (rs.next()) {
//                    NhanVien model = readFromResultSet(rs);
//                    list.add(model);
//                }
//            } finally {
//                rs.getStatement().getConnection().close();
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//        return list;
//    }
//
//    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
//        NhanVien model = new NhanVien();
//        model.setMaNV(rs.getString("MANV"));
//        model.setHoTen(rs.getString("HOVATEN"));
//        model.setGioiTinh(rs.getBoolean("GIOITINH"));
//        model.setNgaySinh(rs.getString("NGAYSINH"));
//        model.setCMND(rs.getString("CMND"));
//        model.setSoDT(rs.getString("SODT"));
//        model.setHocVan(rs.getString("HOCVAN"));
//        model.setHocVi(rs.getString("HOCVI"));
//        model.setMaPB(rs.getString("TENPB"));
//        model.setMaCV(rs.getString("TENCV"));
////        model.setPhuongXa(rs.getString("PHUONG_XA"));
//        String diachi = rs.getString(12) + "," +" "+"XÃ"+" "+ rs.getString(13) + "," +" "+"HUYỆN"+" "+ rs.getString(14) + "," +" "+"TỈNH"+" "+ rs.getString(15);
//        model.setDiaChi(diachi);
////        model.setHonNhan(rs.getString("HONNHAN"));
//        model.setHinh(rs.getString("HINH"));
//        model.setDienthoai(rs.getString("SODT"));
////        model.setTrangThai(rs.getBoolean("TRANGTHAI"));
//        model.setGhiChu(rs.getString("GHICHU"));
//        return model;
//    }
}
