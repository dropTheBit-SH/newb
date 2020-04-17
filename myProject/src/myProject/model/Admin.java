package myProject.model;

public class Admin {
	String ID = "";
	String PW = "";

	public Admin() {
	}

	public Admin(String iD, String pW) {
		ID = iD;
		PW = pW;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	@Override
	public String toString() {
		return "Admin [ID=" + ID + ", PW=" + PW + "]";
	}

}
