import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class sales_homepage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JLabel lblNewLabel ;
	JLabel label_1;
	JLabel label_6;
	JLabel label_7 ;
	JLabel label_8 ;
	
	String s;

	private JLabel image_label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sales_homepage frame = new sales_homepage();
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
	          
	           String query="SELECT * FROM product";
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
		DefaultTableModel model =(DefaultTableModel)table.getModel();
		
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
	public sales_homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 200, 591);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(20, 22, 151, 50);
		panel.add(label);
		
		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setForeground(Color.BLACK);
		lblHomePage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHomePage.setBounds(30, 77, 129, 22);
		panel.add(lblHomePage);
		
		JLabel label_2 = new JLabel("Mirpur 10 ,Dhaka");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(20, 535, 107, 17);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("stacksales@gmail.com");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(20, 563, 137, 17);
		panel.add(label_3);
		
		JButton button = new JButton("Logout");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(new Color(47, 79, 79));
		button.setBounds(20, 494, 170, 30);
		panel.add(button);
		
		JButton btnCardItems = new JButton("Card Items");
		btnCardItems.setBackground(new Color(128, 128, 128));
		btnCardItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CartItem().setVisible(true);
			}
		});
		btnCardItems.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCardItems.setBounds(10, 127, 180, 39);
		panel.add(btnCardItems);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(20, 265, 161, 203);
		panel.add(label_4);
		
		
		ImageIcon icon4 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\nishu.jpg");
        Image img4 = icon4.getImage();
		Image imgScale4 = img4.getScaledInstance(label_4.getWidth(), label_4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon4 = new ImageIcon(imgScale4);
		label_4.setIcon(ScaledIcon4);
		
		JLabel lblNewLabel_1 = new JLabel("Email :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 195, 58, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("nishu@gmail.com");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(65, 195, 139, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(10, 228, 100, 22);
		panel.add(lblUserName);
		
		JLabel lblNishu = new JLabel("Nishu007");
		lblNishu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNishu.setBounds(104, 228, 100, 22);
		panel.add(lblNishu);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(187, 0, 705, 591);
		contentPane.add(panel_1);
		
		JLabel lblOurProducts = new JLabel("Our Products");
		lblOurProducts.setForeground(Color.WHITE);
		lblOurProducts.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOurProducts.setBounds(275, -1, 219, 50);
		panel_1.add(lblOurProducts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 60, 657, 235);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			      int i =table.getSelectedRow();
			      TableModel model = table.getModel();
			      label_1.setText("Product Details");
				
				lblNewLabel.setText    ("Product Name :"+model.getValueAt(i, 3).toString());
			    label_6.setText("Product Price :"+model.getValueAt(i, 4).toString());
				label_7.setText("Product ID:"+model.getValueAt(i, 2).toString());
				label_8.setText("Description:"+model.getValueAt(i, 6).toString());
				
			ImageIcon image = new ImageIcon(new ImageIcon(productlist().get(i).getImage()).getImage().getScaledInstance(image_label.getWidth(), image_label.getHeight(),Image.SCALE_SMOOTH));
			image_label.setIcon(image);     
				      
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.I", "Catagory", "Product Id", "Product Name", "Product Price", "Quantity", "Description"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(30, 365, 270, 23);
		panel_1.add(lblNewLabel);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_1.setBounds(240, 306, 219, 50);
		panel_1.add(label_1);
		
		 label_6 = new JLabel("");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(30, 405, 270, 23);
		panel_1.add(label_6);
		
		label_7 = new JLabel("");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(30, 445, 270, 23);
		panel_1.add(label_7);
		
		label_8 = new JLabel("");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(30, 485, 270, 23);
		panel_1.add(label_8);
		
		image_label = new JLabel("");
		image_label.setBackground(Color.BLACK);
		image_label.setBounds(378, 365, 270, 147);
		panel_1.add(image_label);
		
		JButton btnNewButton = new JButton("Add to Card");
		btnNewButton.setBackground(new Color(0, 195, 152));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				try {
			          Class.forName("com.mysql.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
			          
			          int i =table.getSelectedRow();
				      TableModel model = table.getModel();
				      
				      String cat=(model.getValueAt(i, 1).toString());
				      String ID=(model.getValueAt(i, 3).toString());
				      String name=(model.getValueAt(i, 2).toString());
				      String price=(model.getValueAt(i, 4).toString());
				      String quan=(model.getValueAt(i, 5).toString());
				      String des=(model.getValueAt(i, 6).toString());
				      
				    		  
			          String catagory       = cat;
			          String p_id       = ID;
			          String p_name        = name;
			          String p_price       = price;
			          String quantity    = quan;
			          String description   = des;
			          
			          if(catagory.equals("")||p_id.equals("")||p_name.equals("")||p_price.equals("")|| quantity.equals("")||description.equals(""))
			  			{
			        	 JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			          
			          String query="INSERT INTO cart(catagory,`p_id`,`p_name`,`p_price`, `quantity`, `description`) "
				          		+ "VALUES (?,?,?,?,?,?)";
			          PreparedStatement stmt = con.prepareStatement(query);
			          
				        stmt.setString(1, catagory); 
				        stmt.setString(2, p_id);
				        stmt.setString(3, p_name);	  
				        stmt.setString(4, p_price);
				        stmt.setString(5, quantity);
				        stmt.setString(6,description);
				        
				        
				        
				         int x= stmt.executeUpdate();
			 
				        if (x > 0) {
							JOptionPane.showMessageDialog(null, "Cart Add Successfully");
							new sales_homepage().setVisible(true);
						}
				        
				        con.close();
				        
				}}catch(Exception e1) {
			          System.out.println(e1);
			        }
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(158, 541, 164, 39);
		panel_1.add(btnNewButton);
		
		JButton btnBuyNow = new JButton("Buy Now");
		btnBuyNow.setBackground(new Color(255, 127, 80));
	
		btnBuyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int i =table.getSelectedRow();
			      TableModel model = table.getModel();
			      
			     
			      String name=(model.getValueAt(i, 3).toString());
			   
			      JOptionPane.showMessageDialog(null, "You Have  Buy "+name+"\nPay On Delivery Time");		  
		     
				
			}
		});
		btnBuyNow.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuyNow.setBounds(381, 541, 164, 39);
		panel_1.add(btnBuyNow);
		
		show_product();
	}
}
