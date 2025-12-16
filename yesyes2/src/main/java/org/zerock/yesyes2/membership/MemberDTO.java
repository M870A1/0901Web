package org.zerock.yesyes2.membership;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import org.zerock.yesyes2.VO.MemberVO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String tel;
	private String email;
	private String gender;
	private Date dob;
	private Date regidate;

    public static MemberDTO fromVO(MemberVO vo) {
        if (vo == null) {
            return null;
        }
        return MemberDTO.builder()
                .id(vo.getId())
                .pass(vo.getPass())
                .name(vo.getName())
                .tel(vo.getTel())
                .email(vo.getEmail())
                .gender(vo.getGender())
                .dob(vo.getDob())
                .regidate(vo.getRegidate())
                .build();
    }
}

