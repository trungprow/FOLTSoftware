/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.awt.Component;
import javax.swing.JOptionPane;

public class DialogHelper {
    public static void alert(Component parent,String meggage){
        JOptionPane.showMessageDialog(parent, meggage,
                "HỆ THỐNG QUẢN LÍ",JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confirm(Component parent,String message){
        int result = JOptionPane.showConfirmDialog(parent, message,
                "HỆ THỐNG QUẢN LÍ",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    public static String prompt(Component parent,String meggage){
        return JOptionPane.showInputDialog(parent,meggage,
                "HỆ THỐNG QUẢN LÍ",JOptionPane.INFORMATION_MESSAGE);
    }
}
