package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.MemberBean;
import la.dao.DAOException;
import la.dao.MemberDAO;

@WebServlet("/MemberEntryServlet")
public class MemberEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberEntryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String name =escape(request.getParameter("user_name"));
		String address = escape(request.getParameter("address"));
		String tel = escape(request.getParameter("tel"));
		String emailA = escape(request.getParameter("email"));
		String domain = escape(request.getParameter("domain"));
		String birthday = escape(request.getParameter("birthday"));
		String email = emailA + "@" +domain;
		//try {
			//String strBirthday = request.getParameter("birthday");
			///SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
			//birthday = sdFormat.parse(strBirthday);
		//}catch(ParseException e) {
			//e.printStackTrace();
		//}

		String password = escape(request.getParameter("password"));
		Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
		Pattern p2 = Pattern.compile("^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)+$");
		Matcher m = p.matcher(password);
		Boolean presult = m.matches();
		Matcher a = p2.matcher(emailA);
		Boolean mresult = a.matches();
		if(presult == false) {
			String message = "パスワードは半角英数字で入力してください。";
			request.setAttribute("message", message);
			gotoPage(request,response,"/message.jsp");
		}else if(mresult == false) {
			String message = "メールアドレスは正しいフォームで入力してください。";
			request.setAttribute("message", message);
			gotoPage(request,response,"/message.jsp");
		}else {
		if(name == null || name.length() == 0 || address == null || address.length() == 0
				|| tel == null || tel.length() == 0 || email == null || email.length() == 0
				|| birthday == null || password == null || password.length() == 0) {
			request.setAttribute("message", "未入力項目があります。");
			gotoPage(request,response,"/message.jsp");
		}else {
			MemberBean bean = new MemberBean(name,address,tel,email,birthday,password);
			request.setAttribute("article", bean);
			//ArticleBean articlebean = (ArticleBean)session.getAttribute("article");
			try {
				MemberDAO member = new MemberDAO();
				member.add(bean);
				String message = "登録完了";
				request.setAttribute("message", message);
				gotoPage(request,response,"/message.jsp");
			}catch(DAOException e) {
				e.printStackTrace();
			}

		}
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
