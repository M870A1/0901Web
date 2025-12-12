package org.zerock.yesyes2.membership;

import org.zerock.yesyes2.common.DBConnPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class MemberDAO {

    // 로그인 또는 회원 정보 조회
    public MemberDTO getMemberDTO(String uid, String upass) {
        MemberDTO dto = null;
        String query = "SELECT * FROM member WHERE ID=? AND PASS=?";

        try (Connection con = DBConnPool.getConnection();
             PreparedStatement psmt = con.prepareStatement(query)) {

            psmt.setString(1, uid);
            psmt.setString(2, upass);

            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    dto = new MemberDTO();
                    dto.setId(rs.getString("ID"));
                    dto.setPass(rs.getString("PASS"));
                    dto.setName(rs.getString("NAME"));
                    dto.setTel(rs.getString("TEL"));
                    dto.setEmail(rs.getString("EMAIL"));
                    dto.setGender(rs.getString("GENDER"));
                    dto.setDob(rs.getDate("DOB"));
                    dto.setRegidate(rs.getDate("REGIDATE"));
                }
            }
        } catch (Exception e) {   
            e.printStackTrace();
        }

        return dto;
    }

    // 회원 가입
    public int addMember(MemberDTO dto) {
        int result = 0;
        String sql = "INSERT INTO member(ID, PASS, NAME, TEL, EMAIL, GENDER, DOB, REGIDATE) "
                   + "VALUES(?, ?, ?, ?, ?, ?, ?, sysdate)";

        try (Connection con = DBConnPool.getConnection(); 
             PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setString(1, dto.getId());
            psmt.setString(2, dto.getPass());
            psmt.setString(3, dto.getName());
            psmt.setString(4, dto.getTel());
            psmt.setString(5, dto.getEmail());
            psmt.setString(6, dto.getGender());

            if (dto.getDob() != null) {
                psmt.setDate(7, dto.getDob());
            } else {
                psmt.setNull(7, java.sql.Types.DATE);
            }

            result = psmt.executeUpdate();

        } catch (Exception e) {  
            e.printStackTrace();
        }

        return result;
    }
}
