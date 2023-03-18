/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLy;

import DAO.LuongDAO;
import JDBC.DialogHelper;
import MODEL.Luong;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author PC
 */
public class QLLuong extends javax.swing.JFrame {

    int index = 0;
    LuongDAO dao = new LuongDAO();
    
    /**
     * Creates new form QLLuong1
     */
    public QLLuong() {
        initComponents();
        setLocationRelativeTo(null);
        load();
        txtTongl.setEditable(false);
        txtmaNV.setEditable(false);
    }
   
    public boolean check() {

        if (txtmaLuong.getText().equals("") || txtmaNV.getText().equals(""))  {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập đủ dữ liệu sau đó ấn Save", "Error", 1);
            return false;
        } else if(txtTongl.getText().equals("")){
            JOptionPane.showMessageDialog(this,"vui lòng nhấn nút tính tổng");
        }
        List<Luong> list = dao.select();
        for (int i = 0; i < list.size(); i++) {
            if (txtmaLuong.getText().equalsIgnoreCase(list.get(i).getMaNV())) {
                JOptionPane.showMessageDialog(this, "Trùng Mã Lương", "Error", 1);
                return false;
            }
        }

        return true;
    }
     public boolean check2() {
       
        if (txtmaLuong.getText().equals("") || txtmaNV.getText().equals(""))  {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập đủ dữ liệu sau đó ấn Save", "Error", 1);
            return false;
        }else if( txtluongCoBan.getText().matches("[0-9]{1,11}") || txtHsl.getText().equals("")) {
           JOptionPane.showMessageDialog(this, "vui lòng nhập số lương và hệ số lương");
        }
        
        else if( txtHsl.getText().matches("[0-9]{1,11}")){
            JOptionPane.showMessageDialog(this,"vui lòng nhấn nút tính tổng");
        }
        

        return true;
    }
    void load() {
        DefaultTableModel model = (DefaultTableModel) tbldanhsach.getModel();
        model.setRowCount(0);
        try {
            List<Luong> list = dao.select();
            for (Luong nv : list) {
                Object[] row = {
                    nv.getMaLuong(),
                    nv.getMaNV(),
                    nv.getHeSoluong(),
                    nv.getLuongCoBan(),
                    nv.getTongLuong()};
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    void insert() {
        Luong model = getModel();

        try {
            dao.insert(model);
            this.load();
            this.clear();
            DialogHelper.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm mới thất bại!");
        }

    }

    void update() {
        Luong model = getModel();
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
            String maLuong = txtmaLuong.getText();
            try {
                dao.delete(maLuong);
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
            String maLuong = (String) tbldanhsach.getValueAt(this.index, 0);
            Luong model = dao.findById(maLuong);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception a) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void clear() {
        this.setModel(new Luong());
        this.setStatus(true);
    }

    void setStatus(boolean insertable) {
        
        txtmaLuong.setEditable(insertable);
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

    void setModel(Luong model) {
        txtmaLuong.setText(model.getMaLuong());
        txtmaNV.setText(model.getMaNV());
        txtHsl.setText(String.valueOf(model.getHeSoluong()));
        txtluongCoBan.setText(String.format("%.0f", model.getLuongCoBan()));
        txtTongl.setText(String.format("%.0f", model.getTongLuong()));

    }

    Luong getModel() {
        Luong model = new Luong();
        model.setMaLuong(txtmaLuong.getText());
        model.setMaNV(txtmaNV.getText());
        model.setHeSoluong(Float.valueOf(txtHsl.getText()));
        model.setLuongCoBan(Float.valueOf(txtluongCoBan.getText()));
        model.setTongLuong(Float.valueOf(txtTongl.getText()));
        return model;
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
        lblmatkhau = new javax.swing.JLabel();
        lblhoten = new javax.swing.JLabel();
        txtmaNV = new javax.swing.JTextField();
        txtluongCoBan = new javax.swing.JTextField();
        lbldienthoai = new javax.swing.JLabel();
        txtHsl = new javax.swing.JTextField();
        lblvaitro = new javax.swing.JLabel();
        prev = new javax.swing.JLabel();
        fist = new javax.swing.JLabel();
        Last = new javax.swing.JLabel();
        next = new javax.swing.JLabel();
        txtmaLuong = new javax.swing.JTextField();
        lblTongluong = new javax.swing.JLabel();
        txtTongl = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
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
        lblmatkhau.setText("MÃ LƯƠNG");

        lblhoten.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblhoten.setText("MÃ NHÂN VIÊN");

        txtmaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtmaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaNVActionPerformed(evt);
            }
        });

        txtluongCoBan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtluongCoBan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtluongCoBanFocusLost(evt);
            }
        });

        lbldienthoai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbldienthoai.setText("LƯƠNG CƠ BẢN");

        txtHsl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHsl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHslFocusLost(evt);
            }
        });

        lblvaitro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblvaitro.setText("HỆ SỐ LƯƠNG");

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

        txtmaLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblTongluong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTongluong.setText("TỔNG LƯƠNG");

        txtTongl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTonglActionPerformed(evt);
            }
        });

        jButton1.setText("chọn nhân viên");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(fist)
                .addGap(18, 18, 18)
                .addComponent(prev)
                .addGap(18, 18, 18)
                .addComponent(next)
                .addGap(18, 18, 18)
                .addComponent(Last)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblhoten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblvaitro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbldienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTongluong, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtmaNV)
                    .addComponent(txtHsl)
                    .addComponent(txtluongCoBan, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addComponent(txtmaLuong)
                    .addComponent(txtTongl))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmatkhau))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblhoten)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHsl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvaitro))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtluongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldienthoai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongluong))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(prev)
                    .addComponent(fist)
                    .addComponent(Last)
                    .addComponent(next))
                .addGap(37, 37, 37))
        );

        tabs.addTab("Lương", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbldanhsach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbldanhsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ LƯƠNG", "MÃ NHÂN VIÊN", "HỆ SỐ LƯƠNG", "LƯƠNG CƠ BẢN", "TỔNG LƯƠNG"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addGap(91, 91, 91))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTimKiem)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 418, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGap(0, 41, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tabs.addTab("Danh Sách", jPanel4);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("QUẢN LÝ LƯƠNG");

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
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_prevMouseClicked

    private void fistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fistMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fistMouseClicked

    private void LastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LastMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LastMouseClicked

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        // TODO add your handling code here:
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
       if(check()){
            this.insert();
       }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        
        if(check2()){
           this.update();
       }
        
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked

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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        chonNV chon = new chonNV(this, true);
        chon.setVisible(true);
        txtmaNV.setText(chon.MaNV);
        load();
    }//GEN-LAST:event_jButton1MouseClicked

    private void txtTonglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTonglActionPerformed
        // TODO add your handling code here:
        if (txtluongCoBan.getText().isEmpty() || txtHsl.getText().isEmpty()) {
            DialogHelper.alert(this, "vui lòng nhập số lương và hệ số lương");
        } else {
            Double price = Double.parseDouble(txtHsl.getText());
            Double vira = Double.parseDouble(txtluongCoBan.getText());
            Double cost = price * vira;
            txtTongl.setText(String.format("%.0f", cost));
        }
    }//GEN-LAST:event_txtTonglActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        chonNV chon = new chonNV(this, true);
        chon.setVisible(true);
        txtmaNV.setText(chon.MaNV);
        load();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtHslFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHslFocusLost
        // TODO add your handling code here:
        if (txtluongCoBan.getText().isEmpty() || txtHsl.getText().isEmpty()) {
            DialogHelper.alert(this, "vui lòng nhập số lương và hệ số lương");
        } else {
            Double price = Double.parseDouble(txtHsl.getText());
            Double vira = Double.parseDouble(txtluongCoBan.getText());
            Double cost = price * vira;
            txtTongl.setText(String.format("%.0f", cost));
        }
    }//GEN-LAST:event_txtHslFocusLost

    private void txtmaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaNVActionPerformed

    private void txtluongCoBanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtluongCoBanFocusLost
        // TODO add your handling code here:
        if (txtluongCoBan.getText().isEmpty() || txtHsl.getText().isEmpty()) {
            DialogHelper.alert(this, "vui lòng nhập số lương và hệ số lương");
        } else {
            Double price = Double.parseDouble(txtHsl.getText());
            Double vira = Double.parseDouble(txtluongCoBan.getText());
            Double cost = price * vira;
            txtTongl.setText(String.format("%.0f", cost));
        }
    }//GEN-LAST:event_txtluongCoBanFocusLost

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
            java.util.logging.Logger.getLogger(QLLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLLuong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Last;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMoi;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.JLabel fist;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTongluong;
    private javax.swing.JLabel lbldienthoai;
    private javax.swing.JLabel lblhoten;
    private javax.swing.JLabel lblmatkhau;
    private javax.swing.JLabel lblvaitro;
    private javax.swing.JLabel next;
    private javax.swing.JLabel prev;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbldanhsach;
    private javax.swing.JTextField txtHsl;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTongl;
    private javax.swing.JTextField txtluongCoBan;
    private javax.swing.JTextField txtmaLuong;
    private javax.swing.JTextField txtmaNV;
    // End of variables declaration//GEN-END:variables
}
