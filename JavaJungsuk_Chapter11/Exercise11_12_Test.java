package ch11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Exercise11_12_Test {

	@Test
	void test() throws Exception {
		SutdaDeck deck = new SutdaDeck(); // 카드 덱을 꺼낸다
		deck.shuffle(); // 카드를 섞는다
		Player p1 = new Player("타짜", deck.pick(), deck.pick()); // 패를 보여준다
		Player p2 = new Player("고수", deck.pick(), deck.pick());
		System.out.println(deck.getPoint(p1));
		System.out.println(deck.jokbo.get(p1.c1)+""+deck.jokbo.get(p1.c2));
		assertEquals(deck.getPoint(p1), deck.jokbo.get(p1.c1)+""+deck.jokbo.get(p1.c2));
		assertEquals(deck.getPoint(p2), deck.jokbo.get(p2.c1)+""+deck.jokbo.get(p2.c2));
//		[타짜]10,4 2020
//		[고수]7,4 1008

	}
}
