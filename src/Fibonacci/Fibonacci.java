package day04;

//피보나치 수열
// 이전항 현재항 더해서 다음항,다음항이 다시 현재항
public class Fibonacci {

	static String result1 = "", result2 = "";
	static int pre = 0, cur = 1, next = 1;
	static int end = 8, total1 = 0, total2 = 0;

	public static void main(String[] args) {

    //     test1();
           test2();
    //     System.out.println("1번: " + result1);
           System.out.println("2번: " + result2);
	}

	static String test1() { // 1+1+2+3+5+8+13+21=54
		for (int i = 1; i <= end; i++) {
			cur = next;
			next = pre + next;
			pre = cur;

			total1 += cur;
			result1 += cur + ((i < end) ? "+" : "=");
		}
		result1 += total1;
		return result1;

	}

	static String test2() { // 1+1-2+3-5+8-13+21=14
		for (int i = 1; i <= end; i++) {
			cur = next;
			next = pre + next;
			pre = cur;

			total2 = (i == 1)? total2 + cur : (i % 2 != 1) ? total2 + cur : total2 - cur;
			result2 += cur + ((i == end) ? "=" : (i % 2 == 1) ? "+" : "-");
		}

		result2 += total2;
		return result2;
	}
}
