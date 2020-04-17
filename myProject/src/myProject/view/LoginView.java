package myProject.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame implements ActionListener {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnExit;
	private JButton btnLogin;
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public LoginView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 전체화면
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		setUndecorated(true);
		gd.setFullScreenWindow(this);

		getContentPane().setLayout(null);
		JPanel background = (JPanel) getContentPane();
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBounds(dim.width/2 - 450, dim.height/2 -300, 900, 400);
		background.add(panelCenter);
		panelCenter.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panelC_1 = new JPanel();
		panelCenter.add(panelC_1);
		panelC_1.setLayout(new BorderLayout(0, 0));
		JLabel lblTitle = new JLabel("POS System");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelC_1.add(lblTitle);
		
		JPanel panelC_2 = new JPanel();
		panelCenter.add(panelC_2);
		panelC_2.setLayout(null);
		JLabel lblID = new JLabel("I      D");
		lblID.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblID.setBounds(116, 30, 80, 15);
		panelC_2.add(lblID);
		textField = new JTextField();
		textField.setFont(new Font("Arial Black", Font.BOLD, 15));
		textField.setBounds(260, 15, 600, 48);
		panelC_2.add(textField);
		textField.setColumns(10);
		
		JPanel panelC_3 = new JPanel();
		panelCenter.add(panelC_3);
		panelC_3.setLayout(null);
		JLabel lblPW = new JLabel("P     W");
		lblPW.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblPW.setBounds(116, 30, 80, 15);
		panelC_3.add(lblPW);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial Black", Font.BOLD, 15));
		passwordField.setBounds(260, 15, 600, 48);
		panelC_3.add(passwordField);
		
		JPanel panelC_4 = new JPanel();
		panelCenter.add(panelC_4);
		panelC_4.setLayout(new GridLayout(1, 2, 0, 0));
		JCheckBox chckbxID = new JCheckBox("rememberID");
		chckbxID.setVerticalAlignment(SwingConstants.TOP);
		chckbxID.setFont(new Font("Arial Black", Font.BOLD, 15));
		chckbxID.setHorizontalAlignment(SwingConstants.TRAILING);
		panelC_4.add(chckbxID);
		JCheckBox chckbxPW = new JCheckBox("rememberPW");
		chckbxPW.setVerticalAlignment(SwingConstants.TOP);
		chckbxPW.setFont(new Font("Arial Black", Font.BOLD, 15));
		panelC_4.add(chckbxPW);
		
		JPanel panelC_5 = new JPanel();
		panelCenter.add(panelC_5);
		panelC_5.setLayout(new GridLayout(1, 2, 0, 0));
		btnExit = new JButton("EXIT");
		btnExit.addActionListener(this);
		
		btnExit.setFont(new Font("Arial Black", Font.BOLD, 20));
		panelC_5.add(btnExit);
		btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(this);
		btnLogin.setFont(new Font("Arial Black", Font.BOLD, 20));
		panelC_5.add(btnLogin);
		
		setSize(dim.width, dim.height);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton btn = (JButton) e.getSource();
			if(btn == btnExit){
				JOptionPane.showConfirmDialog(btnExit, "exit?", "Confirm", JOptionPane.YES_NO_OPTION);
			}else if(btn == btnLogin){
				System.out.println("로그인");
			}
		}
	}
}
