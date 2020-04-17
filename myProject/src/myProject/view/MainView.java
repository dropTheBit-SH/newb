package myProject.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class MainView extends View{
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private JTable table;
	
	public MainView() {
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 122, 1920, 958);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panelList = new JPanel();
		panelList.setBounds(0, 118, 653, 962);
		panel.add(panelList);
		panelList.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelList.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(653, 118, 1267, 962);
		panel.add(panelBtn);
		panelBtn.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelBtnN = new JPanel();
		panelBtn.add(panelBtnN);
		panelBtnN.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panelBtnN.add(tabbedPane);
		
		JPanel panelTab = new JPanel();
		tabbedPane.addTab("New tab", null, panelTab, null);
		panelTab.setLayout(new GridLayout(3, 5, 0, 0));
		
		JButton btnMenu1_1 = new JButton("New button");
		panelTab.add(btnMenu1_1);
		JButton btnMenu1_2 = new JButton("New button");
		panelTab.add(btnMenu1_2);
		JButton btnMenu1_3 = new JButton("New button");
		panelTab.add(btnMenu1_3);
		JButton btnMenu1_4 = new JButton("New button");
		panelTab.add(btnMenu1_4);
		JButton btnMenu1_5 = new JButton("New button");
		panelTab.add(btnMenu1_5);
		JButton btnMenu1_6 = new JButton("New button");
		panelTab.add(btnMenu1_6);
		JButton btnMenu1_7 = new JButton("New button");
		panelTab.add(btnMenu1_7);
		JButton btnMenu1_8 = new JButton("New button");
		panelTab.add(btnMenu1_8);
		JButton btnMenu1_9 = new JButton("New button");
		panelTab.add(btnMenu1_9);
		JButton btnMenu1_10 = new JButton("New button");
		panelTab.add(btnMenu1_10);
		JButton btnMenu1_11 = new JButton("New button");
		panelTab.add(btnMenu1_11);
		JButton btnMenu1_12 = new JButton("New button");
		panelTab.add(btnMenu1_12);
		JButton btnMenu1_13 = new JButton("New button");
		panelTab.add(btnMenu1_13);
		JButton btnMenu1_14 = new JButton("New button");
		panelTab.add(btnMenu1_14);
		JButton btnMenu1_15 = new JButton("New button");
		panelTab.add(btnMenu1_15);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panelBtnS = new JPanel();
		panelBtn.add(panelBtnS);
		panelBtnS.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel numkey = new JPanel();
		panelBtnS.add(numkey);
		numkey.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton btnNumkey_7 = new JButton("7");
		btnNumkey_7.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_7);
		
		JButton btnNumkey_8 = new JButton("8");
		btnNumkey_8.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_8);
		
		JButton btnNumkey_9 = new JButton("9");
		btnNumkey_9.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_9);
		
		JButton btnNumkey_4 = new JButton("4");
		btnNumkey_4.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_4);
		
		JButton btnNumkey_5 = new JButton("5");
		btnNumkey_5.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_5);
		
		JButton btnNumkey_6 = new JButton("6");
		btnNumkey_6.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_6);
		
		JButton btnNumkey_1 = new JButton("1");
		btnNumkey_1.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_1);
		
		JButton btnNumkey_2 = new JButton("2");
		btnNumkey_2.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_2);
		
		JButton btnNumkey_3 = new JButton("3");
		btnNumkey_3.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_3);
		
		JButton btnNumkey_min = new JButton("-");
		btnNumkey_min.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_min);
		
		JButton btnNumkey_0 = new JButton("0");
		btnNumkey_0.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_0);
		
		JButton btnNumkey_plu = new JButton("+");
		btnNumkey_plu.setFont(new Font("Arial Black", Font.PLAIN, 25));
		numkey.add(btnNumkey_plu);
		
		JPanel payment = new JPanel();
		panelBtnS.add(payment);
		payment.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnNewButton_2 = new JButton("coupon");
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 25));
		payment.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("giftcard");
		btnNewButton_3.setFont(new Font("Arial Black", Font.PLAIN, 25));
		payment.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("cash");
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 25));
		payment.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("card");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 25));
		payment.add(btnNewButton);
		

	
	}

}
