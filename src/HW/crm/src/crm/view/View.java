package crm.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import crm.controller.Controller;
import crm.model.DAO;
import crm.model.DTO;

public class View implements ActionListener {

	private JFrame frmCrm;

	private JPanel p0;
	private JPanel p1;
	private JPanel p1_0;
	private JPanel p1_1;
	private JPanel p1_2;
	private JPanel p1_3;
	private JPanel p1_4;
	private JPanel p2;
	private JPanel p3;
	private JPanel p3_0;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private static JTextField textField1;
	private static JTextField textField2;
	private static JTextField textField3;
	private static JTextField textField4;
	
	private JButton btn1_total;
	private JButton btn2_add;
	private JButton btn3_delete;
	private JButton btn4_search;
	private JButton btn5_cancel;

	private String[] column = { "INDEX", "NAME", "E-MAIL", "PHONE" };
	private JTable table;
	public static DefaultTableModel dtm;

	Scanner scan = new Scanner(System.in);

	public View() {
		initialize();
	}

	private void initialize() {
		frmCrm = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmCrm.setBounds((dim.width / 2) - (frmCrm.getWidth() / 2), (dim.height / 2) - (frmCrm.getHeight() / 2), 900, 500);
		frmCrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrm.setTitle("Customer Relationship Management");

		p0 = new JPanel();
		p0.setBounds(0, 0, 900, 500);
		frmCrm.getContentPane().add(p0);
		p0.setLayout(null);
		
		p1 = new JPanel(new GridLayout(10,1));
		p1.setBounds(0, 0, 200, 400);
		p0.add(p1);
		
		p2 = new JPanel();
		p2.setBounds(200, 0, 700, 400);
		p0.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(0, 420, 900, 51);
		p0.add(p3);
		p3.setLayout(new BorderLayout(0, 0));
		
		p3_0 = new JPanel();
		p3.add(p3_0, BorderLayout.CENTER);
		
		btn1_total = new JButton("TOTAL");
		btn1_total.setFont(new Font("Consolas", Font.BOLD, 12));
		p3_0.add(btn1_total);
		
		btn2_add= new JButton("ADD");
		btn2_add.setFont(new Font("Consolas", Font.BOLD, 12));
		p3_0.add(btn2_add);
		
		btn3_delete = new JButton("DELETE");
		btn3_delete.setFont(new Font("Consolas", Font.BOLD, 12));
		p3_0.add(btn3_delete);
		
		btn4_search = new JButton("SEARCH");
		btn4_search.setFont(new Font("Consolas", Font.BOLD, 12));
		p3_0.add(btn4_search);
		
		btn5_cancel = new JButton("CANCLE");
		btn5_cancel.setFont(new Font("Consolas", Font.BOLD, 12));
		p3_0.add(btn5_cancel);
		
		p1_0 = new JPanel();
		p1.add(p1_0);
		p1_0.setLayout(new BorderLayout(0, 0));
		lblNewLabel = new JLabel("Customer Information");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		p1_0.add(lblNewLabel, BorderLayout.CENTER);
		
		p1_1 = new JPanel();
		p1.add(p1_1);
		p1_1.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		lblNewLabel_1 = new JLabel("INDEX");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 12));
		p1_1.add(lblNewLabel_1);
		textField1 = new JTextField();
		p1_1.add(textField1);
		textField1.setColumns(10);
		
		p1_2 = new JPanel();
		p1.add(p1_2);
		p1_2.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 12));
		p1_2.add(lblNewLabel_2);
		textField2 = new JTextField();
		p1_2.add(textField2);
		textField2.setColumns(10);
		
		p1_3 = new JPanel();
		p1.add(p1_3);
		p1_3.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		lblNewLabel_3 = new JLabel("E-MAIL");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 12));
		p1_3.add(lblNewLabel_3);
		textField3 = new JTextField();
		p1_3.add(textField3);
		textField3.setColumns(10);
		
		p1_4 = new JPanel();
		p1.add(p1_4);
		p1_4.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		lblNewLabel_4 = new JLabel("PHONE");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 12));
		p1_4.add(lblNewLabel_4);
		textField4 = new JTextField();
		p1_4.add(textField4);
		textField4.setColumns(10);
		p2.setLayout(null);
		
		dtm = new DefaultTableModel(column, 0);
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setBounds(0, 0, 700, 400);
		p2.add(scrollPane);

		frmCrm.setResizable(false);
		frmCrm.setVisible(true);
		
		btn1_total.addActionListener(this);
		btn2_add.addActionListener(this);
		btn3_delete.addActionListener(this);
		btn4_search.addActionListener(this);
		btn5_cancel.addActionListener(this);

	}

	public static DTO inputInfo() {
		DTO tmpInfo = new DTO();
		tmpInfo.setIdx(textField1.getText());
		tmpInfo.setName(textField2.getText());
		tmpInfo.setEmail(textField3.getText());
		tmpInfo.setPhone(textField4.getText());
		return tmpInfo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton btn = (JButton) e.getSource();

			if (btn == btn1_total) {
				Controller.service(1);
				
			} else if (btn == btn2_add) {
				Controller.service(2);
				
			} else if (btn == btn3_delete) {
				Controller.service(3);
				
			} else if (btn == btn4_search) {
				Controller.service(4);
				
			} else if (btn == btn5_cancel) {
				Controller.service(5);
			}
		}
	}

	public static void reset() {
		textField1.setText(null);
		textField2.setText(null);
		textField3.setText(null);
		textField4.setText(null);
		
	}
}