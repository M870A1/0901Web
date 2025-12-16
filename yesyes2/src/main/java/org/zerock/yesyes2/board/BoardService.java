package org.zerock.yesyes2.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.yesyes2.mappers.BoardMapper; // BoardMapper 임포트
import org.zerock.yesyes2.VO.BoardVO; // BoardVO 임포트

import java.util.List;
import java.util.Map;

@Service // Spring Service로 등록
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    // 게시글 작성
    public int writeBoard(BoardVO vo) {
        return boardMapper.insertBoard(vo);
    }

    // 게시글 상세 보기
    public BoardVO getBoard(int num) {
        // 조회수 증가
        boardMapper.updateVisitCount(num);
        // 게시글 정보 반환
        return boardMapper.getBoard(num);
    }
    
    // 게시글 수정
    public int updateBoard(BoardVO vo) {
        return boardMapper.updateBoard(vo);
    }
    
    // 게시글 삭제
    public int deleteBoard(int num) {
        return boardMapper.deleteBoard(num);
    }
    
    // 게시물 수 확인
    public int selectCount(Map<String, Object> map) {
        return boardMapper.selectCount(map);
    }
    
    // 게시글 목록 조회
    public List<BoardVO> getBoardList(Map<String, Object> map) {
        return boardMapper.getBoardList(map);
    }
}