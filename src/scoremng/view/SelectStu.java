package scoremng.view;

public class SelectStu implements View {
	@Override
	public void display() {
		int cnt = 0;
		String gradeKor = "F";
		String gradeEng = "F";
		String gradeMath = "F";
		
		System.out.println(selectStuTitle);

		if(!check()) return;
		
		System.out.printf("▶ 검색할 학생 이름 >> ");
		String tmpStr = scan.next();
		
		for(int i=0; i<data.dtoArr.length; i++) {
			if(data.dtoArr[i].getName().toUpperCase().equals(tmpStr.toUpperCase())) {
				for(int j=0; j<tableBarArr.length-1; j++){
					System.out.printf("%s\t", tableBarArr[j]);
				}
				System.out.println();
				
				System.out.printf(data.dtoArr[i].toString()+"\n\n");
				
				gradeKor = grade(data.dtoArr[i].getSubKor());
				gradeEng = grade(data.dtoArr[i].getSubEng());
				gradeMath = grade(data.dtoArr[i].getSubMath());
			
				System.out.printf("\t\t국어등급\t영어등급\t수학등급\n");
				System.out.printf("\t\t%s\t%s\t%s\n\n", gradeKor, gradeEng, gradeMath);
				cnt++;
			}
		}
		System.out.printf("\n▲ 총 %d건이 검색이 완료되었습니다\n", cnt);
		System.out.println(endTitle);
	}
	
	public String grade(int score) {
		String grade = "F";
		if(score == 100) grade = "A+";
		else if(score >= 90) grade = score%10<3? "A-" : score%10>6? "A+" : "A";
		else if(score >= 80) grade = score%10<3? "B-" : score%10>6? "B+" : "B";
		else if(score >= 70) grade = score%10<3? "C-" : score%10>6? "C+" : "C";
		else if(score >= 60) grade = score%10<3? "D-" : score%10>6? "D+" : "D";
		return grade;
	}
}
