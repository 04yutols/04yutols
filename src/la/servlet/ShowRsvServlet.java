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

import la.bean.RsvBean;
import la.dao.DAOException;
import la.dao.RsvDAO;

/**
 * Servlet implementation class showRsvServlet
 */
@WebServlet("/ShowRsvServlet")
public class ShowRsvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object cancel;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRsvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String isLogin = (String)session.getAttribute("isLogin");
		if(isLogin != null) {
		int id = (int)session.getAttribute("userId");

		RsvDAO rsv = null;
		List<RsvBean> list = null;
		RsvBean bean ;




		String action = request.getParameter("action");
		if(action.equals("reserve")) {
			try {
				rsv = new RsvDAO();
				list = rsv.findRsvByUserId(id);
				session.setAttribute("rsv", list);
				gotoPage(request,response,"/showRsv.jsp");

			}catch(DAOException e) {
				e.printStackTrace();

			}

		}else if(action.equals("cancel")){

			try {

				int rsv_no = (int) session.getAttribute("rsv_no");
				rsv = new RsvDAO();
				list = rsv.findRsvByRsvNo(rsv_no);
				session.setAttribute("rsv_no",rsv_no);
				gotoPage(request,response,"/cancelCheck.jsp");

			} catch (DAOException e) {
				e.printStackTrace();
			}

		}
		}else {
			request.setAttribute("message", "ログインしてください。");
			gotoPage(request,response,"/loginShow.jsp");
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

}