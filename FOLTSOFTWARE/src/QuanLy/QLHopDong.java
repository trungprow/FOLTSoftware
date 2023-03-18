/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLy;

import DAO.HopDongDAO;
import DAO.NhanVienDAO;
import JDBC.DialogHelper;
import JDBC.ShareHelper;
import JDBC.XDate;

import MODEL.HopDong;
import MODEL.NhanVien;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author PC
 */
public class QLHopDong extends javax.swing.JFrame {

    int index = 0;
    HopDongDAO dao = new HopDongDAO();
    NhanVienDAO nvdao = new NhanVienDAO();

    /**
     * Creates new form QLHopDONG
     */
    public QLHopDong() {
        initComponents();
        setLocationRelativeTo(null);
        //fillComboBox();
        load();
        init();
        
       
    }

    public boolean check() {
        //HopDong model = dao.findById(txtmaHD.getText());
        if (txtmaHD.getText().isEmpty() || txtmaNV.getText().isEmpty() || txtLoai.getText().isEmpty()
                || txtngayBD.getText().isEmpty() || txtngayKT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Error", 1);
            return false;

        } else if (!(txtngayBD.getText()).matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng ngày! Xin vui lòng nhập đúng định dạng yyyy-mm-dd", "Error", 1);
            txtngayBD.requestFocus();
            return false;
        } else if (!(txtngayKT.getText()).matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng ngày! Xin vui lòng nhập đúng định dạng yyyy-mm-dd", "Error", 1);
            txtngayKT.requestFocus();
            return false;
        }

        List<HopDong> list = dao.select();
        for (int i = 0; i < list.size(); i++) {
            if (txtmaHD.getText().equals(list.get(i).getMaHD())) {
                JOptionPane.showMessageDialog(this, "Trùng mã hợp đồng!", "Error", 1);
                txtmaHD.requestFocus();
                return false;
            }
        }

        return true;

    }

    ;
    
    public boolean checkUpdate() {
        //HopDong model = dao.findById(txtmaHD.getText());
        if (txtmaHD.getText().isEmpty() || txtmaNV.getText().isEmpty() || txtLoai.getText().isEmpty()
                || txtngayBD.getText().isEmpty() || txtngayKT.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Error", 1);
            return false;

        } else if (!(txtngayBD.getText()).matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng ngày! Xin vui lòng nhập đúng định dạng yyyy-mm-dd", "Error", 1);
            txtngayBD.requestFocus();
            return false;
        } else if (!(txtngayKT.getText()).matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng ngày! Xin vui lòng nhập đúng định dạng yyyy-mm-dd", "Error", 1);
            txtngayKT.requestFocus();
            return false;
        }

        return true;

    }

    ;
    
    void init() {
        setIconImage(ShareHelper.APP_ICON);
        setLocationRelativeTo(null);
    }
    
    public boolean checkDate() {
        Date ngayKT = XDate.toDate(txtngayKT.getText(), "yyyy-MM-dd");
        Date ngayBD = new Date();
        int ngay = ngayKT.getDate() - ngayBD.getDate();
        int thang = ngayKT.getMonth() - ngayBD.getMonth();
        int nam = ngayKT.getYear() - ngayBD.getYear();

        if (nam >= 1 && thang == 0 && ngay == 5) {
            return true;
        } else if (nam == 0 && thang > 0) {
            return true;
        } else if (nam > 0) {
            return true;
        } else {
            DialogHelper.alert(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu ít nhất 1 năm !");
            return false;
        }

    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tbldanhsach.getModel();
        model.setRowCount(0);
        try {
            
            List<HopDong> list = dao.select();
            for (HopDong hd : list) {
                Object[] row = {
                    hd.getMaHD(),
                    hd.getMaNV(),
                    hd.getLoaiHD(),
                    hd.getNgayBD(),
                    hd.getNgayKT(),
                    //hd.getHinh()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        HopDong model = getModel();
        try {
            dao.insert(model);
            //this.fillComboBox();
            this.load();
            this.clear();
            DialogHelper.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Thêm mới thất bại!");
        }
    }

    void update() {
        HopDong model = getModel();

        try {
            dao.update(model);
            this.load();
            DialogHelper.alert(this, "Cập nhập Thành công!");
        } catch (Exception a) {
            DialogHelper.alert(this, "Cập nhập thất bại!");

        }
    }

    void delete() {
        if (DialogHelper.confirm(this, "Bạn có thực sự muốn xóa nhân viên này không?")) {
            String maHD = txtmaHD.getText();
            try {
                dao.delete(maHD);
                this.load();
                this.clear();
                DialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception a) {
                DialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }

    void edit() {
        try {
            String manv = (String) tbldanhsach.getValueAt(this.index, 0);
            HopDong model = dao.findById(manv);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception a) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void clear() {
        this.setModel(new HopDong());
        this.setStatus(true);
        //  lblimage.setIcon(null);
    }
//    
//

    void setStatus(boolean insertable) {
        btnChonmanv.setEnabled(insertable);
        txtmaHD.setEditable(insertable);
        txtmaNV.setEditable(false);
        btnSave.setEnabled(insertable);
        btnEdit.setEnabled(!insertable);
        btnDelete.setEnabled(!insertable);
        boolean first = this.index > 0;
        boolean last = this.index < tbldanhsach.getRowCount() - 1;
        fist.setEnabled(!insertable && first);
        prev.setEnabled(!insertable && first);
        next.setEnabled(!insertable && last);
        Last.setEnabled(!insertable && last);
    }

    void setModel(HopDong model) {
        txtmaHD.setText(model.getMaHD());
        txtmaNV.setText(model.getMaNV());
        txtLoai.setText(model.getLoaiHD());
        txtngayBD.setText(model.getNgayBD());
        txtngayKT.setText(model.getNgayKT());
//        lblimage.setToolTipText(model.getHinh());
//        if (model.getHinh() != null) {
//            lblimage.setIcon(ShareHelper.readLogo(model.getHinh()));
//        }
    }
//

    HopDong getModel() {
        HopDong model = new HopDong();
        model.setMaHD(txtmaHD.getText());
        model.setMaNV(txtmaNV.getText());
        model.setLoaiHD(txtLoai.getText());
        model.setNgayBD(txtngayBD.getText());
        model.setNgayKT(txtngayKT.getText());
       // model.setHinh(lblimage.getToolTipText());
        return model;
    }

//    void fillComboBox() {
//        DefaultComboBoxModel model = (DefaultComboBoxModel) txtmanv.getModel();
//        model.removeAllElements();
//        try {
//            List<NhanVien> list = nvdao.select();
//            for (NhanVien MaNV : list) {
//                model.addElement(MaNV.getMaNV());
//            }
//        } catch (Exception e) {
//            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
//            e.printStackTrace();
//        }
//    }

//    void selectImage() {
//        JFileChooser fileChooser = new JFileChooser("src\\logos\\");
//        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            File file = fileChooser.getSelectedFile();
//            if (ShareHelper.saveLogo(file)) {
//                lblimage.setIcon(ShareHelper.readLogo(file.getName()));
//                lblimage.setToolTipText(file.getName());
//            }
//        }
//    }

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
        lblmatkhau = new javax.swing.JLabel();
        lblhoten = new javax.swing.JLabel();
        txtmaHD = new javax.swing.JTextField();
        txtngayBD = new javax.swing.JTextField();
        lbldienthoai = new javax.swing.JLabel();
        txtLoai = new javax.swing.JTextField();
        lblvaitro = new javax.swing.JLabel();
        prev = new javax.swing.JLabel();
        fist = new javax.swing.JLabel();
        Last = new javax.swing.JLabel();
        next = new javax.swing.JLabel();
        txtngayKT = new javax.swing.JTextField();
        lbldienthoai1 = new javax.swing.JLabel();
        txtmaNV = new javax.swing.JTextField();
        btnChonmanv = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldanhsach = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnMoi = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();

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

        lblmatkhau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblmatkhau.setText("MÃ HỢP ĐỒNG");

        lblhoten.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblhoten.setText("MÃ NHÂN VIÊN");

        txtmaHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtngayBD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbldienthoai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbldienthoai.setText("NGÀY BẮT ĐẦU");

        txtLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblvaitro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblvaitro.setText("TYPE");

        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prev.png"))); // NOI18N
        prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prevMouseClicked(evt);
            }
        });

        fist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fist.png"))); // NOI18N
        fist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fistMouseClicked(evt);
            }
        });

        Last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/last.png"))); // NOI18N
        Last.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LastMouseClicked(evt);
            }
        });

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/next.png"))); // NOI18N
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
        });

        txtngayKT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbldienthoai1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbldienthoai1.setText("NGÀY KẾT THÚC");

        txtmaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnChonmanv.setText("Chọn mã nhân viên");
        btnChonmanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonmanvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(fist)
                .addGap(18, 18, 18)
                .addComponent(prev)
                .addGap(18, 18, 18)
                .addComponent(next)
                .addGap(18, 18, 18)
                .addComponent(Last)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblhoten, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addComponent(lblvaitro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbldienthoai1)
                    .addComponent(lbldienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtngayKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addComponent(txtmaNV, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(txtngayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChonmanv)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmatkhau)
                    .addComponent(txtmaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblhoten)
                    .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonmanv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblvaitro)
                    .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldienthoai)
                    .addComponent(txtngayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldienthoai1)
                    .addComponent(txtngayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(prev)
                    .addComponent(fist)
                    .addComponent(Last)
                    .addComponent(next))
                .addGap(44, 44, 44))
        );

        tabs.addTab("Chi tiết", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbldanhsach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbldanhsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ HỢP ĐỒNG", "MÃ NHÂN VIÊN", "LOẠI HỢP ĐỒNG", "NGÀY BẮT ĐẦU", "NGÀY KẾT THÚC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

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

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem)
                    .addComponent(txtSearch))
                .addGap(0, 423, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGap(0, 42, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tabs.addTab("Danh Sách", jPanel4);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("QUẢN LÝ HỢP ĐỒNG ");

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

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(392, 392, 392)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabs)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseClicked
        // TODO add your handling code here:
        this.index--;
        this.edit();
    }//GEN-LAST:event_prevMouseClicked

    private void fistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fistMouseClicked
        // TODO add your handling code here:
        this.index = 0;
        this.edit();
    }//GEN-LAST:event_fistMouseClicked

    private void LastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LastMouseClicked
        // TODO add your handling code here:
        this.index = tbldanhsach.getRowCount() - 1;
        this.edit();
    }//GEN-LAST:event_LastMouseClicked

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        // TODO add your handling code here:
        this.index++;
        this.edit();
    }//GEN-LAST:event_nextMouseClicked

    private void tbldanhsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tbldanhsach.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tbldanhsachMouseClicked

    private void tabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabsMouseClicked

    private void btnMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiMouseClicked
        // TODO add your handling code here:
        this.clear();
    }//GEN-LAST:event_btnMoiMouseClicked

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        this.delete();

    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        if (this.check() && this.checkDate()) {
            this.insert();
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        if (this.checkUpdate() && this.checkDate()) {
            this.update();
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        new MainAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) tbldanhsach.getModel();
        String search = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tbldanhsach.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnChonmanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonmanvActionPerformed
        // TODO add your handling code here:
        chonNVHD chon = new chonNVHD(this, true);
        chon.setVisible(true);
        txtmaNV.setText(chon.MaNV);
        load();
    }//GEN-LAST:event_btnChonmanvActionPerformed

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
            java.util.logging.Logger.getLogger(QLHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLHopDong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Last;
    private javax.swing.JButton btnChonmanv;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMoi;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.JLabel fist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbldienthoai;
    private javax.swing.JLabel lbldienthoai1;
    private javax.swing.JLabel lblhoten;
    private javax.swing.JLabel lblmatkhau;
    private javax.swing.JLabel lblvaitro;
    private javax.swing.JLabel next;
    private javax.swing.JLabel prev;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbldanhsach;
    private javax.swing.JTextField txtLoai;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtmaHD;
    private javax.swing.JTextField txtmaNV;
    private javax.swing.JTextField txtngayBD;
    private javax.swing.JTextField txtngayKT;
    // End of variables declaration//GEN-END:variables
}
