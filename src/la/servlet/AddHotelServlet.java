package la.servlet;

import java.io.IOException;

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



@WebServlet("/AddHotelServlet")
public class AddHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AddHotelServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);


		if(session==null) {
			request.setAttribute("message", "セッションが切れています。もう一度トップページから操作してください。");
		gotoPage(request,response,"/message.jsp");
		return;
		}

			String action = request.getParameter("action");
		 if(action.equals("add")) {
			HotelBean bean = new HotelBean();
			 String hotel_name = request.getParameter("hotel_name");
			 String address = request.getParameter("address");
			 String roomStr = request.getParameter("room");
			 String tel = request.getParameter("tel");
			 String point = request.getParameter("point");
			 String categoryStr = request.getParameter("category");
			 String picture_url = request.getParameter("picture_url");
			 String priceStr = request.getParameter("price");

			int room =Integer.parseInt(roomStr);
			int category =Integer.parseInt(categoryStr);
			int price =Integer.parseInt(priceStr);

			 bean.setHotel_name(hotel_name);
			 bean.setAddress(address);
			 bean.setTel(tel);
			 bean.setRoom(room);
			 bean.setPoint(point);
			 bean.setCategory(category);
			 bean.setPicture_url(picture_url);
			 bean.setPrice(price);
			 try {
				 HotelDAO dao = new HotelDAO();
				 dao.add(bean);

			 }catch(DAOException e) {
				 e.printStackTrace();
			 }


			session.setAttribute("hotel", bean);
			request.setAttribute("message", "宿を追加しました");
			session.removeAttribute("hotel");
			 gotoPage(request,response,"/admnmessage.jsp");
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

}
