package test;

public class Point3D extends Point{
	int z;
	
	public Point3D(){
		this(1, 1, 1); 
	}
	
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	//p1과 p2의 거리를 구한다
	public static double getDistance(Point3D p1, Point3D p2){
		int a = p1.x - p2.x;
		int b = p1.y - p2.y;
		int c = p1.z - p2.z;
		return Math.sqrt(a*a+b*b+c*c);
	}
	
	//p까지의 거리를 구한다
	public double getDistance(Point3D p){
		return getDistance(this, p);
	}
	
	//p와 같은지 확인한다: 타입체크-값체크-결과반환
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point3D){
			if(this.getDistance((Point3D)obj) == 0)
				return true;
			else
				return false;
		}else
			return false;
    }

	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z +"]";
	}
}
