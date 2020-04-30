package ch11;

//[11-11] 다음은 SutdaㅋCard클래스를 HashSet에 저장하고 출력하는 예제이다. 
//HashSet에 중복된 카드가 저장되지 않도록 SutdaCard의 hashCode()를 알맞게 오버라이딩하시오.

/*
 * hashSet의 hashCode()는 주소(클래스이름+메모리주소)이기 때문에 절대 같을 수 없다
 * 값이 같으면 같은 객체로 인식하도록, hashCode를 오버라이딩해줘야 한다
 * 
 * String의 hashCode()는 값(문자열)이라서 내용이 같으면 같은 해쉬코드를 반환한다
 * toString()을 호출한 결과에 hashCode()를 호출함으로서, String클래스의 hashCode()를 호출할 수 있다
 */
import java.util.*;

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public boolean equals(Object obj) {
		if (obj instanceof SutdaCard) {
			SutdaCard c = (SutdaCard) obj;
			return num == c.num && isKwang == c.isKwang;
		} else {
			return false;
		}
	}

	public String toString() {
		return num + (isKwang ? "K" : "");
	}
	
	@Override
		public int hashCode() {
			return toString().hashCode();
		}

}

class Exercise11_11 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		SutdaCard c3 = new SutdaCard(1, true);
		HashSet set = new HashSet();
		set.add(c1);
		set.add(c2);
		set.add(c3);
		System.out.println("두 객체의 값 비교: "+c1.equals(c2));
		System.out.println("두 객체의 해쉬코드 비교: "+c1.hashCode()+"/"+c2.hashCode());
		System.out.println(set);
	}
}