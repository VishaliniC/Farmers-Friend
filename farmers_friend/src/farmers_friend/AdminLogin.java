package farmers_friend;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AdminLogin extends Login implements ActionListener{
	
	JFrame frame;
	ImagePanel1 panel = new ImagePanel1(new ImageIcon("C:\\Users\\hp\\Downloads\\login.jpg").getImage());
    JLabel l = new JLabel("ADMIN LOGIN");
    JLabel l1 = new JLabel("Admin ID :");
    JLabel l2 = new JLabel("Password :");
    JTextField text1=new JTextField();  
    JPasswordField text2 = new JPasswordField();
     
    JButton b=new JButton("Login");
    Font font = new Font("Calibri", Font.BOLD, 18);
    Font font1 = new Font("Times new roman",Font.BOLD, 28);
    
    public void Login1()
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
    	l.setBounds(600,170,200,30);
    	l1.setBounds(500,230,100,30);
    	l2.setBounds(500,290,100,30);
        text1.setBounds(600,230,200,30);  
        text2.setBounds(600,290,200,30);
        b.setBounds(650,350,100,30);
        l.setFont(font1);
        l1.setFont(font);
        l2.setFont(font);
        b.setFont(font);
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
        frame.getContentPane().add(panel);
    }
    public void actionEvent()
    {
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == b){
	    	String astr1 = text1.getText();
	    	String astr2 = text2.getText();
	    	if(astr1.equals("admin") && astr2.equals("admin"))
	    	{
	    		JOptionPane.showMessageDialog(null,"Logged in Successfully");
	    		frame.setVisible(false);
	    		new AdminHomePage();
	    	}	
	    	else
            {
                JOptionPane.showMessageDialog(null,"Incorrect email-Id or password");
            }
    	}
     }
}


