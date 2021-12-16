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

import la.bean.MemberBean;
import la.dao.DAOException;
import la.dao.MemberDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String isLogin = (String)session.getAttribute("isLogin");
		String action  = request.getParameter("action");

		String inputEmail = null;
		String inputPass = null;

		MemberDAO member;
		MemberDAO exId ;

		List<MemberBean> list = null;

		boolean loginEmail = false;
		boolean loginPass = false;
		try {
			member = new MemberDAO();
			list = member.findAllUser();



		} catch (DAOException e) {

			e.printStackTrace();
		}
		if(isLogin == null || action.equals("logout")) {

			if(action.equals("loginTop")) {
				String email = escape(request.getParameter("email"));
				String password = escape(request.getParameter("pass"));
				for(MemberBean bean : list) {

					loginEmail = bean.getEmail().equals(email);
					loginPass = bean.getPassword().equals(password);
					if(loginEmail==true && loginPass == true) {
						break;
					}
				}
				if(loginEmail == true && loginPass == true) {
					session = request.getSession();
					session.setAttribute("isLogin", "true");
					List<MemberBean> idList = null;
					try {
						exId = new MemberDAO();
						idList = exId.findUserByEmail(email);

					} catch (DAOException e) {

						e.printStackTrace();
					}


					int setUserId = idList.get(0).getId();
					session.setAttribute("userId", setUserId);
					gotoPage(request,response,"/index.jsp");
				}else {
					String message = "メールアドレスまたはパスワードが違います。";
					request.setAttribute("message", message);
					gotoPage(request,response,"/message.jsp");
				}
			}else if(action.equals("loginRsv")){
				String email = escape(request.getParameter("email"));
				String password = escape(request.getParameter("pass"));
				for(MemberBean bean : list) {

					loginEmail = bean.getEmail().equals(email);
					loginPass = bean.getPassword().equals(password);
					if(loginEmail==true && loginPass == true) {
						break;
					}
				}
				if(loginEmail == true && loginPass == true) {
					session = request.getSession();
					session.setAttribute("isLogin", "true");
					List<MemberBean> idList = null;
					try {
						exId = new MemberDAO();
						idList = exId.findUserByEmail(email);

					} catch (DAOException e) {

						e.printStackTrace();
					}

					int setUserId = idList.get(0).getId();
					session.setAttribute("userId", setUserId);
					gotoPage(request,response,"/hotelRsv.jsp");
				}else {
					String message = "ユーザー名またはパスワードが違います。";
					request.setAttribute("message", message);
					gotoPage(request,response,"/message.jsp");
				}
			}else if(action.equals("loginShow")) {
				String email = escape(request.getParameter("email"));
				String password = escape(request.getParameter("pass"));
				for(MemberBean bean : list) {

					loginEmail = bean.getEmail().equals(email);
					loginPass = bean.getPassword().equals(password);
					if(loginEmail==true && loginPass == true) {
						break;
					}
				}
				if(loginEmail == true && loginPass==true ) {
					session = request.getSession();
					session.setAttribute("isLogin", "true");
					List<MemberBean> idList = null;
					try {
						exId = new MemberDAO();
						idList = exId.findUserByEmail(email);

					} catch (DAOException e) {

						e.printStackTrace();
					}

					int setUserId = idList.get(0).getId();
					session.setAttribute("userId", setUserId);
					gotoPage(request,response,"/ShowRsvServlet?action=reserve");
				}else {
					String message = "ユーザー名またはパスワードが違います。";
					request.setAttribute("message", message);
					gotoPage(request,response,"/message.jsp");
				}

			}else if(action.equals("loginMember")) {
				String email = escape(request.getParameter("email"));
				String password = escape(request.getParameter("pass"));
				for(MemberBean bean : list) {

					loginEmail = bean.getEmail().equals(email);
					loginPass = bean.getPassword().equals(password);
					if(loginEmail==true && loginPass == true) {
						break;
					}
				}
				if(loginEmail == true && loginPass == true) {
					session = request.getSession();
					session.setAttribute("isLogin", "true");
					List<MemberBean> idList = null;
					try {
						exId = new MemberDAO();
						idList = exId.findUserByEmail(email);

					} catch (DAOException e) {

						e.printStackTrace();
					}

					int setUserId = idList.get(0).getId();
					session.setAttribute("userId", setUserId);
					gotoPage(request,response,"/ChangeMemberServlet?action=detail");
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
			gotoPage(request,response,"/message.jsp");
		}
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