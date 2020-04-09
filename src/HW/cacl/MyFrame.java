package calc;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
	
	public MyFrame() {
		this("AWT 계산기");
	}

	public MyFrame(String title) {
		this(title, 320, 490);
	}

	public MyFrame(String title, int width, int height) {
		super(title);
		setSize(width, height);
		setResizable(false);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = screen.width/2 - this.getWidth()/2;
		int y = screen.height/2 - this.getHeight()/2;
		setLocation(x, y);
	}
}
