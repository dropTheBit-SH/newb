package crm.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import crm.model.DTO;
import crm.view.View;

public class DAO {
	FileWriter fw;

	private DAO() {
	}
	private static DAO instance;
	public static DAO getInstance() {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}

	public void total() {
		System.out.println("click total btn");
		String tmpStr = null;
		String[] tmpArr;
		Vector<Object> userRow;

		View.dtm.setRowCount(0);
		try {
			BufferedReader br = new BufferedReader(new FileReader("CRM_DB.txt"));
			while (true) {
				tmpStr = br.readLine();
				if (tmpStr == null)
					break;
				System.out.println(tmpStr);

				tmpArr = tmpStr.split(",");

				userRow = new Vector<Object>();
				for (int i = 0; i < tmpArr.length; i++) {
					if (i == 3)
						tmpArr[3] = tmpArr[3].substring(0, tmpArr[3].length() - 1);
					tmpArr[i] = tmpArr[i].substring(tmpArr[i].lastIndexOf("=") + 1);
					userRow.addElement(tmpArr[i]);
				}
				View.dtm.addRow(userRow);
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void add(DTO tmpInfo) {
		System.out.println("click add btn");
		try {
			fw = new FileWriter("CRM_DB.txt", true);
			String info = tmpInfo.toString();
			fw.write(info);
			fw.write("\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		cancel();
	}

	public void delete(String del) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("CRM_DB.txt"));
			fw = new FileWriter("CRM_DB_tmp.txt");
			while (true) {
				String tmpStr = br.readLine();
				if (tmpStr == null)
					break;
				String[] tmpArr = tmpStr.split(",");
				for (int i = 0; i < tmpArr.length; i++) 
					tmpArr[i] = tmpArr[i].substring(tmpArr[i].lastIndexOf("=") + 1);
				if(!(tmpArr[1].equals(del))) {
					fw.append(tmpStr + "\n");
				}
			}
			fw.close();
			br.close();
			
			File CRM_DB = new File("CRM_DB.txt");
			CRM_DB.delete();
			File CRM_DB_tmp = new File("CRM_DB_tmp.txt");
			CRM_DB_tmp.renameTo(CRM_DB);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void search(String srch) {
		System.out.println("click search btn");
		String tmpStr = null;
		String[] tmpArr;
		Vector<Object> userRow;

		try {
			BufferedReader br = new BufferedReader(new FileReader("CRM_DB.txt"));
			while (true) {
				tmpStr = br.readLine();
				if (tmpStr == null)
					break;
				System.out.println(tmpStr);
				tmpArr = tmpStr.split(",");
				for (int i = 0; i < tmpArr.length; i++) {
					if (i == 3)
						tmpArr[3] = tmpArr[3].substring(0, tmpArr[3].length() - 1);
					tmpArr[i] = tmpArr[i].substring(tmpArr[i].lastIndexOf("=") + 1);
				}
				if ((tmpArr[1].equals(srch))) {
					userRow = new Vector<Object>();
					for (int i = 0; i < tmpArr.length; i++)
						userRow.addElement(tmpArr[i]);
					View.dtm.addRow(userRow);
					break;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void cancel() {
		System.out.println("click cancle btn");
	}

}
