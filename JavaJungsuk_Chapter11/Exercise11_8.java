package chapter11;

//[11-8] ����11-7�� StudentŬ������ ����(total)�� �������(schoolRank)�� �����ϱ� ���� �ν��Ͻ������� �߰��Ͽ���. 
//StudentŬ������ �⺻������ �̸�(name)�� �ƴ� ���� (total)�� �������� �� ������������ ������ ����, 
//������ �������� �� �л��� ��������� ����ϰ� ��������� �������� �������� �����Ͽ� ����Ͻÿ�.
import java.util.*;
import java.util.concurrent.SynchronousQueue;

class Student2 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // ����
	int schoolRank; // �������
	
	Student2(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public int compareTo(Object o) {
		if (o instanceof Student2) {
			Student2 tmp = (Student2) o;
			return getTotal() > tmp.getTotal() ? -1 : getTotal() == tmp.getTotal() ? 0 : 1;
		} else {
			return -1;
		}
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," 
				+ getTotal() + "," + getAverage() + "," + schoolRank // �����߰�
		;
	}
} // class Student

class Exercise11_8 {
//������ �������� �� �л��� ��������� ����ϰ� ��������� �������� �������� �����Ͽ� ����Ͻÿ�.
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // ���� list�� �������� ������������ �����Ѵ�.
		int prevRank = -1; // ���� �������
		int prevTotal = -1; // ���� ����
		int length = list.size();
		boolean flag = false;
		
		//1. �ݺ����� �̿��ؼ� list�� ����� Student��ü�� �ϳ��� �д´�.
		for(int i=0; i<length; i++){
			if(list.get(i) instanceof Student2){
				Student2 tmp = (Student2) list.get(i);
				//1.1 1���� ���Ѵ�
				if(prevTotal == -1){
					tmp.schoolRank = 1;
				}else{
					//1.1 ����(total)�� ��������(prevTotal)�� ������ ���� ���(prevRank)�� ���(schoolRank)�� �Ѵ�. 
					if(tmp.getTotal() == prevTotal){
						tmp.schoolRank = prevRank;
						flag = true;
					//1.2 ������ ���� �ٸ���, ���(schoolRank)�� ���� �˸°� ����ؼ� �����Ѵ�. 
					//������ �����ڿ��ٸ�, �� ���� ����� �������� ���� ����ؾ� �Ѵ�. (������ ����) 
					}else{
						tmp.schoolRank = ++prevRank;
					}
				}
				//1.3 ���� ������ ����� ��������(prevTotal)�� �������(prevRank)�� �����Ѵ�.
				prevRank = tmp.schoolRank;
				prevTotal = tmp.total;
				if(flag){
					prevRank++;
					flag = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student2("���ڹ�", 2, 1, 70, 90, 70));
		list.add(new Student2("���ڹ�", 2, 2, 60, 100, 80));
		list.add(new Student2("ȫ�浿", 1, 3, 100, 100, 100));
		list.add(new Student2("���ü�", 1, 1, 90, 70, 80));
		list.add(new Student2("���ڹ�", 1, 2, 80, 80, 90));
		calculateSchoolRank(list);
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}