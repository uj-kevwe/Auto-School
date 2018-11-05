package asar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.Workbook.*;
import jxl.Workbook;


/** Code Lagos Out of School
 ** Season 4.0
 ** Class Group Project
 ** Author: Afternoon Session 
 ** Supervisor: Mr. Urijah Omiunu
 */

public class ASAR {
    
    //create all controls and containers
    JFrame f;
    JPanel pNorth, pCenter, pSouth;
    JLabel lblTitle, lblUser, lblPass;
    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnSign_in, btnReset, btnCreateProfile;
    
    String username = "adminuser";
    String password = "adminpassword";
    //create constructor
    ASAR() {
        //register all controls
        f = new JFrame("ASAR LOGon Page");
        pNorth = new JPanel();
        pCenter = new JPanel();
        pSouth = new JPanel();
        lblTitle = new JLabel("AUTOMATED SCHOOL ACADEMIC RECORD");
        lblUser = new JLabel("Username");
        lblPass = new JLabel("Password");
        txtUser = new JTextField();
        txtPass = new JPasswordField();
        btnSign_in = new JButton("Sign in");
        btnReset = new JButton("Reset");
        btnCreateProfile = new JButton("Sign Up");
    }
    
    public void displayMe() {
        //set Layout Managers on all containers
        f.setLayout(new BorderLayout());
        pNorth.setLayout(new FlowLayout());
        pCenter.setLayout(new GridLayout(2,2));
        pSouth.setLayout(new FlowLayout());
        
        //add an ActionListener to Button Reset
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                txtUser.setText("");
                txtPass.setText("");
            }
        });
        
        //add an ActionListener to Button Sign_in
        btnSign_in.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(username.equals(txtUser.getText().toLowerCase())){
                    if(password.equals(txtPass.getText().toLowerCase())){
                        f.dispose();
                        
                        EntryMenu  em = new EntryMenu();
                        em.displayWindow();
                    }
                }
            }
        });
        
        //add the controls to their respective containers
        pNorth.add(lblTitle);
        pCenter.add(lblUser); pCenter.add(txtUser);
        pCenter.add(lblPass); pCenter.add(txtPass);
        pSouth.add(btnSign_in); pSouth.add(btnReset);
        pSouth.add(btnCreateProfile);
        
        f.add(pNorth, BorderLayout.NORTH);
        f.add(pCenter, BorderLayout.CENTER);
        f.add(pSouth, BorderLayout.SOUTH);
        
        //finalize and display the interface
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setResizable(false);
        f.setVisible(true);
        
        
    }
    
    //main method
    public static void main(String[] args) {
        
        ASAR a = new ASAR();
        a.displayMe();
    
    }
    
}

