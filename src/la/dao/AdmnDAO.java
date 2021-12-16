package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.AdmnBean;

public class AdmnDAO {
	private Connection con;

	public AdmnDAO() throws DAOException{
		getConnection();
	}
	public List<AdmnBean>findAllAdmn() throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM admn";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			List<AdmnBean> list = new ArrayList<AdmnBean>();

			while(rs.next()) {
				int id = rs.getInt("admn_id");
				String password = rs.getString("password");
				AdmnBean bean = new AdmnBean(id,password);
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
