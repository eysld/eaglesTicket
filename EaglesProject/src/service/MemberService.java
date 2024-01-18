package service;

import java.util.List;

import controller.MainController;
import dao.MemberDao;
import util.ScanUtil;
import vo.MemberVo;

public class MemberService {
	private static MemberService instance = null;

	private MemberService() {

	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}

	MemberDao dao = MemberDao.getInstance();
	
	// 로그인
	public boolean login(List<Object> param) {
		MemberVo user = dao.login(param);
		if (user != null) {
			MainController.sessionStorage.put("user", user);
			return true;
		}
		return false;
	}
	
	// 회원가입
	public void memInsert(List<Object> param) {
		dao.memInsert(param);
	}
	
	// 회원 비밀번호 변경
	public void pwUpdate(List<Object> param) {
		dao.pwUpdate(param);
	}
	
	// 비밀번호 확인
	public boolean memPassCheck() {
		String pass = ScanUtil.nextLine("패스워드를 입력하세요. ");
		MemberVo user = (MemberVo) MainController.sessionStorage.get("user");
		String memPass = user.getMem_pw();
		if (pass.equals(memPass)) {
			System.out.println("\r본인확인이 완료되었습니다");
			return true;
		}

		return false;
	}
	
	// 회원 연락처 수정
	public void phoneUpdate(List<Object> param) {
		dao.phoneUpdate(param);
	}
	
	// 회원 탈퇴
	public void memDelete(int memNo) {
		dao.memDelete(memNo);
	}

	public MemberVo myMemList(List<Object> param) {
		return dao.myMemList(param);
	}

	public List<MemberVo> memList() {
		return dao.memList();
	}
	
}
