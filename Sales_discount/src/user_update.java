import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class user_update extends JFrame {

	private JPanel contentPane;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	String s;
	JLabel label1 = new JLabel();
	private JLabel Img1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_update frame = new user_update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
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
	 * Create the frame.
	 */
	public user_update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 207, 551);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(35, 24, 151, 50);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Admin Panel");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(45, 74, 129, 22);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Mirpur 10 ,Dhaka");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(20, 495, 107, 17);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("stacksales@gmail.com");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(20, 523, 137, 17);
		panel.add(label_3);
		
		JButton button = new JButton("Logout");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(new Color(47, 79, 79));
		button.setBounds(20, 454, 166, 30);
		panel.add(button);
		
		JLabel Img1 = new JLabel("");
		Img1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Img1.setBounds(20, 206, 166, 187);
		panel.add(Img1);
		
		
		
		ImageIcon icon5 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\saad.jpg");
		Img1.setBounds(10, 197, 171, 195);
		panel.add(Img1);
		
		Image img5 = icon5.getImage();
		Image imgScale5 = img5.getScaledInstance(Img1.getWidth(), Img1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon6 = new ImageIcon(imgScale5);
		Img1.setIcon(ScaledIcon6);
		
		JLabel label_9 = new JLabel("Email :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(18, 119, 46, 36);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("sksad1998@gmail.com");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(60, 119, 139, 36);
		panel.add(label_10);
		
		JLabel label_13 = new JLabel("User Name :");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(18, 150, 74, 36);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("SK007");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(90, 150, 139, 36);
		panel.add(label_14);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(207, 0, 857, 551);
		contentPane.add(panel_1);
		
		JLabel lblUsersInformation = new JLabel("Users Information");
		lblUsersInformation.setForeground(Color.WHITE);
		lblUsersInformation.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUsersInformation.setBounds(320, 11, 253, 50);
		panel_1.add(lblUsersInformation);
		
		JLabel label_11 = new JLabel("Image :");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_11.setBounds(35, 475, 103, 20);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(35, 58, 261, 155);
		panel_1.add(label_12);
		
		JButton button_1 = new JButton("Choose");
		button_1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				
		         JFileChooser fileChooser = new JFileChooser();
		         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		             label_12.setIcon(ResizeImage(path));
		             s = path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("No Data");
		         }
			}
			public ImageIcon ResizeImage(String imgPath){
		        ImageIcon MyImage = new ImageIcon(imgPath);
		        Image img = MyImage.getImage();
		        Image newImage = img.getScaledInstance(label_12.getWidth(), label_12.getHeight(),Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImage);
		        return image;
		    }
			
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(165, 475, 131, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Save");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			          Class.forName("com.mysql.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");

			          String fname       = textField_5.getText();
			          String lname       = textField.getText();
			          String user_name    = textField_1.getText();
			          String password    = textField_3.getText();
			          String email       = textField_2.getText();
			          String phone       = textField_4.getText();
			          
			          if(fname.equals("")||lname.equals("")||user_name.equals("")|| password.equals("")||email.equals(""))
			  			{
			        	 JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			        	  
			        	 
			        	  
			          String query="INSERT INTO `signup`(`fname`, `lname`, `user_name`, `password`, `email`, `phone`,Image) "
				          		+ "VALUES (?,?,?,?,?,?,?)";
			          PreparedStatement stmt = con.prepareStatement(query);
			          InputStream is = new FileInputStream(new File(s));
			          
			        stmt.setString(1, fname);
			        stmt.setString(2, lname);	  
			        stmt.setString(3, user_name);
			        stmt.setString(4, password);
			        stmt.setString(5, email);
			        stmt.setString(6, phone);
			        stmt.setBlob(7,is);
			        
			        
			         int x= stmt.executeUpdate();
		 
			        if (x > 0) {
						JOptionPane.showMessageDialog(null, "Registration Complete");
						new user_update().setVisible(true);
					}
			        
			        con.close();
			        }
			          
				     } catch(Exception e1) {
			          System.out.println(e1);
			        }
				
				
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBackground(new Color(0, 195, 152));
		button_2.setBounds(735, 445, 110, 38);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Home");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_home().setVisible(true);
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBackground(new Color(244, 164, 96));
		button_3.setBounds(315, 445, 110, 38);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("Update");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			          Class.forName("com.mysql.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");

			          int row =table.getSelectedRow();
			          
			          String value =(table.getModel().getValueAt(row, 0).toString());
			          
			          String query="UPDATE `signup` SET `fname`=?,`lname`=?,`user_name`=?,`password`=?,`email`=?,`phone`=?,`Image`=? WHERE id="+value;
			          
			        PreparedStatement stmt = con.prepareStatement(query);
			        
			          String fname       = textField_5.getText();
			          String lname       = textField.getText();
			          String user_name    = textField_1.getText();
			          String password    = textField_3.getText();
			          String email       = textField_2.getText();
			          String phone       = textField_4.getText();
				    
			          InputStream is = new FileInputStream(new File(s));
				        stmt.setString(1, fname); 
				        stmt.setString(2, lname);
				        stmt.setString(3, user_name);	  
				        stmt.setString(4, password);
				        stmt.setString(5, email);
				        stmt.setString(6,phone);
				        stmt.setBlob(7,is);
				     
				        stmt.executeUpdate();
			            DefaultTableModel model =(DefaultTableModel)table.getModel();
				        model.setRowCount(0);
				        show_user();
				        JOptionPane.showMessageDialog(null, "User Information Update Successfully");
				        con.close();
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
				
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_4.setBackground(new Color(0, 195, 152));
		button_4.setBounds(456, 445, 110, 38);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("Delete");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			          Class.forName("com.mysql.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");

			          int row =table.getSelectedRow();
			          
			          String value =(table.getModel().getValueAt(row, 0).toString());
			          
			          String query="DELETE FROM `signup`WHERE id="+value;
			          
			        PreparedStatement stmt = con.prepareStatement(query);
			        
				     
				        stmt.executeUpdate();
			            DefaultTableModel model =(DefaultTableModel)table.getModel();
				        model.setRowCount(0);
				        show_user();
				        JOptionPane.showMessageDialog(null, "This User is Banned Successfully");
				        con.close();
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
				
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_5.setBackground(new Color(154, 205, 50));
		button_5.setBounds(596, 445, 110, 38);
		panel_1.add(button_5);
		
		JLabel label_4 = new JLabel("First Name :");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(35, 235, 103, 20);
		panel_1.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(165, 237, 131, 20);
		panel_1.add(textField_5);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(35, 275, 103, 20);
		panel_1.add(lblLastName);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(165, 280, 131, 20);
		panel_1.add(textField);
		
		JLabel label_5 = new JLabel("User Name :");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(35, 315, 103, 20);
		panel_1.add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(165, 315, 131, 20);
		panel_1.add(textField_1);
		
		JLabel label_6 = new JLabel("Password    :");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(35, 395, 103, 20);
		panel_1.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(165, 357, 131, 20);
		panel_1.add(textField_2);
		
		JLabel label_7 = new JLabel("Email :");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(35, 355, 103, 20);
		panel_1.add(label_7);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(165, 397, 131, 20);
		panel_1.add(textField_3);
		
		JLabel label_8 = new JLabel("Phone :");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(35, 435, 103, 20);
		panel_1.add(label_8);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(165, 435, 131, 20);
		panel_1.add(textField_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(315, 100, 525, 288);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			      int i =table.getSelectedRow();
			      TableModel model = table.getModel();
			      
                  textField.setText(model.getValueAt(i, 2).toString());
			      textField_1.setText(model.getValueAt(i, 3).toString());
			      textField_2.setText(model.getValueAt(i, 4).toString());
			      textField_3.setText(model.getValueAt(i, 5).toString());
			      textField_4.setText(model.getValueAt(i, 6).toString());
			      textField_5.setText(model.getValueAt(i, 1).toString());
			      
			      
			      ImageIcon image = new ImageIcon(new ImageIcon(userlist().get(i).getImage()).getImage().getScaledInstance(label_12.getWidth(), label_12.getHeight(),Image.SCALE_SMOOTH));
			      label_12.setIcon(image);     
			      
			      
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.I", "First Name ", "Last Name ", "User Name ", "Email", "Password", "Phone"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		show_user();
	}
}
