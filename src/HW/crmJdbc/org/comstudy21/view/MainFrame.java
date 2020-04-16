package org.comstudy21.view;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	JPanel content = null;
	
	public MainFrame() {
		content = (JPanel) getContentPane();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ListView listView = new ListView();
		TitleView titleView = new TitleView();
		ButtonView buttonView = new ButtonView();
		InputView inputView = new InputView();
		
		add(BorderLayout.NORTH, titleView);
		add(listView);
		add(BorderLayout.SOUTH, buttonView);
		add(BorderLayout.WEST, inputView);
		
		setSize(750, 560);
		setVisible(true);
	}
}
