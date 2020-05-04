package ch15;

//[15-8] 다음의 코드는 파일로부터 한 줄 씩 데이터를 읽어서 보여주는 프로그램이다. 
//버튼을 이용해서 첫 줄, 다음 줄, 이전 줄, 마지막 줄로 이동할 수 있으며, 각 줄의 개행문자는 ‘|’를 사용한다. 
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Word extends Frame {
	Button first = new Button("<<");
	Button prev = new Button("<");
	Button next = new Button(">");
	Button last = new Button(">>");
	Panel buttons = new Panel();
	TextArea ta = new TextArea();
	ArrayList wordList = new ArrayList();
	final String WORD_FILE = "word_data.txt";
	final String CR_LF = System.getProperty("line.separator"); // 개행문자
	int pos = 0;

	Word(String title) {
		super(title);
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);
		add("South", buttons);
		add("Center", ta);
		EventHandler handler = new EventHandler();
		addWindowListener(handler);
		first.addActionListener(handler);
		prev.addActionListener(handler);
		next.addActionListener(handler);
		last.addActionListener(handler);
		loadFile(WORD_FILE);
		setBackground(Color.BLACK);
		setSize(300, 200);
		setLocation(200, 200);
		setResizable(true);
		setVisible(true);
		showFirst();
	}

	void showFirst() {
		pos = 0;
		display(pos);
	}

	void showPrevious() {
		pos = (pos > 0) ? --pos : 0;
		display(pos);
	}

	void showNext() {
		int size = wordList.size();
		pos = (pos < size - 1) ? ++pos : size - 1;
		display(pos);
	}

	void showLast() {
		pos = wordList.size() - 1;
		display(pos);
	}

	void display(int pos) { // pos위치에 있는 라인의 내용을 보여준다.
		/*
		 * (1) 아래의 로직에 맞게 코드를 작성하시오. 
		 * 1. wordList에서 pos번째의 위치에 있는 데이터를 읽어온다. 
		 * 2. StringTokenizer를 이용해서 ‘|’를 구분자로 자른다. 
		 * 3. 잘라진 Token에 개행문자(CR_LF)를 붙여서 StringBuffer에 붙인다.(append) 
		 * 4. StringBuffer의 내용을 뽑아서 TextArea에 보여준다.
		 */
		try{
			String line = (String) wordList.get(pos);
			StringTokenizer st = new StringTokenizer(line, "|");
			StringBuffer sb = new StringBuffer(line.length());
			while(st.hasMoreTokens())
				sb.append(st.nextToken()+CR_LF);
			ta.setText(sb.toString());
		}catch (Exception e) {
			System.out.println("예외 발생");
		}
	}
	void loadFile(String fileName) {
		/*
		 * (2) 아래의 로직에 맞게 코드를 작성하시오. 
		 * 1. BuffredReader와 FileReader를 이용해서 파일의 내용을 라인 단위로 읽는다. 
		 * 2. 읽어온 라인을 wordList에 저장한다. 
		 * 3. 만일 예외가 발생하면 프로그램을 종료한다.
		 */
		try(FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr)) {
			String line = "";
			while((line = br.readLine()) != null)
				wordList.add(line);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Word mainWin = new Word("Word Study");
	}

	class EventHandler extends WindowAdapter implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			Button b = (Button) ae.getSource();
			if (b == first) {
				showFirst();
			} else if (b == prev) {
				showPrevious();
			} else if (b == next) {
				showNext();
			} else if (b == last) {
				showLast();
			}
		}

		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	} // class EventHandler
}