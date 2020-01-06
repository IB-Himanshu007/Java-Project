package Management;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;


public class newevent implements ActionListener{
	
	 JFrame f;
	 JLabel l1,l2;
	 JTextField t1,t2;
	 JButton b1,b2;
	 JCheckBox c1,c2;
	 
	
	 public newevent() {
		
				t1=new JTextField(20);
				t2=new JTextField(20);
				b1=new JButton("ADD");
				b2=new JButton("Cancel");
				l1= new JLabel("Event Name");
				l2=new JLabel("Event Member");
				f=new JFrame("NEW EVENT");

				f.add(l1);
				f.add(l2);
				f.add(b1);
				f.add(b2);
				f.add(t1);
				f.add(t2);
				
				l1.setBounds(205, 100, 100, 50);
				l2.setBounds(190, 200, 100, 50);
				t1.setBounds(275,100,500,50);
				t2.setBounds(275,200,500,50);
				b1.setBounds(330,290,100,50);
				b2.setBounds(430, 290, 100, 50);
			
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
				if(e.getSource()==b2)
				{
					f.dispose();
				}
				else if(e.getSource()==b1){
					try {
						Class.forName("com.mysql.jdbc.Driver");
						String s1,s2;
						s1=t1.getText();
						s2=t2.getText();
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagement","root","");
						//here sonoo is the database name, root is the username and root is the password
						Statement stmt=con.createStatement();
						
						if(t1.getText().isEmpty()||t2.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Enter New Event or Close");
							
						}
						else{
							String query="Insert into newevent(eventname,eventmember) values('"+s1+"','"+s2+"')";
							String query2="commit";
							stmt.executeUpdate(query);
							stmt.executeQuery(query2);
							JOptionPane.showMessageDialog(null, "Event Inserted");
						}
									//stmt.executeUpdate("select ");
					} catch (Exception e2) {
						System.out.print(e2);
						// TODO: handle exception
					}
					
				}

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new newevent();
	}

}
