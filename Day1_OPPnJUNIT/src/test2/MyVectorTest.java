package test2;

import java.util.Vector;

public class MyVectorTest {
	public static void main(String[] args) {
		MyVector test = new MyVector();
		Vector v = new Vector<>();
		
//		for(int i=0; i<100; i++){
//			test.add(i);
//		}
		System.out.println("test: "+test.toString());
		
		System.out.println("=============================");
		System.out.println("용량: "+test.capacity()+" / 저장된 객체: "+test.size()+" / 비었는지: "+test.isEmpty());
		
		test.add(123);
		test.add(456);		
		System.out.println("용량: "+test.capacity()+" / 저장된 객체: "+test.size()+" / 비었는지: "+test.isEmpty());
		
		System.out.println("첫번째로 저장된 객체 반환: "+test.get(1));
			
		System.out.println("test: "+test.toString());
		
		System.out.println("456이 저장되어 있는 위치: arr["+test.indexOf(456)+"]에 있음");
		
		System.out.println("456이 삭제되었는지: "+test.remove(456));
		System.out.println("test: "+test.toString());

		test.add(5, "test");
		System.out.println("5번째에 test 추가: "+test.toString());
		
		test.setSize(10);
		System.out.println("용량을 10으로 변경:"+test.capacity());
		
		test.clear();
		System.out.println("test: "+test.toString());
		
		test.add(123);
		test.add(456);		
		test.trimToSize();
		System.out.println("객체에 맞게 조정한뒤 용량: "+test.capacity());
		System.out.println("test: "+test.toString());
	}
}
