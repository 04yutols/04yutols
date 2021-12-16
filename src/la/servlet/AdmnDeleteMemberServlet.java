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
import la.dao.MemberDAO;


@WebServlet("/AdmnDeleteMemberServlet")
public class AdmnDeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AdmnDeleteMemberServlet() {
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
		if (action.equals("confirm")){
			try {
				int user_id=Integer.parseInt(request.getParameter("user_id"));
				MemberDAO dao = new MemberDAO();
				dao.delete(user_id);
				request.setAttribute("message", "退会処理が完了しました。");
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
