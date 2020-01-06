package Management;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class delete_event implements ActionListener{
	JFrame f;
	 JLabel l1,l2;
	 JTextField t1,t2;
	 JButton b1,b2;
	 JCheckBox c1,c2;
	 JDialog d1;
	public delete_event() {
		t1=new JTextField(20);
		//t2=new JTextField(20);
		b1=new JButton("DELETE");
		b2=new JButton("Cancel");
		l1= new JLabel("Event Name");
		//l2=new JLabel("Password");
		//c1=new JCheckBox("Admin");
		//c2=new JCheckBox("Karamcharii");
		f=new JFrame("DELTE");

		f.add(l1);
		//f.add(l2);
		f.add(b1);
		f.add(b2);
		f.add(t1);
		//f.add(t2);
		//f.add(c1);
		//f.add(c2);
		
		
		l1.setBounds(205, 100, 100, 50);
		//l2.setBounds(205, 200, 100, 50);
		t1.setBounds(275,100,500,50);
		//t2.setBounds(275,200,500,50);
		b1.setBounds(330,300,100,50);
		b2.setBounds(430, 300, 100, 50);
		//c1.setBounds(330, 250, 100, 50);
		//c2.setBounds(430, 250, 100, 50);
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
	}	
		public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==b1){
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagement","root","");
			Statement stm =con.createStatement();
			String sql="delete from newevent where eventname='"+t1.getText()+"'";
			stm.execute(sql);
			JOptionPane.showConfirmDialog(null, "'"+t1.getText()+"'Is DELETED");
		}
			else if(e.getSource()==b2){
		f.dispose();
	}	
		} catch (Exception e2) {
			
			System.out.println(e2);// TODO: handle exception
		}
		// TODO Auto-generated constructor stub
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new delete_event();
	}

}
