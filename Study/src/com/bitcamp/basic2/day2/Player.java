package com.bitcamp.basic2.day2;


public class Player {
	// 각 클래스의 필드: 가지고 있다
	
	int num; // 메서드 밖에 있는 클래스의 필드 / 모든 메서드가 사용 할 수 있다
	private int answer; // capsulizing, 은닉 : 유출방지 및 보안
//	protected int answer; /// 프라이빗 answer 필드 사용 불가, 
						  // 프로텍티드로 가족들끼리  사용
						  // 단 프로텍티드는 침투의 여지가 있기 때문에 권장하지 않는다
	
	//인스턴스 생성 시 호출되는 함수를 생성자라고 부른다
	private int call; // getCallValue를 위한 필드변수
	 
	public int getAnswer() { 
		return answer;
	}
	
	public int setAnswer(int arg) {
		return answer = arg;
	}
	
	
	
	public Player() { // 생성자는 반환형을 적지 않고, 클래스명과 일치시킨다
					  // 필드의 초기화 처리(명확하게 하기 위해서) 
					  // 위에다가 쓰면 인스턴스가 생성될 때? vm에서 읽을 때? 언제 처리가 되는지 불분명하다
		num = 1;
//		this.num = num; // this. (참조변수)  = 현재 객체 = 현재 인스턴스
						// 같은 이름을 구분할 때 사용한다
		call = 0; // call이 0이라면, 첫 시도라는 뜻	(값을 보고 상황을 인지하는 것 필요)
		
		//난수: 3자리 정수, 각 자리에는 다른 값
//		answer = (int) Math.random()*1000; // 대문자로 시작한다
									       // 점을 찍었을 때 나오면 바로 쓸 수 있지만, 안 나오면 따로 생성해줘야 한다
								           // static키워드는 new 생성자 없이(=인스턴스를 생성하지 않아도) 사용 할 수 있다
									       // math.random은 double 값을 갖는다: int로 명시적 형변환 -> double의 소수점 다 버림
									       // 0~1 사이의 값
		answer = genInt(3);
//		this.answer = answer;
	}
	/**
	 * 수정할 일이 있을 때는 원래 있던 코드를 수정하기 보다는
	 * 새로운 메서드를 만들고 작업하는게 낫다
	 * 다른 작업자 내용에 영향을 줄 수 잇기 때문에
	 */

	
	private int genInt(int digits) { //원하는 길이의 정답값 구하기 위하여 digits 넣음
		int number = 0;
		digits = 3;
		boolean[] flag = new boolean[10];
		// true: used, false: unused

		
// 무한루프 발생!!!!!! 		
//		for(int i=0; i<digits; ++i) {
//			int r;
//			do{
//				r = ((int) Math.random()*100) %9 +1; // 0~9: %10은 낮은 자리만 남김 / 1~9: %9+1
//			}while(flag[r] /*사용한 적 있는지 여부*/); // r이 false여야만 안 쓴 번호, r은 1~9까지 
//										// while과 흐름의 차이 염두하여 사용
//									    // do while은 유효성 검사(일단 입력하고 조건 확인)
//			number = number*10 +r; // 1자리 값을 3번 뽑아서 합친다
//			// r 사용했다는 표현
//			flag[r] = true; // r번이 true라는 것은 사용했다는 뜻
//		} 
		
// 무한루프 해결코드!!!!!		
		for(int i=0; i<digits; ++i) {
			int r;
			do{
				r = ((int) (Math.random()*100)) %9 +1; 
				// 단항 연산이 다항연산보다 먼저 실행됨, 형변환은 항상 먼저 실행된다
				// 형변환이 다른 연산자보다 먼저 붙으면 오류가 생기니 주의하도록 한다
				// double인 상태로 우선 늘리고 int형으로 바꿔야..
			}while(flag[r] /*사용한 적 있는지 여부*/); 					
			number = number*10 +r; 
			flag[r] = true; 
		} 
		
		
		
		// 아직까지 미구현된 부분: 중복 제거
		// 1) 이전 값과 비교해서 같은 값인지 판단(i가 0이 아닐 때, 앞의 번호와 값 비교  / number를 활용) - 단 길어진다(r값을 쓰거나 number를 분해하거나)
		// 2) 사용여부를 기록(r변수의 사용여부 표시 / r을 활용) - 단 최대 10자리까지 밖에 만들 수가 없다
		return number;
	}
	
	public int[] response(int value) {
		// 자신의 정답과 전달 받은 값을 비교해서 대답한다
		
		int strike = 0;
		int ball = 0; 
		// 정수를 배열로 변환하자 
		
		//개발시 변환처리 많다 toXXX
		String as = String.valueOf(answer); // valueOf: 정수를 문자열로 바꾼다
		String vs = String.valueOf(value);	
		char[] asArray = as.toCharArray(); // 필요한 결과값을 생각하고 변환할 메서드를 찾았다!
		char[] vsArray = vs.toCharArray();
//		char[] arr = String.valueOf(168).toCharArray(); // 체이닝 방식으로 위의 여러줄을간략하게 표현
		
		System.out.println(asArray.length);
		System.out.println(vsArray.length);
		
		for(int i=0; i<3; ++i) { // 비교
			for(int j=0; j<3; ++j) { // 교차비교
				if(asArray[i] == vsArray[j]) { // 값
					if(i == j) { // 위치
						strike++;
					}else {
						ball++;
					}
				}
			}
		}
		
		
		int[] result = new int[2];
		result[0] = strike;
		result[1] = ball;
		return result;
		
	}
	// 상대 값을 맞추기 위한 계싼
	public int getCallValue() { 
		if( call == 0 ) { // call이 0이다 = 첫시도
			call = genInt(3); // 첫시도에만 임의값 지정
			
		}
		return call;
	}
	
	// 다음에 부를 값을 예측한다
	public void predict(int strike, int ball) {
		// 이전에 부른 값(getCallValue), 대답 전달 값
		// 아이디어를 고민해서 작성하는 전략 부분
		
		if(strike+ball==3) { // 순서만 바꾸면 된다 이전 값을 순서만 순환시킴
			int a = call /100; // 123-> 1xx
			int b = (call /10) %10; // 123-> 12x -> x2x
			int c = call %10 ; // 123-> xx3
			int temp = (b*100)+(c*10)+a;
			call = temp;
		}else {
			call = genInt(3);
		}
		
	}
	
}


/* 심판 main이 1번과 2번의 일을 조절 (controller)
 * 맡겨진 일을 하는 서비스(일을 하는 연결고리)
 * 
 * 룰: 메서드에 대한 룰(반환타입 등)
 */