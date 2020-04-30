package ch11;

//[11-13] ���� �ڵ�� ����11-12�� ������Ų ������ �� Player���� ������ ����ϰ�, 
//������ ���� ���� ����� ����ϴ� �ڵ��̴�. 
//TreeMap�� ���ı����� ������ ���� ���� ������� ���������� �ǵ��� �Ʒ��� �ڵ带 �ϼ��Ͻÿ�. 
//��,������ ó���� ���� �ʴ´�.
import java.util.*;

class Exercise11_13 {
	public static void main(String args[]) throws Exception {
		SutdaDeck deck = new SutdaDeck();
		deck.shuffle();
		Player[] pArr = { 
				new Player("Ÿ¥", deck.pick(), deck.pick()), 
				new Player("���", deck.pick(), deck.pick()),
				new Player("����", deck.pick(), deck.pick()), 
				new Player("�߼�", deck.pick(), deck.pick()),
				new Player("�ϼ�", deck.pick(), deck.pick()) };
		TreeMap rank = new TreeMap(new Comparator() {
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Player && o2 instanceof Player) {
					Player p1 = (Player) o1;
					Player p2 = (Player) o2;
					return p2.point - p1.point;
				} else {
					System.out.println("�����Դϴ�!");
					return -1;
				}
			}
		});
		for (int i = 0; i < pArr.length; i++) {
			Player p = pArr[i];
			rank.put(p, deck.getPoint(p));
			System.out.println(p + " " + deck.getPoint(p));
		}
		System.out.println();
		System.out.println("1���� " + rank.firstKey() + "�Դϴ�.");
	}
}

