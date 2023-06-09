/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLy;

import JDBC.DialogHelper;
import JDBC.ShareHelper;
import Main.Chao;
import Main.DangNhap;
import Main.HuongDan;
import ThongKe.ThongKe;
import Main.TroGiup;
import QuanLy.QLTaiKhoan;
import QuanLy.QLLuong;
import QuanLy.QLHopDong;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author User
 */
public class MainAdmin extends javax.swing.JFrame {

    /**
     * Creates new form MainAdmin
     */
    public MainAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tlsBar = new javax.swing.JToolBar();
        btnTK = new javax.swing.JButton();
        btnNV = new javax.swing.JButton();
        btnHDong = new javax.swing.JButton();
        btnLuong = new javax.swing.JButton();
        btnKho = new javax.swing.JButton();
        btnthongKe = new javax.swing.JButton();
        btnhuongDan = new javax.swing.JButton();
        btnhoTro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mnuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuDMK = new javax.swing.JMenuItem();
        mnuInfo = new javax.swing.JMenuItem();
        mnuLogout = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuTK = new javax.swing.JMenuItem();
        mnuNV = new javax.swing.JMenuItem();
        mnuHDong = new javax.swing.JMenuItem();
        mnuLuong = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        jMenu3.setText("File");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar1.add(jMenu4);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FOLT's Sales Management System");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Backgrounds2.jpg"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(244, 236, 253));

        tlsBar.setBackground(new java.awt.Color(204, 255, 255));
        tlsBar.setBorder(null);
        tlsBar.setRollover(true);

        btnTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/taikhoan.png"))); // NOI18N
        btnTK.setFocusable(false);
        btnTK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTK.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });
        tlsBar.add(btnTK);

        btnNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nhanvien.png"))); // NOI18N
        btnNV.setFocusable(false);
        btnNV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNVActionPerformed(evt);
            }
        });
        tlsBar.add(btnNV);

        btnHDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hopdong.png"))); // NOI18N
        btnHDong.setFocusable(false);
        btnHDong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHDong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHDongMouseClicked(evt);
            }
        });
        btnHDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDongActionPerformed(evt);
            }
        });
        tlsBar.add(btnHDong);

        btnLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/luong.png"))); // NOI18N
        btnLuong.setFocusable(false);
        btnLuong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLuong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuongActionPerformed(evt);
            }
        });
        tlsBar.add(btnLuong);

        btnKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kho.jpg"))); // NOI18N
        btnKho.setFocusable(false);
        btnKho.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKho.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoActionPerformed(evt);
            }
        });
        tlsBar.add(btnKho);

        btnthongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/thongke.png"))); // NOI18N
        btnthongKe.setFocusable(false);
        btnthongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnthongKe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnthongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnthongKeMouseClicked(evt);
            }
        });
        btnthongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthongKeActionPerformed(evt);
            }
        });
        tlsBar.add(btnthongKe);

        btnhuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/huongdan.png"))); // NOI18N
        btnhuongDan.setFocusable(false);
        btnhuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnhuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnhuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuongDanActionPerformed(evt);
            }
        });
        tlsBar.add(btnhuongDan);

        btnhoTro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/HOTRO.png"))); // NOI18N
        btnhoTro.setFocusable(false);
        btnhoTro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnhoTro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnhoTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhoTroActionPerformed(evt);
            }
        });
        tlsBar.add(btnhoTro);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tlsBar, javax.swing.GroupLayout.PREFERRED_SIZE, 1172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tlsBar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Version 1.0     |     Bản quyền FOTL’s Team     |     Hotline Mr.Trung - 0362.265.399     |     Website http//fotlsteam.com");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnuBar.setBackground(new java.awt.Color(204, 204, 255));
        mnuBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mnuBar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hethong.png"))); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });

        mnuDMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/doimatkhau.png"))); // NOI18N
        mnuDMK.setText("Đổi mật khẩu");
        mnuDMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDMKActionPerformed(evt);
            }
        });
        jMenu1.add(mnuDMK);

        mnuInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/thongtin.png"))); // NOI18N
        mnuInfo.setText("Thông tin TK");
        mnuInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInfoActionPerformed(evt);
            }
        });
        jMenu1.add(mnuInfo);

        mnuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/dangxuat.png"))); // NOI18N
        mnuLogout.setText("Đăng xuất");
        mnuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuLogoutMouseClicked(evt);
            }
        });
        mnuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(mnuLogout);
        jMenu1.add(jSeparator4);

        mnuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/exit.png"))); // NOI18N
        mnuExit.setText("Thoát");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExit);

        mnuBar.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chucnang.png"))); // NOI18N

        mnuTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/taikhoan.png"))); // NOI18N
        mnuTK.setText("Tài khoản");
        mnuTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTKActionPerformed(evt);
            }
        });
        jMenu2.add(mnuTK);

        mnuNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/nhanvien.png"))); // NOI18N
        mnuNV.setText("Nhân viên");
        mnuNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNVActionPerformed(evt);
            }
        });
        jMenu2.add(mnuNV);

        mnuHDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/hop dong.png"))); // NOI18N
        mnuHDong.setText("Hợp đồng");
        mnuHDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHDongActionPerformed(evt);
            }
        });
        jMenu2.add(mnuHDong);

        mnuLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/luong.png"))); // NOI18N
        mnuLuong.setText("Lương");
        mnuLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLuongActionPerformed(evt);
            }
        });
        jMenu2.add(mnuLuong);

        mnuBar.add(jMenu2);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lienhe.png"))); // NOI18N

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/nha cung cap.png"))); // NOI18N
        jMenuItem9.setText("Nhà cung cấp");
        jMenu5.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/hoadon.png"))); // NOI18N
        jMenuItem10.setText("Hóa đơn");
        jMenu5.add(jMenuItem10);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/kho.png"))); // NOI18N
        jMenuItem11.setText("Kho");
        jMenu5.add(jMenuItem11);

        mnuBar.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/thongtin.png"))); // NOI18N

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/tro giup.png"))); // NOI18N
        jMenuItem12.setText("Hỗ trợ");
        jMenu6.add(jMenuItem12);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img Icon/huong dan.png"))); // NOI18N
        jMenuItem13.setText("Hướng dẫn");
        jMenu6.add(jMenuItem13);

        jMenuItem14.setText("Liên hệ");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        mnuBar.add(jMenu6);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
       new QLTaiKhoan().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnTKActionPerformed

    private void btnNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNVActionPerformed
        try {
            QLNhanVien nhanVien = new QLNhanVien();
            nhanVien.setVisible(true);
            dispose();
        } catch (ParseException ex) {
            Logger.getLogger(MainAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNVActionPerformed

    private void btnHDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDongActionPerformed
       
    }//GEN-LAST:event_btnHDongActionPerformed

    private void btnLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuongActionPerformed
        new QLLuong().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLuongActionPerformed

    private void btnKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoActionPerformed
       new QLSanPham().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKhoActionPerformed

    private void btnthongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthongKeActionPerformed
        new ThongKe().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnthongKeActionPerformed

    private void btnhuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuongDanActionPerformed
       new NhaCungCap().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnhuongDanActionPerformed

    private void btnhoTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhoTroActionPerformed
        new QLHoaDon().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnhoTroActionPerformed

    private void mnuInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInfoActionPerformed
        // TODO add your handling code here:
        new QLTaiKhoan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuInfoActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu1MouseClicked

    private void mnuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogoutActionPerformed
        if (DialogHelper.confirm(this, "Bạn muốn đăng xuất?")) {
            ShareHelper.USER = null;
            this.dispose();
            new Main.DangNhap(this, true).setVisible(true);
        }
    }//GEN-LAST:event_mnuLogoutActionPerformed

    private void mnuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuLogoutMouseClicked
        // TODO add your handling code here: 
        this.setVisible(false);
         new DangNhap(this, true).setVisible(true);
        
    }//GEN-LAST:event_mnuLogoutMouseClicked

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
       if (DialogHelper.confirm(this, "Bạn thật sự muốn thoát?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuDMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDMKActionPerformed
        new Main.DMK().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuDMKActionPerformed

    private void mnuTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTKActionPerformed
        // TODO add your handling code here:
         new QLTaiKhoan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuTKActionPerformed

    private void mnuNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNVActionPerformed
       this.dispose();
        try {
            new QLNhanVien().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(MainAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuNVActionPerformed

    private void mnuHDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHDongActionPerformed
        // TODO add your handling code here:
        new QLHopDong().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuHDongActionPerformed

    private void mnuLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLuongActionPerformed
        // TODO add your handling code here:
        new QLLuong().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuLuongActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void btnHDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHDongMouseClicked
        new QLHopDong().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHDongMouseClicked

    private void btnthongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthongKeMouseClicked
        new ThongKe().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnthongKeMouseClicked

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
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHDong;
    private javax.swing.JButton btnKho;
    private javax.swing.JButton btnLuong;
    private javax.swing.JButton btnNV;
    private javax.swing.JButton btnTK;
    private javax.swing.JButton btnhoTro;
    private javax.swing.JButton btnhuongDan;
    private javax.swing.JButton btnthongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenuItem mnuDMK;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuHDong;
    private javax.swing.JMenuItem mnuInfo;
    private javax.swing.JMenuItem mnuLogout;
    private javax.swing.JMenuItem mnuLuong;
    private javax.swing.JMenuItem mnuNV;
    private javax.swing.JMenuItem mnuTK;
    private javax.swing.JToolBar tlsBar;
    // End of variables declaration//GEN-END:variables
}
