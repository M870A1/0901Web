package org.zerock.yesyes2.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zerock.yesyes2.VO.BoardVO; // BoardDTO 대신 BoardVO 임포트
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    // 새 게시글 추가
    int insertBoard(BoardVO vo);

    // 게시글 상세 보기
    BoardVO getBoard(int num);

    // 조회수 증가
    void updateVisitCount(int num);

    // 게시글 수정
    int updateBoard(BoardVO vo);

    // 게시글 삭제
    int deleteBoard(int num);

    // 전체 게시글 수 조회
    int selectCount(Map<String, Object> map);

    // 검색 기준 게시글 목록 조회
    List<BoardVO> getBoardList(Map<String, Object> map);
}
