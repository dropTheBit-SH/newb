package Console;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class ConsoleTest {

	@Test
	public void test() {
		String[] data = { "a.class", "baby", "bonus", "c", "cA", "ca", "co", "c.", "c0", "c#", "car", "combat", "count",
				"date", "disc" };
//		String[] pattern = {".*[.].+"};
		String[] pattern = {"[a-zA-Z].*"};
		

		for (int x = 0; x < pattern.length; x++) {
			Pattern p = Pattern.compile(pattern[x]);
			System.out.print("Pattern : " + pattern[x] + "  결과: ");
			for (int i = 0; i < data.length; i++) {
				Matcher m = p.matcher(data[i]);
				if (m.matches())
					System.out.print(data[i] + ",");
			}
			System.out.println();
		}
		
	}

}
