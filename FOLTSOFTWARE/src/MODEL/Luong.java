/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.Date;

/**
 *
 * @author Acer
 */
public class Luong {
   private String maLuong;
   private String maNV;
   private Float heSoluong;
   private Float luongCoBan;
   private Float tongLuong;

    public Luong() {
    }

    public Float getTongLuong() {
        return tongLuong;
    }

    public Luong(String maLuong, String maNV, Float heSoluong, Float luongCoBan, Float tongLuong) {
        this.maLuong = maLuong;
        this.maNV = maNV;
        this.heSoluong = heSoluong;
        this.luongCoBan = luongCoBan;
        this.tongLuong = tongLuong;
    }

    public void setTongLuong(Float tongLuong) {
        this.tongLuong = tongLuong;
    }

    public Luong(String maLuong, String maNV, float heSoluong, float luongCoBan) {
        this.maLuong = maLuong;
        this.maNV = maNV;
        this.heSoluong = heSoluong;
        this.luongCoBan = luongCoBan;
    }

    public String getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Float getHeSoluong() {
        return heSoluong;
    }

    public void setHeSoluong(Float heSoluong) {
        this.heSoluong = heSoluong;
    }



    public Float getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(Float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

}
