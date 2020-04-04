package scoremng.view;

import scoremng.model.Dto;

public class SelectSub implements View {
	
	@Override
	public void display() {
		System.out.println(selectSubTitle);
		
		if(!check()) return;
		
		System.out.printf("▶ 과목 선택 (1)국어 (2)영어 (3)수학 >> ");
		subject(scan.nextInt());
		System.out.println(endTitle);
	}
	
	public String subject(int sub) {
		Dto[] sortArr = new Dto[data.dtoArr.length];
		
		System.out.printf("\n%s\t%s\t%s\t%s\n", tableBarArr[0],tableBarArr[1],tableBarArr[sub+1],tableBarArr[7]);
		
		sortArr = sort(sub);
		
		for(int i=0; i<data.dtoArr.length; i++) {
			if(sub==1)	System.out.println(sortArr[i].korToString()+(i+1)); 
			else if(sub==2)	System.out.println(sortArr[i].engToString()+(i+1)); 
			else if(sub==3)	System.out.println(sortArr[i].mathToString()+(i+1)); 
		}
		
		String subStr = sub==1? "국어" : sub==2? "영어" : "수학";
		System.out.printf("\n▲ %s 과목 검색이 완료되었습니다\n", subStr); 
		
		return null;
	}
	
	public Dto[] sort(int sub) {
		Dto tmp = new Dto();
		Dto[] sortArr = new Dto[data.dtoArr.length];
		
		for(int i=0; i<data.dtoArr.length; i++){
			sortArr[i] = new Dto();
			sortArr[i].setIdx(data.dtoArr[i].getIdx());
			sortArr[i].setName(data.dtoArr[i].getName());
			sortArr[i].setSubKor(data.dtoArr[i].getSubKor());
			sortArr[i].setSubEng(data.dtoArr[i].getSubEng());
			sortArr[i].setSubMath(data.dtoArr[i].getSubMath());
		}

		for(int i=0; i<sortArr.length; i++) {
			for(int j=i; j<sortArr.length; j++) {
				switch(sub) {
				case 1: 
					if(sortArr[i].getSubKor() < sortArr[j].getSubKor()) {
						tmp = sortArr[i]; sortArr[i] = sortArr[j]; sortArr[j] = tmp;
					}
					break;
				case 2: 
					if(sortArr[i].getSubEng() < sortArr[j].getSubEng()) {
						tmp = sortArr[i]; sortArr[i] = sortArr[j]; sortArr[j] = tmp;
					}
					break;
				case 3: 
					if(sortArr[i].getSubMath() < sortArr[j].getSubMath()) {
						tmp = sortArr[i]; sortArr[i] = sortArr[j]; sortArr[j] = tmp;
					}
					break;
				}
			}	
		}
		return sortArr;
	}
	
}
