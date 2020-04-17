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

public class View extends JFrame{
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	JPanel background = (JPanel) getContentPane();
	
	public View() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 전체화면
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		setUndecorated(true);
		gd.setFullScreenWindow(this);
		getContentPane().setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 1920, 119);
		background.add(panelMenu);
		panelMenu.setLayout(new GridLayout(1, 8, 0, 0));
		
		JPanel panMenu_1 = new JPanel();
		panelMenu.add(panMenu_1);
		panMenu_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("POS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		panMenu_1.add(lblNewLabel);
		JPanel panMenu_2 = new JPanel();
		panelMenu.add(panMenu_2);
		panMenu_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnMenu_Main = new JButton("MAIN");
		btnMenu_Main.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panMenu_2.add(btnMenu_Main, BorderLayout.CENTER);
		JPanel panMenu_3 = new JPanel();
		panelMenu.add(panMenu_3);
		panMenu_3.setLayout(new BorderLayout(0, 0));
		
		JButton btnMenu_Members = new JButton("MEMBERS");
		btnMenu_Members.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panMenu_3.add(btnMenu_Members, BorderLayout.CENTER);
		JPanel panMenu_4 = new JPanel();
		panelMenu.add(panMenu_4);
		panMenu_4.setLayout(new BorderLayout(0, 0));
		
		JButton btnMenu_Coupon = new JButton("COUPON");
		btnMenu_Coupon.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panMenu_4.add(btnMenu_Coupon, BorderLayout.CENTER);
		JPanel panMenu_5 = new JPanel();
		panelMenu.add(panMenu_5);
		panMenu_5.setLayout(new BorderLayout(0, 0));
		
		JButton btnMenu_Order = new JButton("ORDER");
		btnMenu_Order.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panMenu_5.add(btnMenu_Order, BorderLayout.CENTER);
		JPanel panMenu_6 = new JPanel();
		panelMenu.add(panMenu_6);
		panMenu_6.setLayout(new BorderLayout(0, 0));
		
		JButton btnMenu_Sales= new JButton("SALES");
		btnMenu_Sales.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panMenu_6.add(btnMenu_Sales, BorderLayout.CENTER);
		JPanel panMenu_7 = new JPanel();
		panelMenu.add(panMenu_7);
		panMenu_7.setLayout(new BorderLayout(0, 0));
		
		JButton btnMenu_Option = new JButton("OPTION");
		btnMenu_Option.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panMenu_7.add(btnMenu_Option, BorderLayout.CENTER);
		JPanel panMenu_8 = new JPanel();
		panelMenu.add(panMenu_8);
		panMenu_8.setLayout(new BorderLayout(0, 0));
		
		JButton btnMenu_Exit = new JButton("EXIT");
		btnMenu_Exit.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panMenu_8.add(btnMenu_Exit, BorderLayout.CENTER);

		setSize(dim.width, dim.height);
		setVisible(true);
		
	}
}
