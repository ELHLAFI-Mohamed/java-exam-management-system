package gestion_des_exams;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class insert {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public insert() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 970, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNometudiant = new JLabel("Nom_etudiant :");
		lblNometudiant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNometudiant.setForeground(Color.WHITE);
		lblNometudiant.setBounds(25, 32, 109, 25);
		frame.getContentPane().add(lblNometudiant);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrenom.setBounds(64, 73, 84, 16);
		frame.getContentPane().add(lblPrenom);
		
		JLabel lblCin = new JLabel("CIN :");
		lblCin.setForeground(Color.WHITE);
		lblCin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCin.setBounds(92, 115, 56, 16);
		frame.getContentPane().add(lblCin);
		
		JLabel lblNumDeModule = new JLabel("Num de module :");
		lblNumDeModule.setForeground(Color.WHITE);
		lblNumDeModule.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumDeModule.setBounds(12, 144, 109, 16);
		frame.getContentPane().add(lblNumDeModule);
		
		JLabel lblNote = new JLabel("    Note :");
		lblNote.setForeground(Color.WHITE);
		lblNote.setBackground(Color.WHITE);
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNote.setBounds(52, 183, 56, 16);
		frame.getContentPane().add(lblNote);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(131, 32, 189, 22);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_1.setBackground(Color.WHITE);
		textPane_1.setBounds(131, 73, 189, 25);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_2.setBackground(Color.WHITE);
		textPane_2.setBounds(131, 109, 189, 22);
		frame.getContentPane().add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_3.setBackground(Color.WHITE);
		textPane_3.setBounds(133, 144, 187, 22);
		frame.getContentPane().add(textPane_3);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_6.setBackground(Color.WHITE);
		textPane_6.setBounds(132, 183, 188, 22);
		frame.getContentPane().add(textPane_6);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{  
		    		Class.forName("com.mysql.jdbc.Driver");  
		    			Connection con=DriverManager.getConnection(  
		    			"jdbc:mysql://localhost:3306/ehtp?autoReconnect=true&useSSL=false","root","root");  
		    		//Statement stmt=con.createStatement();  
		    		String query="insert into etudiant values(?,?,?)";
		    		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query) ;
		    		ps.setString(3,textPane.getText());
		    		ps.setString(2,textPane_1.getText());
		    		ps.setString(1,textPane_2.getText());
		    		ps.execute();
		    	
		    		int a=Integer.parseInt(textPane_3.getText());
		    		
		    		String query2="insert into note_elev values(?,?,?)";
		    		PreparedStatement ps2=(PreparedStatement) con.prepareStatement(query2) ;
		    		String b=textPane_6.getText();//Create a string to store the incoming data
		    		float f = Float.parseFloat(b);
		    		ps2.setFloat(1,f);
		    		ps2.setString(2,textPane_2.getText());
		    		ps2.setInt(3,a);
		    		ps2.execute();
		    		
		    		con.close();
		    		
				   }catch(Exception e){ System.out.println(e);}
				
				JOptionPane.showMessageDialog(null,"Saved!!!!!!");
				
				
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(56, 229, 129, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
	  		   	gtraphics x=new gtraphics();
	  		  JOptionPane.showMessageDialog(null,"Logout");
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(522, 32, 109, 25);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblBonjourProfesseur = new JLabel("Bonjour Professeur !!");
		lblBonjourProfesseur.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBonjourProfesseur.setForeground(Color.BLACK);
		lblBonjourProfesseur.setBounds(239, 374, 242, 38);
		frame.getContentPane().add(lblBonjourProfesseur);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\gestion_des_exams\\study-1968077_1280.jpg"));
		lblNewLabel_2.setBounds(0, -99, 1021, 704);
		frame.getContentPane().add(lblNewLabel_2);
	
	}
}
