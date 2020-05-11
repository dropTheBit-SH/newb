package TextTool;
//Text Tool예제를 발전시켜서 여러분들이 필요한 기능들을 하나 둘씩 추가하면, 실무에서도 사용하기 편리한 좋은 도구가 될 것 입니다.

//제가 제안하는 몇가지 기능추가사항은 다음과 같습니다.
//먼저 Frame에 option 체크박스를 하나 추가해서 옵션을 체크하고 버튼을 누르면 다른 기능을 하도록 하는 것입니다.
//1. '짝수줄삭제'버튼 - param1에 숫자 n을 입력받아서  n번째 줄을 삭제할 수 있도록 개선
//                              옵션이 체크되어 있으면 n번째 줄만 남기고 모두 삭제
//2. '문자삭제'버튼 -  옵션이 체크되어 있으면, 특정문자만 남기고 삭제
//3. 'substring2'버튼 -옵션이 체크되어 있으면, param1과 param2에 지정된 문자를 제외하고 삭제
//4. 'distinct'버튼 - 옵션이 체크되어 있으면, 내림차순정렬
//5. 'distinct2'버튼 - 옵션이 체크되어 있으면, 내림차순정렬
//6. '클립보드복사'버튼 - TextArea의 내용을 클립보드로 복사하는 기능
//7. 메뉴를 달아서 파일을 열고 저장하는 기능

//[문제11] TextArea의 데이터를 라인별로 읽어서 param1에 입력된 형식에서 데이터를 뽑아내서 보여주는 '패턴제거'버튼을 구현하세요.

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.*; // Pattern, Matcher클래스를 사용하기 위해 추가
import java.text.*;

public class TextToolEx12 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth, pSouth;
	Label lb1, lb2;
	Checkbox option;

	String[] btnName = { "Undo", // 작업이전 상태로 되돌림
			"n번째줄삭제", // 짝수줄을 삭제하는 기능
			"문자삭제", // Param1에 지정된 문자들을 삭제하는 기능
			"trim", // 라인의 앞뒤 공백을 제거
			"빈줄삭제", // 빈 줄 삭제
			"접두사추가", // Param1과 Param2의 문자열을 각 라인의 앞뒤에 붙이는 기능
			"substring", // Param1과 Param2에 지정된 문자열을 각 라인에서 제거하는 기능
			"substring2", // Param1과 Param2에 지정된 문자열로 둘러싸인 부분을 남기고 제거하는 기능
			"distinct", // 중복값제거한 후 정렬해서 보여주기
			"distinct2", // 중복값제거한 후 정렬해서 보여주기 - 중복카운트 포함
			"패턴적용", // 데이터에 지정된 패턴 적용하기
			"패턴제거", // 데이터에 적용된 패턴 제거하기
	};

	Button[] btn = new Button[btnName.length];

	private final String CR_LF = System.getProperty("line.separator"); // 줄바꿈문자

	private String prevText = "";

	private void registerEventHandler() {
		addWindowListener(this);

		int n = 0; // 버튼순서

		btn[n++].addActionListener(new ActionListener() { // Undo - 작업이전 상태로 되돌림
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();

				if (!prevText.equals(""))
					ta.setText(prevText);
				prevText = curText;
			}
		});

		btn[n++].addActionListener(new ActionListener() { // n번째줄삭제 - n번째줄을 삭제하는
															// 기능
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				int n = Integer.parseInt(tfParam1.getText());
				System.out.println(n);
				System.out.println(n == 2);
				prevText = curText;
				Scanner s = new Scanner(curText);

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();
					if (!option.getState()) {
						// param1에 숫자 n을 입력받아서 n번째 줄을 삭제할 수 있도록 개선
						if (i != n - 1)
							sb.append(line).append(CR_LF);
					} else {
						// 옵션이 체크되어 있으면 n번째 줄만 남기고 모두 삭제
						if (i == n - 1)
							sb.append(line).append(CR_LF);
					}
				}
				ta.setText(sb.toString());
				s.close();
			}
		});

		btn[n++].addActionListener(new ActionListener() { // 문자삭제 - Param1에 지정된
															// 문자를 삭제하는 기능
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText = curText;
				String delText = tfParam1.getText();

				if ("".equals(delText))
					return;
				for (int i = 0; i < curText.length(); i++) {
					char ch = curText.charAt(i);
					if (!option.getState()) {
						if (delText.indexOf(ch) == -1)
							sb.append(ch);
						// 옵션이 체크되어 있으면, 특정문자만 남기고 삭제
					} else {
						if (delText.indexOf(ch) != -1)
							sb.append(ch);
					}
				}
				ta.setText(sb.toString());
			}
		});

		btn[n++].addActionListener(new ActionListener() { // trim - 라인의 좌우공백을
															// 제거하는 기능
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText = curText;
				Scanner s = new Scanner(curText);

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine().trim();
					sb.append(line).append(CR_LF);
				}
				ta.setText(sb.toString());
				s.close();
			}
		});

		btn[n++].addActionListener(new ActionListener() { // 빈줄삭제 - 빈 줄 삭제
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText = curText;
				Scanner s = new Scanner(curText);

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();
					if (line.trim().length() > 0)
						sb.append(line).append(CR_LF);
				}

				ta.setText(sb.toString());
				s.close();
			}
		});

		btn[n++].addActionListener(new ActionListener() { // 접두사 - 각 라인에 접두사,
															// 접미사 붙이기
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
				s.close();
			}
		});

		btn[n++].addActionListener(new ActionListener() { // substring - 문자열 자르기
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText = curText;
				int from = tfParam1.getText().length();
				int to = tfParam2.getText().length();
				Scanner s = new Scanner(curText);

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();
					if (line.length() < from + to)
						return;
					sb.append(line.substring(from, line.length() - to)).append(CR_LF);
				}
				ta.setText(sb.toString());
				s.close();
			}
		});

		btn[n++].addActionListener(new ActionListener() { // substring2 - 지정된
															// 문자를 찾아서 그 위치까지
															// 잘라내기
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText = curText;
				String param1 = tfParam1.getText();
				String param2 = tfParam2.getText();
				Scanner s = new Scanner(curText);

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();
					if (!option.getState()) {
						int from = line.indexOf(param1);
						int to = line.lastIndexOf(param2);
						from = (from == -1) ? 0 : from + param1.length();
						to = (to == -1) ? line.length() : to;
						if (from > to)
							return;
						sb.append(line.substring(from, to)).append(CR_LF);
						// 옵션이 체크되어 있으면, param1과 param2에 지정된 문자를 제외하고 삭제
					} else {
						int from1 = line.indexOf(param1);
						int to1 = from1 + param1.length();
						int from2 = line.indexOf(param2);
						int to2 = from2 + param2.length();
						from1 = (from1 == -1) ? 0 : from1;
						from2 = (from2 == -1) ? 0 : from2;
						sb.append(line.substring(from1, to1)).append(line.substring(from2, to2)).append(CR_LF);
					}
				}

				ta.setText(sb.toString());
				s.close();
			}
		});

		btn[n++].addActionListener(new ActionListener() { // distinct - 중복 라인 제거
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

				if (!option.getState()) {
					Collections.sort(list);
					// 4. 'distinct'버튼 - 옵션이 체크되어 있으면, 내림차순정렬
				} else {
					Collections.sort(list);
					Collections.reverse(list);
				}

				int size = list.size();
				for (int i = 0; i < size; i++) {
					sb.append(list.get(i)).append(CR_LF);
				}
				ta.setText(sb.toString());
				s.close();
			}
		});

		btn[n++].addActionListener(new ActionListener() { // distinct2 - 중복 라인 제거 + 카운트
			
			//distinct2'버튼 - 옵션이 체크되어 있으면, 내림차순정렬
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				Scanner s = new Scanner(curText);
				TreeMap map = new TreeMap();

				String delimiter = tfParam1.getText();

				if (delimiter.length() == 0)
					delimiter = ",";

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();

					if (map.containsKey(line)) {
						Integer value = (Integer) map.get(line);
						map.put(line, new Integer(value.intValue() + 1));
					} else {
						map.put(line, new Integer(1));
					}
				}

				Iterator it = map.entrySet().iterator();

				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();

					int value = ((Integer) entry.getValue()).intValue();

					sb.append(entry.getKey());
					sb.append(delimiter);
					sb.append(value);
					sb.append(CR_LF);
				}

				ta.setText(sb.toString());
				s.close();
			}
		});

		btn[n++].addActionListener(new ActionListener() { // 패턴적용
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				String pattern = tfParam1.getText();
				String delimiter = tfParam2.getText();

				if (delimiter.length() == 0)
					delimiter = ",";

				Scanner s = new Scanner(curText);

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();

					String[] tokens = line.split(delimiter);

					sb.append(MessageFormat.format(pattern, tokens));
					sb.append(CR_LF);
				}

				ta.setText(sb.toString());
			}
		});

		btn[n++].addActionListener(new ActionListener() { // 패턴제거
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				String pattern = tfParam1.getText();
				String delimiter = tfParam2.getText();

				Pattern p = Pattern.compile(pattern);

				if (delimiter.length() == 0)
					delimiter = ",";

				// * 1. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
				Scanner s = new Scanner(curText);
				while (s.hasNextLine()) {
					String line = s.nextLine();
					// * 2. 각 라인을 pattern에 맞게 매칭시킨다.(Pattern클래스의 matcher()사용)
					p.matcher(line);
					// * 3. pattern에 매칭되는 데이터를 구분자와 함께 sb에 저장한다.
					sb.append(line).append(CR_LF);
				}
				// * 4. sb의 내용을 TextArea에 보여준다.
				ta.setText(sb.toString());
			}
		});

	} // end of registerEventHandler()

	public static void main(String[] args) {
		TextToolEx12 win = new TextToolEx12("Text Tool");
		win.show();
	}

	public TextToolEx12(String title) {
		super(title);
		option = new Checkbox("Option", false);
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
		pNorth.add(option);
		pNorth.add(lb1);
		pNorth.add(tfParam1);
		pNorth.add(lb2);
		pNorth.add(tfParam2);

		pSouth.setLayout(new GridLayout(2, 10));

		for (int i = 0; i < btn.length; i++) { // 버튼배열을 하단 Panel에 넣는다.
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
