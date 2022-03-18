package farmers_friend;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class PesticideUser implements ActionListener{

	DataBaseConnection db_Object=new DataBaseConnection();
	
	JLabel l1=new JLabel("Pesticide Details");
	JLabel l2=new JLabel("Select the crop to be searched: ");
	JLabel l3=new JLabel();
	JLabel l4=new JLabel();
	JLabel l5=new JLabel();
	JLabel l6=new JLabel();
	JLabel l7=new JLabel();
	JButton b1=new JButton("Submit");
	JComboBox<String> cb;
	Sidebar s=new Sidebar();
	ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\hp\\Downloads\\gradient1.jpg").getImage());
	void PesticideUser1()
	{

		Vector<String> v = new Vector<>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/farmers_friend","root","root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select cropName from pesticideDetails");
            while (rs.next()) {
                String ids = rs.getString(1);
                v.add(ids);
            }
            cb = new JComboBox<>(v);
            st.close();
            rs.close();
		}
		catch (Exception ex)
        {
			JOptionPane.showMessageDialog(null, ex.toString());
        }
		
		l1.setBounds(620, 100, 400, 50);
   	 	l2.setBounds(430, 200, 300, 30);
   	 	b1.setBounds(980, 200, 100, 30);
   	 	cb.setBounds(730, 200, 200, 30);
   	 
   	 	l1.setFont(s.font2);
   	 	l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
   	 	b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
   	 	cb.setFont(new Font("Times New Roman", Font.BOLD, 18));
   	 	
   	 	b1.addActionListener(this);
   	 	
		s.f.add(l1);
		s.f.add(l2);
		s.f.add(b1);
		s.f.add(cb);
		
		s.f.getContentPane().add(panel);
		s.frame4();
		s.Sidebar1();
	}
	
	public void actionPerformed(ActionEvent e) {
		Pesticide_JavaBean p=new Pesticide_JavaBean();
		if(e.getSource()==b1)
    	{
			String option=(String) cb.getSelectedItem();
			String s1="",s2="",s3="";
			try{
				Connection con=db_Object.getConnection();
		   		PreparedStatement ps = con.prepareStatement("select * from pesticideDetails where cropName=?");
		        ps.setString(1, option);
		        ResultSet rs = ps.executeQuery();
		        if (rs.next())
		        {
			        s1=rs.getString("cropName");
			        s2=rs.getString("disease");
			        s3=rs.getString("pesticide");
		        }
		        
		        p.setCropName(s1);
		        p.setDisease(s2);
		        p.setPesticide(s3);

			}
			catch (Exception ex)
	        {
				JOptionPane.showMessageDialog(null, ex.toString());
	        }
			l3.setText(p.getCropName());
			l4.setText("Disease      :  ");
			l5.setText(p.getDisease());
			l6.setText("Pesticide  :");
			l7.setText("<html><body>" + p.getPesticide() + "<br></body></html>");
			
			l3.setBounds(640, 300, 500, 50);
	   	 	l4.setBounds(500, 370, 200, 40);
	   	 	l5.setBounds(700, 370, 500, 40);
	   	 	l6.setBounds(500, 420, 200, 40);
	   	 	l7.setBounds(550, 330, 600, 400);
	   	 	
	   	 	l3.setFont(s.font2);
	   	 	l4.setFont(new Font("Times New Roman", Font.BOLD, 24));
	   	 	l5.setFont(new Font("Times New Roman", Font.BOLD, 24));
	   	 	l6.setFont(new Font("Times New Roman", Font.BOLD, 24));
	   	 	l7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	   	 	
	   	 	s.f.add(l3);
			s.f.add(l4);
			s.f.add(l5);
			s.f.add(l6);
			s.f.add(l7);
			
			s.f.getContentPane().add(panel);
			s.frame4();
    	}
		
    }
	public static void main(String[] args) {
		PesticideUser s=new PesticideUser();
		s.PesticideUser1();
	}
}