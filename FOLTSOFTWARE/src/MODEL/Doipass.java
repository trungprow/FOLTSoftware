package MODEL;

import java.io.Serializable;

public class Doipass implements Serializable {

    String matkhau;
    String taiKhoan;

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    
}
