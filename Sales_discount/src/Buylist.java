import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Buylist extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buylist frame = new Buylist();
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
	
	
	public ArrayList<Buy> buylist(){
		ArrayList<Buy> buylist = new ArrayList<>();
		

	          
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
	          
	           String query="SELECT * FROM buy_item";
	           Statement stmt = con.createStatement();
	           ResultSet rs=stmt.executeQuery(query);
	        
	           Buy buy;
	        while (rs.next()){ 
	        	buy= new Buy(rs.getInt("id"),rs.getString("fullname"),rs.getString("email"),rs.getString("address"),rs.getString("p_name")
	        			,rs.getString("p_price"),rs.getString("p_id"),rs.getString("quantity"));
	        	buylist.add(buy);
           }
		
		
	          
             con.close(); 
        }catch (Exception e){ 
             //Your exception handling mechanism goes here. 
        } 
		return buylist;	
	}
	
	public void show_buylist() {
		ArrayList<Buy> list = buylist();
		DefaultTableModel model =(DefaultTableModel)table.getModel();
		
		Object[] row = new Object[8];
		
	for(int i=0;i<list.size();i++) {
		row[0]=list.get(i).getid();
		row[1]=list.get(i).getfullname();
		row[2]=list.get(i).getemail();
		row[3]=list.get(i).getaddress();
		row[4]=list.get(i).getp_name();
		row[5]=list.get(i).getp_id();
		row[6]=list.get(i).getp_price();
		row[7]=list.get(i).getquantity();
	
	
		
		model.addRow(row);
		
		
	}
	}
	
	
	
	
	public Buylist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 511);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(30, 22, 151, 50);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Admin Panel");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(30, 71, 129, 22);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Mirpur 10 ,Dhaka");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(30, 440, 107, 17);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("stacksales@gmail.com");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(30, 470, 137, 17);
		panel.add(label_3);
		
		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin().setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(new Color(47, 79, 79));
		button.setBounds(30, 395, 139, 30);
		panel.add(button);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(10, 177, 171, 195);
		panel.add(label_4);

		ImageIcon icon5 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\saad.jpg");
	     Image img5 = icon5.getImage();
		Image imgScale5 = img5.getScaledInstance(label_4.getWidth(), label_4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon6 = new ImageIcon(imgScale5);
		label_4.setIcon(ScaledIcon6);
		
		JLabel label_6 = new JLabel("Email :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(10, 104, 46, 36);
		panel.add(label_6);
		
		JLabel label_5 = new JLabel("sksad1998@gmail.com");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(51, 104, 139, 36);
		panel.add(label_5);
		
		JLabel label_7 = new JLabel("User Name :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(10, 132, 74, 36);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("SK007");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(86, 132, 114, 36);
		panel.add(label_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(199, 0, 645, 511);
		contentPane.add(panel_1);
		
		JLabel lblOrderDetails = new JLabel("Order Details");
		lblOrderDetails.setForeground(Color.WHITE);
		lblOrderDetails.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOrderDetails.setBounds(211, 1, 184, 45);
		panel_1.add(lblOrderDetails);
		
		JButton button_2 = new JButton("Save");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBackground(new Color(0, 195, 152));
		button_2.setBounds(737, 445, 110, 38);
		panel_1.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 57, 600, 205);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.I", "Buyer  Name", "Email", "Address", "Product Name", "Product Price", "Product ID", "Quantity"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(474, 411, 46, 23);
		panel_1.add(label_16);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new admin_home().setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHome.setBackground(new Color(0, 195, 152));
		btnHome.setBounds(281, 461, 100, 39);
		panel_1.add(btnHome);
		show_buylist();
	}
}
