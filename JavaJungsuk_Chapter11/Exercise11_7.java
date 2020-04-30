package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

//[11-7] ������ ���õ� BanNoAscendingŬ������ �ϼ��Ͽ�, 
//ArrayList�� ��� Student�� ���Ͻ����� ��(ban)�� ��ȣ(no)�� �������� ���ĵǰ� �Ͻÿ�.
//(���� ���� ��� ��ȣ�� ���ؼ� �����Ѵ�.)

class BanNoAscending implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student && o2 instanceof Student){
			Student s1 = (Student)o1;
			Student s2 = (Student)o2;
			if(s1.ban == s2.ban){
				return s1.no < s2.no ? -1 : s1.no > s2.no ? 1 : 0;
			}else{
				return s1.ban < s2.ban ? -1 : s1.ban > s2.ban ? 1 : 0;
			}
		}
		return 0;
	}
}

class Exercise11_7 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("���ڹ�", 2, 1, 70, 90, 70));
		list.add(new Student("���ڹ�", 2, 2, 60, 100, 80));
		list.add(new Student("ȫ�浿", 1, 3, 100, 100, 100));
		list.add(new Student("���ü�", 1, 1, 90, 70, 80));
		list.add(new Student("���ڹ�", 1, 2, 80, 80, 90));
		Collections.sort(list, new BanNoAscending());
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}