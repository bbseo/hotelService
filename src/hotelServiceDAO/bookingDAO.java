package hotelServiceDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hotelServiceDTO.bookingListDTO;
import hotelServiceDTO.memberDTO;
import hotelServiceDTO.roomDTO;
import util.DBUtil;


public class bookingDAO {
	public static ArrayList<bookingListDTO> getAllContents() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<bookingListDTO> alist = null;
		String sql = "select b.*,m.member_id from bookingList as b left join member as m on b.member_num=m.member_num";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			alist = new ArrayList<bookingListDTO>();
			while (rset.next()) {
				alist.add(new bookingListDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getDate(4),
						rset.getDate(5), rset.getDate(6), rset.getDate(7), rset.getString(8)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return alist;
	}
	
	
	public static bookingListDTO getContent(int num) throws SQLException{		
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		bookingListDTO am  = null;
		String sql="select b.*,m.member_id from bookingList as b left join member as m on b.member_num=m.member_num where booking_num=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);	
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				am = new bookingListDTO(rset.getInt(1),rset.getInt(2),
						rset.getInt(3),rset.getDate(4),rset.getDate(5),
						rset.getDate(6),rset.getDate(7), rset.getString(8));
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return am;
	}
	
	public static boolean deleteContent(int num) throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String sql="delete from bookingList where booking_num=?";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1,num);

			int count = pstmt.executeUpdate();
			
			if(count != 0){
				result = true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	public static ArrayList<roomDTO> getRoomContents(int hotelNum) throws SQLException {
		System.out.println("roomDAO");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<roomDTO> alist = null;
		String sql = "select * from room where hotel_num = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,hotelNum);
			rset = pstmt.executeQuery();
			alist = new ArrayList<roomDTO>();
			while (rset.next()) {
				alist.add(new roomDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getInt(6), rset.getInt(7),rset.getInt(8),rset.getString(9)));
			}
			System.out.println("room"+alist);
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return alist;
}

	   public static List<Object> getbookingForm(int hotelNum, String category, String checkIn, String checkOut) throws SQLException {
		      System.out.println("getbookingForm DAO : "+category+" / "+hotelNum+" / "+checkIn+" / "+checkOut);
		      
		      Connection con = null;
		      PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      List<Object> list = new ArrayList<>();
		      String sql = "select room_name, max_guest_num, price, category,room_num,hotel_num "
		               +"from room "
		               +"where category= ? and hotel_num = ? and room_name not in (select room_name "
		               +"from room as r left join bookinglist as b on r.room_num=b.room_num "
		               +"where not( ? <= checkin_date or checkout_date <= ?))";

		      con = DBUtil.getConnection();
		      pstmt = con.prepareStatement(sql);
		      pstmt.setString(1, category);
		      pstmt.setInt(2, hotelNum);
		      pstmt.setString(3, checkOut);
		      pstmt.setString(4, checkIn);
		      rset = pstmt.executeQuery();
		      while(rset.next()) {
		         Map<String, String> hm = new HashMap<>();
		         hm.put("roomName",rset.getString("room_name"));
		         hm.put("maxGuestNum", Integer.toString(rset.getInt("max_guest_num")));
		         hm.put("price", Integer.toString(rset.getInt("price")));
		         hm.put("category",rset.getString("category"));
		         hm.put("checkIn",checkIn);
		         hm.put("checkOut",checkOut);
		         hm.put("roomNum", Integer.toString(rset.getInt("room_num")));
		         hm.put("hotelNum", Integer.toString(rset.getInt("hotel_num")));
//		         hm.put("hotelName", rset.getString("hotel_name"));
//		         hm.put("roomName", rset.getString("room_name"));
//		         hm.put("maxGuestNum", Integer.toString(rset.getInt("max_guest_num")));
//		         hm.put("price", Integer.toString(rset.getInt("price")));
//		         hm.put("roomState", rset.getString("room_state"));
		         list.add(hm);
		      }
		      System.out.println(list);
		      return list;
		   }
	
	
}
