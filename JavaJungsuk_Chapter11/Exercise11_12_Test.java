package ch11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Exercise11_12_Test {

	@Test
	void test() throws Exception {
		SutdaDeck deck = new SutdaDeck(); // ī�� ���� ������
		deck.shuffle(); // ī�带 ���´�
		Player p1 = new Player("Ÿ¥", deck.pick(), deck.pick()); // �и� �����ش�
		Player p2 = new Player("���", deck.pick(), deck.pick());
		System.out.println(deck.getPoint(p1));
		System.out.println(deck.jokbo.get(p1.c1)+""+deck.jokbo.get(p1.c2));
		assertEquals(deck.getPoint(p1), deck.jokbo.get(p1.c1)+""+deck.jokbo.get(p1.c2));
		assertEquals(deck.getPoint(p2), deck.jokbo.get(p2.c1)+""+deck.jokbo.get(p2.c2));
//		[Ÿ¥]10,4 2020
//		[���]7,4 1008

	}
}
