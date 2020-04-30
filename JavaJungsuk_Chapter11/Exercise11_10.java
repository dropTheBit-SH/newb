package ch11;
//[11-10] 다음 예제의 빙고판은  1~30 사이의 숫자들로 만든 것인데 숫자들의 위치가 잘 섞이지 않는다는 문제가 있다 
//이러한 문제가 발생하는 이유와 이 문제를 개선하기 위한 방법을 설명하고 이를 개선한 새로운 코드를 작성하시오 

/*
 *hashSet은 순서가 유지되지 않고 중복을 허용하지 않는다
 *(해싱알고리즘에 따라 한 숫자가 고정된 위치에 저장된다)
 *중복을 제거하는 동시에 저장한 순서를 유지하기 위해서
 *list인터페이스를 구현한 컬렉션 클래스인 linkedHashSet을 사용해야한다
 */
import java.util.*;

class Exercise11_10 {
	public static void main(String[] args) {
		Set set = new LinkedHashSet();
		int[][] board = new int[5][5];
		for (int i = 0; set.size() < 25; i++) {
			set.add((int) (Math.random() * 30) + 1 + "");
		}
		Iterator it = set.iterator();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String) it.next());
				System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
			}
			System.out.println();
		}
	} // main
	
	void before() {
		Set set = new HashSet();
		int[][] board = new int[5][5];
		for (int i = 0; set.size() < 25; i++) {
			set.add((int) (Math.random() * 30) + 1 + "");
		}
		Iterator it = set.iterator();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String) it.next());
				System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
			}
			System.out.println();
		}
	} // main
}