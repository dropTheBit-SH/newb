package scoremng.controller;

import static scoremng.resource.R.*;

public class Controller {
	public static void service(){
		
		viewArr[data.no].display();
		switch(data.no){
		case 1:/*점수입력*/
			viewArr[data.no].display();
			dao.insert(data.dto);
			break;
		case 2:/*일괄입력: 여러 명의 학생 한꺼번에 입력하기*/
			viewArr[data.no].display();
			dao.insertGroup(data.tmpArr);
			break;
		case 3:/*전체출력*/
			data.dtoArr = dao.selectAll();
			viewArr[data.no].display();
			break;
		case 4:/*부분출력: 원하는 과목과 과목별 등수 출력*/
			data.dtoArr = dao.selectAll();
			viewArr[data.no].display();
			break;
		case 5:/*학생검색*/
			data.dtoArr = dao.selectAll();
			viewArr[data.no].display();
			break;
		case 6:/*종료*/
			System.out.println(exitTitle);
			System.exit(0);
		default: 
			System.out.printf("※ 오류!! 번호를 다시 확인하세요!!\n");
		}
		data.no = 0;
		service();
		
	}
}
