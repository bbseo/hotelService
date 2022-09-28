package controller;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotelServiceDAO.bookingDAO;
import hotelServiceDAO.hotelDAO;
import hotelServiceDAO.roomDAO;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		System.out.println(command);

		
		if(command == null){
			command = "hotel";
		}
		
		if(command.equals("hotel")){
			hotelList(request, response);
		}else if(command.equals("room")){
			roomList(request, response);
		}else if(command.equals("bookingForm")){
			bookingForm(request, response);
		}
		
		
	}
		
	private void hotelList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		try {
			request.setAttribute("hotel", hotelDAO.getAllContents());
			url = "list.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "紐⑤몢 蹂닿린 �떎�뙣 �옱 �떎�뻾 �빐 二쇱꽭�슂");
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void roomList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		String hotelNum=request.getParameter("hotelNum");
		System.out.println(hotelNum);
		try {
			request.setAttribute("room", roomDAO.getRoomContents(Integer.parseInt(hotelNum)));
			url = "roomList.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "紐⑤몢 蹂닿린 �떎�뙣 �옱 �떎�뻾 �빐 二쇱꽭�슂");
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	private void bookingForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		int hotelNum=Integer.parseInt(request.getParameter("hotelNum"));
//		String hotelNum=request.getParameter("hotelNum");
		String category=request.getParameter("category");
		String[] Ddata = request.getParameter("daterange").split(" - ");
		
		String[] inCheck = Ddata[0].split("/");
		String[] outCheck = Ddata[1].split("/");
		String checkIn = inCheck[2]+"-"+inCheck[0]+"-"+inCheck[1];
		String checkOut = outCheck[2]+"-"+outCheck[0]+"-"+outCheck[1];
		
		
//		String incheck = Ddata[0];
//      SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
//		try {
//			Date data = format.parse(incheck);
//			System.out.println("data : "+data);
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
		String memberNum = "2";//로그인 시 session으로 넘겨받을거임
		System.out.println("=======================================");
		
		
		try {
			request.setAttribute("bookingForm", bookingDAO.getbookingForm(hotelNum,category,checkIn,checkOut));
			url = "bookingForm.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "紐⑤몢 蹂닿린 �떎�뙣 �옱 �떎�뻾 �빐 二쇱꽭�슂");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
