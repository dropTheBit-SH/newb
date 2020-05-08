package TextTool;

//[����9] TextArea�� ������ ������ �ߺ��� ���� �����ϰ� �����ؼ� �����ִ� 'distinct'��ư�� ����� �߰��ؼ�
//�ߺ��� ������ ���� ���� �����ִ� 'distinct2'��ư�� �����ϼ���.

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TextToolEx9 extends Frame implements WindowListener {
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
			"substring2", // Param1�� Param2�� ������ ���ڿ��� �ѷ����� �κ��� ����� �����ϴ� ���
			"distinct", // �ߺ��������� �� �����ؼ� �����ֱ�
			"distinct2", // �ߺ��������� �� �����ؼ� �����ֱ� - �ߺ�ī��Ʈ ����
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
				/* ���� ���� */

			}
		});

		btn[n++].addActionListener(new ActionListener() { // substring - ���ڿ� �ڸ���
			public void actionPerformed(ActionEvent ae) {
				/* ���� ���� */

			}
		});

		btn[n++].addActionListener(new ActionListener() { // substring2 - ������
															// ���ڸ� ã�Ƽ� �� ��ġ����
															// �߶󳻱�
			public void actionPerformed(ActionEvent ae) {
				/* ���� ���� */

			}
		});

		btn[n++].addActionListener(new ActionListener() { // distinct - �ߺ� ���� ����
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				Scanner s = new Scanner(curText);
				HashSet set = new HashSet();

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();
					set.add(line);
				}

				ArrayList list = new ArrayList(set);
				Collections.sort(list);

				int size = list.size();

				for (int i = 0; i < size; i++) {
					sb.append(list.get(i));
					sb.append(CR_LF);
				}

				ta.setText(sb.toString());
			}
		});

		btn[n++].addActionListener(new ActionListener() { // distinct2 - �ߺ� ����
															// ���� + ī��Ʈ
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				// * 1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �о TreeMap�� ��´�.
				Scanner s = new Scanner(curText);
				TreeMap map = new TreeMap<>();
				String line = null;
				int cnt = 0;
				for (int i = 0; s.hasNextLine(); i++) {
					line = s.nextLine();
					// * 1.1 TreeMap�� ���� ��, �� ������ Ű�� �����ϰ� �����δ� �ߺ�Ƚ���� �����Ѵ�.
					
					// * 1.2 TreeMap�� ���� ��, �̹� ���� ������ ���� ����Ǿ� �ִ��� Ȯ���ϰ�
					// * 1.2.1 �̹� ���� ������ ����Ǿ� ������, �ش� Ű�� ���� �о 1������Ű��
					if (map.containsKey(line)) {
						// �ش� Ű: line
						// ���� �о: �ߺ�Ƚ��
						System.out.println("�ߺ�");
						cnt = (int) map.get(line);
						cnt++;
						map.put(line, cnt);
						// * 1.2.2 ���ο� Ű���̸� 1�� ������ �����Ѵ�.
					} else {
						System.out.println("x");
						map.put(line, 1);
					}

				}
				String sp = null;

				// * 2. param1�� ������ ���ڿ��� ������, �� ���ڿ��� Ű�� ���� �����ڷ� ����ϰ� ������, ','��
				// �����ڷ� �����Ѵ�.
				if (!(tfParam1.getText().equals(""))) {
					sp = tfParam1.getText();
				} else {
					sp = ", ";
				}

				// * 3. Iterator�� �̿��ؼ� TreeMap�� ����� Ű�� ���� �����ڿ� �Բ� sb�� �����Ѵ�.
				// * (TreeMap�� ����߱� ������, �ڵ������� Ű���� �������� �������� ���ĵȴ�.)
				Iterator it = map.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry entry = (Map.Entry)it.next();
					sb.append(entry.getKey()).append(sp).append(entry.getValue()).append(CR_LF);
				}
				// * 4. sb�� ����� ������ TextArea�� �����ش�.
				ta.setText(sb.toString());

			}
		});
	} // end of registerEventHandler()

	public static void main(String[] args) {
		TextToolEx9 win = new TextToolEx9("Text Tool");
		win.show();
	}

	public TextToolEx9(String title) {
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

		for (int i = 0; i < btn.length; i++) {
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
