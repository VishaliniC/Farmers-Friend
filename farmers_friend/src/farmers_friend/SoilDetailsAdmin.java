package farmers_friend;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class SoilDetailsAdmin implements ActionListener{
	
	DataBaseConnection db_Object=new DataBaseConnection();
	
	JLabel l0=new JLabel("Soil");
	JLabel l1=new JLabel("Crop Name");
	JLabel l2=new JLabel("Soil Type");
	JLabel l3=new JLabel("Description");
	JTextField t1=new JTextField(); 
    JTextField t2=new JTextField(); 
    JTextField t3=new JTextField(); 
    JButton b1=new JButton("Add");
    JButton b2=new JButton("Update");
    JButton b3=new JButton("Delete");
	
	void SoilDetailsAdmin1()
	{
		AdminSidebar a=new AdminSidebar();
		ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\hp\\Downloads\\gradient2.jpg").getImage());
		
		l0.setBounds(700,100,400,50);
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
		a.frame3();
		a.AdminSidebar1();
		

	}
	
	public void actionPerformed(ActionEvent e) {
		String str1 = t1.getText();
    	String str2 = t2.getText();
    	String str3 = t3.getText();
    	
    	Soil_JavaBean s=new Soil_JavaBean();
    	
    	s.setCropName(str1);
    	s.setSoilType(str2);
    	s.setDescription(str3);
    	
		if(e.getSource()==b1)
    	{	    	
	    	
			try{

				Connection con=db_Object.getConnection();
		   		PreparedStatement ps = con.prepareStatement("insert into soilDetails(cropName,soilType,description) values(?,?,?)");
		        ps.setString(1, s.getCropName());
		        ps.setString(2, s.getSoilType());
		        ps.setString(3, s.getDescription()); 
		        if(!(s.getCropName().equals("")) && !(s.getSoilType().equals("")) && !(s.getDescription().equals("")))
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
		   		PreparedStatement ps = con.prepareStatement("update soilDetails set soilType=?,description=? where cropName=?");
		        ps.setString(3, s.getCropName());
		        ps.setString(1, s.getSoilType());
		        ps.setString(2, s.getDescription()); 
		        if(!(s.getCropName().equals("")) && !(s.getSoilType().equals("")) && !(s.getDescription().equals("")))
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
		   		PreparedStatement ps = con.prepareStatement("delete from soilDetails where cropName=?");
		        ps.setString(1, s.getCropName());
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
		SoilDetailsAdmin s=new SoilDetailsAdmin();
		s.SoilDetailsAdmin1();

	}

}
