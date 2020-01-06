package Management;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

public class update_event implements ActionListener{
	JFrame f;
	 JLabel l1,l2,l3;
	 JTextField t1,t2,t3;
	 JButton b1,b2;
	 JCheckBox c1,c2;
	 JDialog d1;
	public update_event() 
	{
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		b1=new JButton("UPDATE");
		b2=new JButton("Cancel");
		l1=new JLabel("Event Name To be Updated");
		l2=new JLabel("Updated Event Name");
		l3=new JLabel("Event Member");
		//c1=new JCheckBox("Admin");
	  //c2=new JCheckBox("Karamcharii");
		f=new JFrame("UPDATE");
        f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(b1);
		f.add(b2);
		f.add(t1);
		f.add(t2);
		f.add(t3);
	  //f.add(c1);
	  //f.add(c2);
		l1.setBounds(205, 100, 100, 50);
		l2.setBounds(150, 175, 125, 50);
		l3.setBounds(175, 250, 100, 50);
		t1.setBounds(275,100,500,50);
		t2.setBounds(275,175,500,50);
		t3.setBounds(275,250,500,50);
		b1.setBounds(330,325,100,50);
		b2.setBounds(430,325,100,50);
	  //c1.setBounds(330, 250, 100, 50);
	  //c2.setBounds(430, 250, 100, 50);
	  //ButtonGroup bg = new ButtonGroup();
	  //bg.add(c1);bg.add(c2);	
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
public void actionPerformed(ActionEvent e){
	
 if(e.getSource()==b2){
		f.dispose();
	}
	else if(e.getSource()==b1){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagement", "root", "");
        Statement stm=c1.createStatement();
        String sql="Update newevent set eventname='"+t2.getText()+"',eventmember='"+t3.getText()+"'  where eventname='"+t1.getText()+"'"; 
        stm.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "EVENT UPDATED");
	} catch (Exception e2) {
		// TODO: handle exception
	}
	}
}
	public static void main(String[] args) {
		new update_event();
		// TODO Auto-generated method stub

	}

}
