package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnPool;

public class MemberDAO {

	public MemberDTO getMemberDTO(String uid, String upass) {
		DBConnPool pool = new DBConnPool();
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MemberDTO dto = new MemberDTO();
		
		String query = "SELECT * FROM member WHERE ID=? AND PASS=?";
		try {
			con = pool.con;
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString("ID"));
				dto.setPass(rs.getString("PASS"));
				dto.setName(rs.getString("NAME"));
				dto.setTel(rs.getString("TEL"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setGender(rs.getString("GENDER"));
				dto.setDob(rs.getDate("DOB"));
				dto.setRegidate(rs.getDate("REGIDATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close(); 
				if (psmt != null) psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (pool != null) pool.close();
		}
		return dto;
	}

	public int addMember(MemberDTO dto) {
		DBConnPool pool = new DBConnPool();
		Connection con = null;
		PreparedStatement psmt = null;
		int result = 0;
		
		String sql = "INSERT INTO member(ID, PASS, NAME, TEL, EMAIL, GENDER, DOB, REGIDATE) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, sysdate)";

		try {
			con = pool.con;
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getTel());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, dto.getGender());
			if (dto.getDob() != null) {
				psmt.setDate(7, dto.getDob());
			} else {
				psmt.setNull(7, java.sql.Types.DATE);
			}
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원 추가 중 DB오류 발생: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (pool != null) pool.close();
		}
		return result;
	}
}