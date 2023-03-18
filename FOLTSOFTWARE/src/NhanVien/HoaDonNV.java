/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVien;

import DAO.HoaDonDAO;
import DAO.SanPhamDAO;
import JDBC.DialogHelper;
import JDBC.JdbcHelper;
import JDBC.ShareHelper;
import MODEL.HoaDon;
import MODEL.SanPham;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ACER
 */
public class HoaDonNV extends javax.swing.JFrame {

    HoaDonDAO dao = new HoaDonDAO();
    SanPhamDAO daosp = new SanPhamDAO();
    int index = 0;
    String sluong;
    String msp;
    String user = ShareHelper.USER.getUsername();
    int count = 0;

    public HoaDonNV() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        load();
        load_sp();
        txtUsername.setEditable(false);
        txtUsername.setText(user);
        txtthanhTien.setEditable(false);
        txtGia.setEditable(false);
    }

    void stt() {
        sluong = txtsoLuong.getText();
        msp = txtmaSP.getText();
    }

    public boolean check1() {
        HoaDon list = (HoaDon) dao.findById(txtmahoadon.getText());
        String checkus = list.getUsername();
        if (user != checkus) {
            DialogHelper.alert(this, "Bạn không thể xóa hóa đơn của người khác!");
            return false;
        }

        return true;
    }

    public boolean check() {

        if (txtmahoadon.getText().isEmpty() ||txtmaSP.getText().isEmpty() || txttenSP.getText().isEmpty() || txtsoLuong.getText().isEmpty()
                || txtGia.getText().isEmpty() || txtthanhTien.getText().isEmpty() || txttenKH.getText().isEmpty() || txtSDT.getText().isEmpty()
                || txtUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Error", 1);
            return false;
            
        } else if (!(txtSDT.getText()).matches("^\\+?[0-9. ()-]{10,11}$")) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi Số Điện Thoại!", "Error", 1);
            txtSDT.requestFocus();
            return false;
        }
        List<HoaDon> list = dao.select();
        for (int i = 0; i < list.size(); i++) {
            if (txtmahoadon.getText().equalsIgnoreCase(list.get(i).getMaHDon())) {
                DialogHelper.alert(this, "Trùng mã hóa đơn!!");
                return false;
            }
        }
        
        return true;
    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tbldanhsach.getModel();
        model.setRowCount(0);
        try {
            List<HoaDon> list = dao.select();
            count = list.size();
            for (HoaDon hd : list) {
                Object[] row = {
                    hd.getMaHDon(),
                    hd.getMaSP(),
                    hd.getTenSP(),
                    hd.getSoLuong(),
                    hd.getGia(),
                    hd.getThanhTien(),
                    hd.getKhachHang(),
                    hd.getSDT(),
                    hd.getUsername()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void load_sp() {
        DefaultTableModel model = (DefaultTableModel) load_sp.getModel();
        model.setRowCount(0);
        try {
            List<SanPham> list = daosp.select();
            for (SanPham sp : list) {
                Object[] row = {
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getSoLuong(),
                    sp.getDonGia(),};
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void update() {
        index = tbldanhsach.getSelectedRow();
        if (index == -1) {
            DialogHelper.alert(this, "Bạn chưa chọn đối tượng cần cập nhật trong bảng!");
            return;
        } else {
            try {
                HoaDon model = getModel();
                dao.update(model);
                this.load();
                DialogHelper.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại!");
            }
        }
    }

    void loadbs() {
        if (txtsoLuong.getText().isEmpty() && txtGia.getText().isEmpty()) {
            txtsoLuong.setText("1");
            txtGia.setText("0");
            Double price = Double.parseDouble(txtGia.getText());
            Double vira = Double.parseDouble(txtsoLuong.getText());
            Double cost = price * vira;
            txtthanhTien.setText(String.valueOf(cost));
        } else if (txtsoLuong.getText() != "1") {
            Double price = Double.parseDouble(txtGia.getText());
            Double vira = Double.parseDouble(txtsoLuong.getText());
            Double cost = price * vira;
            txtthanhTien.setText(String.valueOf(cost));
        }

    }

    void setModelSP(SanPham sanpham) {
        txtmaSP.setText(sanpham.getMaSP());
        txttenSP.setText(sanpham.getTenSP());
        txtGia.setText(String.format("%.0f", sanpham.getDonGia()));
//        Double price = Double.parseDouble(txtGia.getText());
//        Double vira = Double.parseDouble(txtsoLuong.getText());
//        Double cost = price * vira;
//        txtthanhTien.setText(String.valueOf(cost));
//        txtsoLuong.setTextmodel.getSoLuong());
//        txtmaNCC.setText(model.getMaNCC());
    }

    SanPham getModelSP() {
        SanPham sanpham = new SanPham();
        sanpham.setMaSP(txtmaSP.getText());
        sanpham.setTenSP(txttenSP.getText());
        sanpham.setSoLuong(txtsoLuong.getText());
        sanpham.setDonGia(Double.parseDouble(txtGia.getText()));
//        model.setSoLuong(txtsoLuong.getText());
//        model.setMaNCC(txtmaNCC.getText());
        return sanpham;
    }

    void setStatusSP(boolean insertable) {
        txtmaSP.setEditable(insertable);
    }

    void Delete() {
        if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa?")) {
            String xoa = txtmahoadon.getText();
            try {
                dao.delete(xoa);
                this.load();
                this.clear();
                DialogHelper.alert(this, "Xóa thành công!");
            } catch (HeadlessException e) {
                DialogHelper.alert(this, "Xóa thất bại!");
            }
        }

    }

    void insert() {
        HoaDon model = getModel();
        try {
            dao.insert(model);
            this.load();
            this.clear();
            DialogHelper.alert(this, "Đã thêm hóa đơn");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm hóa đơn thất bại");
        }
    }

    void clear() {
        txtGia.setText("");
        txtSDT.setText("");
        txtmaSP.setText("");
        txtmahoadon.setText("");
        txtsoLuong.setText("");
        txttenKH.setText("");
        txttenSP.setText("");
        txtthanhTien.setText("");
        txtUsername.setText(user);
    }

    void setModel(HoaDon model) {
        txtmahoadon.setText(model.getMaHDon());
        txtmaSP.setText(model.getMaSP());
        txttenSP.setText(model.getTenSP());
        txtsoLuong.setText(model.getSoLuong());
        txtGia.setText(String.format("%.0f", model.getGia()));
//        Double price = Double.parseDouble(txtGia.getText());
//        Double vira = Double.parseDouble(txtsoLuong.getText());
//        Double cost = price * vira;
//        txtthanhTien.setText(String.valueOf(cost));
        txtthanhTien.setText(String.format("%.0f", model.getThanhTien()));
        txttenKH.setText(model.getKhachHang());
        txtSDT.setText(model.getSDT());
        txtUsername.setText(model.getUsername());
    }

    HoaDon getModel() {
        HoaDon model = new HoaDon();
        model.setMaHDon(txtmahoadon.getText());
        model.setMaSP(txtmaSP.getText());
        model.setTenSP(txttenSP.getText());
        model.setSoLuong((txtsoLuong.getText()));
        model.setGia(Double.parseDouble(txtGia.getText()));
        model.setThanhTien(Double.parseDouble(txtthanhTien.getText()));
        model.setKhachHang(txttenKH.getText());
        model.setSDT(txtSDT.getText());
        model.setUsername(txtUsername.getText());

        return model;

    }

    void edit() {
        try {
            String MaHDon = (String) tbldanhsach.getValueAt(this.index, 0);
            HoaDon model = dao.findById(MaHDon);
            if (model != null) {
                this.setModel(model);
                this.setStatus(true);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void edit_sp() {
        try {
            String MaSP = (String) load_sp.getValueAt(this.index, 0);
            SanPham sanpham = daosp.findById(MaSP);
            if (sanpham != null) {
                this.setModelSP(sanpham);
                this.setStatusSP(true);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setStatus(boolean insertable) {
//        txtmahoadon.setEditable(insertable);
        txtmaSP.setEditable(insertable);
        txttenSP.setEditable(insertable);
        txtGia.setEditable(insertable);
//        txttenKH.setEnabled(insertable);
        btnSave.setEnabled(!insertable);
//        btnDelete.setEnabled(insertable);
//        btnEdit.setEnabled(insertable);
//        btnMoi.setEnabled(insertable);
//        btnTimkiem.setEnabled(insertable);
//        boolean first = this.index > 0;
//        boolean last = this.index < tblxevao.getRowCount() - 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblmanhanvien = new javax.swing.JLabel();
        lblmatkhau = new javax.swing.JLabel();
        lblhoten = new javax.swing.JLabel();
        txttenKH = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        lbldienthoai = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblvaitro = new javax.swing.JLabel();
        lbltenKH = new javax.swing.JLabel();
        txtmaSP = new javax.swing.JTextField();
        lblsdtKH = new javax.swing.JLabel();
        txttenSP = new javax.swing.JTextField();
        txtsoLuong = new javax.swing.JTextField();
        lblgia = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        txtthanhTien = new javax.swing.JTextField();
        lblthanhTien = new javax.swing.JLabel();
        txtmahoadon = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldanhsach = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnMoi = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        load_sp = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabsMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblmanhanvien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblmanhanvien.setText("MÃ HÓA ĐƠN");

        lblmatkhau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblmatkhau.setText("SỐ LƯỢNG");

        lblhoten.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblhoten.setText("TÊN KHÁCH HÀNG");

        txttenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbldienthoai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbldienthoai.setText("USERNAME");

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblvaitro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblvaitro.setText("SĐT KH");

        lbltenKH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbltenKH.setText("MÃ SẢN PHẨM");

        txtmaSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtmaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaSPActionPerformed(evt);
            }
        });

        lblsdtKH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblsdtKH.setText("TÊN SẢN PHẨM");

        txttenSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txttenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenSPActionPerformed(evt);
            }
        });

        txtsoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtsoLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsoLuongFocusLost(evt);
            }
        });
        txtsoLuong.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtsoLuongInputMethodTextChanged(evt);
            }
        });
        txtsoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoLuongActionPerformed(evt);
            }
        });

        lblgia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblgia.setText("GIÁ");

        txtGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtGia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaFocusLost(evt);
            }
        });
        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        txtthanhTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtthanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtthanhTienActionPerformed(evt);
            }
        });

        lblthanhTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblthanhTien.setText("THÀNH TIỀN");

        txtmahoadon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblsdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(txttenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtsoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblgia, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblhoten, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblvaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbldienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblthanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtthanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(txtmahoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblmanhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmahoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbltenKH))
                    .addComponent(txtmaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblsdtKH))
                    .addComponent(txttenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblmatkhau))
                    .addComponent(txtsoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblgia))
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblthanhTien))
                    .addComponent(txtthanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lblhoten))
                    .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblvaitro))
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbldienthoai))
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tabs.addTab("Hóa Đơn", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbldanhsach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbldanhsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ HÓA ĐƠN", "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "GIÁ", "THÀNH TIỀN", "TÊN KH", "SĐT KH", "USERNAME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldanhsach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldanhsachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldanhsach);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
        );

        tabs.addTab("Chi Tiết", jPanel4);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("HÓA ĐƠN");

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        btnMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMoiMouseClicked(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deleta.png"))); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        load_sp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        load_sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        load_sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                load_spMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(load_sp);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Kho");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel2)
                .addContainerGap(157, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/in.png"))); // NOI18N
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(566, 566, 566))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaSPActionPerformed

    private void txttenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenSPActionPerformed

    private void tbldanhsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachMouseClicked

        if (evt.getClickCount() == 1) {
            this.index = tbldanhsach.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
                tabs.setSelectedIndex(0);
                this.setStatus(false);
                this.stt();
            }
        }
    }//GEN-LAST:event_tbldanhsachMouseClicked

    private void tabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabsMouseClicked

    private void btnMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiMouseClicked
        // TODO add your handling code here:
        this.clear();
        String manv = "HD" + (count + 1);
        txtmahoadon.setText(manv);
    }//GEN-LAST:event_btnMoiMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        String msp = txtmaSP.getText();
        SanPham sl = daosp.findBySL(msp);
        if (sl != null) {
            String sluong = sl.getSoLuong();
            String slb = txtsoLuong.getText();
            int slcl = Integer.parseInt(sluong) + Integer.parseInt(slb);
            String dk = String.valueOf(slcl);
            String tsql = "Update sanPham set soLuong = ? where MaSP = ?";
            JdbcHelper.executeUpdate(tsql, dk, msp);
            this.Delete();
            this.load_sp();
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (this.check()) {
            if (!txtsoLuong.getText().isEmpty()) {
                String msp = txtmaSP.getText();
                SanPham sl = daosp.findBySL(msp);
                if (sl != null) {
                    String sluong = sl.getSoLuong();
                    String slb = txtsoLuong.getText();
                    int slcl = Integer.parseInt(sluong) - Integer.parseInt(slb);
                    String dk = String.valueOf(slcl);
                    String tsql = "Update sanPham set soLuong = ? where MaSP = ?";
                    JdbcHelper.executeUpdate(tsql, dk, msp);
                } else {
                    DialogHelper.alert(this, "Lỗi");
                }
            } else {
                DialogHelper.alert(this, "Bạn chưa chọn số lượng sản phẩm!");
            }
            this.insert();
            this.load_sp();
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        SanPham sl = daosp.findBySL(msp);
        if (sl != null) {
            String slton = sl.getSoLuong();
            int slcl = Integer.parseInt(sluong) + Integer.parseInt(slton);
            String dk = String.valueOf(slcl);
            String tsql = "Update sanPham set soLuong = ? where MaSP = ?";
            JdbcHelper.executeUpdate(tsql, dk, msp);
        }
        String mspn = txtmaSP.getText();
        SanPham slcn = daosp.findBySL(mspn);
        if (slcn != null) {
            String slup = txtsoLuong.getText();
            String slmoi = slcn.getSoLuong();
            int newSL = Integer.parseInt(slmoi) - Integer.parseInt(slup);
            String tran = String.valueOf(newSL);
            String nsql = "Update sanPham set soLuong = ? where MaSP = ?";
            JdbcHelper.executeUpdate(nsql, tran, mspn);
        }
        this.update();
        this.load_sp();
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        new MainNV().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void load_spMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_load_spMouseClicked

        if (evt.getClickCount() == 1) {
            this.index = load_sp.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit_sp();
            }
        }
    }//GEN-LAST:event_load_spMouseClicked

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void txtsoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoLuongActionPerformed

    }//GEN-LAST:event_txtsoLuongActionPerformed

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked

        try {
            String ma = txtmahoadon.getText();
            String link = "src/NhanVien/xuatHoaDon.jrxml";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String database = "jdbc:sqlserver://localhost:1433;databaseName=DATN;";
            String us = "sa";
            String pw = "123";
            Connection conn = (Connection) DriverManager.getConnection(database, us, pw);

            Hashtable map = new Hashtable();

            map.put("MaHDon", ma);
            JasperReport a = JasperCompileManager.compileReport(link);

            JasperPrint p = JasperFillManager.fillReport(a, map, conn);

            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "D:/demo.pdf");
        } catch (Exception ex) {
            DialogHelper.alert(this, "Thanh Toán thất bại!");
        }


    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void txtsoLuongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsoLuongFocusLost
        if (txtsoLuong.getText().isEmpty() || txtGia.getText().isEmpty() || txtsoLuong.getText().equals("0") || txtGia.getText().equals("0")) {
            DialogHelper.alert(this, "Chưa nhập đầy đủ thông tin cần thiết!");
        } else {
            Double price = Double.parseDouble(txtGia.getText());
            Double vira = Double.parseDouble(txtsoLuong.getText());
            Double cost = price * vira;
            txtthanhTien.setText(String.format("%.0f", cost));
        }
    }//GEN-LAST:event_txtsoLuongFocusLost

    private void txtsoLuongInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtsoLuongInputMethodTextChanged

    }//GEN-LAST:event_txtsoLuongInputMethodTextChanged

    private void txtGiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaFocusLost
        if (txtsoLuong.getText().isEmpty() || txtGia.getText().isEmpty() || txtsoLuong.getText().equals("0") || txtGia.getText().equals("0")) {
            DialogHelper.alert(this, "Chưa nhập đầy đủ thông tin cần thiết!");
        } else {
            Double price = Double.parseDouble(txtGia.getText());
            Double vira = Double.parseDouble(txtsoLuong.getText());
            Double cost = price * vira;
            txtthanhTien.setText(String.format("%.0f", cost));
        }
    }//GEN-LAST:event_txtGiaFocusLost

    private void txtthanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtthanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtthanhTienActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HoaDonNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMoi;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnThanhToan;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbldienthoai;
    private javax.swing.JLabel lblgia;
    private javax.swing.JLabel lblhoten;
    private javax.swing.JLabel lblmanhanvien;
    private javax.swing.JLabel lblmatkhau;
    private javax.swing.JLabel lblsdtKH;
    private javax.swing.JLabel lbltenKH;
    private javax.swing.JLabel lblthanhTien;
    private javax.swing.JLabel lblvaitro;
    private javax.swing.JTable load_sp;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbldanhsach;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtmaSP;
    private javax.swing.JLabel txtmahoadon;
    private javax.swing.JTextField txtsoLuong;
    private javax.swing.JTextField txttenKH;
    private javax.swing.JTextField txttenSP;
    private javax.swing.JTextField txtthanhTien;
    // End of variables declaration//GEN-END:variables
}
