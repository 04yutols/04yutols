package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.HotelBean;
import la.bean.RsvBean;

public class RsvDAO {
	private Connection con;

	public RsvDAO() throws DAOException{
		getConnection();
	}
	public List<RsvBean>findRsvByUserId(int userId) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM rsv WHERE user_id = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, userId);

			rs = st.executeQuery();



			List<RsvBean> list = new ArrayList<RsvBean>();

			while(rs.next()) {
				int rsv_no = rs.getInt("rsv_no");
				String hotel_name = rs.getString("hotel_name");
				String date = rs.getString("date");
				int rsv_num = rs.getInt("rsv_num");
				int id = rs.getInt("user_id");
				int priceSum = rs.getInt("sum_price");
				String plan_name = rs.getString("plan_name");
				int stay = rs.getInt("stay");
				RsvBean bean = new RsvBean(rsv_no,date,hotel_name,rsv_num,id, priceSum,plan_name,stay);
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
	public List<RsvBean>findRsvByRsvNo(int rsvNum) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM rsv WHERE rsv_no = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, rsvNum);

			rs = st.executeQuery();

			List<RsvBean> list = new ArrayList<RsvBean>();

			while(rs.next()) {
				int rsv_no = rs.getInt("rsv_no");
				String hotel_name = rs.getString("hotel_name");
				String date = rs.getString("date");
				int rsv_num = rs.getInt("rsv_num");
				int id = rs.getInt("user_id");
				int priceSum = rs.getInt("sum_price");
				int stay = rs.getInt("stay");
				RsvBean bean = new RsvBean(rsv_no,date,hotel_name,rsv_num,id, priceSum,stay );
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

	public void add(RsvBean rsv ,int userId,HotelBean hotel) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			Date today = new Date(System.currentTimeMillis());
			int rsvNumber = 0;
			String sql = "SELECT nextval('rsv_rsv_no_seq')";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			if(rs.next()) {
				rsvNumber = rs.getInt(1)+1;
			}
			rs.close();
			st.close();


			sql = "INSERT INTO rsv VALUES(?,?,?,?,?,?,?,?,?)";

			st= con.prepareStatement(sql);

			st.setInt(1, rsvNumber);
			st.setString(2, rsv.getDate());
			st.setString(3, hotel.getHotel_name());
			st.setInt(4, rsv.getRsv_num());
			st.setInt(5, userId);
			st.setInt(6, rsv.getSum_price());
			st.setInt(7, rsv.getPlan_no());
			st.setString(8, rsv.getPlan_name());
			st.setInt(9, rsv.getStay());


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
	public void delete(int rsv) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql ="DELETE FROM rsv WHERE rsv_no = ?" ;

			st= con.prepareStatement(sql);

			st.setInt(1, rsv);

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
