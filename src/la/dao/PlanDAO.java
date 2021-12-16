package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.PlanBean;

public class PlanDAO {
	private Connection con;

	public PlanDAO() throws DAOException{
		getConnection();
	}
	public List<PlanBean>findByPlanNo(int plan_no) throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM plan WHERE plan_no = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, plan_no);

			rs = st.executeQuery();



			List<PlanBean> list = new ArrayList<PlanBean>();

			while(rs.next()) {
				int plan_num = rs.getInt("plan_no");
				String plan_name = rs.getString("plan_name");
				String plan_info = rs.getString("plan_info");
				int plan_price = rs.getInt("plan_price");

				PlanBean bean = new PlanBean(plan_num,plan_name,plan_info,plan_price);
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

	public List<PlanBean>findAllPlan() throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM plan";

			st = con.prepareStatement(sql);


			rs = st.executeQuery();



			List<PlanBean> list = new ArrayList<PlanBean>();

			while(rs.next()) {
				int plan_num = rs.getInt("plan_no");
				String plan_name = rs.getString("plan_name");
				String plan_info = rs.getString("plan_info");
				int plan_price = rs.getInt("plan_price");

				PlanBean bean = new PlanBean(plan_num,plan_name,plan_info,plan_price);
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
