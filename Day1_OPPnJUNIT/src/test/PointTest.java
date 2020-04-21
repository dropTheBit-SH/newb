package test;

public class PointTest {
	public static void main(String[] args) {
		
		Point t1 = new Point(3, 5);
		System.out.println("t1: "+t1);
		Point t2 = new Point();
		System.out.println("t2: "+t2);
		
		System.out.println();
		
		System.out.println("t1과 t2의 거리: "+Point.getDistance(t1, t2));
		System.out.println("t1로부터 t2까지 거리: "+t2.getDistance(t1));
		System.out.println("t1을 t2와 비교: "+t1.equals(t2));
		System.out.println("t1을 t1과 비교: "+t1.equals(t1));

		System.out.println("---------------------------------");
		
		Point3D t3 = new Point3D(1, 2, 3);
		System.out.println("t3: "+t3);
		Point3D t4 = new Point3D();
		System.out.println("t4: "+t4);
		
		System.out.println();
		
		System.out.println("t3와 t4의 거리: "+Point3D.getDistance(t3, t4));
		System.out.println("t3로부터 t4까지 거리: "+t3.getDistance(t4));
		System.out.println("t3을 t4와 비교: "+t3.equals(t4));
		System.out.println("t3을 t3와 비교: "+t3.equals(t3));
	}
}
