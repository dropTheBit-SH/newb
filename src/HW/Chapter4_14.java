package book2;

class Oval implements Shape{
	private int x;
	private int y;
	public Oval(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void draw() {
		System.out.println(x+"x"+y+"에 내접하는 타원입니다.");
	}
	public double getArea() {
		return PI*x*y;
	}
}
class Rect implements Shape{
	private int x;
	private int y;
	public Rect(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void draw() {
		System.out.println(x+"x"+y+"크기의 사각형입니다.");
	}
	public double getArea() {
		return x*y;
	}
}
public class Chapter4_14 {
	public static void main(String[] args) {
		Shape[] list = new Shape[3]; // Shape을 상속받은 클래스 객체의 레퍼런스 배열
		list[0] = new Circle(10); // 반지름이 10인 원 객체
		list[1] = new Oval(20, 30); // 20x30 사각형에 내접하는 타원
		list[2] = new Rect(10, 40); // 10x40 크기의 사각형
		
		for(int i=0; i<list.length; i++) list[i].redraw();
		for(int i=0; i<list.length; i++) System.out.println("면적은 "+ list[i].getArea());
	}
}
