package book2;

class ColorPoint2 extends Point{
	private String color;
	public ColorPoint2(){
		super(0,0);
		this.color = "BLACK";
	}
	public ColorPoint2(int x, int y){
		super(x, y);
		this.color = "BLACK";
	}
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setColor(String color){
		this.color = color;
	}
	
	public String getXY(){
		return "("+x+","+y+")의 점";
	}
	public String getColor(){
		return color+"색의 ";
	}
	@Override
	public String toString() {
		return getColor()+getXY();
	}
}


public class Chapter4_6 {
	public static void main(String[] args) {
		ColorPoint2 zeroPoint = new ColorPoint2(); // (0,0) 위치의 BLACK 색 점
		System.out.println(zeroPoint.toString()+"입니다.");
		
		ColorPoint2 cp = new ColorPoint2(10, 10);
		cp.setXY(5, 5);
		cp.setColor("RED");
		System.out.println(cp.toString()+"입니다.");
	}
	
}
