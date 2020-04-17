package myProject.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MembersView extends View{
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private JTable table;
	private JTextField textField_Number;
	private JTextField textField_Name;
	private JTextField textField_Phone;
	private JTextField textField_Age;
	private JTextField textField_Adrress;
	private JTextField textField_Email;
	private JTextField textField_Like;
	private JTextField textField_Mileage;
	private JTextField textField_Grade;
	
	public MembersView() {
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 122, 1920, 958);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_enroll = new JPanel();
		panel.add(panel_enroll);
		panel_enroll.setLayout(null);
		
		JLabel lblMemTitle = new JLabel("MEMBERSHIP");
		lblMemTitle.setFont(new Font("Arial Black", Font.ITALIC, 24));
		lblMemTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemTitle.setBounds(244, 10, 481, 86);
		panel_enroll.add(lblMemTitle);
		
		JPanel panel_mem = new JPanel();
		panel_mem.setBounds(26, 106, 922, 725);
		panel_enroll.add(panel_mem);
		panel_mem.setLayout(new GridLayout(9, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_mem.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNumber.setBounds(33, 27, 177, 37);
		panel_1.add(lblNumber);
		textField_Number = new JTextField();
		textField_Number.setBounds(222, 24, 642, 40);
		panel_1.add(textField_Number);
		textField_Number.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_mem.add(panel_2);
		panel_2.setLayout(null);
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblName.setBounds(33, 27, 177, 37);
		panel_2.add(lblName);
		textField_Name = new JTextField();
		textField_Name.setBounds(222, 24, 642, 40);
		panel_2.add(textField_Name);
		textField_Name.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_mem.add(panel_3);
		panel_3.setLayout(null);
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPhone.setBounds(33, 27, 177, 37);
		panel_3.add(lblPhone);
		textField_Phone = new JTextField();
		textField_Phone.setBounds(222, 24, 642, 40);
		panel_3.add(textField_Phone);
		textField_Phone.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_mem.add(panel_4);
		panel_4.setLayout(null);
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAge.setBounds(33, 27, 177, 37);
		panel_4.add(lblAge);
		textField_Age = new JTextField();
		textField_Age.setBounds(222, 24, 642, 40);
		panel_4.add(textField_Age);
		textField_Age.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_mem.add(panel_5);
		panel_5.setLayout(null);
		JLabel lblAdrress = new JLabel("Adrress");
		lblAdrress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdrress.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAdrress.setBounds(33, 27, 177, 37);
		panel_5.add(lblAdrress);
		textField_Adrress = new JTextField();
		textField_Adrress.setBounds(222, 24, 642, 40);
		panel_5.add(textField_Adrress);
		textField_Adrress.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_mem.add(panel_6);
		panel_6.setLayout(null);
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEmail.setBounds(33, 27, 177, 37);
		panel_6.add(lblEmail);
		textField_Email = new JTextField();
		textField_Email.setBounds(222, 24, 642, 40);
		panel_6.add(textField_Email);
		textField_Email.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_mem.add(panel_7);
		panel_7.setLayout(null);
		JLabel lblLike = new JLabel("Like");
		lblLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblLike.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLike.setBounds(33, 27, 177, 37);
		panel_7.add(lblLike);
		textField_Like = new JTextField();
		textField_Like.setBounds(222, 24, 642, 40);
		panel_7.add(textField_Like);
		textField_Like.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_mem.add(panel_8);
		panel_8.setLayout(null);
		JLabel lblMileage = new JLabel("Mileage");
		lblMileage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMileage.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMileage.setBounds(33, 27, 177, 37);
		panel_8.add(lblMileage);
		textField_Mileage = new JTextField();
		textField_Mileage.setBounds(222, 24, 642, 40);
		panel_8.add(textField_Mileage);
		textField_Mileage.setColumns(10);
		
		
		JPanel panel_9 = new JPanel();
		panel_mem.add(panel_9);
		panel_9.setLayout(null);
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGrade.setBounds(33, 27, 177, 37);
		panel_9.add(lblGrade);
		textField_Grade = new JTextField();
		textField_Grade.setBounds(222, 24, 642, 40);
		panel_9.add(textField_Grade);
		textField_Grade.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(244, 851, 508, 71);
		panel_enroll.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnMemDel = new JButton("Delete");
		btnMemDel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel_10.add(btnMemDel);
		
		JButton btnMemUpd = new JButton("Update");
		btnMemUpd.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel_10.add(btnMemUpd);
		
		JButton btnMemAdd = new JButton("Add");
		btnMemAdd.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel_10.add(btnMemAdd);
		
		
	}
}
