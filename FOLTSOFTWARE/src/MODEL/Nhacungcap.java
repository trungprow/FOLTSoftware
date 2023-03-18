/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Admin
 */
public class Nhacungcap {
    private String maNCC;
    private String tenNCC;

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public Nhacungcap(String maNCC, String tenNCC) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
    }

    @Override
    public String toString() {
        return "Nhacungcap{" + "maNCC=" + maNCC + ", tenNCC=" + tenNCC + '}';
    }

    public Nhacungcap() {
    }
    
}
