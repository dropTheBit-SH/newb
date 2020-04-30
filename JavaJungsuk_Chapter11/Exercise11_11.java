package ch11;

//[11-11] ������ Sutda��CardŬ������ HashSet�� �����ϰ� ����ϴ� �����̴�. 
//HashSet�� �ߺ��� ī�尡 ������� �ʵ��� SutdaCard�� hashCode()�� �˸°� �������̵��Ͻÿ�.

/*
 * hashSet�� hashCode()�� �ּ�(Ŭ�����̸�+�޸��ּ�)�̱� ������ ���� ���� �� ����
 * ���� ������ ���� ��ü�� �ν��ϵ���, hashCode�� �������̵������ �Ѵ�
 * 
 * String�� hashCode()�� ��(���ڿ�)�̶� ������ ������ ���� �ؽ��ڵ带 ��ȯ�Ѵ�
 * toString()�� ȣ���� ����� hashCode()�� ȣ�������μ�, StringŬ������ hashCode()�� ȣ���� �� �ִ�
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
		System.out.println("�� ��ü�� �� ��: "+c1.equals(c2));
		System.out.println("�� ��ü�� �ؽ��ڵ� ��: "+c1.hashCode()+"/"+c2.hashCode());
		System.out.println(set);
	}
}