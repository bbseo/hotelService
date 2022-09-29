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
import javax.servlet.http.HttpSession;

import hotelServiceDAO.bookingDAO;
import hotelServiceDAO.hotelDAO;
import hotelServiceDAO.memberDAO;
import hotelServiceDAO.roomDAO;
import hotelServiceDTO.bookingListDTO;
import hotelServiceDTO.hotelDTO;
import hotelServiceDTO.memberDTO;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		
		
		if(command == null){
			command = "hotel";
		}
		
		if(command.equals("hotel")){
			hotelList(request, response);
		}else if(command.equals("room")){
			roomList(request, response);
		}else if(command.equals("bookingForm")){
			bookingForm(request, response);
		}else if(command.equals("booking")) {
			booking(request, response);
		}
		
		HttpSession memberSession = request.getSession();
		
		String memberId = (String)memberSession.getAttribute("memberId");
		
		try {
			memberDTO member = new memberDAO().selectMember(memberId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	private void hotelList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		String grade=request.getParameter("grade");
		
		if (name == null) {
			name = "";
		}
		if(location == null) {
			location="";
		}

		
		String url = "error.jsp";
		try {
			request.setAttribute("hotel", hotelDAO.getAllContents(name,location));
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
		String category=request.getParameter("category");
		String[] Ddata = request.getParameter("daterange").split(" - ");
		
		String[] inCheck = Ddata[0].split("/");
		String[] outCheck = Ddata[1].split("/");
		String checkIn = inCheck[2]+"-"+inCheck[0]+"-"+inCheck[1];
		String checkOut = outCheck[2]+"-"+outCheck[0]+"-"+outCheck[1];

		try {
			request.setAttribute("bookingForm", bookingDAO.getbookingForm(hotelNum,category,checkIn,checkOut));
			url = "bookingForm.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "에러");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}
	
	
	private void booking(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		String url = "error.jsp";
	    String guestNum = request.getParameter("guestNum");
	    String roomNum = request.getParameter("roomNum");
	    String checkIn = request.getParameter("checkIn");
	    String checkOut = request.getParameter("checkOut");
	    HttpSession session = request.getSession();
//	    String memberId = (String) session.getAttribute("member_id");
	    String memberId = "user";
	    int memberNum = 8;
	    try {
//			memberDTO member = memberDAO.selectMember(memberId);
//			memberNum = member.getMemberNum();
			boolean result = false;
		    System.out.println(checkIn);
		    
			result = bookingDAO.booking(new bookingListDTO(memberNum,Integer.parseInt(roomNum),Integer.parseInt(guestNum),checkIn,checkOut));
		    if(result) {
		    	request.setAttribute("complete", bookingDAO.bookingComplete(memberId));
				url = "bookingComplete.jsp";
		    	request.getRequestDispatcher(url).forward(request, response);
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    
	   
	    
	}

}
