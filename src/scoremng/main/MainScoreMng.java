package scoremng.main;

import scoremng.controller.Controller;
import static scoremng.resource.R.*;

public class MainScoreMng {
	public static void main (String[] args){
		System.out.println(appTitle);
		Controller.service();
	}
}
