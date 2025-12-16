package org.zerock.yesyes2.membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.yesyes2.mappers.MemberMapper;

import org.zerock.yesyes2.VO.MemberVO;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public MemberDTO login(String id, String pass) {
        // MemberMapper는 MemberVO를 반환하므로, 이를 받아서 DTO로 변환
        MemberVO vo = memberMapper.getMemberVO(id, pass);

        if (vo != null && vo.getId() != null) {
            return MemberDTO.fromVO(vo); // VO를 DTO로 변환하여 반환
        }
        return null;
    }

    public int register(MemberDTO dto) {
        int result = 0;
        try {
            // MemberDTO를 MemberVO로 변환하여 Mapper에 전달
            MemberVO vo = MemberVO.fromDTO(dto);
            result = memberMapper.addMember(vo);
        } catch (Exception e) {
            System.out.println("회원가입 서비스 처리 중 예외 발생");
            e.printStackTrace();
        }
        return result;
    }
}
