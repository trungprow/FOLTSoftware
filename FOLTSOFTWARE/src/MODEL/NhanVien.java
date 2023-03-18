/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.Serializable;

public class NhanVien implements Serializable {

    private String MaNV;
    private String tenNV;
    private String Username;
    private String matKhau;
    private boolean gioiTinh;
    private String maHD;
    private String MaL;
    private String diaChi;
    private String Sdt;
    private String Gmail;
    @Override
    public String toString() {
        return this.tenNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getGmail() {
        return Gmail;
    }

    public String getMaL() {
        return MaL;
    }

    public void setMaL(String MaL) {
        this.MaL = MaL;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public NhanVien(String MaNV, String tenNV, String Username, String matKhau, boolean gioiTinh, String maHD, String MaL, String diaChi, String Sdt, String Gmail) {
        this.MaNV = MaNV;
        this.tenNV = tenNV;
        this.Username = Username;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
        this.maHD = maHD;
        this.MaL = MaL;
        this.diaChi = diaChi;
        this.Sdt = Sdt;
        this.Gmail = Gmail;
    }

    public NhanVien() {
    }
    
}
