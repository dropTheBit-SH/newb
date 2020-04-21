package test2;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class MyVectorTestJunit {

	@Test
	public void test() {
		Vector v = new Vector<>();
		for(int i=0; i<1000; i++)
			v.add(""+i);
		assertTrue(v.size()==1000); //괄호 안이 참이면 테스트 통과
	}
	
	//테스트 케이스별로 여러개를 만들어서 시행 가능
	@Test
	public void test2() {
		Vector v = new Vector<>();
		for(int i=0; i<1000; i++)
			v.add(""+i);
		assertTrue(v.size()==1000); //괄호 안이 참이면 테스트 통과
	}
}
