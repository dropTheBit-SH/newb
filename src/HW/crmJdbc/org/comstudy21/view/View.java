package org.comstudy21.view;

import java.awt.LayoutManager;

import javax.swing.JPanel;

import org.comstudy21.resource.R;

public abstract class View extends JPanel implements R {
	public View() {
		display();
	}
	public abstract void display();
}
