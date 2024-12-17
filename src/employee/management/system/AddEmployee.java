
package employee.management.system;
//import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class AddEmployee extends JFrame implements ActionListener{

    Random ran=new Random();
    int number=ran.nextInt(999999);
    JButton add,back;
    JTextField tfname,tffname,tffsalary,tffaddress,tfphone,tffemail,tffdesignation,tfaadhar;
    JDateChooser dateChooser;
    JLabel lbelempid;
    JComboBox cbeducation;
    public AddEmployee(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel heading=new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("san_serif",Font.BOLD,25));
        add(heading);
        
         JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        
        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        
   dateChooser=new JDateChooser();
   dateChooser.setBounds(200,200,150,30);
  // dateChooser.setForeground(new Color(105,105,105));
    add(dateChooser);
        
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        
        tffsalary=new JTextField();
        tffsalary.setBounds(600,200,150,30);
        add(tffsalary);
        
         JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);
        
        tffaddress=new JTextField();
        tffaddress.setBounds(200,250,150,30);
        add(tffaddress);
        
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        
        tffemail=new JTextField();
        tffemail.setBounds(200,300,150,30);
        add(tffemail);
        
        JLabel labeleducation=new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);
        
        String cources[]={"BBA","BCA","BA","B.COM","BTech","MBA","MCA","MA","MTech","MSC","BSC","Phd"};
        cbeducation=new JComboBox(cources);
        cbeducation.setBounds(600,300,150,30);
        cbeducation.setBackground(Color.white);
        add(cbeducation);
        
         JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tffdesignation=new JTextField();
        tffdesignation.setBounds(200,350,150,30);
        add(tffdesignation);
        
        JLabel labelaadhar=new JLabel("Aadhar");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        JLabel labelempid=new JLabel("Employee id");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);
        
        lbelempid=new JLabel("" +number);          //"" It converts number into the String
        lbelempid.setBounds(200,400,150,30);
        lbelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lbelempid);
        
         add=new JButton("Add Details");
         add.setBounds(250,550,150,40);
     //   add.addActionListener(this);
       add.setBackground(Color.black);
       add.setForeground(Color.white);
       add.addActionListener(this);
         add(add);
        
       back=new JButton("Back");
       back.setBounds(450,550,150,40);
       back.addActionListener(this);
       back.setBackground(Color.black);
       back.setForeground(Color.white);
       back.addActionListener(this);
       add(back);
        
         
         
      setSize(900,700);
      setLocation(300,50);
      setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        //String dcdob;
      if(ae.getSource()==add){
          String name=tfname.getText();
          String fname=tffname.getText();
          String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
          String salary=tffsalary.getText();
          String address=tffaddress.getText();
          String phone=tfphone.getText();
          String email=tffemail.getText();
          String education=(String)cbeducation.getSelectedItem();
          String designation=tffdesignation.getText();
          String aadhar=tfaadhar.getText();
          String empid=lbelempid.getText();
          try{
             Conn conn=new Conn();
             String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
             conn.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Details added successfully");
             setVisible(false);
             new Home();
          }catch(Exception e){
              e.printStackTrace();
          }
          
          
          
          
          
      }  else{
        setVisible(false);
        new Home();
      }
        
        
    }
    
        public static void main(String args[]) {

        new AddEmployee();
        }
}
