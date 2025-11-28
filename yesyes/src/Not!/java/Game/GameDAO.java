package Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBConnPool;

public class GameDAO {

	// 특정 카테고리의 게임 목록을 불러오는 메소드
	public List<GameDTO> getGameList(String category) {
		List<GameDTO> gameList = new ArrayList<>();
		
		// DBConnPool을 사용하여 Connection 객체 얻기
		DBConnPool pool = new DBConnPool();
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		// SQL 쿼리문 작성
		String sql = "SELECT * FROM GAMES WHERE CATEGORY = ? ORDER BY REG_DATE DESC";

		try {
			con = pool.con; // 커넥션 풀에서 연결 가져오기
			
			// PreparedStatement 객체 생성
			psmt = con.prepareStatement(sql);
			
			// SQL 쿼리의 '?' 파라미터에 값을 설정
			psmt.setString(1, category);
			
			// 쿼리 실행 및 ResultSet 객체 반환
			rs = psmt.executeQuery();

			// ResultSet의 결과를 반복하며 List<GameDTO>에 추가
			while (rs.next()) {
				// GameDTO 객체를 생성하고 ResultSet의 데이터로 초기화
				GameDTO dto = new GameDTO(
					rs.getString("GAME_ID"),
					rs.getString("TITLE"),
					rs.getString("DESCRIPTION"),
					rs.getString("IMAGE_PATH"),
					rs.getString("LINK_URL"),
					rs.getString("CATEGORY"),
					rs.getDate("REG_DATE")
				);
				
				// 리스트에 DTO 객체 추가
				gameList.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게임 목록 조회 중 예외 발생");
			e.printStackTrace();
		} finally {
			// 사용한 리소스 반납 (ResultSet, PreparedStatement)
			// Connection은 커넥션 풀에 의해 관리되므로 여기서 닫지 않을 수 있다.
			// DBConnPool의 close() 메소드가 모든 것을 처리한다면 그에 맞게 조정
			try {
                if (rs != null) rs.close();
                if (psmt != null) psmt.close();
				pool.close(); // DBConnPool의 정책에 따라 호출 여부 결정
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}
		
		return gameList;
	}

	// 새로운 게임을 추가하는 메소드 (관리자 기능)
	public int insertGame(GameDTO dto) {
		int result = 0;
		DBConnPool pool = new DBConnPool();
		Connection con = null;
		PreparedStatement psmt = null;
		
		// INSERT SQL 쿼리문을 작성
		String sql = "INSERT INTO GAMES (GAMEID, TITLE, DESCRIPTION, IMAGE_PATH, LINK_URL, CATEGORY, REG_DATE)"
				+ " VALUES (?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			con = pool.con;
			psmt = con.prepareStatement(sql);
			
			// SQL 쿼리의 '?' 파라미터에 DTO 객체의 값 설정
			psmt.setString(1, dto.getGameId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getDescription());
			psmt.setString(4, dto.getImagePath());
			psmt.setString(5, dto.getLinkUrl());
			psmt.setString(6, dto.getCategory());

			// 쿼리 실행 및 결과 반환 (삽입된 행의 수)
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("게임 등록 중 예외 발생");
			e.printStackTrace();
		} finally {
			try {
                if (psmt != null) psmt.close();
				// pool.close(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}
		
		return result;
	}

	// 게임 정보 수정(UPDATE), 삭제(DELETE) 메소드를 추가로 구현
	
}