package scoremng.view;

import scoremng.model.Dto;

public class InputOne implements View {

	@Override
	public void display() {
		System.out.println(inputOneTitle);
		Dto dto = new Dto();
		
		System.out.print("이름 >> ");
		dto.setName(scan.next());
		System.out.print("국어 점수>> ");
		dto.setSubKor(scan.nextInt());
		System.out.print("영어 점수>> ");
		dto.setSubEng(scan.nextInt());
		System.out.print("수학 점수>> ");
		dto.setSubMath(scan.nextInt());
		
		dto.setSum(dto.getSum());
		dto.setAvg(dto.getAvg());
		data.dto = dto;
		
		System.out.printf("\n▲ %s의 점수가 입력되었습니다\n",dto.getName());
		System.out.println(endTitle);
	}
}
