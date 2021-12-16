package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


@WebServlet("/ChangeMemberServlet")
public class ChangeMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangeMemberServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		//int userId = Integer.parseInt(userIdStr);
		MemberDAO member;
		List<MemberBean> list = null;
		MemberBean bean ;
		String action = request.getParameter("action");
		String isLogin = (String)session.getAttribute("isLogin");
		if(isLogin != null) {
			int userId = (int)session.getAttribute("userId");
			if(action.equals("detail")) {
				try {
					member = new MemberDAO();
					list = member.findUserById(userId);
					session.setAttribute("memberDetail", list);
					gotoPage(request,response,"/memberDetail.jsp");
				}catch(DAOException e) {
					e.printStackTrace();
				}
			}else if(action.equals("change")) {

				try {
					member = new MemberDAO();
					list = member.findUserById(userId);
					request.setAttribute("member", list);
					gotoPage(request,response,"/changeMember.jsp");



				}catch(DAOException e) {
					e.printStackTrace();
				}
			}else if (action.equals("change_member")) {
				String user_name = escape(request.getParameter("user_name"));
				String address =escape(request.getParameter("address"));
				String tel = escape(request.getParameter("tel"));
				String email = escape(request.getParameter("email"));
				String birthday = escape(request.getParameter("birthday"));
				String password = escape(request.getParameter("password"));
				Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
				Matcher m = p.matcher(password);
				Boolean result = m.matches();
				if(result == false) {
					String message = "パスワードは半角英数字で入力してください。";
					request.setAttribute("message", message);
					gotoPage(request,response,"/message.jsp");
				}else {
					try {
						member = new MemberDAO();
						bean = new MemberBean(user_name,address,tel,email,birthday,password);
						member.update(bean,userId);
						String message = "更新が完了しました。";
						request.setAttribute("message", message);
						gotoPage(request,response,"/message.jsp");



					}catch(DAOException e) {
						e.printStackTrace();
					}
				}
			}else if(action.equals("delete")) {
				try {
					member = new MemberDAO();
					member.delete(userId);
					String message = "退会完了しました。";
					request.setAttribute("message", message);
					gotoPage(request,response,"/message.jsp");
					session.invalidate();


				}catch(DAOException e) {
					e.printStackTrace();
				}
			}
		}else {
			request.setAttribute("message", "ログインしてください。");
			gotoPage(request,response,"/memberLogin.jsp");
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
