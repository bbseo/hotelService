package hotelServiceDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotelServiceDTO.bookingListDTO;
import hotelServiceDTO.memberDTO;
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
}
