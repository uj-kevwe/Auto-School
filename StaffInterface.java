package asar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffInterface extends JFrame {
    JPanel p1, p2,p3, p11, p12;
    JComboBox comboClass;
    JButton btnUpload, btnReport;
    JLabel lblClass, lblMessage;
    String [] classes = {"Select Class","JSS1", "JSS2", "JSS3", "SS1",
    "SS2", "SS3"};
    Font font;
    int index;
    
    
    StaffInterface() {
        p1 = new JPanel();
        p11 = new JPanel();
        p12 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        comboClass = new JComboBox(classes);
        btnUpload = new JButton("Upload Scores");
        btnReport = new JButton("Prepare Report");
        lblClass = new JLabel("Class");
        lblMessage = new JLabel("Thank you for using ASAR");
        
        font = new Font("Times New Roman", Font.ITALIC,10);
    }
    
    public void displayWin() {
        String classSelected = "";
        setTitle("Staff Interface");
        setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(2,1));
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        p11.setLayout(new FlowLayout());
        p12.setLayout(new FlowLayout());
        
        btnUpload.setSize(200, 200);
        btnReport.setSize(200, 200);
        
           
       /*     if(index == 1) {
                classSelected = "JSS1";
            }
            else if(index == 2) {
                classSelected = "JSS2";
            }
            else if(index == 3) {
                classSelected = "JSS3";
            }
            else if(index == 4) {
                classSelected = "SS1";
            }
            else if(index == 5) {
                classSelected = "SS2";
            }
            else if(index == 6) {
                classSelected = "SS3";
            }*/
        
/*        btnUpload.addActionListener(new ActionListener(){   
            public void actionPerformed(ActionEvent e) {
                dispose();
                   int index = comboClass.getSelectedIndex();
                UploadScores up = new UploadScores();
                up.displayScreen(index);
            }
        });*/
            btnUpload.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   dispose();
                   int index = comboClass.getSelectedIndex();
                   UploadScores u = new UploadScores();
                   u.display(index);
               } 
            });
        
        lblMessage.setFont(font);
        
        p11.add(new JLabel("AUTOMATED STUDENT ASSESMENT RECORD"));
        p12.add(lblClass); p12.add(comboClass);
        p1.add(p11); p1.add(p12);
        p2.add(btnUpload); p2.add(btnReport);
        p3.add(lblMessage);
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setVisible(true);
    }
}
