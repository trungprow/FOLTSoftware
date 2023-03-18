/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import JDBC.DateHelper;
import java.util.Date;

public class HopDong {
   private String maHD;
   private String maNV;
   private String loaiHD;
   private String ngayBD;
   private String ngayKT;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getLoaiHD() {
        return loaiHD;
    }

    public void setLoaiHD(String loaiHD) {
        this.loaiHD = loaiHD;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public HopDong(String maHD, String maNV, String loaiHD, String ngayBD, String ngayKT) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.loaiHD = loaiHD;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public HopDong() {
        
    }
    
    
}
