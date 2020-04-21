 package test;

public class Point {
	int x;
	int y;
	
	public Point(){
		this(1, 1);
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//p1과 p2의 거리를 구한다
	public static double getDistance(Point p1, Point p2){
		int a = p1.x - p2.x;
		int b = p1.y - p2.y;
		return Math.sqrt(a*a+b*b);
	}
	
	//p까지의 거리를 구한다
	public double getDistance(Point p){
		return getDistance(this, p);
	}
	
	//p와 같은지 확인한다: 타입체크-값체크-결과반환
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point){
			if(this.getDistance((Point)obj) == 0)
				return true;
			else
				return false;
		}else
			return false;
    }
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
