package la.bean;

import java.io.Serializable;

public class PlanBean implements Serializable {
	private int plan_no;
	private String plan_name;
	private String plan_info;
	private int plan_price;

	public PlanBean() {
		super();
	}

	public PlanBean(int plan_no, String plan_name, String plan_info, int plan_price) {
		super();
		this.plan_no = plan_no;
		this.plan_name = plan_name;
		this.plan_info = plan_info;
		this.plan_price = plan_price;
	}

	public int getPlan_no() {
		return plan_no;
	}

	public void setPlan_no(int plan_no) {
		this.plan_no = plan_no;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public String getPlan_info() {
		return plan_info;
	}

	public void setPlan_info(String plan_info) {
		this.plan_info = plan_info;
	}

	public int getPlan_price() {
		return plan_price;
	}

	public void setPlan_price(int plan_price) {
		this.plan_price = plan_price;
	}
}
