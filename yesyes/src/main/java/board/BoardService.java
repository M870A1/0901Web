package board;

import java.util.List;
import java.util.Map;

public class BoardService {
    private BoardDAO boardDAO;

    public BoardService() {
        this.boardDAO = new BoardDAO();
    }

    // 게시글 목록 조회
    public List<BoardDTO> getBoardList() {
        return boardDAO.getBoardList();
    }

    // 게시글 작성
    public int writeBoard(BoardDTO dto) {
        
        return boardDAO.insertBoard(dto);
    }

    // 게시글 상세 보기
        public BoardDTO getBoard(int num) {
            // 조회수 증가
            boardDAO.updateVisitCount(num);
            // 게시글 정보 반환
            return boardDAO.getBoard(num);
        }
    
        // 게시글 수정
        public int updateBoard(BoardDTO dto) {
            return boardDAO.updateBoard(dto);
        }
    
        // 게시글 삭제
            public int deleteBoard(int num) {
                return boardDAO.deleteBoard(num);
            }
        
            // 게시물 수 확인
            public int selectCount(Map<String, Object> map) {
                return boardDAO.selectCount(map);
            }
            
            // 게시글 목록 조회
            public List<BoardDTO> getBoardList(Map<String, Object> map) {
                return boardDAO.getBoardList(map);
            }
        }
        