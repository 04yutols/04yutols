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

import la.bean.HotelBean;
import la.bean.PlanBean;
import la.dao.DAOException;
import la.dao.HotelDAO;
import la.dao.PlanDAO;

@WebServlet("/SerchHotelServlet")
public class SerchHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SerchHotelServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		HotelDAO hotel;
		List<HotelBean> list = null;
		HotelBean bean ;

		PlanDAO plan;
		List<PlanBean> planlist = null;
		PlanBean planbean ;

		String action = request.getParameter("action");

		if(action.equals("serchCategory")) {
			String categoryNoStr = request.getParameter("categoryNo");
			int categoryNo = Integer.parseInt(categoryNoStr);
			try {
				hotel = new HotelDAO();
				bean = new HotelBean();
				list = hotel.findHotelById(categoryNo);
				request.setAttribute("hotel", list);
				gotoPage(request,response,"/showHotel.jsp");
			}catch(DAOException e) {
				e.printStackTrace();
			}

		}else if(action.equals("serchPrice")) {
			String minPriceStr = request.getParameter("minPrice");
			int minPrice = Integer.parseInt(minPriceStr);
			String maxPriceStr = request.getParameter("maxPrice");
			int maxPrice = Integer.parseInt(maxPriceStr);
			try {
				hotel = new HotelDAO();
				bean = new HotelBean();
				list = hotel.findHotelByprice(minPrice,maxPrice);
				request.setAttribute("hotel", list);
				gotoPage(request,response,"/showHotel.jsp");
			}catch(DAOException e) {
				e.printStackTrace();
			}

		}else if(action.equals("serchKey")) {
			String key = "%";
			key += request.getParameter("key");
			key +="%";
			try {
				hotel = new HotelDAO();
				bean = new HotelBean();
				list = hotel.findHotelByName(key);
				if (list.size() != 0) {
					request.setAttribute("hotel", list);
					gotoPage(request,response,"/showHotel.jsp");
				} else if (list.size() == 0) {
					String message = "該当の宿はありません。";
					request.setAttribute("message", message);
					gotoPage(request,response,"/message.jsp");
				}

			}catch(DAOException e) {
				e.printStackTrace();
			}

		}else if(action.equals("detail")) {

			try {
				plan = new PlanDAO();
				planbean = new PlanBean();

				hotel = new HotelDAO();
				bean = new HotelBean();
				String noStr = request.getParameter("no");
				int no = Integer.parseInt(noStr);


				list = hotel.findHotelByHotelNo(no);
				planlist = plan.findAllPlan();

				session.setAttribute("hotelnum", no);


				request.setAttribute("hotel", list);
				session.setAttribute("plan", planlist);

				gotoPage(request,response,"/hotelInfo.jsp");
			}catch(DAOException e) {
				e.printStackTrace();
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
}
