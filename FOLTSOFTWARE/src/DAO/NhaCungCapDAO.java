/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.JdbcHelper;
import MODEL.Nhacungcap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhaCungCapDAO {
     public void insert(Nhacungcap model) {
        String sql = "INSERT INTO nhaCungCap(MaNCC, tenNCC) VALUES (?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaNCC(),
                model.getTenNCC()
               
               );
    }

    public void update(Nhacungcap model) {
        String sql = "UPDATE nhaCungCap SET tenNCC=? WHERE MaNCC=?";
        JdbcHelper.executeUpdate(sql,
              
                model.getTenNCC(),
                   model.getMaNCC()
               );
    }

    public void delete(String MaNCC) {
        String sql = "DELETE FROM nhaCungCap WHERE MaNCC=?";
        JdbcHelper.executeUpdate(sql, MaNCC);
    }

    public List<Nhacungcap> select() {
        String sql = "SELECT * FROM nhaCungCap";
        return select(sql);
    }

    public Nhacungcap findById(String MaNCC) {
        String sql = "SELECT * FROM nhaCungCap WHERE MaNCC=?";
        List<Nhacungcap> list = select(sql, MaNCC);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Nhacungcap> select(String sql, Object... args) {
        List<Nhacungcap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Nhacungcap model = readFromResultSet(rs);
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

    private Nhacungcap readFromResultSet(ResultSet rs) throws SQLException {
        Nhacungcap model = new Nhacungcap();
        model.setMaNCC(rs.getString("MaNCC"));
        model.setTenNCC(rs.getString("tenNCC"));
        
        return model;
    }
}
