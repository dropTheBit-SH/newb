package ch15;

//[15-7] 다음의 코드는 대화내용을 파일에 저장할 수 있는 채팅 프로그램이다. 
//‘저장’버튼을 누르면 대화내용이 저장되도록 알맞은 코드를 넣어 완성하시오.
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

class ChatWin extends Frame {
	String nickname = "";
	TextArea ta = new TextArea();
	Panel p = new Panel();
	TextField tf = new TextField(30);
	Button bSave = new Button("저장");

	ChatWin(String nickname) {
		super("Chatting");
		this.nickname = nickname;
		setBounds(200, 100, 300, 200);
		p.setLayout(new FlowLayout());
		p.add(tf);
		p.add(bSave);
		add(ta, "Center");
		add(p, "South");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		bSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				FileDialog fileSave = new FileDialog(ChatWin.this, "파일저장", FileDialog.SAVE);
				fileSave.setVisible(true);
				String fileName = fileSave.getDirectory() + fileSave.getFile();
				saveAs(fileName);
			}
		});
		EventHandler handler = new EventHandler();
		ta.addFocusListener(handler);
		tf.addFocusListener(handler);
		tf.addActionListener(handler);
		ta.setText("#" + nickname + "님 즐거운 채팅되세요.");
		ta.setEditable(false);
		setResizable(false);
		setVisible(true);
		tf.requestFocus();
	}

	void saveAs(String fileName) {
		BufferedWriter bw = null;
		try {
			FileWriter fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(ta.getText());
		} catch (IOException e) {
			System.out.println("saveAs()-IOException");
		}finally {
				JOptionPane.showMessageDialog(bSave, "저장 완료");
				try {
					if(bw!=null) bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	} // saveAs메서드의 끝

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java ChatWin NICKNAME");
			System.exit(0);
		}
		new ChatWin(args[0]);
	} // main

	class EventHandler extends FocusAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String msg = tf.getText();
			if ("".equals(msg))
				return;
			ta.append("\r\n" + nickname + ">" + msg);
			tf.setText("");
		}

		public void focusGained(FocusEvent e) {
			tf.requestFocus();
		}
	} // class EventHandler
} // class