package la.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.HotelBean;
import la.bean.MemberBean;
import la.bean.PlanBean;
import la.bean.RsvBean;
import la.dao.DAOException;
import la.dao.HotelDAO;
import la.dao.MemberDAO;
import la.dao.PlanDAO;
import la.dao.RsvDAO;

@WebServlet("/RsvServlet")
public class RsvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RsvServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//①hotelRsv.jspからpeople、date、confirmボタン持ってくる

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		MemberBean mbean = null;
		PlanBean pbean = null;

		String action = request.getParameter("action");

		int user_id = 0;
		String name = null;
		String address = null;
		String tel = null;

		RsvBean rbean = null;
		HotelBean hbean = null;

		String isLogin = (String)session.getAttribute("isLogin");
		if(isLogin != null) {


		//②セッションスコープからuserid取ってきて、MemberDAOを使ってuserの全情報中のname, address, telを表示させる。
		user_id = (int)session.getAttribute("userId");
		try {
		MemberDAO dao = new MemberDAO();
	    mbean = (MemberBean) dao.findUserById(user_id).get(0);
		name =  mbean.getName();
		address =  mbean.getAddress();
		tel = mbean.getTel();;
		} catch (DAOException e) {
			e.printStackTrace();
		}



		//③MemberBeanとRsvBeanから取ってきてリストに格納（リスト名付ける）
		List<RsvBean> rsvInformation =  new ArrayList<RsvBean>();
		session.setAttribute("mbean", mbean);



		//④rsvCheck.jspで表示する
		if(action.equals("jump")) {
			int hotel_no = Integer.parseInt(request.getParameter("hotel_no"));
			session.setAttribute("hotel_no", hotel_no);
			gotoPage(request,response,"/hotelRsv.jsp");

		}
		else if (action.equals("confirm")) {
			String peoplestr = request.getParameter("people");
			String date = request.getParameter("date");
			String stayStr = request.getParameter("stay");
			int plan_no = Integer.parseInt(request.getParameter("plan"));

			int people = Integer.parseInt(peoplestr);
			int stay = Integer.parseInt(stayStr);
			//空欄があった場合、、、
			if (date == null || date.length() == 0) {
				request.setAttribute("message", "未入力項目があります。");
				RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
				rd.forward(request,  response);
				return;
			}

			//数字以外のものを入力したら、、、
			try {
				people = Integer.parseInt(peoplestr);
			} catch (NumberFormatException e){
				request.setAttribute("message", "人数は数値を入力してください。");
				RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
				rd.forward(request,  response);
				return;
			}
			rbean = new RsvBean();
			rbean.setDate(request.getParameter("date"));
			rbean.setRsv_num(people);
			rbean.setPlan_no(plan_no);
			rbean.setStay(stay);
			try {
				PlanDAO plan= new PlanDAO();
				PlanBean planBean = (PlanBean)plan.findByPlanNo(plan_no).get(0);
				String plan_name = planBean.getPlan_name();
				rbean.setPlan_name(plan_name);
			}catch(DAOException e) {
				e.printStackTrace();
			}
			int num = (int)session.getAttribute("hotelnum");

			try {
				HotelDAO hotel = new HotelDAO();
				hbean = (HotelBean)hotel.findHotelByHotelNo(num).get(0);
				PlanDAO plan = new PlanDAO();
				pbean = (PlanBean)plan.findByPlanNo(plan_no).get(0);

				int plan_price = pbean.getPlan_price();
				int price = hbean.getPrice();
				int staydays = rbean.getStay();

				int priceSum = (((plan_price+price) * people)*staydays);
				rbean.setSum_price(priceSum);

				session.setAttribute("hbean", hbean);
				session.setAttribute("pbean", pbean);
				session.setAttribute("priceSum", priceSum);

			}catch(DAOException e) {

			}

			session.setAttribute("rbean", rbean);
			gotoPage(request, response, "/rsvCheck.jsp");
		}
		//⑤「予約確定ボタン」押下後メッセージを表示
		else if (action.equals("rsvComp")) {
		   int userId = (int)session.getAttribute("userId");

		    pbean = (PlanBean)session.getAttribute("pbean");
			rbean = (RsvBean)session.getAttribute("rbean");
			hbean = (HotelBean)session.getAttribute("hbean");
			try {
				RsvDAO dao = new RsvDAO();
			    dao.add(rbean, userId, hbean);

			} catch (DAOException e) {
				e.printStackTrace();
			}
			request.setAttribute("message","予約が完了しました。");
			gotoPage(request, response, "/message.jsp");

		}

	}else {
		request.setAttribute("message", "ログインしてください。");
		gotoPage(request,response,"/loginRsv.jsp");
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page)throws ServletException,
	IOException {
		RequestDispatcher rd =  request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
