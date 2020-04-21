package homework;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BingoTest {
	// 2차원 배열 arr의 빙고 갯수를 세어서 반환. 아래의 메서드를 완성하고 테스트하시오.
	int bingoCheck(int[][] arr) {
		int cnt = 0;
		
		// (가로)같은 배열, 다른 순서 -> 값1 -> 빙고
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(arr[i][j]!=1) break;
				else if(j==arr[i].length-1) cnt++;
			}
		// (세로)다른 배열, 같은 순서 -> 값1 -> 빙고
			for(int j=0; j<arr[i].length; j++){
				if(arr[j][i]!=1) break;
				else if(j==arr[i].length-1) cnt++;
			}
		// (대각선)배열과 순서의 숫자가 같음 -> 값1 -> 빙고
			for(int j=0; j<arr[i].length; j++){
				if(i==j && arr[i][j]!=1) break;
				else if(i==j && i==arr.length-1) cnt++;
			}
		}
		// (역대각선)배열과 순서를 합하여 길이가 됨 -> 값1 -> 빙고
		thisLine : for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(i+j==arr.length-1 && arr[i][j]!=1) break thisLine;
				else if(i+j==arr.length-1 && i==arr.length-1) cnt++;
			}
		}
		return cnt;
	}

	@Test
	public void test5() {
		int[][] arr = { 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 0, 1, 0 }, 
				{ 1, 0, 1, 0, 0 }, 
				{ 1, 1, 0, 1, 0 },
				{ 1, 0, 0, 0, 1 }, };
		assertTrue(bingoCheck(arr) == 4);
	}
	
	@Test
	public void test4() {
		int[][] arr = { 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 0, 0, 0 }, 
				{ 1, 0, 1, 0, 0 }, 
				{ 1, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 1 }, };
		assertTrue(bingoCheck(arr) == 3);
	}

	@Test
	public void test3() {
		int[][] arr = { 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 0 }, 
				{ 1, 0, 0, 0, 0 }, 
				{ 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0 }, };
		assertTrue(bingoCheck(arr) == 2);
	}

	@Test
	public void test2() {
		int[][] arr = { 
				{ 1, 1, 1, 1, 1 }, 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, };
		assertTrue(bingoCheck(arr) == 1);
	}

	@Test
	public void test() {
		int[][] arr = { 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 }, };
		assertTrue(bingoCheck(arr) == 12);
	}
}
