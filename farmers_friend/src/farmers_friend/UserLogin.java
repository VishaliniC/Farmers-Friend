package farmers_friend;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
 
public class UserLogin extends Login implements ActionListener {
	
	DataBaseConnection db_Object=new DataBaseConnection();
	
	static String str1,str2;
	JFrame frame;
	ImagePanel1 panel = new ImagePanel1(new ImageIcon("C:\\Users\\hp\\Downloads\\login.jpg").getImage());
    JLabel l = new JLabel("LOGIN PAGE");
    JLabel l1 = new JLabel("Email ID :");
    JLabel l2 = new JLabel("Password :");
    JTextField text1=new JTextField();  
    JPasswordField text2 = new JPasswordField();
     
    JButton b=new JButton("Login");
    JButton b1=new JButton("Register");
    JButton b2=new JButton("Admin Login");
    Font font = new Font("Calibri", Font.BOLD, 18);
    Font font1 = new Font("Times new roman",Font.BOLD, 28);
    
    void Login1()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Login Form");
        frame.setSize(1366,768);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    public void setLocationAndSize()
    {
    	l.setBounds(610,170,200,30);
    	l1.setBounds(500,230,100,30);
    	l2.setBounds(500,290,100,30);
        text1.setBounds(600,230,200,30);  
        text2.setBounds(600,280,200,30);
        b.setBounds(600,340,85,30);
        b1.setBounds(700,340,100,30);
        b2.setBounds(600,400,200,30);
        l.setFont(font1);
        l1.setFont(font);
        l2.setFont(font);
        b.setFont(font);
        b1.setFont(font);
        b2.setFont(font);
        l.setForeground(Color.WHITE);
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
    }
    public void addComponentsToFrame()
    {
    	frame.add(l);
        frame.add(l1);
        frame.add(l2);
        frame.add(text1);
        frame.add(text2);
        frame.add(b);
        frame.add(b1);
        frame.add(b2);
        frame.getContentPane().add(panel);
    }
    public void actionEvent()
    {
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == b){
	    	str1 = text1.getText();
	    	str2 = text2.getText();
	    	
	    	Login_JavaBean log=new Login_JavaBean();
	    	log.setEmail(str1);
	    	log.setPassword(str2);
	    	
	    	try{  
	    		 Connection con=db_Object.getConnection();
	    		 PreparedStatement ps = con.prepareStatement("select email from register where email=? and password=?");
	             ps.setString(1, log.getEmail());
	             ps.setString(2, log.getPassword());
	             ResultSet rs = ps.executeQuery();
	             if (rs.next())
	             {
	            	 JOptionPane.showMessageDialog(null,"Logged in Successfully");
	            	 frame.setVisible(false);
	            	 HomePage h=new HomePage();
	             } 
	             else
	             {
	                 JOptionPane.showMessageDialog(null,"Incorrect email-Id or password");
	             }
	          }
	         catch (Exception ex)
	         {
	        	 JOptionPane.showMessageDialog(null, ex.toString());
	         }
    	}
    	if(e.getSource() == b1){
    		frame.setVisible(false);
    		Register r = new Register();
    	}
    	
    	if(e.getSource() == b2){
    		Login f=new AdminLogin();
    		f.Login1();
    	}

     }
     
}
