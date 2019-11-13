package gestion_des_exams;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class data {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public data() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("                   EHTP                                   ");
		frame.setBounds(100, 100, 634, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 900, 616, -933);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		Vector<Vector> data=new Vector();
		Vector<String> columns=new Vector();
		try{  
    		Class.forName("com.mysql.jdbc.Driver");  
    			Connection con=DriverManager.getConnection(  
    			"jdbc:mysql://localhost:3306/ehtp?autoReconnect=true&useSSL=false","root","root");  
    		Statement stmt=con.createStatement();  
    		ResultSet rs=stmt.executeQuery("select e.nom,e.prenom,e.cin,m.num,m.nom,m.coef,n.note from etudiant as e,module as m,note_elev as n where e.cin=n.cin and m.num=n.num ;");  
    		while(rs.next()) {
    			Vector vect=new Vector();
    		vect.add(rs.getString("nom"));
    		vect.add(rs.getString("prenom"));
    		vect.add(rs.getString("cin"));
    		vect.add(rs.getInt("num"));
    		vect.add(rs.getString("m.nom"));
    		vect.add(rs.getInt("coef"));
    		vect.add(rs.getFloat("note"));
    		data.addElement(vect);
    		}
    		columns.add("nom");
    		columns.add("prenom");
    		columns.add("cin");
    		columns.add("num De module");
    		columns.add("nom De module");
    		columns.add("coef");
    		columns.add("note");
  		  
  		 JScrollPane scrollPane;
  		   JTable jt=new JTable(data,columns);
  		   jt.setForeground(Color.BLACK);
  		   jt.setBackground(new Color(255, 255, 255));
  		   jt.setFont(new Font("Tahoma", Font.BOLD, 15));
  		// jt.setRowHeight(1,30);
  		
  		
  		   scrollPane=new JScrollPane(jt);
  		   scrollPane.setBounds(0,0, 868, 907);
  		   scrollPane.setViewportBorder(new LineBorder(Color.WHITE, 4));
  		   frame.getContentPane().add(scrollPane);
  		   scrollPane.setPreferredSize(new Dimension(500, 900));
  		   jt.setRowHeight(50);
  		   
  		   JButton btnLogout = new JButton("Logout");
  		   btnLogout.addActionListener(new ActionListener() {
  		   	public void actionPerformed(ActionEvent e) {
  		   		frame.setVisible(false);
  		   	gtraphics x=new gtraphics();
  		  JOptionPane.showMessageDialog(null,"Logout");
  		   	}
  		   });
  		   btnLogout.setBackground(Color.CYAN);
  		   btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
  		   btnLogout.setForeground(Color.BLACK);
  		   scrollPane.setColumnHeaderView(btnLogout);
  		   
  		   JButton btnNewButton = new JButton("Logouut");
  		   btnNewButton.setBackground(Color.CYAN);
  		   btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
  		   btnNewButton.setForeground(new Color(0, 0, 0));
  		   btnNewButton.addActionListener(new ActionListener() {
  		   	public void actionPerformed(ActionEvent arg0) {
  		   	frame.setVisible(false);
  		   	gtraphics x=new gtraphics();
  		  JOptionPane.showMessageDialog(null,"Logout");
  		   	}
  		   });
  		   scrollPane.setRowHeaderView(btnNewButton);
  		   JLabel lblNewLabel = new JLabel("New label");
  		   lblNewLabel.setBounds(0, -33, 616, 510);
  		   lblNewLabel.setBackground(Color.WHITE);
  		   frame.getContentPane().add(lblNewLabel);
  		   lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\gestion_des_exams\\Concours-EHTP-Maroc.jpg"));
  		 
  		   con.close();
  		   
  		       		   
  		   
  		   
  		   
    	   }catch(Exception e){ System.out.println(e);}
		
		
	}
}
