package org.zerock.yesyes2.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date; // java.sql.Date 임포트

import org.zerock.yesyes2.membership.MemberDTO;

@Getter
@ToString
@AllArgsConstructor // 모든 필드를 포함하는 생성자
// @NoArgsConstructor // 제거: 중복 생성자 오류의 원인
@Builder // 빌더 패턴 사용

// VO : DB에서 데이터를 꺼낼때 사용하는 객체
// 데이터를 꺼내는 용도로 사용하기 때문에 Setter를 구현하지 않음
// 테이블의 열과 변수가 1대1로 매칭되록 작성

public class MemberVO {
    private String id;
    private String pass;
    private String name;
    private String tel;
    private String email;
    private String gender;
    private Date dob;
    private Date regidate;

    public static MemberVO fromDTO(MemberDTO dto) {
        if (dto == null) {
            return null;
        }
        return MemberVO.builder()
                .id(dto.getId())
                .pass(dto.getPass())
                .name(dto.getName())
                .tel(dto.getTel())
                .email(dto.getEmail())
                .gender(dto.getGender())
                .dob(dto.getDob())
                .regidate(dto.getRegidate())
                .build();
    }
}
