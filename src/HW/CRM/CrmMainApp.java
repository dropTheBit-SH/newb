package homework;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;


		
public class CrmMainApp {
			
	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;
	private JButton btn5_cancle;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrmMainApp window = new CrmMainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CrmMainApp() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((dim.width/2)-(frame.getWidth()/2), (dim.height/2)-(frame.getHeight()/2), 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("고객관리시스템");
		frame.getContentPane().setLayout(null);
		
		JPanel panel_file = new JPanel();
		panel_file.setBounds(200, 0, 684, 400);
		frame.getContentPane().add(panel_file);
		
		table = new JTable();
		panel_file.add(table);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 10, 116, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(72, 72, 116, 21);
		frame.getContentPane().add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(72, 196, 116, 21);
		frame.getContentPane().add(textField_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(72, 134, 116, 21);
		frame.getContentPane().add(textField_3);
		
		JLabel lblIndex = new JLabel("INDEX");
		lblIndex.setLabelFor(textField_1);
		lblIndex.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIndex.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIndex.setBounds(12, 13, 57, 15);
		frame.getContentPane().add(lblIndex);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setLabelFor(textField_2);
		lblName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(12, 75, 57, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setLabelFor(textField_3);
		lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(12, 137, 57, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setLabelFor(textField_4);
		lblPhone.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhone.setBounds(12, 199, 57, 15);
		frame.getContentPane().add(lblPhone);
		
		btn5_cancle = new JButton("CANCLE");
		btn5_cancle.setBounds(660, 420, 97, 23);
		frame.getContentPane().add(btn5_cancle);
		
		JButton btn4_search = new JButton("SEARCH");
		btn4_search.setBounds(520, 420, 97, 23);
		frame.getContentPane().add(btn4_search);
		
		JButton btn3_delete = new JButton("DELETE");
		btn3_delete.setBounds(390, 420, 97, 23);
		frame.getContentPane().add(btn3_delete);
		
		JButton btn2_add = new JButton("ADD");
		btn2_add.setBounds(260, 420, 97, 23);
		frame.getContentPane().add(btn2_add);
		
		JButton btn1_view = new JButton("All");
		btn1_view.setBounds(120, 420, 97, 23);
		frame.getContentPane().add(btn1_view);
		frame.setVisible(true);
		
	}
}
