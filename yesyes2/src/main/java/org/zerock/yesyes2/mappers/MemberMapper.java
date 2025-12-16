package org.zerock.yesyes2.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zerock.yesyes2.VO.MemberVO; // MemberDTO 대신 MemberVO 임포트

@Mapper
public interface MemberMapper {
    // 로그인 또는 회원 정보 조회
    MemberVO getMemberVO(@Param("id") String id, @Param("pass") String pass); // MemberDTO -> MemberVO 변경

    // 회원 가입
    int addMember(MemberVO vo);
}
