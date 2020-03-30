package book2;

class Point3D extends Point{
	private int z;
	public Point3D(){
		super(0, 0);
		this.z = 0;
	}
	public Point3D(int x, int y, int z){
		super(x,y);
		this.z = z;
	}
	public void setZ(int z){
		this.z = z;
	}
	public void moveUp(){
		z++;
	}
	public void moveDown(){
		 z--;
	}
	public void move(int x, int y){
		super.move(x, y);
	}
	public void move(int x, int y, int z){
		super.move(x, y);
		this.z = z;
	}
	public String toString(){
		return "("+x+","+y+","+z+")";
	}

}
public class Chapter4_7 {
	public static void main(String[] args) {
		Point3D p = new Point3D(1,2,3);
		System.out.println(p.toString()+"입니다.");
		
		p.moveUp();
		System.out.println(p.toString()+"입니다.");
		
		p.moveDown();
		p.move(10, 10);
		System.out.println(p.toString()+"입니다.");
		
		p.move(100, 200, 300);
		System.out.println(p.toString()+"입니다.");
	}
}
