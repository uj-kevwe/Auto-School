package asar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentInterface extends JFrame {
    
    StudentInterface() {
        
    }
    
    public void displayWin() {
        setTitle("Student Interface");
        add(new JLabel("AUTOMATED SCHOOL ACADEMIC RECORD"));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setResizable(false);
        setVisible(true);
    }
}