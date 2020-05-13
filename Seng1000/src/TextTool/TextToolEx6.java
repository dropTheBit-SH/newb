package TextTool;

//[����6] TextArea�� �� ������ �տ��� param1�� �Էµ� ���ڿ���, �ڿ��� param2�� �Էµ� ���ڿ��� ���� �����
//'substring'��ư�� �����ϼ���.

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TextToolEx6 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth, pSouth;
	Label lb1, lb2;

	String[] btnName = { "Undo", // �۾����� ���·� �ǵ���
			"¦���ٻ���", // ¦������ �����ϴ� ���
			"���ڻ���", // Param1�� ������ ���ڵ��� �����ϴ� ���
			"trim", // ������ �յ� ������ ����
			"���ٻ���", // �� �� ����
			"���λ��߰�", // Param1�� Param2�� ���ڿ��� �� ������ �յڿ� ���̴� ���
			"substring", // Param1�� Param2�� ������ ���ڿ��� �� ���ο��� �����ϴ� ���
	};

	Button[] btn = new Button[btnName.length];

	private final String CR_LF = System.getProperty("line.separator"); // �ٹٲ޹���

	private String prevText = "";

	private void registerEventHandler() {
		addWindowListener(this);

		int n = 0; // ��ư����

		btn[n++].addActionListener(new ActionListener() { // Undo - �۾����� ���·� �ǵ���
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();

				if (!prevText.equals("")) {
					ta.setText(prevText);
				}

				prevText = curText;
			}
		});

		btn[n++].addActionListener(new ActionListener() { // ¦���ٻ��� - ¦������ �����ϴ�
															// ���
			public void actionPerformed(ActionEvent ae) {

				/* ���� ���� */
			}
		});

		btn[n++].addActionListener(new ActionListener() { // ���ڻ��� - Param1�� ������
															// ���ڸ� �����ϴ� ���
			public void actionPerformed(ActionEvent ae) {

				/* ���� ���� */
			}
		});

		btn[n++].addActionListener(new ActionListener() { // trim - ������ �¿������
															// �����ϴ� ���
			public void actionPerformed(ActionEvent ae) {
				/* ���� ���� */
			}
		});

		btn[n++].addActionListener(new ActionListener() { // ���ٻ��� - �� �� ����
			public void actionPerformed(ActionEvent ae) {
				/* ���� ���� */
			}
		});

		btn[n++].addActionListener(new ActionListener() { // ���λ� - �� ���ο� ���λ�,
															// ���̻� ���̱�
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				String prefix = tfParam1.getText();
				String postfix = tfParam2.getText();

				Scanner s = new Scanner(curText);

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();

					sb.append(prefix);
					sb.append(line);
					sb.append(postfix);
					sb.append(CR_LF);
				}

				ta.setText(sb.toString());
			}
		});

		btn[n++].addActionListener(new ActionListener() { // substring - ���ڿ� �ڸ���
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				// * 1. param1�� param2�� ���� �����´�.(getText()���)
				String p1 = tfParam1.getText();
				String p2 = tfParam2.getText();
				// * 2. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
				// * (ScannerŬ������ hasNextLine(), nextLine()���)
				Scanner s =  new Scanner(curText);
				String line = null;
				while(s.hasNextLine()){
					line = s.nextLine();
					// * 3. �о�� ������ substring���� �ڸ���. - param1�� param2�� ���뿡 ������� ���̸�ŭ �ڸ���.
					// * (param1�� ���ڿ����̿� param2�� ���ڿ� ���̸� �̿�)
					System.out.println(p1.length());
					//sb.append("aaaaaa"); 11���� p1, ��ü - p1+p2
					System.out.println(line.length()-p2.length());
					sb.append(line.substring(p1.length(), line.length()-p2.length())).append(CR_LF);
				}
				// * 4. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
				ta.setText(sb.toString());

			}
		});

	} // end of registerEventHandler()

	public static void main(String[] args) {
		TextToolEx6 win = new TextToolEx6("Text Tool");
		win.show();
	}

	public TextToolEx6(String title) {
		super(title);
		lb1 = new Label("param1:", Label.RIGHT);
		lb2 = new Label("param2:", Label.RIGHT);
		tfParam1 = new TextField(15);
		tfParam2 = new TextField(15);

		ta = new TextArea();
		pNorth = new Panel();
		pSouth = new Panel();

		for (int i = 0; i < btn.length; i++) {

			btn[i] = new Button(btnName[i]);
		}

		pNorth.setLayout(new FlowLayout());
		pNorth.add(lb1);
		pNorth.add(tfParam1);
		pNorth.add(lb2);
		pNorth.add(tfParam2);

		pSouth.setLayout(new GridLayout(2, 10));

		for (int i = 0; i < btn.length; i++) { // ��ư�迭�� �ϴ� Panel�� �ִ´�.
			pSouth.add(btn[i]);
		}

		add(pNorth, "North");
		add(ta, "Center");
		add(pSouth, "South");

		setBounds(100, 100, 600, 300);
		ta.requestFocus();
		registerEventHandler();
		setVisible(true);
	} // public TextToolEx1(String title) {

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
} // end of class