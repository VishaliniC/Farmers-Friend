package farmers_friend;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class PesticideDetailsAdmin implements ActionListener{
	
	DataBaseConnection db_Object=new DataBaseConnection();
	
	JLabel l0=new JLabel("Pesticide");
	JLabel l1=new JLabel("Crop Name");
	JLabel l2=new JLabel("Disease");
	JLabel l3=new JLabel("Pesticide");
	JTextField t1=new JTextField(); 
    JTextField t2=new JTextField(); 
    JTextField t3=new JTextField(); 
    JButton b1=new JButton("Add");
    JButton b2=new JButton("Update");
    JButton b3=new JButton("Delete");
	
	void PesticideDetailsAdmin1()
	{
		AdminSidebar a=new AdminSidebar();
		ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\hp\\Downloads\\gradient2.jpg").getImage());
		
		l0.setBounds(650,100,400,50);
		l1.setBounds(500,200,200,30);
		l2.setBounds(500,280,200,30);
		l3.setBounds(500,360,200,30);
		t1.setBounds(700,200,380,30);
		t2.setBounds(700,280,380,30);
		t3.setBounds(700,360,380,30);
		b1.setBounds(500,450,180,30);
		b2.setBounds(700,450,180,30);
		b3.setBounds(900,450,180,30);
		
		l0.setFont(a.font2);
		l1.setFont(a.font3);
		l2.setFont(a.font3);
		l3.setFont(a.font3);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		a.f.add(l0);
		a.f.add(l1);
		a.f.add(l2);
		a.f.add(l3);
		a.f.add(t1);
		a.f.add(t2);
		a.f.add(t3);
		a.f.add(b1);
		a.f.add(b2);
		a.f.add(b3);
		
		a.f.getContentPane().add(panel);
		a.frame5();
		a.AdminSidebar1();
		

	}
	
	public void actionPerformed(ActionEvent e) {
		String str1 = t1.getText();
    	String str2 = t2.getText();
    	String str3 = t3.getText();
    	
    	Pesticide_JavaBean p=new Pesticide_JavaBean();
    	
    	p.setCropName(str1);
    	p.setDisease(str2);
    	p.setPesticide(str3);
		
		if(e.getSource()==b1)
    	{
			try{
				Connection con=db_Object.getConnection();
		   		PreparedStatement ps = con.prepareStatement("insert into PesticideDetails(cropName,disease,pesticide) values(?,?,?)");
		        ps.setString(1, p.getCropName());
		        ps.setString(2, p.getDisease());
		        ps.setString(3, p.getPesticide()); 
		        if(!(p.getCropName().equals("")) && !(p.getDisease().equals("")) && !(p.getPesticide().equals("")))
		        {
		        	ps.executeUpdate();
		        	JOptionPane.showMessageDialog(null,"Added Sucessfully");
		        	t1.setText("");
		        	t2.setText("");
		        	t3.setText("");
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
		
		if(e.getSource()==b2)
    	{
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");  
	   		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/farmers_friend","root","root");
		   		PreparedStatement ps = con.prepareStatement("update PesticideDetails set disease=?,pesticide=? where cropName=?");
		        ps.setString(3, p.getCropName());
		        ps.setString(1, p.getDisease());
		        ps.setString(2, p.getPesticide()); 
		        if(!(p.getCropName().equals("")) && !(p.getDisease().equals("")) && !(p.getPesticide().equals("")))
		        {
		        	int i=ps.executeUpdate();
		        	if(i>0)
		        	{
			        	JOptionPane.showMessageDialog(null,"Updated Sucessfully");
			        	t1.setText("");
			        	t2.setText("");
			        	t3.setText("");
		        	}
		        	else
		        	{
		        		JOptionPane.showMessageDialog(null,"Entered crop does not exist");
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
		
		if(e.getSource()==b3)
    	{
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");  
	   		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/farmers_friend","root","root");
		   		PreparedStatement ps = con.prepareStatement("delete from PesticideDetails where cropName=?");
		        ps.setString(1, p.getCropName());
		        if(!(str1.equals("")))
		        {
		        	int i=ps.executeUpdate();
		        	if(i>0)
		        	{
		        		JOptionPane.showMessageDialog(null,"Removed Sucessfully");
			        	t1.setText("");
		        	}
		        	else
		        	{
		        		JOptionPane.showMessageDialog(null,"Entered crop does not exist");
		        	}
		        }
		        else
		        {
		        	JOptionPane.showMessageDialog(null,"Please enter the crop name to be deleted");
		        }
			}
			catch (Exception ex)
	        {
				JOptionPane.showMessageDialog(null, ex.toString());
	        }
    	}
    }
	
	public static void main(String[] args) {
		PesticideDetailsAdmin s=new PesticideDetailsAdmin();
		s.PesticideDetailsAdmin1();

	}

}
