package chapter7;

import java.util.Scanner;
import java.util.Vector;

public class C7_10 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Vector<Shape> v = new Vector<Shape>();
		Shape shape = null;
		System.out.println("그래픽 에디터 beauty을 실행합니다.");
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
			switch(scan.nextInt()) {
			case 1:
				System.out.print("Line(1), Rect(2), Circle(3) >> ");
				switch(scan.nextInt()) {
				case 1:	shape = new Line(); break;
				case 2:	shape = new Rect(); break;
				case 3:	shape = new Circle(); break;
				}
				v.add(shape); break;
			case 2:
				System.out.println("삭제할 도형의 위치 >> ");
				int position = scan.nextInt();
				if(!(v.size() == 0 || position > v.size())){
					v.remove(position); break;
				}else{
					System.out.println("삭제 할 수 없습니다."); break;
				}
			case 3:
				for(int i=0; i<v.size(); i++)
					v.get(i).draw();
				break;
			case 4:
				System.out.println("beauty를 종료합니다.");
				System.exit(0);
			}
		}
	}
}
abstract class Shape {
	private Shape next;
	public Shape() { next = null; }
	public void setNext(Shape obj) { next = obj; } 
	public Shape getNext() { return next; }
	public abstract void draw();
}
class Line extends Shape {
	public void draw() {
		System.out.println("Line");
	}
}
class Rect extends Shape {
	public void draw() {
		System.out.println("Rect");
	}
}
class Circle extends Shape {
	public void draw() {
		System.out.println("Circle");
	}
}
