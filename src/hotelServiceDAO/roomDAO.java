package hotelServiceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotelServiceDTO.roomDTO;
import util.DBUtil;

public class roomDAO {
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
	//		private int roomNum;
	//		private int hotelnum;
	//		private String roomName;
	//		private String roomimage;
	//		private String roomState;
	//		private int gurestNum;
	//		private int maxGuestNum;
	//		private int price;
	//		private String category;
			System.out.println("room"+alist);
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return alist;
}
}
