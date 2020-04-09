package calc;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MainApp extends MyFrame implements ActionListener {
	Panel panel = new Panel();
	Button[] btnArr = new Button[19];
	TextField textField = new TextField();
	Label label = new Label();
	Panel p1 = new Panel();
	String tmp = "";
	double result = 0;
	String[] v;
	Vector<String> operator = new Vector<>();
	Vector<Double> number = new Vector<>();
	boolean flag = false;

	public MainApp() {
		panel.setBackground(new Color(51,51,51));
		panel.setLayout(null);
		this.add(panel);
		
		textField.setBackground(new Color(246,246,246));
		label.setBackground(new Color(246,246,246));

		panel.add(textField);
		textField.setBounds(10, 10, 295, 100);
		textField.setFont(new Font("",Font.BOLD,30));
		
		panel.add(label);
		label.setBounds(10, 120, 295, 30);
		label.setFont(new Font("",Font.PLAIN,15));

		for(int i=0; i<btnArr.length; i++) {
			btnArr[i] = new Button(""+i);
			btnArr[i].setFont(new Font("",Font.PLAIN, 18));
			panel.add(btnArr[i]);
		}
		
		btnArr[1].setLabel("C");
		btnArr[2].setLabel("±");
		btnArr[3].setLabel(".");
		btnArr[4].setLabel("/");
		btnArr[8].setLabel("*");
		btnArr[12].setLabel("-");
		btnArr[16].setLabel("+");
		btnArr[18].setLabel("=");
		btnArr[17].setLabel("0");
		btnArr[13].setLabel("1");
		btnArr[14].setLabel("2");
		btnArr[15].setLabel("3");
		btnArr[9].setLabel("4");
		btnArr[10].setLabel("5");
		btnArr[11].setLabel("6");
		btnArr[5].setLabel("7");
		btnArr[6].setLabel("8");
		btnArr[7].setLabel("9");
		
		int x = 10;
		int y = 160;
		for(int i=1; i<btnArr.length; i++){
			if(i==17 || i==18) {
				btnArr[i].setBounds(x, y, 145, 50);
				x += 75;
			} else {
				btnArr[i].setBounds(x, y, 70, 50);
			}
			x += 75;
			
			if(i%4 == 0 && i!=0 ) {
				x = 10;
				y += 60;
			}
		}
		
		for(int i=1; i<=3; i++)	btnArr[i].setBackground(new Color(255,226,226));
		for(int i=4; i<=16; i+=4) btnArr[i].setBackground(new Color(186,215,223));
		for(int i=5; i<=17 ; i++) {
			if(i%4!=0) btnArr[i].setBackground(new Color(246,246,246));
		}

		play();
	}
	
	private void play() {
		for(int i=0; i<View.btnArr.length; i++)
			btnArr[i].addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof Button) {
			Button btn = (Button) e.getSource();
			String input = btn.getLabel();
			textField.setText(textField.getText()+btn.getLabel());
			
			if(input.equals("C")) {
				reset();
				label.setText(null);
				
			}else if(input.equals("=")) {
				if(flag == true || tmp.equals("")) {
					label.setText("error! reset...");
					reset();
				}else {
					number.add(Double.parseDouble(tmp));
					tmp = "";
					textField.setText(null);
					flag = false;
					calculation();
				}
				
			}else if(input.equals("+")){
				inputOperator("+");
				
			}else if(input.equals("-")){
				inputOperator("-");
				
			}else if(input.equals("*")){
				inputOperator("*");
				
			}else if(input.equals("/")){
				inputOperator("/");
				
			}else {
				if(number.size() == 0) 		label.setText(null);
				tmp += input;
				flag = false;
			}
			
			System.out.println(number);
			System.out.println(operator);
		}
	}
	
	private void inputOperator(String string) {
		if(flag == true || (tmp.equals("") && number.size() == 0) ) {
			label.setText("error! reset...");
			reset();
		}else {
			number.add(Double.parseDouble(tmp));
			tmp = "";
			flag = true;
			operator.add(string);
		}
	}

	private void reset() {
		tmp = "";
		flag = false;
		number.clear();
		operator.clear();
		textField.setText(null);
	}

	private void calculation() {
		while(operator.size() != 0) {
			if(operator.contains("*")) {
				int idx = (operator.indexOf("*"));
				number.add(idx, number.get(idx) * number.get(idx+1));
				number.remove(idx+1); number.remove(idx+1);
				operator.remove(idx);
			
			}else if(operator.contains("/")) {
				int idx = (operator.indexOf("/"));
				number.add(idx, number.get(idx) / number.get(idx+1) );
				number.remove(idx+1); number.remove(idx+1);
				operator.remove(idx);
				
			}else if(operator.contains("+")) {
				int idx = (operator.indexOf("+"));
				number.add(idx, number.get(idx) + number.get(idx+1));
				number.remove(idx+1); number.remove(idx+1);
				operator.remove(idx);
				
			}else if(operator.contains("-")) {
				int idx = (operator.indexOf("-"));
				number.add(idx, number.get(idx) - number.get(idx+1));
				number.remove(idx+1); number.remove(idx+1);
				operator.remove(idx);
			}
		}
		tmp = ""+number.get(0);
		textField.setText(tmp);
		number.clear();
	}

	public static void main(String[] args) {
		new MainApp();
	}
}




