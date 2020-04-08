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

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class product_update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;
	
	String s;
	JLabel label1 = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					product_update frame = new product_update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ArrayList<Product> productlist(){
		ArrayList<Product> productlist = new ArrayList<>();
		

	          
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
	          
	          
	           String query="SELECT * FROM product" ;
	           Statement stmt = con.createStatement();
	           ResultSet rs=stmt.executeQuery(query);
	        
	        Product product;
	        while (rs.next()){ 
	        	product= new Product(rs.getInt("id"),rs.getString("catagory"),rs.getString("p_id"),rs.getString("p_name")
	        			,rs.getString("p_price"),rs.getString("p_fprice"),rs.getString("description"),rs.getBytes("Image"));
	        	productlist.add(product);
           }
		
		
	          
             con.close(); 
        }catch (Exception e){ 
             //Your exception handling mechanism goes here. 
        } 
		return productlist;	
	}
	
	public void show_product() {
		ArrayList<Product> list = productlist();
		DefaultTableModel model =(DefaultTableModel)table_1.getModel();
		
		Object[] row = new Object[8];
		
	for(int i=0;i<list.size();i++) {
		row[0]=list.get(i).getid();
		row[1]=list.get(i).getcatagory();
		row[2]=list.get(i).getp_name();
		row[3]=list.get(i).getp_id();
		row[4]=list.get(i).getp_price();
		row[5]=list.get(i).getp_fprice();
		row[6]=list.get(i).getdescription();
		row[7]=list.get(i).getImage();
		model.addRow(row);
		
		
	}
	}
	/**
	 * Create the frame.
	 */
	public product_update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 198, 551);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(20, 22, 151, 50);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Admin Panel");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(20, 72, 129, 22);
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
		button.setBounds(22, 454, 149, 30);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(15, 193, 151, 219);
		panel.add(lblNewLabel);
		
		
		ImageIcon icon5 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\saad.jpg");
		
		Image img5 = icon5.getImage();
		Image imgScale5 = img5.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon6 = new ImageIcon(imgScale5);
		lblNewLabel.setIcon(ScaledIcon6);
		
		JLabel label_8 = new JLabel("Email :");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(10, 116, 46, 36);
		panel.add(label_8);
		
		JLabel label_13 = new JLabel("sksad1998@gmail.com");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(53, 116, 139, 36);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("User Name :");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(10, 146, 74, 36);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("SK007");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(84, 146, 108, 36);
		panel.add(label_15);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(177, 0, 857, 551);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProductInformatiom = new JLabel("Product Information");
		lblProductInformatiom.setBounds(320, 11, 273, 50);
		lblProductInformatiom.setForeground(Color.WHITE);
		lblProductInformatiom.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblProductInformatiom);
		
		JLabel label_5 = new JLabel("Catagory  :");
		label_5.setBounds(35, 235, 103, 20);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label_5);
		
		JComboBox combo = new JComboBox();
		combo.setBounds(165, 235, 131, 20);
		combo.setBackground(Color.WHITE);
		panel_1.add(combo);
		
		combo.addItem("Mobile Phone");
		combo.addItem("Men");
		combo.addItem("Women");
		combo.addItem("Electronics");
		combo.addItem("Vehicles");
		combo.addItem("Property");
		JLabel label_6 = new JLabel("Product  Name :");
		label_6.setBounds(35, 315, 123, 20);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label_6);
		
		textField = new JTextField();
		textField.setBounds(165, 275, 131, 20);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(Color.GRAY);
		panel_1.add(textField);
		
		JLabel label_7 = new JLabel("Product  Id :");
		label_7.setBounds(35, 275, 123, 20);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 315, 131, 20);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(165, 355, 131, 20);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GRAY);
		panel_1.add(textField_2);
		
		JLabel lblProductQuantity = new JLabel("Quantity:");
		lblProductQuantity.setBounds(35, 355, 131, 20);
		lblProductQuantity.setForeground(Color.WHITE);
		lblProductQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblProductQuantity);
		
		JLabel label_9 = new JLabel("Discount :");
		label_9.setBounds(35, 395, 103, 20);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label_9);
		
		textField_3 = new JTextField();
		textField_3.setBounds(165, 395, 131, 20);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.GRAY);
		panel_1.add(textField_3);
		
		JLabel label_10 = new JLabel("Description :");
		label_10.setBounds(35, 435, 103, 20);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label_10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(165, 435, 131, 20);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.GRAY);
		panel_1.add(textField_4);
		
		JLabel label_11 = new JLabel("Image :");
		label_11.setBounds(35, 475, 103, 20);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		button_1.setBounds(165, 475, 131, 23);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(button_1);
		
		JButton btnUpdate = new JButton("Save");
		btnUpdate.setBounds(737, 445, 110, 38);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
			          Class.forName("com.mysql.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
			          
			          String catagory       = (String) combo.getSelectedItem();
			          String p_id       = textField.getText();
			          String p_name        = textField_1.getText();
			          String p_price       = textField_2.getText();
			          String p_fprice    = textField_3.getText();
			          String description   = textField_4.getText();
			          
			          if(catagory.equals("")||p_id.equals("")||p_name.equals("")||p_price.equals("")|| p_fprice.equals("")||description.equals(""))
			  			{
			        	 JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			          
			          String query="INSERT INTO product(catagory,`p_id`,`p_name`,`p_price`, `p_fprice`, `description`,Image) "
				          		+ "VALUES (?,?,?,?,?,?,?)";
			          PreparedStatement stmt = con.prepareStatement(query);
			          InputStream is = new FileInputStream(new File(s));
				        stmt.setString(1, catagory); 
				        stmt.setString(2, p_id);
				        stmt.setString(3, p_name);	  
				        stmt.setString(4, p_price);
				        stmt.setString(5, p_fprice);
				        stmt.setString(6,description);
				        stmt.setBlob(7,is);
				        
				        
				         int x= stmt.executeUpdate();
			 
				        if (x > 0) {
							JOptionPane.showMessageDialog(null, "Product Update Successfully");
							new admin_home().setVisible(true);
						}
				        
				        con.close();
				        
				}}catch(Exception e1) {
			          System.out.println(e1);
			        }
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBackground(new Color(0, 195, 152));
		panel_1.add(btnUpdate);
		
		JButton button_3 = new JButton("Home");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_home().setVisible(true);
			}
		});
		button_3.setBounds(315, 445, 110, 38);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBackground(new Color(244, 164, 96));
		panel_1.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(315, 100, 532, 300);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
			      int i =table_1.getSelectedRow();
			      TableModel model = table_1.getModel();
			      
                  textField.setText(model.getValueAt(i, 2).toString());
			      textField_1.setText(model.getValueAt(i, 3).toString());
			      textField_2.setText(model.getValueAt(i, 4).toString());
			      textField_3.setText(model.getValueAt(i, 5).toString());
			      textField_4.setText(model.getValueAt(i, 6).toString());
			      
		
			      
			      ImageIcon image = new ImageIcon(new ImageIcon(productlist().get(i).getImage()).getImage().getScaledInstance(label_12.getWidth(), label_12.getHeight(),Image.SCALE_SMOOTH));
			      label_12.setIcon(image);     
			      
	      
			      
			}
		        
		     
		        
		    
		    
			
		});
		
		
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.I", "Catagory", "Product ID", "Product Name", "Product Price", "Quantity", "Description"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(83);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(79);
		scrollPane.setViewportView(table_1);
		
		
		JButton button_2 = new JButton("Update");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			          Class.forName("com.mysql.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");

			          int row =table_1.getSelectedRow();
			          
			          String value =(table_1.getModel().getValueAt(row, 0).toString());
			          
			          String query="UPDATE `product` SET `catagory`=?,`p_id`=?,`p_name`=?,`p_price`=?,`p_fprice`=?,`description`=?,`Image`=? WHERE id="+value;
			          
			        PreparedStatement stmt = con.prepareStatement(query);
			        
			          String catagory       = (String) combo.getSelectedItem();
			          String p_id       = textField.getText();
			          String p_name        = textField_1.getText();
			          String p_price       = textField_2.getText();
			          String p_fprice    = textField_3.getText();
			          String description   = textField_4.getText();
				    
			          InputStream is = new FileInputStream(new File(s));
				        stmt.setString(1, catagory); 
				        stmt.setString(2, p_id);
				        stmt.setString(3, p_name);	  
				        stmt.setString(4, p_price);
				        stmt.setString(5, p_fprice);
				        stmt.setString(6,description);
				        stmt.setBlob(7,is);
				     
				        stmt.executeUpdate();
			            DefaultTableModel model =(DefaultTableModel)table_1.getModel();
				        model.setRowCount(0);
				        show_product();
				        JOptionPane.showMessageDialog(null, "Product Update Successfully");
				        con.close();
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBackground(new Color(0, 195, 152));
		button_2.setBounds(456, 445, 110, 38);
		panel_1.add(button_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			          Class.forName("com.mysql.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");

			          int row =table_1.getSelectedRow();
			          
			          String value =(table_1.getModel().getValueAt(row, 0).toString());
			          
			          String query="DELETE FROM `product`WHERE id="+value;
			          
			        PreparedStatement stmt = con.prepareStatement(query);
			        
				     
				        stmt.executeUpdate();
			            DefaultTableModel model =(DefaultTableModel)table_1.getModel();
				        model.setRowCount(0);
				        show_product();
				        JOptionPane.showMessageDialog(null, "Product Delete Successfully");
				        con.close();
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
			}
			
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBackground(new Color(154, 205, 50));
		btnDelete.setBounds(596, 445, 110, 38);
		panel_1.add(btnDelete);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(474, 411, 46, 23);
		panel_1.add(label_4);
		
		show_product();
	}
}
