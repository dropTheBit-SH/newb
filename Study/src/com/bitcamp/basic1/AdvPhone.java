package com.bit;

public class AdvPhone extends Phone{ // Phone 클래스의 상속: 기존 소스에 메서드 추가 등 확장 
	
//	private String number;    // 어차피 보이지 않기 때문에 이름이 같아도 괜찮다
	public void setNumber(String number){
		this.number = number; // (private String number;없을 때) 상속이어도 다 받을 수는 없고 private은 사용 할 수 없다 
							  // 단, 따로 인터셉트를 하지 않는 이상!
							  // protected은 상속 가능
	}
		@Override 
		public void rcv() {	// 부모껄 버리고 다시 만들 때(업그레이드된 같은 기능)
							// 호출하는 방법은 그대로, 실행하는 결과만 다르게
			System.out.println(number+"...");
			System.out.println("전화받기.....");
			
			
		
	}
	
}
