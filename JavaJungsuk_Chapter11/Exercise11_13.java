package ch11;

//[11-13] 다음 코드는 문제11-12를 발전시킨 것으로 각 Player들의 점수를 계산하고, 
//점수가 제일 높은 사람을 출력하는 코드이다. 
//TreeMap의 정렬기준을 점수가 제일 높은 사람부터 내림차순이 되도록 아래의 코드를 완성하시오. 
//단,동점자 처리는 하지 않는다.
import java.util.*;

class Exercise11_13 {
	public static void main(String args[]) throws Exception {
		SutdaDeck deck = new SutdaDeck();
		deck.shuffle();
		Player[] pArr = { 
				new Player("타짜", deck.pick(), deck.pick()), 
				new Player("고수", deck.pick(), deck.pick()),
				new Player("물주", deck.pick(), deck.pick()), 
				new Player("중수", deck.pick(), deck.pick()),
				new Player("하수", deck.pick(), deck.pick()) };
		TreeMap rank = new TreeMap(new Comparator() {
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Player && o2 instanceof Player) {
					Player p1 = (Player) o1;
					Player p2 = (Player) o2;
					return p2.point - p1.point;
				} else {
					System.out.println("오류입니다!");
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
		System.out.println("1위는 " + rank.firstKey() + "입니다.");
	}
}

