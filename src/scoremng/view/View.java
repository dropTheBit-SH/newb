package scoremng.view;

import scoremng.resource.R;

public interface View extends R {
	void display();
	
	default boolean check() {
		boolean flag = false;
		if(dao.getTop()==0) {
			System.out.println("※ 저장된 값이 없습니다!!");
			System.out.println(endTitle);
			flag = false;
		}else {
			flag = true;
		}
		return flag;
	}
}
