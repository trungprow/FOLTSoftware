/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author ACER
 */
public class HoaDon {
    private String maSP;
    private String maHDon;
    private String tenSP;
    private String soLuong;
    private Double gia;
    private Double thanhTien;
    private String khachHang;
    private String SDT;
    private String Username;

    @Override
    public String toString() {
        return "HoaDon{" + "maSP=" + maSP + ", maHDon=" + maHDon + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", khachHang=" + khachHang + ", SDT=" + SDT + ", Username=" + Username + '}';
    }

    public HoaDon(String maSP, String maHDon, String tenSP, String soLuong, Double gia, Double thanhTien, String khachHang, String SDT, String Username) {
        this.maSP = maSP;
        this.maHDon = maHDon;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.gia = gia;
        this.thanhTien = thanhTien;
        this.khachHang = khachHang;
        this.SDT = SDT;
        this.Username = Username;
    }
    

    public HoaDon(String maSP, String maHDon, String tenSP, String soLuong, String khachHang, String SDT, String Username) {
        this.maSP = maSP;
        this.maHDon = maHDon;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.khachHang = khachHang;
        this.SDT = SDT;
        this.Username = Username;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaHDon() {
        return maHDon;
    }

    public void setMaHDon(String maHDon) {
        this.maHDon = maHDon;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }
    

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
            public HoaDon() {
    }
}
