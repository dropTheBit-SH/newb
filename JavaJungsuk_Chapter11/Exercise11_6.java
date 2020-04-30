package ch11;

//[11-6] ������ �ڵ�� ��������� �������� �л� ���� ���� ���� ���̴�. 
//TreeSet�� �л����� ����� �������� �����ϵ��� compare(Object o1, Object o2)�� 
//��������� ������ �ָ� �ش� ������ ���� �л��� ���� ��ȯ�ϴ� getGroupCount()�� �ϼ��϶�.
//[Hint] TreeSet�� subSet(Object from, Object to)�� ����϶�.

import java.util.*;

class Exercise11_6 {

	//��������� ������ �ָ� �ش� ������ ���� �л��� ���� ��ȯ�ϴ� getGroupCount()�� �ϼ��϶�.
	//[Hint] TreeSet�� subSet(Object from, Object to)�� ����϶�.
	static int getGroupCount(TreeSet tset, int from, int to) {
		
		TreeSet tmpSet = new TreeSet();
		//1. ��������� �����´� 
			//1-1. tset ��ü�� ������
		Iterator it = tset.iterator();
		while (it.hasNext()){
			//1-2. ������ student�� �´��� Ȯ���ϰ� ������ ��ȯ�Ѵ�
			Object tmp = it.next(); 
			if(tmp instanceof Student){
				Student std = (Student) tmp;
			//1-3. student Ŭ������ getAverage()�� ȣ���ؼ� ����� Ȯ���Ѵ�
				float stdAvg = std.getAverage(); 
		//2. ������ �´��� Ȯ���ϰ�, ���� ��ȯ�Ѵ�
				tmpSet.add(stdAvg);
			}
		}
		return tmpSet.subSet((float)from, (float)to).size();
	}

	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() {
			//TreeSet�� �л����� ����� �������� �����ϵ��� compare(Object o1, Object o2)
			public int compare(Object o1, Object o2) {
				//Student�� �´��� Ȯ���ϰ� ��ȯ�ؼ�
				if(o1 instanceof Student && o2 instanceof Student){
					Student s1 = (Student)o1;
					Student s2 = (Student)o2;
					//Student Ŭ������ getAverage()�� Ȱ���Ѵ�
					float t1 = s1.getAverage();
					float t2 = s2.getAverage();
					// ���� ũ�� -1, ���ų� ������ 1 ��ȯ(������ ������..)
					return t1 < t2 ? -1 : 1;
				}
				return -1;
			}
		});
		set.add(new Student("ȫ�浿", 1, 1, 100, 100, 100));
		set.add(new Student("���ü�", 1, 2, 90, 70, 80));
		set.add(new Student("���ڹ�", 1, 3, 80, 80, 90));
		set.add(new Student("���ڹ�", 1, 4, 70, 90, 70));
		set.add(new Student("���ڹ�", 1, 5, 60, 100, 80));
		Iterator it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		
		System.out.println("[60~69] :" + getGroupCount(set, 60, 70));
		System.out.println("[70~79] :" + getGroupCount(set, 70, 80));
		System.out.println("[80~89] :" + getGroupCount(set, 80, 90));
		System.out.println("[90~100] :" + getGroupCount(set, 90, 101));
	}
}