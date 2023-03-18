/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.TaiKhoan;
import JDBC.JdbcHelper;
import MODEL.Doipass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {
    public void insert(TaiKhoan model) {
        String sql = "INSERT INTO taiKhoan (Username, Password, Role, Status) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getUsername(),
                model.getPassword(),
                model.isRole(),
                model.isStatus()
        );
    }

    public void update(TaiKhoan model) {
        String sql = "UPDATE taiKhoan SET Password=?, Role=?, Status=? WHERE Username=?";
        JdbcHelper.executeUpdate(sql,
               model.getPassword(),
                model.isRole(),
                model.isStatus(),
                model.getUsername()
        );
    }

    public void delete(String taiKhoan) {
        String sql = "DELETE FROM taiKhoan WHERE Username=?";
        JdbcHelper.executeUpdate(sql, taiKhoan);
    }

    public List<TaiKhoan> select() {
        String sql = "SELECT * FROM taiKhoan";
        return select(sql);
    }
    public List<TaiKhoan> select1() {
        String sql = "select tk.Username from taiKhoan tk, (select taiKhoan.Username from taiKhoan EXCEPT select nhanVien.Username from nhanVien) as tmp where tk.Username = tmp.Username";
        return select1(sql);
    }

    
    public void update1(Doipass model) {
        String sql = "UPDATE taiKhoan SET Password=? WHERE Username=?";
        JdbcHelper.executeUpdate(sql,         
                model.getMatkhau(),
                model.getTaiKhoan()
                );
    }
public void update2(TaiKhoan model) {
        String sql = "UPDATE taiKhoan SET Status='0' WHERE Username=?";
        JdbcHelper.executeUpdate(sql,         
                model.getUsername()
                );
    }
    public TaiKhoan findById(String taiKhoan) {
        String sql = "SELECT * FROM taiKhoan WHERE Username=?";
        List<TaiKhoan> list = select(sql, taiKhoan);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public TaiKhoan findById3(String vaitro) {
        String sql = "SELECT * FROM TAIKHOAN WHERE VAITRO=?";
        List<TaiKhoan> list = select(sql, vaitro);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public TaiKhoan findById2(String taikhoan, boolean vaitro) {
        String sql = "SELECT * FROM TAIKHOAN WHERE TAIKHOAN = ? AND VAITRO=?";
        List<TaiKhoan> list = select(sql, taikhoan, vaitro);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public TaiKhoan findById1(String taikhoan, String matkhau) {
        String sql = "SELECT * FROM taiKhoan WHERE Username=? AND Password=?";
        List<TaiKhoan> list = select(sql, taikhoan, matkhau);
        
        return list.size() > 0 ? list.get(0) : null;
    }
   
    private List<TaiKhoan> select(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;

            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet(rs);
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
    private List<TaiKhoan> select1(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;

            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet1(rs);
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

    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoan model = new TaiKhoan();
        model.setUsername(rs.getString("Username"));
        model.setPassword(rs.getString("Password"));
        model.setRole(rs.getBoolean("Role"));
        model.setStatus(rs.getBoolean("Status"));
        return model;
    }
    private TaiKhoan readFromResultSet1(ResultSet rs) throws SQLException {
        TaiKhoan model = new TaiKhoan();
        model.setUsername(rs.getString("Username"));
        return model;
    }
}
