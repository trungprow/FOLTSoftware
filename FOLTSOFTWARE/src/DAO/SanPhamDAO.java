/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.JdbcHelper;
import MODEL.DonGia;
import MODEL.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class SanPhamDAO {

    public void insert(SanPham model) {
        String sql = "INSERT INTO sanPham(MaSP, tenSP, soLuong, MaNCC) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getSoLuong(),
                model.getMaNCC(),
                model.getDonGia()
        );
    }

    public void update(SanPham model) {
        String sql = "UPDATE sanPham SET tenSP=?, soLuong=?, MaNCC=? WHERE MaSP=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getSoLuong(),
                model.getMaNCC(),
                model.getDonGia()
        );
    }

    public void delete(String MaSP) {
        String sql = "DELETE FROM sanPham WHERE MaSP=?";
        JdbcHelper.executeUpdate(sql, MaSP);
    }

    public List<SanPham> select() {
        String sql = "SELECT * FROM sanPham s, giaSP g where s.MaSP = g.MaSP";
        return select(sql);
    }

    public List<SanPham> select1() {
        String sql = "select sanPham.MaSP, sanPham.tenSP from sanPham, (select sanPham.MaSP from sanPham\n"
                + "EXCEPT\n"
                + "select giaSP.MaSP from giaSP) as tmp where sanPham.MaSP = tmp.MaSP";
        return select2(sql);
    }

    public List<SanPham> selectG() {
        String sql = "SELECT * FROM giaSP where gia=?";
        return select(sql);
    }

    public SanPham findById1(String MaSP) {
        String sql = "SELECT * FROM sanPham where MaSP = ?";
        List<SanPham> list = select2(sql, MaSP);
        return list.size() > 0 ? list.get(0) : null;
    }

    public SanPham findById(String MaSP) {
        String sql = "SELECT * FROM sanPham s, giaSP g where s.MaSP=? and s.MaSP = g.MaSP";
        List<SanPham> list = select(sql, MaSP);
        return list.size() > 0 ? list.get(0) : null;
    }

    public SanPham findBySL(String MaSP) {
        String sql = "SELECT soLuong FROM sanPham where MaSP=?";
        List<SanPham> list = select1(sql, MaSP);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<SanPham> select(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet(rs);
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

    private List<SanPham> select1(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet1(rs);
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

    private List<SanPham> select2(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet2(rs);
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

    private SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setMaSP(rs.getString("MaSP"));
        model.setTenSP(rs.getString("tenSP"));
        model.setSoLuong(rs.getString("soLuong"));
        model.setMaNCC(rs.getString("MaNCC"));
        model.setDonGia(rs.getDouble("gia"));
        return model;
    }

    private SanPham readFromResultSet1(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setSoLuong(rs.getString("soLuong"));
        return model;
    }

    private SanPham readFromResultSet2(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setMaSP(rs.getString("MaSP"));
        model.setTenSP(rs.getString("tenSP"));
        return model;
    }
}
