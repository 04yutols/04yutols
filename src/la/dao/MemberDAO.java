package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.MemberBean;

public class MemberDAO {
	private Connection con;

	public MemberDAO() throws DAOException{
		getConnection();
	}
	public List<MemberBean>findAllUser() throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		Date date = new Date();
		try {
			String sql = "SELECT * FROM member";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			List<MemberBean> list = new ArrayList<MemberBean>();

			while(rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				String address = rs.getString("address");
				String pass = rs.getString("password");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				MemberBean bean = new MemberBean(id,name,address,tel,email,birthday,pass);
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
	public List<MemberBean>findUserByEmail(String userEmail) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM member WHERE email = ?";

			st = con.prepareStatement(sql);

			st.setString(1, userEmail);

			rs = st.executeQuery();



			List<MemberBean> list = new ArrayList<MemberBean>();

			while(rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				String address = rs.getString("address");
				String pass = rs.getString("password");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				MemberBean bean = new MemberBean(id,name,address,tel,email,birthday,pass);
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
	public List<MemberBean>findUserById(int user_id) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		Date date = new Date();
		try {
			String sql = "SELECT * FROM member WHERE user_id = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, user_id);

			rs = st.executeQuery();



			List<MemberBean> list = new ArrayList<MemberBean>();

			while(rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				String address = rs.getString("address");
				String pass = rs.getString("password");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				MemberBean bean = new MemberBean(id,name,address,tel,email,birthday,pass);
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
	public void add(MemberBean member) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			int memberNumber = 0;
			String sql = "SELECT nextval('member_user_id_seq')";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			if(rs.next()) {
				memberNumber = rs.getInt(1);
			}
			memberNumber++;
			rs.close();
			st.close();


			sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?)";

			st= con.prepareStatement(sql);

			st.setInt(1, memberNumber);
			st.setString(2, member.getName());
			st.setString(3, member.getAddress());
			st.setString(4, member.getTel());
			st.setString(5, member.getEmail());
			st.setString(6, member.getBirthday());
			st.setString(7, member.getPassword());
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
	public void update(MemberBean member, int userId) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql ="UPDATE member set user_name = ?,address = ?,tel = ?,email = ?,Birthday = ?,password = ? WHERE user_id = ?" ;

			st= con.prepareStatement(sql);

			st.setString(1, member.getName());
			st.setString(2, member.getAddress());
			st.setString(3, member.getTel());
			st.setString(4, member.getEmail());
			st.setString(5, member.getBirthday());
			st.setString(6, member.getPassword());
			st.setInt(7, userId);
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
	public void delete(int userId) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql ="DELETE FROM member WHERE user_id = ?" ;

			st= con.prepareStatement(sql);

			st.setInt(1, userId);

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
