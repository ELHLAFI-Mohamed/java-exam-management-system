package gestion_des_exams;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class gtraphics {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gtraphics window = new gtraphics();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gtraphics() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("EHTP");
		frame.setFont(new Font("Dialog", Font.ITALIC, 12));
		frame.setBounds(100, 100, 798, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 JPanel panel= new JPanel();
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(145, 404, 108, 16);
		panel.add(lblUsername);
		
		textField  = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(250, 402, 156, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(149, 443, 73, 16);
		panel.add(lblPassword);
		
		textField_1 = new JPasswordField(10);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setBounds(250, 437, 156, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.CYAN);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(309, 472, 97, 25);
		panel.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-12, 0, 792, 532);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\gestion_des_exams\\study-1968077_1280.jpg"));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Username=textField.getText();
				String Password=textField_1.getText();
				JPanel pan=new JPanel();
		        if (Username.trim().equals("student") && Password.trim().equals("student")){
		        	frame.setVisible(false);
		        	data t=new data();
	        }
		        else if(Username.trim().equals("professor") && Password.trim().equals("123456789")) {
		        	frame.setVisible(false);
		        	insert t=new insert();
		        	
		        }
			}
		});
		
	}
}
