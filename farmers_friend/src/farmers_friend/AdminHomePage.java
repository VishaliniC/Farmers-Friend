package farmers_friend;

import javax.swing.*;
import java.awt.*;

public class AdminHomePage{
	
	AdminHomePage()
	{
		AdminSidebar s=new AdminSidebar();
		ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\hp\\Downloads\\agri3.jpg").getImage());
		s.l1=new JLabel("Welcome  To");
		s.l2=new JLabel("FarmEasy!!");
		s.l3=new JLabel("Agriculture is our wisest pursuit, because it will in the end contribute");
		s.l4=new JLabel("most to real wealth,good morals, and happiness. — Thomas Jefferson");
		
        s.l1.setBounds(600,100,1000,50);
        s.l2.setBounds(650,200,1000,50);
        s.l3.setBounds(450,300,1000,100);
        s.l4.setBounds(470,350,1000,100);
        
        s.l1.setFont(s.font);
        s.l2.setFont(s.font);
        s.l3.setFont(s.quote);
        s.l4.setFont(s.quote);
        
        s.l1.setForeground(s.c2);
        s.l2.setForeground(s.c2);
        s.l3.setForeground(Color.WHITE);
        s.l4.setForeground(Color.WHITE);
        
        s.f.add(s.l1);
        s.f.add(s.l2);
        s.f.add(s.l3);
        s.f.add(s.l4);
        
        s.f.getContentPane().add(panel);
		s.frame1();
		s.AdminSidebar1();
	}
	
	public static void main(String[] args){
		new AdminHomePage();
	}

}