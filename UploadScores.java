
package asar;

import java.io.File;
import java.io.IOException;
import javax.swing.*;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.Workbook;
import jxl.write.Label;
import java.awt.*;
import java.awt.event.*;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class UploadScores extends JFrame {
    JPanel p1, p2,p3;
    JComboBox comboStdtId;
    JTextField txtName, txtSubj, txtCA1, txtCA2, txtExam,txtTotal;
    JButton btnNextSubj, btnNextStdt;
    String [] idList, subjList;
    int subjIndex, subjCol = 4, subjRow = 2, subjCount = 1;
    int nameCol = 2, nameRow = 4, nameCount = 0;
    boolean loopAgain;
    
    
    UploadScores() {
        p1 = new JPanel(); p2 = new JPanel(); p3 = new JPanel();
        
        txtName = new JTextField(); txtSubj = new JTextField();
        txtCA1 = new JTextField("0"); txtCA2 = new JTextField("0");
        txtExam = new JTextField("0"); txtTotal = new JTextField("0");
        btnNextSubj = new JButton("Next Subject");
        btnNextStdt = new JButton("Next Student");
        
        
    }
    
    public void display(int index) {
        idList = new String [100];
        subjList = new String [100];
        try {
            //Steps to connect to excel
            //step1: create File object
            File f = new File("school.xls");
            
            //step2: connect an existing Workbook object
            Workbook w = Workbook.getWorkbook(f);
            //Step3: connect an existing sheet
            Sheet s = w.getSheet(index - 1);
            
            //retrieve all ID Numbers from excel
            int row = 4, col = 1;
            for(int i = 0; i<3; i++){
                idList[i] = s.getCell(col, row).getContents();
                
                row++;
            } 
            
            //retrieve all subjets from excel
            row = 2; col = 4;int ind = 0;
         
         loopAgain = true;
         while(loopAgain){
             if(!(s.getCell(col, 2).getContents().isEmpty())) {
                 subjList[ind] = s.getCell(col, 2).getContents();
                 col=col+4;
                 loopAgain = true;
                 System.out.println(subjList[ind]);
                 ind ++;
             }
             else
                 loopAgain = false;
             
         }
            w.close();
            System.out.println("Number of subjects:\t"+ ind);
        }
        
        catch (IOException e) {
            System.out.println("IOException observed");
        }
        
        catch(BiffException e) {
            System.out.println("BiffException Observed");
        }
        catch(ArrayIndexOutOfBoundsException e2){
            
        }
        comboStdtId = new JComboBox(idList);
        
        setLayout(new BorderLayout());
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(7,2));
        p3.setLayout(new GridLayout(2,1));
        
        
        txtName.setEditable(false);
        txtSubj.setEditable(false);
        txtTotal.setEditable(false);
        
        //subjCol = 4; subjRow = 2;
        subjIndex = 0;
        loopAgain = true;
//        while(loopAgain){
            try{
                File f = new File("school.xls");
                Workbook w = Workbook.getWorkbook(f);
                Sheet s = w.getSheet(index-1);
             
                txtName.setText((s.getCell(nameCol,nameRow).getContents() + " " +
                    s.getCell(nameCol+1, nameRow).getContents()));
            
                txtSubj.setText(s.getCell(subjCol, subjRow).getContents());
            
            }
            catch(IOException e) {
            
            }
            catch (BiffException e) {
            
            }
  //      }

        btnNextStdt.setEnabled(false);
        btnNextSubj.setEnabled(false);
        p1.add(new JLabel("AUTOMATED STUDENT ACADEMIC RECORD"));
        p2.add(new JLabel("Student ID Number:")); p2.add(comboStdtId);
        p2.add(new JLabel("Student Name"));
        p2.add(txtName);
        p2.add(new JLabel("Subject"));
        p2.add(txtSubj);
        p2.add(new JLabel("CA1 Scores"));
        p2.add(txtCA1);
        p2.add(new JLabel("CA2 Scores"));
        p2.add(txtCA2);
        p2.add(new JLabel("Exam Scores"));
        p2.add(txtExam);
        p2.add(new JLabel("Total Scores"));
        p2.add(txtTotal);
        p3.add(btnNextSubj);
        p3.add(btnNextStdt);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setVisible(true);
        
       // open excel to retrieve information 
                    txtCA1.addFocusListener(new FocusListener() {
                public void focusLost(FocusEvent e){
                    if(txtCA1.getText().isEmpty()){
                    
                        JOptionPane.showMessageDialog(null, "This field is not "
                            + "optional!");
                        
                        //txtCA1.setText("0");
                        txtCA1.grabFocus();
                        
                    }
                
                    else{
                        if(Integer.valueOf(txtCA1.getText().trim())>20) {
                            JOptionPane.showMessageDialog(null, "Assessment CA1 can't be greater than 20");
                            txtCA1.grabFocus();
                        }
                        
                        else {
                            int score = Integer.valueOf(txtCA1.getText().trim());
                            int total = Integer.valueOf(txtTotal.getText().trim()) + score;
                            txtTotal.setText(Integer.toString(total));
                            txtCA1.setEditable(false);
                        }
                        
                    }
                }
                public void focusGained(FocusEvent e1){
                    txtCA1.setText("");
                }
            });
        
            txtCA2.addFocusListener(new FocusListener() {
                public void focusLost(FocusEvent e){
                    if(txtCA2.getText().isEmpty()){
                    
                        JOptionPane.showMessageDialog(null, "This field is not "
                            + "optional!");
                        //txtCA2.setText("0");
                        txtCA2.grabFocus();
                    }
                
                    else{
                        if(Integer.valueOf(txtCA2.getText().trim())>20) {
                            JOptionPane.showMessageDialog(null, "Assessment CA2 can't be greater than 20");
                            txtCA2.grabFocus();
                        }
                        
                        else {
                            int score = Integer.valueOf(txtCA2.getText().trim());
                            int total = Integer.valueOf(txtTotal.getText().trim()) + score;
                            txtTotal.setText(Integer.toString(total));
                            txtCA2.setEditable(false);
                        }
                        
                    }
                }
                public void focusGained(FocusEvent e1){
                    txtCA2.setText("");
                }
            });
        
            txtExam.addFocusListener(new FocusListener() {
                public void focusLost(FocusEvent e){
                    if(txtExam.getText().isEmpty()){
                    
                        JOptionPane.showMessageDialog(null, "This field is not "
                            + "optional!");
                        //txtExam.setText("0");
                        txtExam.grabFocus();
                    }
                
                    else{
                        if(Integer.valueOf(txtExam.getText().trim())>60) {
                            JOptionPane.showMessageDialog(null, "Assessment CA1 can't be greater than 20");
                            txtExam.grabFocus();
                        }
                        
                        else {
                            int score = Integer.valueOf(txtExam.getText().trim());
                            int total = Integer.valueOf(txtTotal.getText().trim()) + score;
                            txtTotal.setText(Integer.toString(total));
                            txtExam.setEditable(false);
                        }
                        
                    }
                }
                public void focusGained(FocusEvent e1){
                    txtExam.setText("");
                }
            });
            
            txtTotal.addFocusListener(new FocusListener(){
                public void focusLost(FocusEvent f){
                    
                }
                
                public void focusGained(FocusEvent f){
                    btnNextSubj.setEnabled(true);
                }
            });
            
        
            btnNextSubj.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //store data into Excel File
                    
                    try{
                        File f = new File("school.xls");
                        Workbook w = Workbook.getWorkbook(f);
                        WritableWorkbook wCopy = Workbook.createWorkbook(new File("sch.xls"), w);
                        WritableSheet s = wCopy.getSheet(index-1);
                        s.addCell(new Label(nameCol+2,nameRow,txtCA1.getText()));
                        s.addCell(new Label(nameCol+3,nameRow,txtCA2.getText()));
                        s.addCell(new Label(nameCol+4,nameRow,txtExam.getText()));
                        s.addCell(new Label(nameCol+5,nameRow,txtTotal.getText()));
                    
                        JOptionPane.showMessageDialog(null, "NAME:  "+txtName.getText()+ "\nSUBJECT:  "
                            + txtSubj.getText() + "\n for "+subjCount + " subjects successfuly written to Excel");
                        subjCol = subjCol + 4; subjCount++; nameCol = nameCol+4;
                        //subjRow++;
                        //reset controls
                        txtSubj.setText(s.getCell(subjCol, subjRow).getContents());
                        txtCA1.setText("0"); txtCA1.setEditable(true);
                        txtCA2.setText("0"); txtCA2.setEditable(true);
                        txtExam.setText("0"); txtExam.setEditable(true);
                        txtTotal.setText("0");
                        
                        if(s.getCell(subjCol, subjRow).getContents().isEmpty()) {
                            btnNextSubj.setEnabled(false);
                            btnNextStdt.setEnabled(true);
                            JOptionPane.showMessageDialog(null, "Assessments for " + subjCount +
                                    " completed for " + txtName.getText() + ".\nProceed for next Student");
                        }
                        else
                            btnNextSubj.setEnabled(false);
                        txtCA1.grabFocus();
                        
                        System.out.println("ANYTHING");
                        wCopy.write();
                        wCopy.close();
                        w.close();
                        
                        File f1 = new File("sch.xls");
                        Workbook w1 = Workbook.getWorkbook(f1);
                        WritableWorkbook wCopy1 = Workbook.createWorkbook(new File("school.xls"), w1);
                        
                        
                        
                        wCopy1.write(); wCopy1.close();w1.close();
                        
                        
                    }
                    catch(IOException e2){
                         System.out.println("Wetin dey happen");
                         System.out.println(e2.getCause());
                         e2.printStackTrace();
                    }
                
                    catch(Exception e3) {
                        System.out.println("Na w oh");
                    }
                
                }
            });
            
            btnNextStdt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //nextStudent();
                    //reset counters
                    nameCount++;
                    nameCol =2; 
                    nameRow++;
                    subjCol = 4; 
                    subjRow=2; 
                    subjCount = 1;
                    
                    //reset Controls
                    comboStdtId.setSelectedIndex(nameCount);
                    try{
                        File f = new File("school.xls");
                        Workbook w = Workbook.getWorkbook(f);
                        Sheet s = w.getSheet(index-1);
                        
                        txtName.setText(s.getCell(nameCol, nameRow).getContents() +
                                " " + s.getCell(nameCol+1, nameRow).getContents());
                        
                        txtSubj.setText(s.getCell(subjCol, subjRow).getContents());
                        btnNextStdt.setEnabled(false);
                        
                        w.close();
                    }
                    catch(Exception ex) {
                        
                    }
                }
            });
            
            comboStdtId.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //nextStudent();
                }
            });
        
        
        
        
    }
}