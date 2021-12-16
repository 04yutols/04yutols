package la.bean;

import java.io.Serializable;

public class AdmnBean implements Serializable {
	int admn_id;
	String password;


	public AdmnBean() {

	}

	public AdmnBean(int admn_id, String password) {
		super();
		this.admn_id = admn_id;
		this.password = password;
	}
	public int getAdmn_id() {
		return admn_id;
	}
	public void setAdmn_id(int admn_id) {
		this.admn_id = admn_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
