package Management;

import javax.swing.*;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;


public class login implements ActionListener {
	
	 JFrame f;
 JLabel l1,l2;
 JTextField t1,t2;
 JButton b1,b2;
 JCheckBox c1,c2;
 JDialog d1;
 
	public login() {
		t1=new JTextField(20);
		t2=new JTextField(20);
		b1=new JButton("LOGIN");
		b2=new JButton("Cancel");
		l1= new JLabel("Username");
		l2=new JLabel("Password");
		c1=new JCheckBox("Admin");
		c2=new JCheckBox("Karamcharii");
		f=new JFrame("LOG IN");

		f.add(l1);
		f.add(l2);
		f.add(b1);
		f.add(b2);
		f.add(t1);
		f.add(t2);
		f.add(c1);
		f.add(c2);
		
		
		l1.setBounds(205, 100, 100, 50);
		l2.setBounds(205, 200, 100, 50);
		t1.setBounds(275,100,500,50);
		t2.setBounds(275,200,500,50);
		b1.setBounds(330,300,100,50);
		b2.setBounds(430, 300, 100, 50);
		c1.setBounds(330, 250, 100, 50);
		c2.setBounds(430, 250, 100, 50);
		ButtonGroup bg = new ButtonGroup();
		bg.add(c1);bg.add(c2);
		
		f.setSize(1280,720);
		f.setLayout(null);
		b1.setBackground(Color.CYAN);
		b2.setBackground(Color.CYAN);
		t1.setBackground(Color.WHITE);
		f.setBackground(Color.CYAN);
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.setVisible(true);
		// TODO Auto-generated constructor stub
	}
	 public void actionPerformed(ActionEvent e) {
		
		 UIManager UI=new UIManager();
		 UI.put("OptionPane.background", Color.CYAN);
		 UI.put("Panel.background", Color.CYAN);

		 //JOptionPane.showMessageDialog(null,"Text","SetColor",JOptionPane.INFORMATION_MESSAGE);
	 
		 if(e.getSource()==b2)
		{
			f.dispose();
		}
		else if(e.getSource()==b1){
			try {
				if(t1.getText().isEmpty()||t2.getText().isEmpty()){
					
					JOptionPane.showMessageDialog(null, "PLEASE ENTER BOTH FEILDS","CYAN",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					String u=c1.getText();
					JOptionPane.showMessageDialog(null, u);
					String s1,s2,s3,s4;
					s3=t1.getText();
					s4=t2.getText();
					String query="SELECT * FROM login";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagement","root","");
				    Statement stmt=con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next()){
					s1 =rs.getString("username");
					s2=rs.getString("pascode");
					if(s1.equals(s3) && s2.equals(s4)){
				    JOptionPane.showMessageDialog(null, "WELCOME"+s1);
					new newevent();
					f.dispose();
					}	
					else{
						JOptionPane.showMessageDialog(null, "INVALID USERNAME/PASSCODE");
					break;
					}					
					}
					//stmt.executeUpdate("select ");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
				// TODO: handle exception
		}
		}
	 }
	public static void main(String[] args) {
		new login();
		// TODO Auto-generated method stub
	}

}
