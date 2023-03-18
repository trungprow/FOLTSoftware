/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {

    public List<Object[]> getNhanVien() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call tk_nhanVien}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaNV"),
                        rs.getString("tenNV"),
                        rs.getString("diaChi"),
                        rs.getFloat("heSoLuong"),
                        rs.getFloat("tongLuong"),
                        rs.getString("Username")
                    };
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
    public List<Object[]> getSP() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call tk_sanPham}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaSP"),
                        rs.getString("tenSP"),
                        rs.getString("soLuong"),
                        rs.getFloat("gia"),
                        rs.getString("ngay"),
                        rs.getString("MaNCC"),
                        rs.getString("tenNCC")
                    };
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
    public List<Object[]> getHD() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call tk_hoaDon}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaHDon"),
                        rs.getString("MaSP"),
                        rs.getString("tenSP"),
                        rs.getString("soLuong"),
                        rs.getFloat("gia"),
                        rs.getFloat("thanhTien"),
                        rs.getString("khachHang"),
                        rs.getString("soDT"),
                        rs.getString("Username")
                    };
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
    
    public List<Object[]> getHDong() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call tk_hopDong}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaHD"),
                        rs.getString("loaiHD"),
                        rs.getString("MaNV"),
                        rs.getString("tenNV"),
                        rs.getString("diaChi"),
                        rs.getString("Email"),
                        rs.getString("SDT"),
                        rs.getDate("ngayBD"),
                        rs.getDate("ngayKT")
                    };
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

//    public List<Object[]> ThongKeNhanVien() {
//        List<Object[]> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                String sql = "{call tk_nhanVien}";
//                rs = JdbcHelper.executeQuery(sql);
//                while (rs.next()) {
//                    String diachi = rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6);
//                    Object[] model = {
//                        rs.getString("MaNV"),
//                        rs.getString("HoVaTen"),
//                        diachi,
//                        rs.getBoolean("TrangThai") ? "Đang Hoạt Động" : "Không Hoạt Động",};
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
//    public List<Object[]> ThongKeNhanVienTinh(String tinh) {
//        List<Object[]> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                String sql = "{call thongkeNVT (?)}";
//                rs = JdbcHelper.executeQuery(sql, tinh);
//                while (rs.next()) {
//                    String diachi = rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7);
//                    Object[] model = {
//                        rs.getString("MaNV"),
//                        rs.getString("HoVaTen"),
//                        diachi,
//                        rs.getBoolean("TrangThai") ? "Đang Hoạt Động" : "Không Hoạt Động",};
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
//    public List<Object[]> LuongNV(int nam) {
//        List<Object[]> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                String sql = "{call thongkeNam (?)}";
//                rs = JdbcHelper.executeQuery(sql, nam);
//                while (rs.next()) {
//                    Object[] model = {
//                        rs.getString("MANV"),
//                        rs.getString("HoVaTen"),
//                        rs.getString("TenPB"),
//                        rs.getString("TenCV"),
//                        rs.getFloat("TONG"),};
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
//    public List<Object[]> ThongKePB(String pb) {
//        List<Object[]> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                String sql = "{call thongkePB (?)}";
//                rs = JdbcHelper.executeQuery(sql, pb);
//                while (rs.next()) {
//                    Object[] model = {
//                        rs.getString("MaNV"),
//                        rs.getString("HoVaTen"),
//                        rs.getString("TENPB"),};
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
//    public List<Object[]> ThongKeCV(String cv) {
//        List<Object[]> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                String sql = "{call thongkeCV (?)}";
//                rs = JdbcHelper.executeQuery(sql, cv);
//                while (rs.next()) {
//                    Object[] model = {
//                        rs.getString("MaNV"),
//                        rs.getString("HoVaTen"),
//                        rs.getString("TENCV"),};
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
//    public List<Object[]> LuongNV2(int thang, int nam) {
//        List<Object[]> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                String sql = "{call thongkeThang(?,?)}";
//                
//                rs = JdbcHelper.executeQuery(sql, thang, nam);
//                while (rs.next()) {
//                    Object[] model = {
//                        rs.getString("MANV"),
//                        rs.getString("HoVaTen"),
//                        rs.getString("TenPB"),
//                        rs.getString("TenCV"),
//                        rs.getFloat("HESOLUONG"),
//                        rs.getFloat("LUONGCOBAN"),
//                        rs.getFloat("PHUCAP"),
//                        rs.getString("NGAYKT"),
//                        rs.getFloat("TONG"),};
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
//    public List<Object[]> LuongNV1() {
//        List<Object[]> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                String sql = "{call thongkeLuong}";
//                rs = JdbcHelper.executeQuery(sql);
//                while (rs.next()) {
//                    Object[] model = {
//                        rs.getString("MANV"),
//                        rs.getString("HoVaTen"),
//                        rs.getString("TenPB"),
//                        rs.getString("TenCV"),
//                        rs.getFloat("HESOLUONG"),
//                        rs.getFloat("LUONGCOBAN"),
//                        rs.getFloat("PHUCAP"),
//                        rs.getString("NGAYKT"),
//                        rs.getFloat("TONG"),};
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
}
