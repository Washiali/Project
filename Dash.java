/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stace Omwando
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
 import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


public class Dash extends JFrame{

    private static void setModel(TableModel resultSetToTableModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    JTable table;
     JLabel message;
     DefaultTableModel model; 
     JButton add;
     JButton logout;
     String[] columnNames = {"Name", "Gender", "Telephone"
, "Date Of Birth", "Age"};
        

    public Dash(){
       
    JFrame one = new JFrame("Dashboard");
        Panel panel = new Panel();
        one.add(panel);
        
        message = new JLabel("Chart showing gender distribution");
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        
         panel.setLayout(null);
        message.setBounds(300, 10, 300, 30);
        table.setBounds(250,100,300,30);
        add.setBounds(200,350,100,30);
        logout.setBounds(250,350,100,30);
        
        one.add(add);
        one.add(table);
        one.add(logout);
        try {
    Class.forName("com.mysql.jdbc.Driver");
    String path ="jdbc:mysql://localhost:3306/student activity management system";
    String user = "root";
    String pass = "";
    Connection con =DriverManager.getConnection(path, user, pass);
    Statement stmt = con.createStatement();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql = "select * from club";
    pst = con.prepareStatement(sql);
    rs=pst.executeQuery(sql);
    Dash.setModel(DbUtils.resultSetToTableModel(rs));
    
    }                                    
catch(Exception e){
    JOptionPane.showMessageDialog(null, "Error!\n" +e, "ERROR",JOptionPane.ERROR_MESSAGE);
} 
        add.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                one.dispose();
                new adduser();
            }
        });  
        
        logout.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
                
            }
        });  
//        
         
    }
    public static void main(String []args){
   
   }
    
}
