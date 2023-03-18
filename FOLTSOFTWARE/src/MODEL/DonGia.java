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
public class DonGia {
    private String MaSP;
    private String Ngay;
    private Double Gia;

    public DonGia(String MaSP, String Ngay, Double Gia) {
        this.MaSP = MaSP;
        this.Ngay = Ngay;
        this.Gia = Gia;
    }

    public DonGia() {
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }

    public Double getGia() {
        return Gia;
    }

    public void setGia(Double Gia) {
        this.Gia = Gia;
    }
    
}
