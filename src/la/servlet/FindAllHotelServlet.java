package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.HotelBean;
import la.dao.DAOException;
import la.dao.HotelDAO;

@WebServlet("/FindAllHotelServlet")
public class FindAllHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public FindAllHotelServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//①index→Servlet
		try {
			String action = request.getParameter("action");

			//②全てのホテルデータを取る（HotelDAOとやりとり）findAllメソッドから
			HotelDAO dao = new HotelDAO();

			//③それをリストに格納
			List<HotelBean> list = dao.findAllHotel();

			//④リクエストスコープに送る
			request.setAttribute("hotel", list);
			gotoPage(request, response, "/top.jsp");
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/message.jsp");
		}
	}

	//⑤GotoPageメソッド（サーブレットで共通を使って飛ぶ先のURL(top.jsp)を指定（ここから先はtop.jspさんお願いします。）
	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
