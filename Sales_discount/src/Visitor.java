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

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Visitor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	JLabel label_5;
	JLabel label_6;
	JLabel label_7;
	JLabel label_8;
	JLabel label_9;
	JLabel label_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visitor frame = new Visitor();
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
	
	
	
	public Visitor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 189, 591);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(20, 22, 151, 50);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Home Page");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(28, 119, 129, 22);
		panel.add(label_1);
		
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
		
		JButton button = new JButton("LOGIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new userlogin().setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(new Color(47, 79, 79));
		button.setBounds(20, 494, 139, 30);
		panel.add(button);
		
		JButton button_1 = new JButton("Card Items");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JOptionPane.showMessageDialog(null, "Please Login First");	
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(10, 152, 161, 39);
		panel.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(30, 238, 129, 173);
		panel.add(lblNewLabel);
		
		
		
		ImageIcon icon4 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\super.png");
        Image img4 = icon4.getImage();
		Image imgScale4 = img4.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon4 = new ImageIcon(imgScale4);
		lblNewLabel.setIcon(ScaledIcon4);
		
		JLabel lblVisitor = new JLabel("Visitor");
		lblVisitor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitor.setForeground(Color.BLACK);
		lblVisitor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVisitor.setBounds(30, 86, 129, 22);
		panel.add(lblVisitor);
	       
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(179, 0, 705, 591);
		contentPane.add(panel_1);
		
		JLabel label_4 = new JLabel("Our Products");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_4.setBounds(275, -1, 219, 50);
		panel_1.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 60, 657, 235);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			      int i =table.getSelectedRow();
			      TableModel model = table.getModel();
			      label_6.setText("Product Details");
				
			      label_5.setText    ("Product Name :"+model.getValueAt(i, 3).toString());
			    label_8.setText("Product Price :"+model.getValueAt(i, 4).toString());
				label_7.setText("Product ID:"+model.getValueAt(i, 2).toString());
				label_9.setText("Description:"+model.getValueAt(i, 6).toString());
				
				
			ImageIcon image = new ImageIcon(new ImageIcon(productlist().get(i).getImage()).getImage().getScaledInstance(label_10.getWidth(), label_10.getHeight(),Image.SCALE_SMOOTH));
			label_10.setIcon(image);     
				      
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.I", "Catagory", "Product ID", "Product Name", "Product Price", "Quantity", "Description"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		 label_5 = new JLabel("");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(30, 365, 270, 23);
		panel_1.add(label_5);
		
		 label_7 = new JLabel("");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(30, 405, 270, 23);
		panel_1.add(label_7);
		
	    label_8 = new JLabel("");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(30, 445, 270, 23);
		panel_1.add(label_8);
		
		 label_9 = new JLabel("");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(30, 485, 270, 23);
		panel_1.add(label_9);
		
		label_10 = new JLabel("");
		label_10.setBackground(Color.BLACK);
		label_10.setBounds(378, 365, 270, 147);
		panel_1.add(label_10);
		
		JButton button_2 = new JButton("Add to Card");
		button_2.setBackground(new Color(0, 195, 152));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please Login First");	
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBounds(158, 541, 164, 39);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Buy Now");
		button_3.setBackground(new Color(255, 127, 80));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please Login First");	
				new userlogin().setVisible(true);
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBounds(381, 541, 164, 39);
		panel_1.add(button_3);
		
	    label_6 = new JLabel("");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_6.setBounds(230, 317, 219, 50);
		panel_1.add(label_6);
		
		show_product();
	}
}
