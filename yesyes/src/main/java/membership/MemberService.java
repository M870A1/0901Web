package membership;



public class MemberService {

    public MemberDTO login(String id, String pass) {
        MemberDAO dao = new MemberDAO();
        MemberDTO dto = dao.getMemberDTO(id, pass);

        
        // DAO에서 반환된 DTO의 ID가 null이 아니면 로그인 성공
        if (dto != null && dto.getId() != null) {
            return dto;
        }
        return null;
    }

    public int register(MemberDTO dto) {
        MemberDAO dao = new MemberDAO();
        int result = 0;
        try {
            // MemberDAO의 addMember 메소드를 호출하여 회원 정보를 DB에 추가
            result = dao.addMember(dto);
        } catch (Exception e) {
            System.out.println("회원가입 서비스 처리 중 예외 발생");
            e.printStackTrace();
        } finally {

        }
        return result;
    }
}
