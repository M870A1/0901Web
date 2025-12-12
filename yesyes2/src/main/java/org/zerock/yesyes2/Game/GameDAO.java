package org.zerock.yesyes2.Game;

import org.zerock.yesyes2.common.DBConnPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class GameDAO {

    // 특정 카테고리의 게임 목록 조회
    public List<GameDTO> getGameList(String category, int count) {
        List<GameDTO> gameList = new ArrayList<>();
        String sql = "SELECT * FROM GAMES WHERE CATEGORY = ? "
                   + "ORDER BY REG_DATE DESC "
                   + "OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";

        try (Connection con = DBConnPool.getConnection();
             PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setString(1, category);
            psmt.setInt(2, count);

            try (ResultSet rs = psmt.executeQuery()) {
                while (rs.next()) {
                    GameDTO dto = new GameDTO(
                            rs.getString("GAME_ID"),
                            rs.getString("TITLE"),
                            rs.getString("DESCRIPTION"),
                            rs.getString("IMAGE_PATH"),
                            rs.getString("LINK_URL"),
                            rs.getString("CATEGORY"),
                            rs.getDate("REG_DATE")
                    );
                    gameList.add(dto);
                }
            }
        } catch (Exception e) {
            System.out.println("게임 목록 조회 중 예외 발생");
            e.printStackTrace();
        }

        return gameList;
    }

    // 새로운 게임을 등록하는 메소드
    public int insertGame(GameDTO dto) {
        int result = 0;
        String sql = "INSERT INTO GAMES (GAMEID, TITLE, DESCRIPTION, IMAGE_PATH, LINK_URL, CATEGORY, REG_DATE) "
                   + "VALUES (?, ?, ?, ?, ?, ?, SYSDATE)";

        try (Connection con = DBConnPool.getConnection();
             PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setString(1, dto.getGameId());
            psmt.setString(2, dto.getTitle());
            psmt.setString(3, dto.getDescription());
            psmt.setString(4, dto.getImagePath());
            psmt.setString(5, dto.getLinkUrl());
            psmt.setString(6, dto.getCategory());

            result = psmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("게임 등록 중 예외 발생");
            e.printStackTrace();
        }

        return result;
    }
}
