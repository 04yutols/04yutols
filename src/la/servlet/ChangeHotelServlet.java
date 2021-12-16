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

import la.bean.HotelBean;
import la.dao.DAOException;
import la.dao.HotelDAO;

@WebServlet("/ChangeHotelServlet")
public class ChangeHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ChangeHotelServlet() {
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
		if(action.equals("hotel")) {
			HotelDAO hotelDAO;
			try {
				hotelDAO = new HotelDAO();
				List<HotelBean> hotelList = hotelDAO.findAllHotel();
				request.setAttribute("hotel_name", hotelList);

			} catch (DAOException e) {

				e.printStackTrace();
			}


			gotoPage(request,response,"/showAllHotel.jsp");

		}else if(action.equals("update")) {
			int code = Integer.parseInt(request.getParameter("hotel_no"));
			try {
				HotelDAO dao = new HotelDAO();

				List<HotelBean> list = dao.findHotelByHotelNo(code);
				session.setAttribute("hoteldetail", list);
				session.setAttribute("hotel_no", code);
				gotoPage(request,response,"/changeHotel.jsp");


			} catch (DAOException e) {

				e.printStackTrace();
			}



		}else if(action.equals("changehotel")) {


				String hotel_name = escape(request.getParameter("hotel_name"));
				String address = escape(request.getParameter("address"));
				String roomStr = escape(request.getParameter("room"));
				String tel = escape(request.getParameter("tel"));
				String point = escape(request.getParameter("point"));
				//String categoryStr = request.getParameter("category");
				String picture_url = escape(request.getParameter("picture_url"));
				String priceStr = escape(request.getParameter("price"));

				int room =Integer.parseInt(roomStr);
				//int category =Integer.parseInt(categoryStr);
				int price =Integer.parseInt(priceStr);


				HotelBean bean = new HotelBean(hotel_name,address,tel,room, point, picture_url,price);

				session.setAttribute("hotel",bean);
				gotoPage(request,response,"/changeHotelCheck.jsp");


		}else if(action.equals("comp")) {
			try {
				HotelDAO dao = new HotelDAO();

				HotelBean bean = new HotelBean();

				bean =	(HotelBean) session.getAttribute("hotel");
				String codeStr = session.getAttribute("hotel_no").toString();
				int code = Integer.parseInt(codeStr);
				dao.update(bean,code);

				session.removeAttribute("hotel");
				session.removeAttribute("hoteldetail");

				request.setAttribute("message","変更が完了しました" );
				gotoPage(request,response,"/admnmessage.jsp");
			} catch (DAOException e) {

				e.printStackTrace();
			}


		}else {
			request.setAttribute("message", "正しくしてください");
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