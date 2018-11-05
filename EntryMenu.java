package asar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntryMenu {
    JFrame f;
    JPanel panelTop, panelMid, panelBot;
    JLabel lblTitle;
    JRadioButton radioStaff, radioStudent;
    ButtonGroup group;
    JButton btnNext, btnBack, btnDummy;
    
    
    EntryMenu() {
        f = new JFrame("User option Page");
        panelTop = new JPanel();
        panelMid = new JPanel();
        panelBot = new JPanel();
        lblTitle = new JLabel("AUTOMATED SCHOOL ACADEMIC RECORD");
        radioStaff = new JRadioButton("Staff");
        radioStudent = new JRadioButton("Student");
        group = new ButtonGroup();
        group.add(radioStaff); group.add(radioStudent);
        btnNext = new JButton("Next");
        btnBack = new JButton("Back");
        btnDummy = new JButton("");
        btnNext.setToolTipText("proceed to next page");
        btnBack.setToolTipText("you are logging out");
    }
    
    public void displayWindow() {
        f.setLayout(new BorderLayout());
        panelTop.setLayout(new FlowLayout());
        panelMid.setLayout(new GridLayout(3,1));
        panelBot.setLayout(new FlowLayout());
        
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                ASAR a = new ASAR();
                a.displayMe();
            }
        });
        
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(radioStaff.isSelected()){
                    f.dispose();
                    StaffInterface s = new StaffInterface();
                    s.displayWin();
                }
                else if (radioStudent.isSelected()){
                    f.dispose();
                    StudentInterface s = new StudentInterface();
                    s.displayWin();
                }
                else
                    JOptionPane.showMessageDialog(null, "You Must select a user Type");
                
                
                
                
                
            }
        });
        
        panelTop.add(lblTitle);
        panelMid.add(new JLabel("select a user type"));
        panelMid.add(radioStaff);
        panelMid.add(radioStudent);
        panelBot.add(btnNext);
        panelBot.add(btnBack);
        
        f.add(panelTop, BorderLayout.NORTH);
        f.add(panelMid, BorderLayout.CENTER);
        f.add(panelBot, BorderLayout.SOUTH);
        f.add(btnDummy, BorderLayout.WEST);
        btnDummy.setEnabled(false);
        btnDummy.setBorderPainted(false);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.pack();
        f.setVisible(true);
    }
    
}
