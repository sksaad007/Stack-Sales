import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class admin extends JFrame {

	private JPanel contentPane;
	private Frame panel;
	private Window lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JLabel label_8;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 200, 512);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 195, 152));
		
		JLabel label = new JLabel("Stack Sales");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(30, 30, 151, 50);
		panel_1.add(label);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setBounds(40, 105, 129, 22);
		panel_1.add(lblAdminLogin);
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setForeground(Color.BLACK);
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\engineer1.png"));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(45, 160, 129, 147);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Mirpur 10 ,Dhaka");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(30, 430, 107, 17);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("stacksales@gmail.com");
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(30, 464, 137, 17);
		panel_1.add(label_3);
		
		JButton btnRegistration = new JButton(" Registration");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new adminreg().setVisible(true);
			}
		});
		btnRegistration.setForeground(Color.WHITE);
		btnRegistration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistration.setBackground(new Color(112, 128, 144));
		btnRegistration.setBounds(30, 366, 139, 30);
		panel_1.add(btnRegistration);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 50, 67));
		panel_2.setBounds(185, 0, 550, 511);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		ImageIcon icon = new ImageIcon ("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\login1.png");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(195, 24, 169, 170);
		panel_2.add(label_4);
		
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(label_4.getWidth(), label_4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon = new ImageIcon(imgScale);
		label_4.setIcon(ScaledIcon);
		
		JLabel label_5 = new JLabel("User Name  :");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_5.setBounds(122, 249, 101, 25);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Password    :");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_6.setBounds(122, 294, 101, 25);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Email          :");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_7.setBounds(123, 339, 100, 25);
		panel_2.add(label_7);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBackground(Color.GRAY);
		textField.setBounds(249, 247, 169, 25);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(249, 294, 169, 25);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GRAY);
		textField_2.setBounds(249, 337, 169, 25);
		panel_2.add(textField_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			private String welcomeName;
	

			public void actionPerformed(ActionEvent e) {
				
				try {
			          Class.forName("com.mysql.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
			          Statement stmt = con.createStatement();
			          
			          String user_name =textField.getText();
			          String password =textField_1.getText(); 
			          String email =textField_2.getText().toString();
			          
			          if(email.equals("")||user_name.equals("")|| password.equals(""))
			  			{JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			          
			          String sql="SELECT * FROM admin_signup WHERE  user_name='"+user_name+"'and password='"+password+"' and email='"+email+"'";
			  
			         
			           
			          ResultSet rs=stmt.executeQuery(sql);
			          if( rs.next())
			          {
			        	  
			        	  welcomeName = rs.getString("fname");
			        	  
				            JOptionPane.showMessageDialog(null, "Welcome "+welcomeName);
				        	  JOptionPane.showMessageDialog(null, "Login Successful");
				               new admin_home().setVisible(true);
					
					
				         }
			          else if( !rs.next())
				        	
			  			{JOptionPane.showMessageDialog(null, "Something is Wrong Password");}
			        	  
			        con.close();
			        }
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
			}
		});
		btnNewButton.setBackground(new Color(0, 195, 152));
		btnNewButton.setBounds(290, 400, 100, 30);
		panel_2.add(btnNewButton);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new Homepage().setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHome.setBackground(new Color(192, 192, 192));
		btnHome.setBounds(143, 400, 100, 30);
		panel_2.add(btnHome);

	

	}
}
