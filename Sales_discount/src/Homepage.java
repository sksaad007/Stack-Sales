import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(1, 50, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Stack Sales ");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWelcome.setBounds(355, 35, 287, 39);
		contentPane.add(lblWelcome);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.setBackground(new Color(0, 195, 152));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new admin().setVisible(true);
			}
		});
		btnNewButton.setBounds(272, 399, 100, 39);
		contentPane.add(btnNewButton);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new userlogin().setVisible(true);
				
			}
		});
		btnUser.setBackground(new Color(0, 195, 152));
		btnUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUser.setBounds(443, 399, 100, 39);
		contentPane.add(btnUser);
		
		JButton btnVisitor = new JButton("Visitor");
		btnVisitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Visitor().setVisible(true);
			}
		});
		btnVisitor.setBackground(new Color(0, 195, 152));
		btnVisitor.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVisitor.setBounds(622, 399, 100, 39);
		contentPane.add(btnVisitor);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 215, 511);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(33, 40, 151, 50);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Find it, love it, buy it! ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(-32, 101, 287, 39);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\shop1.png"));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(42, 220, 116, 138);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Mirpur 10 ,Dhaka");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(33, 433, 107, 17);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("stacksales@gmail.com");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(33, 461, 137, 17);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(260, 240, 130, 130);
		contentPane.add(label_5);
		
		
;
		
		ImageIcon icon = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\engineer_1 .png");
        Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon = new ImageIcon(imgScale);
		label_5.setIcon(ScaledIcon);
		
		JLabel label_6 = new JLabel("");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(428, 259, 130, 94);
		contentPane.add(label_6);
		
		ImageIcon icon2 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\team_1.png");
        Image img2 = icon2.getImage();
		Image imgScale2 = img2.getScaledInstance(label_6.getWidth(), label_6.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon2 = new ImageIcon(imgScale2);
		label_6.setIcon(ScaledIcon2);
		
		JLabel label_7 = new JLabel("");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(609, 259, 130, 94);
		contentPane.add(label_7);
		
		
		ImageIcon icon3 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\return.png");
        Image img3 = icon3.getImage();
		Image imgScale3 = img3.getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon3 = new ImageIcon(imgScale3);
		label_7.setIcon(ScaledIcon3);
		
		JLabel label_8 = new JLabel("");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(429, 94, 114, 112);
		contentPane.add(label_8);
		
		ImageIcon icon4 = new ImageIcon("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\super.png");
        Image img4 = icon4.getImage();
		Image imgScale4 = img4.getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon4 = new ImageIcon(imgScale4);
		label_8.setIcon(ScaledIcon4);
	       
		
	}
}
