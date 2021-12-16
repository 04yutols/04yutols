package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.HotelBean;

public class HotelDAO {
	private Connection con;

	public HotelDAO() throws DAOException{
		getConnection();
	}
	public List<HotelBean>findAllHotel() throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM hotel";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			List<HotelBean> list = new ArrayList<HotelBean>();

			while(rs.next()) {
				int hotel_no = rs.getInt("hotel_no");
				String hotel_name = rs.getString("hotel_name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				int room = rs.getInt("room");
				String point = rs.getString("point");
				String picture_url = rs.getString("picture_url");
				int category = rs.getInt("category_no");
				int price = rs.getInt("price");
				HotelBean bean = new HotelBean(hotel_no,hotel_name,address,tel,room, point,picture_url,category,price);
				list.add(bean);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (st !=null) {
					st.close();
				}

				if (rs !=null) {
					rs.close();
				}
				close();

			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}
	public List<HotelBean>findHotelByHotelNo(int hotelNo) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM hotel WHERE hotel_no = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, hotelNo);

			rs = st.executeQuery();


			List<HotelBean> list = new ArrayList<HotelBean>();

			while(rs.next()) {
				int hotel_no = rs.getInt("hotel_no");
				String hotel_name = rs.getString("hotel_name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				int room = rs.getInt("room");
				String point = rs.getString("point");
				String picture_url = rs.getString("picture_url");
				int category = rs.getInt("category_no");
				int price = rs.getInt("price");
				HotelBean bean = new HotelBean(hotel_no,hotel_name,address,tel,room, point,picture_url,category,price);
				list.add(bean);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (st !=null) {
					st.close();
				}

				if (rs !=null) {
					rs.close();
				}
				close();

			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}
	public List<HotelBean>findHotelById(int categoryNo) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM hotel WHERE category_no = ? ORDER BY price";

			st = con.prepareStatement(sql);

			st.setInt(1, categoryNo);

			rs = st.executeQuery();


			List<HotelBean> list = new ArrayList<HotelBean>();

			while(rs.next()) {
				int hotel_no = rs.getInt("hotel_no");
				String hotel_name = rs.getString("hotel_name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				int room = rs.getInt("room");
				String point = rs.getString("point");
				String picture_url = rs.getString("picture_url");
				int category = rs.getInt("category_no");
				int price = rs.getInt("price");
				HotelBean bean = new HotelBean(hotel_no,hotel_name,address,tel,room, point,picture_url,category,price);
				list.add(bean);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (st !=null) {
					st.close();
				}

				if (rs !=null) {
					rs.close();
				}
				close();

			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}
	public List<HotelBean>findHotelByprice(int hotel_priceMin ,int hotel_priceMax) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM hotel WHERE price >= ? AND price < ? ORDER BY price";

			st = con.prepareStatement(sql);

			st.setInt(1, hotel_priceMin);
			st.setInt(2, hotel_priceMax);

			rs = st.executeQuery();


			List<HotelBean> list = new ArrayList<HotelBean>();

			while(rs.next()) {
				int hotel_no = rs.getInt("hotel_no");
				String hotel_name = rs.getString("hotel_name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				int room = rs.getInt("room");
				String point = rs.getString("point");
				String picture_url = rs.getString("picture_url");
				int category = rs.getInt("category_no");
				int price = rs.getInt("price");

				HotelBean bean = new HotelBean(hotel_no,hotel_name,address,tel,room, point,picture_url,category,price);
				list.add(bean);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (st !=null) {
					st.close();
				}

				if (rs !=null) {
					rs.close();
				}
				close();

			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}
	public List<HotelBean>findHotelByName(String name) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM hotel WHERE hotel_name like ?";

			st = con.prepareStatement(sql);

			st.setString(1, name);

			rs = st.executeQuery();



			List<HotelBean> list = new ArrayList<HotelBean>();

			while(rs.next()) {
				int hotel_no = rs.getInt("hotel_no");
				String hotel_name = rs.getString("hotel_name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				int room = rs.getInt("room");
				String point = rs.getString("point");
				String picture_url = rs.getString("picture_url");
				int category = rs.getInt("category_no");
				int price = rs.getInt("price");

				HotelBean bean = new HotelBean(hotel_no,hotel_name,address,tel,room, point,picture_url,category,price);
				list.add(bean);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (st !=null) {
					st.close();
				}

				if (rs !=null) {
					rs.close();
				}
				close();

			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}
	public void add(HotelBean hotel) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			int hotelNumber = 0;
			String sql = "SELECT nextval('hotel_hotel_no_seq')";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			if(rs.next()) {
				hotelNumber = rs.getInt(1);
			}
			hotelNumber++;
			rs.close();
			st.close();


			sql = "INSERT INTO hotel VALUES(?,?,?,?,?,?,?,?,?)";

			st= con.prepareStatement(sql);

			st.setInt(1, hotelNumber);
			st.setString(2, hotel.getHotel_name());
			st.setString(3, hotel.getAddress());
			st.setString(4, hotel.getTel());
			st.setInt(5, hotel.getRoom());
			st.setString(6, hotel.getPoint());
			st.setString(7, hotel.getPicture_url());
			st.setInt(8, hotel.getCategory());
			st.setInt(9, hotel.getPrice());
			st.executeUpdate();
			st.close();

		} catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (st !=null) {
					st.close();
				}

				if (rs !=null) {
					rs.close();
				}
				close();

			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}
	public void update(HotelBean hotel,int code) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql ="UPDATE hotel set hotel_name = ?,address = ?,tel = ?,room = ?,"
					+ "point = ?,picture_url = ? ,category_no = ?, price = ? WHERE hotel_no = ?" ;

			st= con.prepareStatement(sql);

			st.setString(1, hotel.getHotel_name());
			st.setString(2, hotel.getAddress());
			st.setString(3, hotel.getTel());
			st.setInt(4, hotel.getRoom());
			st.setString(5, hotel.getPoint());
			st.setString(6, hotel.getPicture_url());
			st.setInt(7, hotel.getCategory());
			st.setInt(8, hotel.getPrice());
			st.setInt(9, code);
			st.executeUpdate();
			st.close();

		} catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (st !=null) {
					st.close();
				}

				if (rs !=null) {
					rs.close();
				}
				close();

			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}
	public void delete(int hotelNo) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql ="DELETE FROM hotel WHERE hotel_no = ?" ;

			st= con.prepareStatement(sql);

			st.setInt(1, hotelNo);

			st.executeUpdate();
			st.close();

		} catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (st !=null) {
					st.close();
				}

				if (rs !=null) {
					rs.close();
				}
				close();

			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}
	private void getConnection() throws DAOException{
		try {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql:hoteldb";
		String user = "postgres";
		String pass = "himitu";
		con = DriverManager.getConnection(url,user,pass);
	}catch(Exception e) {
		throw new DAOException("接続に失敗しました。");
		}


	}
	private void close() throws SQLException {
		if(con != null) {
			con.close();
			con = null;
		}
	}
}
