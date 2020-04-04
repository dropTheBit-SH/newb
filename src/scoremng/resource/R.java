package scoremng.resource;

import java.util.Scanner;
import scoremng.model.Dao;
import scoremng.view.*;

public interface R {
	static String appTitle = "■■■■■■■■■■■■■■■■■■■■■■■ 성적관리  프로그램 ■■■■■■■■■■■■■■■■■■■■■■■";
	static String exitTitle = "■■■■■■■■■■■■■■■■■■■■■■■■   종        료    ■■■■■■■■■■■■■■■■■■■■■■■■";
	static String inputOneTitle = "─────────────────────────── 점수입력 ──────────────────────────";
	static String inputGroupTitle = "────────────────────────── 일괄입력 ──────────────────────────";
	static String outputAllTitle = "────────────────────────── 전체출력 ──────────────────────────";
	static String selectSubTitle = "────────────────────────── 부분출력 ──────────────────────────";
	static String selectStuTitle = "────────────────────────── 학생검색 ──────────────────────────";
	static String endTitle = "────────────────────────────────────────────────────────────";
	static String menuTitle = "▶  메뉴";
	static String[] tableBarArr = {"번호","이름","국어","영어","수학","총점","평균","등수"};
	static String[] menuArr = {"","점수입력","일괄입력","전체출력","부분출력","학생검색","종료하기"};
	
	Scanner scan = new Scanner(System.in);
	Data data = new Data();
	Dao dao = Dao.getInstance();
	View[] viewArr = {new Menu(),new InputOne(),new InputGroup(),
			new OutputAll(),new SelectSub(),new SelectStu()};
}
