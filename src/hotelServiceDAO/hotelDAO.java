package hotelServiceDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotelServiceDTO.hotelDTO;
import util.DBUtil;

public class hotelDAO {

	// 모든 게시물 조회
	public static ArrayList<hotelDTO> getAllContents() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<hotelDTO> alist = null;
		String sql = "select * from hotel";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			alist = new ArrayList<hotelDTO>();
			while (rset.next()) {
				alist.add(new hotelDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4),
						rset.getString(5), rset.getString(6)));
			}
			System.out.println(alist);
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return alist;
	}
}
