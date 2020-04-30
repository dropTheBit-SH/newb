package ch11;

//[11-14] ������ ����ó�� ���α׷��� �Ϻ��̴�. 
//ScannerŬ������ �̿��ؼ� ȭ�����κ��� �����͸� �Է��ϰ� �����ִ� ����� �ϼ��Ͻÿ�.
/*
�׽�Ʈ�� ������
���ڹ�,1,1,10,50,20
���ڹ�,1,2,100,50,30
���ڹ�,1,3,100,50,90
���ڹ�,1,4,80,50,20
���ڹ�,1,5,10,80,40
���ڹ�,3,2,100,50,20
ĥ�ڹ�,3,1,100,100,100
���ڹ�,2,1,10,50,20
���ڹ�,2,2,10,80,20
���ڹ�,2,3,10,50,90

 */
import java.io.*;
import java.util.*;

class Exercise11_14 {
	static ArrayList record = new ArrayList(); // ���������͸� ������ ����
	static Scanner s = new Scanner(System.in);

	public static void main(String args[]) {
		while (true) {
			switch (displayMenu()) {
			case 1:
				inputRecord();
				break;
			case 2:
				displayRecord();
				break;
			case 3:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
		} // while(true)
	}

//(1) menu�� �����ִ� �޼���
	static int displayMenu() {
		System.out.println("**************************************************");
		System.out.println("* ���� ���� ���α׷� *");
		System.out.println("**************************************************");
		System.out.println();
		System.out.println(" 1. �л����� �Է��ϱ� ");
		System.out.println();
		System.out.println(" 2. �л����� ����");
		System.out.println();
		System.out.println(" 3. ���α׷� ���� ");
		System.out.println();
		int menu = 0;
		// 1. ȭ�����κ��� �޴��� �Է¹޴´�. �޴��� ���� 1~3������ ���̾�� �Ѵ�. 
		while (true) {
			try {
				System.out.print("���ϴ� �޴��� �����ϼ���.(1~3) : ");
				menu = Integer.parseInt(s.nextLine().trim());
				// 2. 1~3������ ���� �Է¹��� ������, �޴��� ������ �߸��Ǿ����� �˷��ְ� �ٽ� �Է¹޴´�.
				if(!(menu >= 1 && menu <= 3))
					throw new Exception();
				// (��ȿ�� ���� �Է¹��� ������ �ݺ��ؼ� �Է¹޴´�.)
				else break;
			}catch (Exception e) {
				System.out.printf(" �޴� ������ �߸��Ǿ����ϴ� \n\n");
			}
		}
		return menu;
	} // public static int displayMenu(){
	
//(2) �����͸� �Է¹޴� �޼���
	static void inputRecord() {
		System.out.println("1. �л����� �Է��ϱ�");
		System.out.println("�̸�,��,��ȣ,�����,�����,���м���'�� ������ ������� �Է��ϼ���.");
		System.out.println("�Է��� ��ġ���� q�� �Է��ϼ���. ����ȭ������ ���ư��ϴ�.");
		while (true) {
			System.out.print(">>");
			try {
				String input = s.nextLine().trim();
				//�Է¹��� ���� q �Ǵ� Q�̸� �޼��带 ����
				if(input.equalsIgnoreCase("Q"))
					return;
				//Scanner�� �̿��ؼ� ȭ�����κ��� �����͸� �Է¹޴´�.(','�� �����ڷ�) 
				//�Է¹��� ������ Student�ν��Ͻ��� �����ϰ� record�� �߰��Ѵ�.
				Scanner sc = new Scanner(input).useDelimiter(",");
				Student3 std = new Student3(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
				record.add(std);
			// �Է¹��� �����Ϳ��� ���ܰ� �߻��ϸ�, "�Է¿����Դϴ�."�� �����ְ� �ٽ� �Է¹޴´�. 
			}catch (Exception e) {
				System.out.printf(" �Է¿����Դϴ�.\n\n");
			}
			//q �Ǵ� Q�� �Էµ� ������ 2~3�� �۾��� �ݺ��Ѵ�.
			
		} // end of while
	} // public static void inputRecord() {
	
// ������ ����� �����ִ� �޼���
	static void displayRecord() {
		int koreanTotal = 0;
		int englishTotal = 0;
		int mathTotal = 0;
		int total = 0;
		int length = record.size();
		if (length > 0) {
			calculateSchoolRank(record);
			calculateClassRank(record);
			System.out.println();
			System.out.println("�̸� �� ��ȣ ���� ���� ���� ���� ��� ������� �ݵ��");
			System.out.println("====================================================");
			for (int i = 0; i < length; i++) {
				Student3 student = (Student3) record.get(i);
				System.out.println(student);
				koreanTotal += student.kor;
				mathTotal += student.math;
				englishTotal += student.eng;
				total += student.total;
			}
			System.out.println("====================================================");
			System.out.println("����: " + koreanTotal + " " + englishTotal + " " + mathTotal + " " + total);
			System.out.println();
		} else {
			System.out.println("====================================================");
			System.out.println(" �����Ͱ� �����ϴ�.");
			System.out.println("====================================================");
		}
		
	} // static void displayRecord() {
	public static void calculateClassRank(List list) {
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		// 1. �ݺ����� �̿��ؼ� list�� ����� Student��ü�� �ϳ��� �д´�.
		for(int i=0, j=0; i<length; i++, j++){
			if(list.get(i) instanceof Student3){
				Student3 std = (Student3) list.get(i);
				// 1.1 ���� �޶�����,(ban�� prevBan�� �ٸ���) ���� ���(prevRank)�� ���� ����(prevTotal)�� �ʱ�ȭ�Ѵ�. 
				if(std.ban != prevBan) {
					prevRank = -1;
					prevTotal = -1;
					j = 0;
				}
				// 1.2 ����(total)�� ��������(prevTotal)�� ������ ���� ���(prevRank)�� ���(classRank)�� �Ѵ�. 
				if(std.total == prevTotal) 
					std.classRank = prevRank;
				// 1.3 ������ ���� �ٸ���, ���(classRank)�� ���� �˸°� ����ؼ� �����Ѵ�. 
				// ������ �����ڿ��ٸ�, �� ���� ����� �������� ���� ����ؾ� �Ѵ�. (������ ����) 
				else
					std.classRank = j+1;
				// 1.4 ���� �ݰ� ������ ����� ���� ��(prevBan), ���� ����(prevTotal), ���� ���(prevRank)�� �����Ѵ�.
				prevBan = std.ban;
				prevTotal = std.total;
				prevRank = std.classRank;
			}else {
				System.out.println("����ȯ ����!");
			}
		}
	}

	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // ���� list�� �������� ������������ �����Ѵ�.
		int prevRank = -1; // ���� �������
		int prevTotal = -1; // ���� ����
		int length = list.size();
		//1. �ݺ����� �̿��ؼ� list�� ����� Student��ü�� �ϳ��� �д´�.
		for(int i=0; i<length; i++){
			if(list.get(i) instanceof Student3){
				Student3 std = (Student3) list.get(i);
				//1.1 ����(total)�� ��������(prevTotal)�� ������ ���� ���(prevRank)�� ���(schoolRank)�� �Ѵ�. 
				if(std.total == prevTotal)
					std.schoolRank = prevRank;
				//1.2 ������ ���� �ٸ���, ���(schoolRank)�� ���� �˸°� ����ؼ� �����Ѵ�. 
				//������ �����ڿ��ٸ�, �� ���� ����� �������� ���� ����ؾ� �Ѵ�. (������ ����) 
				else
					std.schoolRank = i+1;
				//1.3 ���� ������ ����� ��������(prevTotal)�� �������(prevRank)�� �����Ѵ�.
				prevRank = std.schoolRank;
				prevTotal = std.total;
			}else {
				System.out.println("����ȯ ����!");
			}
		}
	}
}

