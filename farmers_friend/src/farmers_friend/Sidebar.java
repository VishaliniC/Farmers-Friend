package farmers_friend;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Sidebar implements ActionListener{
	JFrame f=new JFrame();
	JLabel l1,l2,l3,l4;
	JButton b0,b1,b2,b3,b4,b5,b6,b7;
	Font font = new Font("Castellar",Font.BOLD, 50);
	Font font0=new Font("Times new roman",Font.BOLD, 25);
    Font font1=new Font("Times new roman",Font.BOLD, 20);
    Font font2=new Font("Algerian",Font.BOLD,40);
    Font font3=new Font("Century Schoolbook",Font.BOLD,20);
    Font quote=new Font("Lucida Calligraphy",Font.BOLD,18);
    Color c1 = new Color(0, 128, 43); 
    Color c2 = new Color(0, 77, 0); 
	public void Sidebar1()
	{        
        b0=new JButton(new ImageIcon("C:\\Users\\hp\\Downloads\\logo.jpg")); 
        b1=new JButton("HOME PAGE");
        b2=new JButton("MY ACCOUNT");
        b3=new JButton("SOIL");
        b4=new JButton("TEMPERATURE");
        b5=new JButton("PESTICIDES");
        b6=new JButton("LOGOUT");
        b7=new JButton("");
        
        b0.setBounds(0,0,300,150);
        b1.setBounds(0,150,300,60);  
        b2.setBounds(0,210,300,60);    
        b3.setBounds(0,270,300,60);
        b4.setBounds(0,330,300,60);
        b5.setBounds(0,390,300,60);
        b6.setBounds(0,450,300,60);
        b7.setBounds(0,510,300,318);
        
        b1.setFont(font1);
        b2.setFont(font1);
        b3.setFont(font1);
        b4.setFont(font1);
        b5.setFont(font1);
        b6.setFont(font1);
        
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);
        b4.setForeground(Color.WHITE);
        b5.setForeground(Color.WHITE);
        b6.setForeground(Color.WHITE);
        
        b0.setBackground(c1);
        b0.setBorderPainted(false);   
        b1.setBackground(c1);
        b2.setBackground(c1);
        b3.setBackground(c1);
        b4.setBackground(c1);
        b5.setBackground(c1);
        b6.setBackground(c1);
        b7.setBackground(c1);
        b7.setBorderPainted(false);     
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
        f.add(b0);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
	}
	
	//HomePage
	public void frame1()
	{
		f.setTitle("Farmers Friend");
        f.setSize(1366,768);
        f.setVisible(true);
        f.setLayout(null);
	}
	
	//Login
	public void frame2()
	{
		f.setTitle("Login");
        f.setSize(1366,768);
        f.setVisible(true);
        f.setLayout(null);
	}
	
	//MyAccount
	public void frame3()
	{
		f.setTitle("MyAccount");
        f.setSize(1366,768);
        f.setVisible(true);
        f.setLayout(null);
	}
	
	//Soil
	public void frame4()
	{
		f.setTitle("Soil");
	    f.setSize(1366,768);
	    f.setVisible(true);
	    f.setLayout(null);
	}
	
	//Temperature
	public void frame5()
	{
		f.setTitle("Temperature");
		f.setSize(1366,768);
		f.setVisible(true);
		f.setLayout(null);
	}
	
	//Pesticide
	public void frame6()
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
			HomePage h=new HomePage();
    	}
		if(e.getSource()==b2)
    	{
			f.setVisible(false);
			MyAccount h=new MyAccount();
			h.MyAccount1();
    	}
		if(e.getSource()==b3)
    	{
			f.setVisible(false);
			SoilUser s=new SoilUser();
			s.SoilUser1();
    	}
		if(e.getSource()==b4)
    	{
			f.setVisible(false);
			TemperatureUser s=new TemperatureUser();
			s.TemperatureUser1();
    	}
		if(e.getSource()==b5)
    	{
			f.setVisible(false);
			PesticideUser s=new PesticideUser();
			s.PesticideUser1();
    	}
		if(e.getSource()==b6)
    	{
			f.setVisible(false);
			Login f1=new UserLogin();
    		f1.Login1();
    	}
    }
	
	public static void main(String[] args){
		new Sidebar();
	}
}

//background image
class ImagePanel extends JPanel {

	  private Image img;
	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    setSize(1620,1080);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 300, 0,getWidth(), getHeight(), null);
	  }
	}

class ImagePanel1 extends JPanel {

	  private Image img;
	  public ImagePanel1(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel1(Image img) {
	    this.img = img;
	    setSize(1620,1080);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0,getWidth(), getHeight(), null);
	  }
	}
