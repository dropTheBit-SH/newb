package ch15;

//[15-9] ������ �޸��� ���α׷��� �Ϻ��ε�, fileOpen()�� saveAs()�� ���� �����Ǿ�
//���� �ʴ�. �� �� �޼��带 �����Ͽ� ���α׷��� �ϼ��Ͻÿ�.
import java.awt.event.*;
import java.awt.*;
import java.io.*;

class Exercise15_9 extends Frame {
	String fileName;
	TextArea content;
	MenuBar mb;
	Menu mFile;
	MenuItem miNew, miOpen, miSaveAs, miExit;

	Exercise15_9(String title) {
		super(title);
		content = new TextArea();
		add(content);
		mb = new MenuBar();
		mFile = new Menu("File");
		miNew = new MenuItem("New");
		miOpen = new MenuItem("Open");
		miSaveAs = new MenuItem("Save As...");
		miExit = new MenuItem("Exit");
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSaveAs);
		mFile.addSeparator(); // �޴� �и���(separator)�� �ִ´�.
		mFile.add(miExit);
		mb.add(mFile); // MenuBar�� Menu�� �߰��Ѵ�.
		setMenuBar(mb); // Frame�� MenuBar�� ���Խ�Ų��.
// �޴��� �̺�Ʈ �ڵ鷯�� ����Ѵ�.
		MyHandler handler = new MyHandler();
		miNew.addActionListener(handler);
		miOpen.addActionListener(handler);
		miSaveAs.addActionListener(handler);
		miExit.addActionListener(handler);
		setSize(300, 200);
		setVisible(true);
	}

// ���õ� ������ ������ �о TextArea�� �����ִ� �޼���
	void fileOpen(String fileName) {
		//1. BuffredReader�� FileReader�� �̿��ؼ� ������ ������ �д´�. 
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			//2.StringWriter�� ����Ѵ�. 
			StringWriter output = new StringWriter();
			String line = "";
			while((line = br.readLine()) != null) {
				output.write(line);
				output.write('\n');
			}
			//3. StringWriter�� ������ content(TextArea)�� �����ش�.
			content.setText(output.toString());
		} catch (FileNotFoundException e) {
			System.out.println("fileOpen()-FileNotFoundException");
		} catch (IOException e) {
			System.out.println("fileOpen()-IOException");
		}finally {
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	} // fileOpen�޼����� ��
	
// TextArea�� ������ ������ ���Ͽ� �����ϴ� �޼���
	void saveAs(String fileName) {
		//1. BuffredWriter�� FileWriter�� �����Ѵ�. 
		BufferedWriter bw = null;
		try {
			FileWriter fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			//2. content�� �ִ� ������ �����ͼ� BufferedWriter�� ����Ѵ�. 
			bw.write(content.getText());
		} catch (Exception e) {
			System.out.println("fileOpen()-Exception");
			//3. BufferedWriter�� �ݴ´�.
		}finally {
			if(bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	} // saveAs�޼����� ��

	public static void main(String args[]) {
		Exercise15_9 mainWin = new Exercise15_9("Text Editor");
	} // main�޼����� ��
// �޴��� Ŭ������ �� �޴��� ó���ڵ�

	class MyHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("New")) {
				content.setText("");
			} else if (command.equals("Open")) {
				FileDialog fileOpen = new FileDialog(Exercise15_9.this, "���Ͽ���");
				fileOpen.setVisible(true);
				fileName = fileOpen.getDirectory() + fileOpen.getFile();
				System.out.println(fileName);
// ���õ� ������ ������ TextArea�� �����ش�.
				fileOpen(fileName);
			} else if (command.equals("Save As...")) {
				FileDialog fileSave = new FileDialog(Exercise15_9.this, "��������", FileDialog.SAVE);
				fileSave.setVisible(true);
				fileName = fileSave.getDirectory() + fileSave.getFile();
				System.out.println(fileName);
// ���� TextArea�� ������ ���õ� ���Ͽ� �����Ѵ�.
				saveAs(fileName);
			} else if (command.equals("Exit")) {
				System.exit(0); // ���α׷��� �����Ų��.
			}
		}
	} // class MyHandler
} // Exercise15_9Ŭ������ ��