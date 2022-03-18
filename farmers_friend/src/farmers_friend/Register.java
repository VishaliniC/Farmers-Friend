package farmers_friend;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
 
public class Register implements ActionListener {
	
	DataBaseConnection db_Object=new DataBaseConnection();
	
	JFrame frame;
	ImagePanel1 panel = new ImagePanel1(new ImageIcon("C:\\Users\\hp\\Downloads\\login.jpg").getImage());
    JLabel l = new JLabel("REGISTER PAGE");
    JLabel l1 = new JLabel("Name :");
    JLabel l2 = new JLabel("Email ID :");
    JLabel l3 = new JLabel("Mobile No :");
    JLabel l4 = new JLabel("Password :");
    JLabel l5 = new JLabel("Confirm ");
    JLabel l7 = new JLabel("Password :");
    JLabel l6 = new JLabel("City :");
    JTextField text1=new JTextField(); 
    JTextField text2=new JTextField(); 
    JTextField text3=new JTextField(); 
    JPasswordField text4 = new JPasswordField();
    JPasswordField text5=new JPasswordField(); 
    JTextField text6=new JTextField();
    JButton b=new JButton("Register");
    Font font = new Font("Calibri", Font.BOLD, 18);
    Font font1 = new Font("Times new roman",Font.BOLD, 28);
    Register()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Register Form");
        frame.setSize(1366,768);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    public void setLocationAndSize()
    {
    	l.setBounds(570,80,250,50);
    	l1.setBounds(500,118,100,100); 
    	l2.setBounds(500,178,100,100);
    	l3.setBounds(500,238,150,100); 
    	l4.setBounds(500,298,100,100); 
    	l5.setBounds(500,340,100,100);
    	l7.setBounds(500,366,100,100);
    	l6.setBounds(500,418,100,100);
    	text1.setBounds(655,155,200,30);
    	text2.setBounds(655,215,200,30);
    	text3.setBounds(655,275,200,30);
    	text4.setBounds(655,335,200,30);
    	text5.setBounds(655,395,200,30);
    	text6.setBounds(655,455,200,30);
    	b.setBounds(655,550,200,40);  
        l.setFont(font1);
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font);
        l7.setFont(font);
        b.setFont(font);
        l.setForeground(Color.WHITE);
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.WHITE);
        l7.setForeground(Color.WHITE);
    }
    public void addComponentsToFrame()
    {
    	frame.add(l);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(text4);
        frame.add(text5);
        frame.add(text6);
        frame.add(b);
        frame.getContentPane().add(panel);
    }
    public void actionEvent()
    {
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
    	showData();	
    }
    public void showData()
    {
    	String str1 = text1.getText();
    	String str2 = text2.getText();
    	String str3 = text3.getText();
    	String str4 = text4.getText();
    	String str5 = text5.getText();
    	String str6 = text6.getText();
    	Register_JavaBean jb=new Register_JavaBean();
    	jb.setName(str1);
    	jb.setEmail(str2);
    	jb.setMobile(str3);
    	jb.setPassword(str4);
    	jb.setConfirmPassword(str5);
    	jb.setCity(str6);
    	try{  
    		 Connection con=db_Object.getConnection();
    		 PreparedStatement ps = con.prepareStatement("insert into register(name,email,mobile,password,confirmpassword,city) values(?,?,?,?,?,?)");
             ps.setString(1, jb.getName());
             ps.setString(2, jb.getEmail());
             ps.setString(3, jb.getMobile());
             ps.setString(4, jb.getPassword());
             ps.setString(5, jb.getConfirmPassword());
             ps.setString(6, jb.getCity());
             PreparedStatement ps1 = con.prepareStatement("select mobile from register where mobile =?");
             ps1.setString(1,jb.getMobile());
             ResultSet rs = ps1.executeQuery();
             if(!(jb.getName().equals("")) && !(jb.getEmail().equals("")) && !(jb.getMobile().equals("")) && !(jb.getPassword().equals("")) && !(jb.getConfirmPassword().equals("")) && !(jb.getCity().equals("")))
             {
            	 if (rs.next())
                 {
            		 JOptionPane.showMessageDialog(null,"User has Already Registered");
                 }
                 else if(jb.getPassword().equals(jb.getConfirmPassword()))
                 {
                	 ps.executeUpdate();
                	 JOptionPane.showMessageDialog(null,"Registered Sucessfully");
                	 frame.setVisible(false);
                	 Login f1=new UserLogin();
             		 f1.Login1();
                 }
                 else if(!(jb.getPassword().equals(jb.getConfirmPassword())))
                 {
                	 JOptionPane.showMessageDialog(null,"Password did not match");
                 }
                 
             }
             else
             {
            	 JOptionPane.showMessageDialog(null,"Please fill all the required fields");
             }
             
         }
         catch (Exception ex)
         {
        	 JOptionPane.showMessageDialog(null, ex.toString());
         }

     }
     
    public static void main(String[] args)
    {
        new Register();
    }
}
