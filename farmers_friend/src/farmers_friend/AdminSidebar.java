package farmers_friend;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AdminSidebar implements ActionListener{

	JFrame f=new JFrame();
	JLabel l1,l2,l3,l4;
	JButton b0,b1,b2,b3,b4,b5,b6;
	Font font = new Font("Castellar",Font.BOLD, 50);
	Font font0=new Font("Times new roman",Font.BOLD, 25);
    Font font1=new Font("Times new roman",Font.BOLD, 20);
    Font font2=new Font("Algerian",Font.BOLD,40);
    Font font3=new Font("Century Schoolbook",Font.BOLD,20);
    Font quote=new Font("Lucida Calligraphy",Font.BOLD,18);
    Color c1 = new Color(0, 128, 43); 
    Color c2 = new Color(0, 77, 0); 
	public void AdminSidebar1()
	{        
        b0=new JButton(new ImageIcon("C:\\Users\\hp\\Downloads\\logo.jpg")); 
        b1=new JButton("HOME PAGE");
        b2=new JButton("SOIL");
        b3=new JButton("TEMPERATURE");
        b4=new JButton("PESTICIDES");
        b5=new JButton("LOGOUT");
        b6=new JButton("");
        
        b0.setBounds(0,0,300,150);
        b1.setBounds(0,150,300,60);   
        b2.setBounds(0,210,300,60);
        b3.setBounds(0,270,300,60);
        b4.setBounds(0,330,300,60);
        b5.setBounds(0,390,300,60);
        b6.setBounds(0,450,300,318);
        
        b1.setFont(font1);
        b2.setFont(font1);
        b3.setFont(font1);
        b4.setFont(font1);
        b5.setFont(font1);
        
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);
        b4.setForeground(Color.WHITE);
        b5.setForeground(Color.WHITE);
        
        b0.setBackground(c1);
        b0.setBorderPainted(false);   
        b1.setBackground(c1);
        b2.setBackground(c1);
        b3.setBackground(c1);
        b4.setBackground(c1);
        b5.setBackground(c1);
        b6.setBackground(c1);
        b6.setBorderPainted(false);     
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
        f.add(b0);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
	}
	
	//HomePage
	public void frame1()
	{
		f.setTitle("Farmers Friend");
        f.setSize(1366,768);
        f.setVisible(true);
        f.setLayout(null);
	}
	
	//Logout
	public void frame2()
	{
		f.setTitle("Farmers Friend");
	    f.setSize(1366,768);
	    f.setVisible(true);
	    f.setLayout(null);
	}
	
	//Soil
	public void frame3()
	{
		f.setTitle("Soil");
	    f.setSize(1366,768);
	    f.setVisible(true);
	    f.setLayout(null);
	}
	
	//Temperature
	public void frame4()
	{
		f.setTitle("Temperature");
		f.setSize(1366,768);
		f.setVisible(true);
		f.setLayout(null);
	}
	
	//Pesticide
	public void frame5()
	{
		f.setTitle("Pesticide");
		f.setSize(1366,768);
		f.setVisible(true);
		f.setLayout(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
    	{
			f.setVisible(false);
			new AdminHomePage();
    	}
		if(e.getSource()==b2)
    	{
			f.setVisible(false);
			SoilDetailsAdmin h=new SoilDetailsAdmin();
			h.SoilDetailsAdmin1();
    	}
		if(e.getSource()==b3)
    	{
			f.setVisible(false);
			TemperatureDetailsAdmin t=new TemperatureDetailsAdmin();
			t.TemperatureDetailsAdmin1();
    	}
		if(e.getSource()==b4)
    	{
			f.setVisible(false);
			PesticideDetailsAdmin t=new PesticideDetailsAdmin();
			t.PesticideDetailsAdmin1();
    	}
		if(e.getSource()==b5)
    	{
			f.setVisible(false);
    		Login f=new AdminLogin();
    		f.Login1();
    	}
		
    }
	
	public static void main(String[] args){
		AdminSidebar admin=new AdminSidebar();
		admin.AdminSidebar1();
		
	}
}

