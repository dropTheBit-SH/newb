package com.bit.demo.carpark;

import com.bit.demo.carpark.model.Car;

public class ParkService {
	// Space 안에 Car 들이 여러 개 저장되어 있다....
	private Space cardao;//Data Access Object
	private int nums;	// 현재 주차 대수
	
	public ParkService() {
		cardao = new Space(20);// 최대 주차 대수
		/*
		 * 배열 처리 시 길이
		 * 	최대 길이 : 요소 번호
		 * 	현재 길이 : 직접 처리해야 한다... 변수 만들어 관리한다...
		 */
	}
	public Car getCar(String carno) {
		// TODO Auto-generated method stub
		return cardao.selectByNo(carno);
	}

	public double getPrice(Car car) {
		// TODO Auto-generated method stub
		// 11:00 ~ 10:00
		int inMint = car.getIntime()%100;
		inMint += car.getIntime()/100*60;

		int outMint = car.getOuttime()%100;
		outMint += car.getOuttime()/100*60;
		
		int diff = (outMint - inMint) / 10; 
		return 5000+(diff*500);
	}
	// 어떤 행동, 처리를 만든다..... 메서드를 만든다...
	
	public boolean comeIn(Car car) {
		// 저장하기 - Space.Car[]
		// ++
		return cardao.save(car);// 반환 처리 : 일의 결과 확인
	}
	
	public boolean outCome(Car car) {
		int idx = cardao.indexOfNo(car.getNo());
		cardao.clean(idx);
//		cardao.clean(car.getNo());
		// 여러 개의 함수를 만들 수 있다.
		//	--
		return true;
	}


}
