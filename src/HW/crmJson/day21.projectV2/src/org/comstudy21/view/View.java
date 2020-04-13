package org.comstudy21.view;

import javax.swing.JPanel;

import org.comstudy21.resource.R;

public abstract class View extends JPanel implements R {
	public abstract void init(); // 레이아웃 설정
	public abstract void start(); // 이베트 설정
}
