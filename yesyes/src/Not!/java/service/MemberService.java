package service;

import membership.MemberDAO;
import membership.MemberDTO;

public class MemberService {

	// MemberDAO를 서비스에서 공통으로 사용
	private MemberDAO dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	// 로그인 시 사용
	public MemberDTO getMember(String id, String pass) {
		return dao.getMemberDTO(id, pass);
	}

	// 회원가입 시 사용
	public boolean registerMember(String id, String pass, String name) throws Exception {
		int result = dao.addMember(id, pass, name);
		return (result > 0);
	}
}
