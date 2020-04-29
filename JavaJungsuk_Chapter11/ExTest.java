package chapter11;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class ExTest {

	// ��������� ������ �ָ� �ش� ������ ���� �л��� ���� ��ȯ�ϴ� getGroupCount()�� �ϼ��϶�.
	// [Hint] TreeSet�� subSet(Object from, Object to)�� ����϶�.
	static int getGroupCount(TreeSet tset, int from, int to) {

		TreeSet tmpSet = new TreeSet();
		// 1. ��������� �����´�
		// 1-1. tset ��ü�� ������
		Iterator it = tset.iterator();
		while (it.hasNext()) {
			// 1-2. ������ student�� �´��� Ȯ���ϰ� ������ ��ȯ�Ѵ�
			Object tmp = it.next();
			if (tmp instanceof Student) {
				Student std = (Student) tmp;
				// 1-3. student Ŭ������ getAverage()�� ȣ���ؼ� ����� Ȯ���Ѵ�
				float stdAvg = std.getAverage();
				// 2. ������ �´��� Ȯ���ϰ�, ���� ��ȯ�Ѵ�
				tmpSet.add(stdAvg);
			}
		}
		return tmpSet.subSet((float) from, (float) to).size();
	}

	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() {
			// TreeSet�� �л����� ����� �������� �����ϵ��� compare(Object o1, Object o2)
			public int compare(Object o1, Object o2) {
				// Student�� �´��� Ȯ���ϰ� ��ȯ�ؼ�
				if (o1 instanceof Student && o2 instanceof Student) {
					Student s1 = (Student) o1;
					Student s2 = (Student) o2;
					// Student Ŭ������ getAverage()�� Ȱ���Ѵ�
					float t1 = s1.getAverage();
					float t2 = s2.getAverage();
					// ���� ũ�� -1, ���ų� ������ 1 ��ȯ(������ ������..)
					return t1 < t2 ? -1 : 1;
				}
				return -1;
			}
		});
	}

	@Test
	public void test1() {
		TreeSet set = new TreeSet();
		set.add(new Student("ȫ�浿", 1, 1, 100, 100, 100));
		assertTrue(getGroupCount(set, 90, 101) == 1);
	}
}
