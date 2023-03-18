/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.NhanVien;
import JDBC.JdbcHelper;
import MODEL.Doipass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {

    public void insert(NhanVien model) {
        String sql = "INSERT INTO nhanVien(MaNV, tenNV, Username, gioiTinh, diaChi, SDT, Email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaNV(),
                model.getTenNV(),
                model.getUsername(),
                model.isGioiTinh(),
                model.getDiaChi(),
                model.getSdt(),
                model.getGmail()
        );
    }

    public void update(NhanVien model) {
        String sql = "UPDATE nhanVien SET tenNV=?, Username=?, gioiTinh=?, diaChi=?, SDT=?, Email=? WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenNV(),
                model.getUsername(),
                model.isGioiTinh(),
                model.getDiaChi(),
                model.getSdt(),
                model.getGmail(),
                model.getMaNV()
        );
    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM nhanVien WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }
//    public void delete(String MaHD) {
//        String sql = "DELETE FROM hopDong WHERE MaHD=?";
//        JdbcHelper.executeUpdate(sql, MaHD);
//    }

    public List<NhanVien> select() {
        String sql = "SELECT * FROM nhanVien";
        return select(sql);
    }

    public List<NhanVien> select2() {
        String sql = "select nv.MaNV, nv.tenNV from nhanVien nv, (select nhanVien.MaNV from nhanVien EXCEPT select luong.MaNV from luong) as tmp where nv.MaNV = tmp.MaNV";
        return select3(sql);
    }
    public List<NhanVien> select4() {
        String sql = "select nv.MaNV, nv.tenNV from nhanVien nv, (select nhanVien.MaNV from nhanVien EXCEPT select hopDong.MaNV from hopDong) as tmp where nv.MaNV = tmp.MaNV";
        return select3(sql);
    }

    public List<NhanVien> selectTk(String tk) {
        String sql = "SELECT MaNV FROM nhanVien where Username = ?";
        return select1(sql, tk);
    }

    public List<NhanVien> find(String tk) {
        String sql = "select * from nhanVien nv, hopDong hd, luong l where nv.Username = ? and nv.MaNV = hd.MaNV and nv.MaNV = l.MaNV";
        return select2(sql, tk);
    }

    public List<NhanVien> select1(String manv) {
        String sql = "SELECT * FROM nhanVien where Username = ?";
        return select(sql, manv);
    }

    public NhanVien findById(String MaNV) {
        String sql = "SELECT * FROM nhanVien WHERE MaNV=?";
        List<NhanVien> list = select(sql, MaNV);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
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

    private List<NhanVien> select1(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet1(rs);
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
     private List<NhanVien> select3(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet3(rs);
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

    private List<NhanVien> select2(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet2(rs);
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

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setTenNV(rs.getString("tenNV"));
        model.setUsername(rs.getString("Username"));
//        model.setMaHD(rs.getString("MaHD"));
//        model.setMaL(rs.getString("MaLuong"));
        model.setGioiTinh(rs.getBoolean("gioiTinh"));
        model.setDiaChi(rs.getString("diaChi"));
        model.setSdt(rs.getString("SDT"));
        model.setGmail(rs.getString("Email"));
        return model;
    }

    private NhanVien readFromResultSet1(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        return model;
    }

    private NhanVien readFromResultSet2(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setTenNV(rs.getString("tenNV"));
        model.setUsername(rs.getString("Username"));
        model.setMaHD(rs.getString("MaHD"));
        model.setMaL(rs.getString("MaLuong"));
        model.setGioiTinh(rs.getBoolean("gioiTinh"));
        model.setDiaChi(rs.getString("diaChi"));
        model.setSdt(rs.getString("SDT"));
        model.setGmail(rs.getString("Email"));
        return model;
    }
    private NhanVien readFromResultSet3(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setTenNV(rs.getString("tenNV"));
        return model;
    }
}
