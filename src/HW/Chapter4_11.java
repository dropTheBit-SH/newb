package book2;

import java.util.*;

abstract class Calc{
	protected int a;
	protected int b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	abstract int calculate();
	
}

class Add extends Calc{
	public int calculate() {
		return a+b;
	}
}
class Sub extends Calc{
	public int calculate() {
		return a-b;
	}
}
class Mul extends Calc{
	public int calculate() {
		return a*b;
	}
}
class Div extends Calc{
	public int calculate() {
		return a/b;
	}
}

public class Chapter4_11 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("두 정수와 연산자를 입력하시오>> ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		Calc calculator = null;
		switch(scan.next()){
		case "+": calculator = new Add(); break;
		case "-": calculator = new Sub(); break;
		case "*": calculator = new Mul(); break;
		case "/": calculator = new Div(); break;
		}
		calculator.setValue(a, b);
		System.out.println(calculator.calculate());
	}
}
