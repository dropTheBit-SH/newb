package org.comstudy21.resource;

import java.util.Scanner;

import org.comstudy21.controller.PhonebookController;
import org.comstudy21.model.Dao;
import org.comstudy21.view.Delete;
import org.comstudy21.view.Input;
import org.comstudy21.view.Menu;
import org.comstudy21.view.Modify;
import org.comstudy21.view.Output;
import org.comstudy21.view.Search;

public interface R {
	String appName = "Phone Book";
	
	PhonebookController controller = new PhonebookController();
	
	int MAX = 100;
	
	Input input = new Input();
	Output output = new Output();
	Menu menu = new Menu();
	Search search = new Search();
	Modify modify = new Modify();
	Delete delete = new Delete();
	
	//Dao dao = new Dao();
	// 싱글톤 객체를 참조한다.
	Dao dao = Dao.getInstance();
	
	Scanner scan = new Scanner(System.in);
	
	// 나중에 컬렉션 객체로 변경 될 수 있다.
	Data data = new Data();
}
