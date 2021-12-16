package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.dao.DAOException;
import la.dao.HotelDAO;



@WebServlet("/DeleteHotelServlet")
public class DeleteHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public DeleteHotelServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;charset=UTF-8");

		request.setCharacterEncoding("UTF-8");
		if(session==null) {
			request.setAttribute("message", "セッションが切れています。もう一度トップページから操作してください。");
			gotoPage(request,response,"/message.jsp");
			return;
		}
		String action = request.getParameter("action");
		if(action.equals("delete")){
			int hotel_no=Integer.parseInt(request.getParameter("hotel_no"));
			session.setAttribute("hotel_no", hotel_no);
			gotoPage(request,response,"/deleteCheck.jsp");


		}else if (action.equals("confirm")){
			try {

				int code = (int) session.getAttribute("hotel_no");
				HotelDAO dao = new HotelDAO();
				dao.delete(code);
				request.setAttribute("message", "宿を削除しました。");
				session.removeAttribute("hotel_no");
				gotoPage(request,response,"/admnmessage.jsp");

			} catch (DAOException e) {

				e.printStackTrace();
			}


		}else if(action.equals("deni")) {
			request.setAttribute("message", "トップページに戻ってください");
			gotoPage(request,response,"/admnmessage.jsp");
		}
	}




	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response,String page)throws ServletException,
	IOException{

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
