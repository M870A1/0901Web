package membership;

import java.sql.SQLException;

import common.DBConnPool;

// DBConnPool을 상속받아 변수를 따로 선언하지 않아도 DB관련 객체를 자유롭게 사용할 수 있음
public class MemberDAO extends DBConnPool {
//	public MemberDAO(String drv,String url, String id, String pw) {
//		super(drv,url,id,pw);
//	}

	// 한명의 Member를 찾아서 MemberDTO에 담아 돌려주는 메서드, 로그인 처리
	public MemberDTO getMemberDTO(String uid, String upass) {
		// 반환값 설정
		MemberDTO dto = new MemberDTO();
		// SQL 작성
		String query = "SELECT * FROM member WHERE ID=? AND PASS=?";
		try {
			// SQL 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			// 데이터가 1건 검색된다면 실행되는 if문
			// 데이터가 없다면 dto의 모든 값은 null설정됨
			if (rs.next()) {
				dto.setId(rs.getString("ID"));
				dto.setPass(rs.getString("PASS"));
				dto.setName(rs.getString("NAME"));
				dto.setRegidate(rs.getDate("REGIDATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //자원 누수 예방조치
			try {
				if (rs != null)
					rs.close(); // rs가 null이 아니면 닫기
				if (psmt != null)
					psmt.close(); // psmt가 null이 아니면 닫기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 검색 결과 반환하는 return문
		return dto;
	}

	public int addMember(String id, String pass, String name) throws SQLException {
		int result = 0;
		String sql = "INSERT INTO member(ID,PASS,NAME,REGIDATE)" + " VALUES(?, ?, ?, sysdate)";

		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id); // 첫번째 ?의 값 설정
			psmt.setString(2, pass);// 두번째 ?의 값 설정
			psmt.setString(3, name);// 세번째 ?의 값 설정
			// executeUpdate() : INSERT, UPDATE, DELETE문을 실행하는 메서드
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원 추가 중 DB오류 발생" + e.getMessage());
			e.printStackTrace();
		} finally {//자원 누수 예방조치
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}