package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.AdmnBean;
import la.dao.AdmnDAO;
import la.dao.DAOException;


@WebServlet("/LoginAdmnServlet")
public class LoginAdmnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginAdmnServlet() {
        super();

    }

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		String isLogin = (String)session.getAttribute("admnLogin");
		String action  = request.getParameter("action");

		AdmnDAO admn;

		List<AdmnBean> list = null;

		boolean loginId = false;
		boolean loginPass = false;

	try {
			admn = new AdmnDAO();
			list = admn.findAllAdmn();


		} catch (DAOException e) {

			e.printStackTrace();
		}
		if(isLogin == null || action.equals("logout")) {

			if(action.equals("login")) {
				String admn_Id = escape(request.getParameter("id"));
				String password = escape(request.getParameter("pass"));
				int Admn_id = Integer.parseInt(admn_Id);

				for(AdmnBean bean : list) {
					loginId = bean.getAdmn_id() == Admn_id;
					loginPass = bean.getPassword().equals(password);

					if(loginId==true && loginPass == true) {
						break;
					}
				}

				if(loginId == true && loginPass == true) {
					session = request.getSession();
					session.setAttribute("admnLogin", "true");

					gotoPage(request,response,"/admnMenu.jsp");

				}else {
					String message = "ユーザー名またはパスワードが違います。";
					request.setAttribute("message", message);
					gotoPage(request,response,"/message.jsp");
				}


			}else if(action.equals("logout")) {
				session = request.getSession(false);
				if(session != null) {
					session.invalidate();
					String message = "ログアウトしました。";
					request.setAttribute("message", message);
					gotoPage(request,response,"/message.jsp");
				}

			}

		}else if(isLogin.equals("true") ) {
			String message = "すでにログインしています。";
			request.setAttribute("message", message);
			gotoPage(request,response,"/message.jsp");}
		}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page)throws ServletException,
	IOException {
		RequestDispatcher rd =  request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	private  String escape(String val) {
	       if (val == null) return "";
	       val = val.replaceAll("&", "& amp;");
	       val = val.replaceAll("<", "& lt;");
	       val = val.replaceAll(">", "& gt;");
	       val = val.replaceAll("\"", "&quot;");
	       val = val.replaceAll("'", "&apos;");
	       return val;

}
}