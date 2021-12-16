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
import la.dao.RsvDAO;


@WebServlet("/CancelRsvServlet")
public class CancelRsvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public CancelRsvServlet() {
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
		if (action.equals("cancel")){
			int rsv_no=Integer.parseInt(request.getParameter("rsv_no"));
			session.setAttribute("rsv_no", rsv_no);
			gotoPage(request,response,"/cancelCheck.jsp");

		}else if(action.equals("confirm")) {

			try {
				int rsv_no=(int) session.getAttribute("rsv_no");

				RsvDAO dao = new RsvDAO();
				dao.delete(rsv_no);
				session.removeAttribute("rsv_no");
			} catch (DAOException e) {

				e.printStackTrace();
			}
			request.setAttribute("message", "キャンセルしました");
			gotoPage(request,response,"/message.jsp");


		}else if(action.equals("deni")) {
			request.setAttribute("message", "トップページに戻ってください");
			gotoPage(request,response,"/message.jsp");
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
