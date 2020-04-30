package ch11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class Exercise11_10_Test {
	
	@Test
	void test01() {
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
		System.out.println("------------------------");
		Set set2 = new HashSet();
		int[][] board2 = new int[5][5];
		for (int i = 0; set2.size() < 25; i++) {
			set2.add((int) (Math.random() * 30) + 1 + "");
		}
		Iterator it2 = set2.iterator();
		for (int i = 0; i < board2.length; i++) {
			for (int j = 0; j < board2[i].length; j++) {
				board2[i][j] = Integer.parseInt((String) it2.next());
				System.out.print((board2[i][j] < 10 ? " " : " ") + board2[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------");
//		assertNotEquals(set, set2);
	}
	@Test
	void test02() {
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
		System.out.println("------------------------");
		Set set2 = new HashSet();
		int[][] board2 = new int[5][5];
		for (int i = 0; set2.size() < 25; i++) {
			set2.add((int) (Math.random() * 30) + 1 + "");
		}
		Iterator it2 = set2.iterator();
		for (int i = 0; i < board2.length; i++) {
			for (int j = 0; j < board2[i].length; j++) {
				board2[i][j] = Integer.parseInt((String) it2.next());
				System.out.print((board2[i][j] < 10 ? " " : " ") + board2[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------");
//		assertNotEquals(set, set2);
	}
	@Test
	void test03() {
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
		System.out.println("------------------------");
		Set set2 = new HashSet();
		int[][] board2 = new int[5][5];
		for (int i = 0; set2.size() < 25; i++) {
			set2.add((int) (Math.random() * 30) + 1 + "");
		}
		Iterator it2 = set2.iterator();
		for (int i = 0; i < board2.length; i++) {
			for (int j = 0; j < board2[i].length; j++) {
				board2[i][j] = Integer.parseInt((String) it2.next());
				System.out.print((board2[i][j] < 10 ? " " : " ") + board2[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------");
//		assertNotEquals(set, set2);
	}
	@Test
	void test04() {
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
		System.out.println("------------------------");
		Set set2 = new HashSet();
		int[][] board2 = new int[5][5];
		for (int i = 0; set2.size() < 25; i++) {
			set2.add((int) (Math.random() * 30) + 1 + "");
		}
		Iterator it2 = set2.iterator();
		for (int i = 0; i < board2.length; i++) {
			for (int j = 0; j < board2[i].length; j++) {
				board2[i][j] = Integer.parseInt((String) it2.next());
				System.out.print((board2[i][j] < 10 ? " " : " ") + board2[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------");
//		assertNotEquals(set, set2);
	}
	@Test
	void test05() {
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
		System.out.println("------------------------");
		Set set2 = new HashSet();
		int[][] board2 = new int[5][5];
		for (int i = 0; set2.size() < 25; i++) {
			set2.add((int) (Math.random() * 30) + 1 + "");
		}
		Iterator it2 = set2.iterator();
		for (int i = 0; i < board2.length; i++) {
			for (int j = 0; j < board2[i].length; j++) {
				board2[i][j] = Integer.parseInt((String) it2.next());
				System.out.print((board2[i][j] < 10 ? " " : " ") + board2[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------");
//		assertNotEquals(set, set2);
	}
	
//	@Test
	void test() {
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
		System.out.println("------------------------");
		Set set2 = new LinkedHashSet();
		int[][] board2 = new int[5][5];
		for (int i = 0; set2.size() < 25; i++) {
			set2.add((int) (Math.random() * 30) + 1 + "");
		}
		Iterator it2 = set2.iterator();
		for (int i = 0; i < board2.length; i++) {
			for (int j = 0; j < board2[i].length; j++) {
				board2[i][j] = Integer.parseInt((String) it2.next());
				System.out.print((board2[i][j] < 10 ? " " : " ") + board2[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------");
		assertNotEquals(set, set2);
	}

//	@Test
	void test2() {
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
		System.out.println("------------------------");
		Set set2 = new HashSet();
		int[][] board2 = new int[5][5];
		for (int i = 0; set2.size() < 25; i++) {
			set2.add((int) (Math.random() * 30) + 1 + "");
		}
		Iterator it2 = set2.iterator();
		for (int i = 0; i < board2.length; i++) {
			for (int j = 0; j < board2[i].length; j++) {
				board2[i][j] = Integer.parseInt((String) it2.next());
				System.out.print((board2[i][j] < 10 ? " " : " ") + board2[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------");
		assertEquals(set, set2);
	}
}
