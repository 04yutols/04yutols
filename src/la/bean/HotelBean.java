package la.bean;

import java.io.Serializable;

public class HotelBean implements Serializable {

	private int hotel_no;
	private String hotel_name;
	private String address;
	private String tel;
	private int room;
	private String point;
	private String picture_url;
	private int category;
	private int price;

	public HotelBean() {
		super();
	}

	public HotelBean(int hotel_no, String hotel_name, String address, String tel, int room, String point,
			String picture_url, int category,int price) {
		super();
		this.hotel_no = hotel_no;
		this.hotel_name = hotel_name;
		this.address = address;
		this.tel = tel;
		this.room = room;
		this.point = point;
		this.picture_url = picture_url;
		this.category = category;
		this.price = price;
	}
	public HotelBean(String hotel_name, String address, String tel, int room, String point,
			String picture_url, int category,int price) {
		super();
		this.hotel_name = hotel_name;
		this.address = address;
		this.tel = tel;
		this.room = room;
		this.point = point;
		this.picture_url = picture_url;
		this.category = category;
		this.price = price;
	}
	public HotelBean(String hotel_name, String address, String tel, int room, String point,
			String picture_url,int price) {
		super();
		this.hotel_name = hotel_name;
		this.address = address;
		this.tel = tel;
		this.room = room;
		this.point = point;
		this.picture_url = picture_url;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHotel_no() {
		return hotel_no;
	}

	public void setHotel_no(int hotel_no) {
		this.hotel_no = hotel_no;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getPicture_url() {
		return picture_url;
	}

	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
}
