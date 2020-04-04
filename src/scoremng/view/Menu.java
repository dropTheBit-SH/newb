package scoremng.view;

public class Menu implements View {
	@Override
	public void display() {
		System.out.println(menuTitle);
		for(int i=1; i<menuArr.length; i++){
			System.out.printf("  %d.%s ", i, menuArr[i]);
		}
		System.out.printf("\n\n메뉴 선택 >> ");
		data.no = scan.nextInt();
		System.out.println();
	}
}
