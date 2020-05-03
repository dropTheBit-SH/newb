package ch15;
//[15-5] ������ FilterWriter�� ��ӹ޾Ƽ� ���� ������ HtmlTagFilterWriter�� ����ؼ� 
//�־��� ���Ͽ� �ִ� �±׸� ��� �����ϴ� ���α׷��̴�. 
//HtmlTagFilterWriter�� write()�� �±׸� �����ϵ��� �ڵ带 �ϼ��Ͻÿ�.
import java.io.*;

class Exercise15_5 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("USAGE: java Exercise15_5 TAGET_FILERESULT_FILE");
			System.exit(0);
		}
		String inputFile = args[0];
		String outputFile = args[1];
		try {
			BufferedReader input = new BufferedReader(new FileReader(inputFile));
			HtmlTagFilterWriter output = new HtmlTagFilterWriter(new FileWriter(outputFile));
			int ch = 0;
			while ((ch = input.read()) != -1) {
				output.write(ch);
			}
			input.close();
			output.close();
			System.out.println("�Ϸ�");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
}

class HtmlTagFilterWriter extends FilterWriter {
	StringWriter tmp = new StringWriter();
	boolean inTag = false;
	HtmlTagFilterWriter(Writer out) {
		super(out);
	}
	public void write(int c) throws IOException {
	//1. ����� ����(c)�� '<'�̸� inTag�� ���� true�� �Ѵ�. 
		if(c=='<')
			inTag = true;
	//2. ����� ����(c)�� '>'�̸� inTag�� ���� false�� �Ѵ�. ���ο� StringWriter�� �����Ѵ�.(���� StringWriter�� ������ ������.) 
		else if(c=='>') {
			inTag = false;
			tmp = new StringWriter();
		}
	//3. inTag�� ���� true�̸�, StringWriter�� ����(c)�� ����ϰ� inTag�� ���� false�̸�, out�� ����(c)�� ����Ѵ�. 
	//[����] �±װ� ���۵Ǹ� StringWriter�� ����ϰ� �±װ� ������ StringWriter�� �������.
		if(inTag == true) tmp.write(c);
		else out.write(c);
	}
	public void close() throws IOException {
		out.write(tmp.toString()); // StringWriter�� ������ ����ϰ�
		super.close(); // ������ close()�� ȣ���ؼ� ��� ��Ʈ���� �ݴ´�.
	}
}