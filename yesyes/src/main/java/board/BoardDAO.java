package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.DBConnPool;

public class BoardDAO {

    // 게시글 목록 조회
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = new ArrayList<>();
        DBConnPool pool = new DBConnPool();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String query = "SELECT num, title, content, author, id, postdate, visitcount FROM board ORDER BY num DESC";

        try {
            con = pool.con;
            psmt = con.prepareStatement(query);
            rs = psmt.executeQuery();

            while (rs.next()) {
                BoardDTO dto = new BoardDTO();
                dto.setNum(rs.getInt("num"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setAuthor(rs.getString("author"));
                dto.setId(rs.getString("id"));
                dto.setPostdate(rs.getDate("postdate"));
                dto.setVisitcount(rs.getInt("visitcount"));
                boardList.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("게시글 목록 조회 중 오류 발생");
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
        return boardList;
    }

    // 새 게시글 추가
    public int insertBoard(BoardDTO dto) {
        DBConnPool pool = new DBConnPool();
        Connection con = null;
        PreparedStatement psmt = null;
        int result = 0;

        String sql = "INSERT INTO board (num, title, content, author, id, postdate, visitcount) "
                + "VALUES (seq_board_num.nextval, ?, ?, ?, ?, sysdate, 0)";

        try {
            con = pool.con;
            psmt = con.prepareStatement(sql);
            psmt.setString(1, dto.getTitle());
            psmt.setString(2, dto.getContent());
            psmt.setString(3, dto.getAuthor());
            psmt.setString(4, dto.getId());
            result = psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("게시글 추가 중 오류 발생");
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

    // 게시글 상세 보기
    public BoardDTO getBoard(int num) {
        BoardDTO dto = null;
        DBConnPool pool = new DBConnPool();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String query = "SELECT num, title, content, author, id, postdate, visitcount FROM board WHERE num = ?";

        try {
            con = pool.con;
            psmt = con.prepareStatement(query);
            psmt.setInt(1, num);
            rs = psmt.executeQuery();

            if (rs.next()) {
                dto = new BoardDTO();
                dto.setNum(rs.getInt("num"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setAuthor(rs.getString("author"));
                dto.setId(rs.getString("id"));
                dto.setPostdate(rs.getDate("postdate"));
                dto.setVisitcount(rs.getInt("visitcount"));
            }
        } catch (SQLException e) {
            System.out.println("게시글 상세 조회 중 오류 발생");
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
    
    // 조회수 1 증가
        public void updateVisitCount(int num) {
            DBConnPool pool = new DBConnPool();
            Connection con = null;
            PreparedStatement psmt = null;
    
            String sql = "UPDATE board SET visitcount = visitcount + 1 WHERE num = ?";
    
            try {
                con = pool.con;
                psmt = con.prepareStatement(sql);
                psmt.setInt(1, num);
                psmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("조회수 증가 중 오류 발생");
                e.printStackTrace();
            } finally {
                try {
                    if (psmt != null) psmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (pool != null) pool.close();
            }
        }
    
        // 게시글 수정
        public int updateBoard(BoardDTO dto) {
            DBConnPool pool = new DBConnPool();
            Connection con = null;
            PreparedStatement psmt = null;
            int result = 0;
    
            String sql = "UPDATE board SET title = ?, content = ? WHERE num = ?";
    
            try {
                con = pool.con;
                psmt = con.prepareStatement(sql);
                psmt.setString(1, dto.getTitle());
                psmt.setString(2, dto.getContent());
                psmt.setInt(3, dto.getNum());
                result = psmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("게시글 수정 중 오류 발생");
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
    
        // 게시글 삭제
            public int deleteBoard(int num) {
                DBConnPool pool = new DBConnPool();
                Connection con = null;
                PreparedStatement psmt = null;
                int result = 0;
        
                String sql = "DELETE FROM board WHERE num = ?";
        
                try {
                    con = pool.con;
                    psmt = con.prepareStatement(sql);
                    psmt.setInt(1, num);
                    result = psmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("게시글 삭제 중 오류 발생");
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
        
            // 검색 조건에 맞는 게시물의 개수를 반환합니다.
            public int selectCount(Map<String, Object> map) {
                int totalCount = 0;
                DBConnPool pool = new DBConnPool();
                Connection con = null;
                PreparedStatement psmt = null;
                ResultSet rs = null;
        
                String query = "SELECT COUNT(*) FROM board";
                if (map.get("searchWord") != null) {
                    query += " WHERE " + map.get("searchField") + " "
                           + " LIKE '%" + map.get("searchWord") + "%'";
                }
        
                try {
                    con = pool.con;
                    psmt = con.prepareStatement(query);
                    rs = psmt.executeQuery();
                    if (rs.next()) {
                        totalCount = rs.getInt(1);
                    }
                } catch (Exception e) {
                    System.out.println("게시물 카운트 중 예외 발생");
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
        
                return totalCount;
            }
        
            // 검색 조건에 맞는 게시물 목록을 반환합니다(페이징 기능 지원).
            public List<BoardDTO> getBoardList(Map<String, Object> map) {
                List<BoardDTO> boardList = new ArrayList<>();
                DBConnPool pool = new DBConnPool();
                Connection con = null;
                PreparedStatement psmt = null;
                ResultSet rs = null;
        
                String query = "SELECT * FROM ( "
                             + "    SELECT Tb.*, ROWNUM rNum FROM ( "
                             + "        SELECT * FROM board ";
        
                if (map.get("searchWord") != null) {
                    query += " WHERE " + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%' ";
                }
        
                query += "        ORDER BY num DESC "
                       + "    ) Tb "
                       + " ) "
                       + " WHERE rNum BETWEEN ? AND ?";
        
                try {
                    con = pool.con;
                    psmt = con.prepareStatement(query);
                    psmt.setString(1, map.get("start").toString());
                    psmt.setString(2, map.get("end").toString());
                    rs = psmt.executeQuery();
        
                    while (rs.next()) {
                        BoardDTO dto = new BoardDTO();
                        dto.setNum(rs.getInt("num"));
                        dto.setTitle(rs.getString("title"));
                        dto.setContent(rs.getString("content"));
                        dto.setAuthor(rs.getString("author"));
                        dto.setId(rs.getString("id"));
                        dto.setPostdate(rs.getDate("postdate"));
                        dto.setVisitcount(rs.getInt("visitcount"));
                        boardList.add(dto);
                    }
                } catch (Exception e) {
                    System.out.println("게시물 조회 중 예외 발생");
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
                return boardList;
            }
        }
        