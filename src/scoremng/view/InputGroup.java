package scoremng.view;

import scoremng.model.Dto;

public class InputGroup implements View {

	@Override
	public void display() {
		System.out.println(inputGroupTitle);
		int tmp = 0;
		insert: while(true) {
			System.out.print("입력할 인원 수>> ");
			tmp = scan.nextInt();
			if(tmp> (dao.getMax()-dao.getTop()))
				System.out.printf("※ 남은 공간(%d/%d)\n\n", dao.getTop(), dao.getMax());
			else break insert;
		}
		Dto[] tmpArr = new Dto[tmp];
		data.tmpArr = new Dto[tmp];
		for(int i=0; i<tmp; i++){
			tmpArr[i] = new Dto();
			System.out.print("이름>> ");
			tmpArr[i].setName(scan.next());
			System.out.print("국어 점수>> ");
			tmpArr[i].setSubKor(scan.nextInt());
			System.out.print("영어 점수>> ");
			tmpArr[i].setSubEng(scan.nextInt());
			System.out.print("수학 점수>> ");
			tmpArr[i].setSubMath(scan.nextInt());
			
			tmpArr[i].setSum(tmpArr[i].getSum());
			tmpArr[i].setAvg(tmpArr[i].getAvg());
			data.tmpArr[i] = tmpArr[i];
		}
		System.out.printf("\n▲ %d명의 점수가 입력되었습니다\n",tmp);
		System.out.println(endTitle);
	}
}
