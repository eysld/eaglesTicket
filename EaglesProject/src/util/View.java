package util;

public enum View {
	
	MAIN,						// 홈	
	MEMBER,						// 회원
	ADMIN,						// 관리자
	LOGIN,						// 로그인
	MEM_INSERT, 				// 회원가입
	EAT_IS_HAPPY,				// 응원도 식후경
	RESTAURANT,					// 식당(구장밖)
	FOODCOURT,					// 푸드코트(구장내)
	
	
	MYPAGE,						// 마이페이지
	MEM_UPDATE,					// 회원정보 수정
	MEM_UPDATE_PASS_CHECK,		// 비밀번호 확인
	MEM_DELETE,					// 회원탈퇴
	
	GAME_LIST,					// 경기내역 조회
	MEM_TICKETING,				// 자리 예매
	MEM_TICKETING_LIST,			// 예매 티켓 조회
	MEM_TICKETING_DELETE,		// 예매 취소
	MEM_PAY,					// 결제
	
	SEAT_LIST,					// 좌석 리스트
	SEAT_ONEBASE,				// 1루 좌석
	SEAT_THREEBASE,				// 3루 좌석
	SEAT_OUTFIELD,				// 외야 좌석

	RES_LIST,					// 식당 리스트
	RES_DETAIL,					// 식당 상세조회
	RES_SEARCH,					// 식당 검색

	FCT_LIST,					// 푸드코트 리스트
	FCT_DETAIL,					// 푸드코트 상세조회
	FCT_SEARCH,					// 푸드코트 검색

	ADMIN_GAME_UPDATE,			// 경기정보 수정
	ADMIN_MEM_LIST				// 회원 리스트 조회
	
	
	
}
