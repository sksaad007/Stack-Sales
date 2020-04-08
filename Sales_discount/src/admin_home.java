import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class admin_home extends JFrame {

	private JPanel contentPane;
	private String imgScale2;
	JLabel lblSksadgmailcom;
	private JTable table;
	
	
	
	public ArrayList<User> userlist(){
		ArrayList<User> userlist = new ArrayList<>();
		

	          
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
	          
	           String query="SELECT * FROM signup";
	           Statement stmt = con.createStatement();
	           ResultSet rs=stmt.executeQuery(query);
	        
	        User user;
	        while (rs.next()){ 
	        	user= new User(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("user_name")
	        			,rs.getString("password"),rs.getString("email"),rs.getString("phone"),rs.getBytes("Image"));
	        	userlist.add(user);
          
	        	
	        	   
		      
	        }
		
		
	          
             con.close(); 
        }catch (Exception e){ 
             //Your exception handling mechanism goes here. 
        } 
		return userlist;	
	}
	public void show_user() {
		ArrayList<User> list = userlist();
		DefaultTableModel model =(DefaultTableModel)table.getModel();
		
		Object[] row = new Object[8];
		
	for(int i=0;i<list.size();i++) {
		row[0]=list.get(i).getid();
		row[1]=list.get(i).getfname();
		row[2]=list.get(i).getlname();
		row[3]=list.get(i).getuser_name();
		row[4]=list.get(i).getemail();
		row[5]=list.get(i).getpassword();
		row[6]=list.get(i).getphone();
		row[7]=list.get(i).getImage();
		model.addRow(row);
		
		
	}
	

	
	}

	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_home frame = new admin_home();
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
	
	
	public admin_home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 200, 551);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(30, 30, 151, 50);
		panel.add(label);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setForeground(Color.BLACK);
		lblAdminPanel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdminPanel.setBounds(38, 107, 129, 22);
		panel.add(lblAdminPanel);
		
		JLabel label_3 = new JLabel("Mirpur 10 ,Dhaka");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(30, 495, 107, 17);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("stacksales@gmail.com");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(30, 523, 137, 17);
		panel.add(label_4);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin().setVisible(true);
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBackground(new Color(47, 79, 79));
		btnLogout.setBounds(30, 454, 139, 30);
		panel.add(btnLogout);
		
		 lblSksadgmailcom = new JLabel("sksad1998@gmail.com");
		lblSksadgmailcom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSksadgmailcom.setBounds(52, 140, 139, 36);
		panel.add(lblSksadgmailcom);
		
		JLabel label_9 = new JLabel("Email :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(10, 140, 46, 36);
		panel.add(label_9);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon icon5 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\saad.jpg");
		lblNewLabel.setBounds(10, 225, 171, 195);
		panel.add(lblNewLabel);
		
		Image img5 = icon5.getImage();
		Image imgScale5 = img5.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon6 = new ImageIcon(imgScale5);
		lblNewLabel.setIcon(ScaledIcon6);
		
		JLabel lblUsername = new JLabel("User Name :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 172, 74, 36);
		panel.add(lblUsername);
		
		JLabel lblSk = new JLabel("SK007");
		lblSk.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSk.setBounds(84, 172, 139, 36);
		panel.add(lblSk);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(198, 1, 559, 550);
		contentPane.add(panel_1);
		
		JLabel label_5 = new JLabel("");
		
		ImageIcon icon = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\engineer_1 .png");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(228, 11, 130, 130);
		panel_1.add(label_5);
		
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon = new ImageIcon(imgScale);
		label_5.setIcon(ScaledIcon);
		
		JButton btnNewButton = new JButton("Product Upload");
		btnNewButton.setBackground(new Color(0, 195, 152));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Product_upload().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(73, 280, 170, 47);
		panel_1.add(btnNewButton);
		
		JButton btnStockUpdate = new JButton("Stock Update");
		btnStockUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new product_update().setVisible(true);
			}
		});
		btnStockUpdate.setBackground(new Color(0, 195, 152));
		btnStockUpdate.setForeground(new Color(0, 0, 0));
		btnStockUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStockUpdate.setBounds(332, 280, 180, 47);
		panel_1.add(btnStockUpdate);
		
		JButton btnManageUsers = new JButton("Manage Users");
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new user_update().setVisible(true);
			}
		});
		btnManageUsers.setBackground(new Color(0, 195, 152));
		btnManageUsers.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnManageUsers.setBounds(73, 450, 170, 47);
		panel_1.add(btnManageUsers);
		
		JButton btnManageOders = new JButton("Product Delivery");
		btnManageOders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Buylist().setVisible(true);
			}
		});
		btnManageOders.setBackground(new Color(0, 195, 152));
		btnManageOders.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnManageOders.setBounds(332, 450, 180, 47);
		panel_1.add(btnManageOders);
		
		JLabel label_1 = new JLabel("");
		ImageIcon icon1 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\database.png");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(90, 160, 130, 94);
		panel_1.add(label_1);
		
		Image img1 = icon1.getImage();
		Image imgScale1 = img1.getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon1 = new ImageIcon(imgScale1);
		label_1.setIcon(ScaledIcon1);
		
		JLabel label_2 = new JLabel("");
		ImageIcon icon2 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\market.png");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(356, 160, 130, 94);
		panel_1.add(label_2);
		
		Image img2 = icon2.getImage();
		Image imgScale2 = img2.getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon3 = new ImageIcon(imgScale2);
		label_2.setIcon(ScaledIcon3);
		
		JLabel label_6 = new JLabel("");
		ImageIcon icon3 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\professional.png");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(90, 345, 130, 94);
		panel_1.add(label_6);
		
		Image img3 = icon3.getImage();
		Image imgScale3 = img3.getScaledInstance(label_6.getWidth(), label_6.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon4 = new ImageIcon(imgScale3);
		label_6.setIcon(ScaledIcon4);
		
		JLabel label_7 = new JLabel("");
		ImageIcon icon4 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\delivery.png");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(356, 345, 130, 94);
		panel_1.add(label_7);
		
		Image img4 = icon4.getImage();
		Image imgScale4 = img4.getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon5 = new ImageIcon(imgScale4);
		label_7.setIcon(ScaledIcon5);
		
		table = new JTable();
		table.setBounds(27, 421, 1, 1);
		panel_1.add(table);
		show_user();
	}
}
