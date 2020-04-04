package scoremng.model;
//성명 국어 수학 영어 총점 평균 학점 등수
public class Dto {
	public int idx;
	public String name;
	public int subKor;
	public int subEng;
	public int subMath;
	public int sum;
	public double avg;	
	
	public Dto(){}
	public Dto(int idx, String name, int subKor, int subEng, int subMath, int sum, double avg, int rank) {
		this.idx = idx;
		this.name = name;
		this.subKor = subKor;
		this.subEng = subEng;
		this.subMath = subMath;
		this.sum = sum;
		this.avg = avg;
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSubKor() {
		return subKor;
	}
	public void setSubKor(int subKor) {
		this.subKor = subKor;
	}
	public int getSubEng() {
		return subEng;
	}
	public void setSubEng(int subEng) {
		this.subEng = subEng;
	}
	public int getSubMath() {
		return subMath;
	}
	public void setSubMath(int subMath) {
		this.subMath = subMath;
	}
	public int getSum() {
		return subKor+subEng+subMath;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return (subKor+subEng+subMath)/3;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return idx+"번\t"+name+"\t"+subKor+"\t"+subEng+"\t"+subMath+"\t"+sum+"\t"+avg+"\t";
	}

	public String korToString() {
		return idx+"번\t"+name+"\t"+subKor+"\t";
	}
	
	public String engToString() {
		return idx+"번\t"+name+"\t"+subEng+"\t";
	}
	
	public String mathToString() {
		return idx+"번\t"+name+"\t"+subMath+"\t";
	}
	
}
