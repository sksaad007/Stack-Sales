import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.xml.crypto.Data;

public class userlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public static String welcomeName = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogin frame = new userlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public userlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelimage = new JLabel("");
		labelimage.setBounds(0, 0, 790, 545);
		labelimage.setBackground(Color.BLACK);
		ImageIcon icon = new ImageIcon ("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\pexels3.png");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(labelimage.getWidth(), labelimage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon = new ImageIcon(imgScale);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel.setBackground(new Color(0,0, 0,0));
		panel.setBounds(0, 0, 643, 565);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
	
		labelimage.setIcon(ScaledIcon);
		contentPane.add(labelimage);
	
		

		JLabel lblNewLabel = new JLabel("Stack Sales");
		lblNewLabel.setBounds(230, 37, 161, 57);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.GRAY);
		textField.setBounds(280, 214, 169, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email          :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(165, 214, 100, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblUserName = new JLabel("User Name  :");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUserName.setBounds(165, 276, 101, 25);
		panel.add(lblUserName);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(280, 276, 169, 25);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GRAY);
		textField_2.setBounds(280, 336, 169, 25);
		panel.add(textField_2);
		
		JLabel lblPassword = new JLabel("Password    :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(165, 336, 101, 25);
		panel.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(0, 195, 152));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
			          Class.forName("com.mysql.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
			          Statement stmt = con.createStatement();
			          
			          String email =textField.getText();
			          String user_name =textField_1.getText(); 
			          String password =textField_2.getText().toString();
			          
			          if(email.equals("")||user_name.equals("")|| password.equals(""))
			  			{JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			          
			          String sql="SELECT * FROM signup WHERE email='"+email+"'and user_name='"+user_name+"'and password='"+password+"'";
			  
			         
			           
			          ResultSet rs=stmt.executeQuery(sql);
			          if( rs.next())
			          {   
			        	  welcomeName = rs.getString("fname");
			        	  String welcomeName2 = rs.getString("lname");
			        	  
			        	  JOptionPane.showMessageDialog(null, "Login Successful");
			        	  JOptionPane.showMessageDialog(null, "Welcome " +welcomeName +welcomeName2  );
					 new sales_homepage().setVisible(true);
					
					
				         }
			          else if( !rs.next())
				        	
			  			{JOptionPane.showMessageDialog(null, "Wrong Password");}
			        	  
			        con.close();
			        }
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(175, 410, 100, 30);
		panel.add(btnNewButton);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new usersignup().setVisible(true);
			}
		});
		btnSignup.setBackground(new Color(127, 255, 212));
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSignup.setBounds(331, 410, 100, 30);
		panel.add(btnSignup);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\unnamed.png"));
		ImageIcon icon2 = new ImageIcon ("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\login.png");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(260, 113, 64, 68);
		panel.add(label);
		
		
		
		
	}
}
