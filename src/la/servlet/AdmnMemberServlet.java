package la.servlet;

import java.io.IOException;
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

@WebServlet("/AdmnMemberServlet")
public class AdmnMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AdmnMemberServlet() {
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
		if(action.equals("user")) {
			MemberDAO memberDAO;
			try {
				memberDAO = new MemberDAO();
				List<MemberBean> memberList = memberDAO.findAllUser();
				request.setAttribute("member", memberList);

			} catch (DAOException e) {

				e.printStackTrace();
			}


			gotoPage(request,response,"/admnMember.jsp");

		}else if(action.equals("update")) {
			int user = Integer.parseInt(request.getParameter("user_id"));
			try {
				MemberDAO dao = new MemberDAO();

				List<MemberBean> userlist = dao.findUserById(user);

				request.setAttribute("user", userlist);
				session.setAttribute("user", user);

			} catch (DAOException e) {

				e.printStackTrace();
			}
			gotoPage(request,response,"/admnChangeMember.jsp");
		}else if(action.equals("cngmember")) {

		}
		int user = (int) session.getAttribute("user");
		String user_name = request.getParameter("user_name");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String password = request.getParameter("password");

		MemberDAO dao;
		try {
			dao = new MemberDAO();

			MemberBean bean = new MemberBean(user_name,address,tel,email,birthday,password);
			dao.update(bean,user);
			session.removeAttribute("user");
		} catch (DAOException e) {

			e.printStackTrace();
		}





		request.setAttribute("message", "情報が更新されました");
		gotoPage(request,response,"/admnmessage.jsp");






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
