package la.bean;

import java.io.Serializable;

public class RsvBean implements Serializable {

	int rsv_no;
	String date;
	String hotel_name;
	int rsv_num;
	int user_id;
	int sum_price;
	String plan_name;
	int plan_no;
	int stay;



	public String getPlan_name() {
		return plan_name;
	}


	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}


	public int getPlan_no() {
		return plan_no;
	}


	public void setPlan_no(int plan_no) {
		this.plan_no = plan_no;
	}


	public RsvBean() {

	}


	public RsvBean(int rsv_no, String date, String hotel_name, int rsv_num, int user_id, int sum_price,int stay) {
		super();
		this.rsv_no = rsv_no;
		this.date = date;
		this.hotel_name = hotel_name;
		this.rsv_num = rsv_num;
		this.user_id = user_id;
		this.sum_price = sum_price;
		this.stay = stay;

	}
	public RsvBean(int rsv_no2, String date2, String hotel_name2, int rsv_num2, int id, int priceSum,
			String plan_name,int stay) {
		super();
		this.rsv_no = rsv_no2;
		this.date = date2;
		this.hotel_name = hotel_name2;
		this.rsv_num = rsv_num2;
		this.user_id = id;
		this.sum_price = priceSum;
		this.plan_name = plan_name;
		this.stay = stay;

	}


	public int getStay() {
		return stay;
	}


	public void setStay(int stay) {
		this.stay = stay;
	}


	public int getRsv_no() {
		return rsv_no;
	}
	public void setRsv_no(int rsv_no) {
		this.rsv_no = rsv_no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public int getRsv_num() {
		return rsv_num;
	}
	public void setRsv_num(int rsv_num) {
		this.rsv_num = rsv_num;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getSum_price() {
		return sum_price;
	}


	public void setSum_price(int sum_price) {
		this.sum_price = sum_price;
	}
}


