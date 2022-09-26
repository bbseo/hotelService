package hotelServiceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import util.DBUtil;

public class LoginDAO {
	
	public static boolean login(String id, String pwd) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		String sql = "select member_pw from member where member_id=?";
		
		con = DBUtil.getConnection();
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			if(rset.getString(1).equals(pwd)) {
				result = true;
			}
		}
		
		return result;
	}
}
