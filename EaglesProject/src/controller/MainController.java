package controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.MemberService;
import service.RestaurantService;
import service.TicketService;
import util.ScanUtil;
import util.View;
import view.EaglesPrint;
import vo.GameVo;
import vo.MemberVo;
import vo.RestaurantVo;
import vo.TicketVo;

public class MainController extends EaglesPrint {
	
	static public Map<String, Object> sessionStorage = new HashMap<>();
	
	MemberService memberService = MemberService.getInstance();
	TicketService ticketService = TicketService.getInstance();
	RestaurantService restaurantService = RestaurantService.getInstance();

	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.MAIN;
		while (true) {
			switch (view) {
			case MAIN:
				view = home();
				break;
			case LOGIN:
				view = login();
				break;
			case MEMBER:
				view = member();
				break;
			case ADMIN:
				view = admin();
				break;
			case GAME_LIST:
				view = gameList();
				break;
			case MEM_INSERT:
				view = memInsert();
				break;
			case MEM_TICKETING:
				view = memTicketing();
				break;
			case MEM_TICKETING_LIST:
				view = memTicketingList();
				break;
			case MEM_TICKETING_DELETE:
				view = memTicketingDelete();
				break;
			case MYPAGE:
				view = myPage();
				break;
			case MEM_UPDATE:
				view = memUpdate();
				break;
			case MEM_DELETE:
				view = memDelete();
				break;
			case MEM_UPDATE_PASS_CHECK:
				view = memUpdatePassCheck();
				break;
			case SEAT_LIST:
				view = seatList();
				break;
			case ADMIN_GAME_UPDATE:
				view = adminGameUpdate();
				break;
			case ADMIN_MEM_LIST:
				view = adminMemList();
				break;
			case EAT_IS_HAPPY:
				view = eatIsHappy();
				break;
			case RESTAURANT:
				view = restaurant();
				break;
			case FOODCOURT:
				view = foodcourt();
				break;
			case RES_LIST:
				view = resList();
				break;
			case RES_SEARCH:
				view = resSearch();
				break;
			case FCT_LIST:
				view = fctList();
				break;
			case FCT_SEARCH:
				view = fctSearch();
				break;
			default:
				break;
			}
		}
	}

	private View home() {

		// 로고 출력
		printLogo();
		printHome();

		int sel = ScanUtil.menu0();
		switch (sel) {
		case 1:
			return View.LOGIN;
		case 2:
			return View.MEM_INSERT;
		default:
			return View.MAIN;
		}
	}

// ------------------------------ 회원--------------------------------------------------------	
	private View member() {
		printMember();
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.GAME_LIST;
		case 2:
			return View.MEM_TICKETING;
		case 3:
			return View.MEM_TICKETING_LIST;
		case 4:
			return View.EAT_IS_HAPPY;
		case 5:
			return View.MYPAGE;
		case 6:
			return View.MAIN;
		default:
			return View.MEMBER;
		}
	}

	// 로그인
	private View login() {
		printLn(2);
		
		String id =   ScanUtil.nextLine("아이디    : ");
		String pass = ScanUtil.nextLine("비밀번호 : ");
		printLn(1);

		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);

		// 로그인 성공여부
		boolean loginPass = memberService.login(param);
		// 로그인 성공했다면
		if (loginPass) {
			MemberVo user = (MemberVo) sessionStorage.get("user");
			// 가져온 회원의 회원번호가 0이면 관리자이므로 관리자 화면으로 이동
			if (user.getMem_no() == 0)
				return View.ADMIN;
			// 0이 아니면 회원화면으로 이동
			return View.MEMBER;
		}
		// 로그인 실패했다면
		System.out.println("존재하지 않는 ID 입니다. 다시 확인해주세요");
		try {
		      for (int i = 0; i < 2; i++) {
		        Thread.sleep(1000);
		      }
		    } catch (Exception e) {
		    }
		return View.MAIN;
	}

	// 회원가입 페이지
	private View memInsert() {
		// 각각의 가입 회원 정보를 입력
		printLongVar2();
		printLn(1);
		System.out.println(" ⚾ 회원가입 페이지 \r");
		String id = ScanUtil.nextLine("ID >> \r");
		String pw = ScanUtil.nextLine("PW >> \r");
		String name = ScanUtil.nextLine("이름 >> \r");
		String birth = ScanUtil.nextLine("생년월일(YYYYMMDD) >> \r");
		String phone = ScanUtil.nextLine("전화번호 >> ");
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pw);
		param.add(name);
		param.add(birth);
		param.add(phone);

		memberService.memInsert(param);

		System.out.println("");
		System.out.println(name + "님 한화이글스 가입을 환영합니다! \r");
		String en = ScanUtil.nextLine(" ◁ 홈으로 돌아가려면 엔터를 눌러주세요 ▷ ");
		return View.MAIN;
	}

	// 마이페이지
	private View myPage() {

		MemberVo user = (MemberVo) sessionStorage.get("user");
		String id = user.getMem_id();
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		MemberVo memMylist = memberService.myMemList(param);
		Date birth = memMylist.getMem_birth();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String str_birth = sdf.format(birth);
		printLn(14);
		printMenuVar1();
		printLn(1);
		System.out.println("👤 "+memMylist.getMem_name()+"\r");
		System.out.println("ID: " + memMylist.getMem_id() + "\n" + "생년월일: "
				+ str_birth + "\n" + "전화번호: " + memMylist.getMem_phone());
		printLn(1);
		printLn(2);
		printMypage();
		printLn(8);
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEM_UPDATE_PASS_CHECK;
		case 2:
			return View.MEM_DELETE;
		case 3:
			return View.MAIN;
		case 4:
			return View.MEMBER;
		}
		System.out.println("잘못 입력 하셨습니다. 다시 선택해주세요");
		return myPage();
	}

	// 회원정보 수정시 비밀번호 확인
	private View memUpdatePassCheck() {
		boolean passCheck = memberService.memPassCheck();

		if (passCheck != true) {
			System.out.println("1. 다시 입력");
			System.out.println("2. 홈");
			int sel = ScanUtil.menu();
			if (sel == 1)
				return View.MEM_UPDATE_PASS_CHECK;
			if (sel == 2)
				return View.MEMBER;
		}

		return View.MEM_UPDATE;
	}

	// 회원정보 수정
	private View memUpdate() {
		MemberVo user = (MemberVo) sessionStorage.get("user");
		String id = user.getMem_id();
		printUpdate();
		int sel = ScanUtil.menu();

		if (sel == 1) {
			printLn(1);
			String pw = ScanUtil.nextLine("변경하실 비밀번호를 입력하세요 >> ");
			List<Object> param = new ArrayList();
			param.add(pw);
			param.add(id);
			memberService.pwUpdate(param);
		}
		if (sel == 2) {
			printLn(1);
			String phone = ScanUtil.nextLine("변경하실 전화번호를 입력하세요 >> ");
			List<Object> param = new ArrayList();
			param.add(phone);
			param.add(id);
			memberService.phoneUpdate(param);
			System.out.println("전화번호가 변경되었습니다.");
		}
		if (sel == 3)
			return View.MYPAGE;
		return View.MYPAGE;
	}

	// 회원탈퇴
	private View memDelete() {
		MemberVo user = (MemberVo) sessionStorage.get("user");
		int memNo = user.getMem_no();
		String del = ScanUtil.nextLine("탈퇴를 원하시면(y)/ 아니면(n)를 입력해주세요 >> ");

		if (del.equalsIgnoreCase("n"))
			return View.MYPAGE;
		if (del.equalsIgnoreCase("y")) {
			boolean passCheck = memberService.memPassCheck();
			while (true) {
				if (passCheck != true) {
					System.out.println("1. 다시 입력");
					System.out.println("2. 마이페이지");
					int sel = ScanUtil.menu();
					if (sel == 1)
						passCheck = memberService.memPassCheck();
					if (sel == 2)
						return View.MYPAGE;
				} else if (passCheck == true) {
					memberService.memDelete(memNo);
					System.out.println("정상 탈퇴 처리 되었습니다.");
					break;
				}
			}
		}
		return View.MAIN;
	}
// --------------------------------관리자------------------------------------------------------

	private View admin() {
		printLongVar();
		printLn(4);
		printAdminImage();
		System.out.println("\t < 관리자 >");
		printAdmin();
		printLn(5);
		printLongVar2();
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.ADMIN_GAME_UPDATE;
		case 2:
			return View.ADMIN_MEM_LIST;
		case 3:
			return View.MAIN;
		}
		System.out.println("잘못 입력 하셨습니다. 다시 선택해주세요");
		return admin();
	}

	// 관리자 회원목록 조회
	private View adminMemList() {
		printMemList();
		String en = ScanUtil.nextLine("\r\r ※ 돌아가려면 엔터를 눌러주세요 ※");
		return View.ADMIN;
	}

	// 관리자 경기내용 수정
	private View adminGameUpdate() {
		int page = 1;
		if (MainController.sessionStorage.containsKey("page")) {
			page = (int) MainController.sessionStorage.get("page");
		}
		int start = 1 + (page - 1) * 6;
		int end = page * 6;
		int max = 27;

		List<Object> params = new ArrayList();
		params.add(start);
		params.add(end);
		List<GameVo> list = ticketService.gameList(params);
		printLn(2);
		printGameUpdate(list);
		printLn(2);
		System.out.println("1. 이전페이지\r");
		System.out.println("2. 다음페이지\r");
		System.out.println("3. 경기정보 수정\r");
		printLongVar2();
		int sel = ScanUtil.menu();
		if (sel == 1) {
			page = page - 1;
			if (page < 1)
				page = 1;
			MainController.sessionStorage.put("page", page);
		}
		if (sel == 2) {
			if (end < max)
				page = page + 1;
			MainController.sessionStorage.put("page", page);
		}
		if (sel == 3) {
			int no = ScanUtil.nextInt("변경할 경기번호를 선택하세요 >> ");
			String result = ScanUtil.nextLine("승/패/취소 중 하나를 입력하세요 >> ");
			List<Object> param = new ArrayList();
			param.add(result);
			ticketService.gameUpdate(param, no);
			System.out.println("\r경기 내용이 정상적으로 수정되었습니다.");
			String en = ScanUtil.nextLine("\r\r ※ 돌아가려면 엔터를 눌러주세요 ※");
			
			return View.ADMIN;
		}
		return View.ADMIN_GAME_UPDATE;
	}

// --------------------------------티켓예매--------------------------------------------------

	// 전체 경기 내역 조회
	private View gameList() {
		int page = 1;
		if (MainController.sessionStorage.containsKey("page")) {
			page = (int) MainController.sessionStorage.get("page");
		}
		int start = 1 + (page - 1) * 6;
		int end = page * 6;
		int max = 27;
		List<Object> param = new ArrayList();
		param.add(start);
		param.add(end);

		List<GameVo> gameList = ticketService.gameList(param);
		printLongVar();
		printLn(5);
		System.out.println("\t\t\t\t\t◈ 전체경기조회◈");
		printLn(3);
		printGameList(gameList);
		int sel = ScanUtil.menu();
		if (sel == 1) {
			page = page - 1;
			if (page < 1)
				page = 1;
			MainController.sessionStorage.put("page", page);
		}
		if (sel == 2) {
			if (end < max)
				page = page + 1;
			MainController.sessionStorage.put("page", page);
		}
		if (sel == 3)
			return View.MEMBER;
		return View.GAME_LIST;
	}

	// 회원 티켓예매
	private View memTicketing() {
		printLongVar();
		printSlogan();
		printTicketList();
		System.out.println("※ 티켓은 경기날짜를 기준으로 일주일 전 오픈됩니다. ");
		printLn(2);
		printAvailGameList();
		int gameNo = ScanUtil.nextInt("예매할 경기번호를 선택해주세요. ");
		sessionStorage.put("gameNo", gameNo);
		return View.SEAT_LIST;
	}

	// 선택한 날짜의 좌석조회
	private View seatList() {
		// 경기날짜 가져오기
		int gameNo = (int) sessionStorage.get("gameNo");
		// 선택한 좌석들을 담을 리스트
		List<List<Object>> list = new ArrayList<List<Object>>();
		// 해당 경기의 좌석현황
		printSeatList(gameNo);
		printLn(1);
		printAreaMenu();
		int area = ScanUtil.menu();
		// 구역 저장
		sessionStorage.put("area", area);
		if (area == 1) {
			printLn(14);
			System.out.println("\t [1루] \n");
			ticketService.seatList(1, gameNo);
			printSeatMenu(list);

		}
		if (area == 2) {
			printLn(14);
			System.out.println("\t [3루] \n");
			ticketService.seatList(2, gameNo);
			printSeatMenu(list);
		}
		if (area == 3) {
			printLn(14);
			System.out.println("\t [외야] \n");
			ticketService.seatList(3, gameNo);
			printSeatMenu(list);
		}
		if (area == 4) {
			return View.MEMBER;
		}
		// 결제가 완료될 때까지 좌석선택
		A: while (true) {
			printLongVar();
			printLn(1);
			System.out.println(" 현재 선택한 좌석목록 ");
			for (int i = 0; i < list.size(); i++) {
				List<Object> ticketList = list.get(i);
				printSelectSeatList(ticketList);
			}

			printSeatSel();
			int sel = ScanUtil.menu();
			switch (sel) {
			case 1:
				
				printSeatList(gameNo);
				printAreaMenu();
				area = ScanUtil.menu();
				sessionStorage.put("area", area);
				if (area == 1) {
					printLn(2);
					System.out.println("\t [1루] \n");
					ticketService.seatList(1, gameNo);
					printSeatMenu(list);

				}
				if (area == 2) {
					printLn(2);
					System.out.println("\t [3루] \n");
					ticketService.seatList(2, gameNo);
					printSeatMenu(list);
				}
				if (area == 3) {
					printLn(2);
					System.out.println("\t [외야] \n");
					ticketService.seatList(3, gameNo);
					printSeatMenu(list);
				}
				if (area == 4) {
					return View.MEMBER;
				}
				break;
			case 2:
				printLn(20);
				printLongVar();
				printLn(2);
				System.out.println("선택된 좌석 ");
				for (int i = 0; i < list.size(); i++) {
					List<Object> ticketList = list.get(i);
					printSelectSeatList(ticketList);
				}
				// 유저정보를 꺼내와서
				MemberVo user = (MemberVo) sessionStorage.get("user");
				int memNo = user.getMem_no();
				printLn(3);
				String yn = ScanUtil.nextLine(" 결제진행[y] / 취소[n] ");
				if (yn.equalsIgnoreCase("y")) { // 결제가 진행되면 예매한 좌석들을 테이블에 저장
					Map<String, Object> pay = ticketService.getPayNo();
					BigDecimal payNo = (BigDecimal) pay.get("PAY_NO");
					List<Object> param = new ArrayList<Object>();
					
					List<Object> reserve = new ArrayList<Object>();
					param.add(payNo);
					param.add(memNo);
					reserve.add(memNo);
					reserve.add(payNo);
					ticketService.pay(param);
					for (int i = 0; i < list.size(); i++) {
						ticketService.ticketing(list.get(i), payNo);
					}
					printLn(2);
					System.out.println(" ⚾ 결제가 완료되었습니다. ⚾");
					printLn(2);
					
					printReservationListByPay(reserve);
					printLn(1);
					String home = ScanUtil.nextLine("◁ 홈으로 돌아가시려면 엔터를 눌러주세요 ▷");
					printLn(1);
				} else if (yn.equalsIgnoreCase("n")) { // 결제가 취소되면 예매화면으로 이동
					System.out.println("결제가 취소되었습니다. ");
					return View.MEMBER;
				}
				break A;
			case 3:
				return View.MEM_TICKETING;
			default:
				return View.MEM_TICKETING;
			}
		}
		return View.MEMBER;
	}

	// 예매내역 조회
	private View memTicketingList() {
		MemberVo user = (MemberVo) sessionStorage.get("user");
		int memNo = user.getMem_no();
		printLongVar();
		printLn(2);
		System.out.println("1. 예매내역 조회\r\r");
		System.out.println("2. 예매취소\r\r");
		System.out.println("3. 메인\r\r");
		printLongVar2();
		int sel = ScanUtil.menu();
		if (sel == 1) {
			printReservationList(memNo);
		}
		if (sel == 2) {

			return View.MEM_TICKETING_DELETE;
		}
		if (sel == 3) {
			return View.MEMBER;
		}

		return View.MEM_TICKETING_LIST;
	}

	// 예매취소
	private View memTicketingDelete() {

		MemberVo user = (MemberVo) sessionStorage.get("user");
		int memNo = user.getMem_no();
		printLn(2);
		System.out.println("1. 예매별 취소\r\r");
		System.out.println("2. 좌석별 취소\r\r");
		System.out.println("3. 돌아가기\r\r");
		int no = ScanUtil.menu();
		if (no == 1) {
			printReservationList(memNo);
			printLn(1);
			printLongVar2();
			printLn(1);
			int payNo = ScanUtil.nextInt("취소시킬 예매번호를 선택해주세요.");
			printLn(2);
			String yn = ScanUtil.nextLine(" 예매번호 " +green+ payNo+exit + "번의 취소를 원하면 [y]\r 돌아가려면 [n]을 눌러주세요 >>");
			printLn(10);
			if (yn.equalsIgnoreCase("n"))
				return View.MEM_TICKETING_LIST;
			if (yn.equalsIgnoreCase("y")) {
				ticketService.ticketDelete(payNo);
				printLn(1);
				System.out.println("선택한 예매번호의 취소가 완료되었습니다. ");
			}
		}
		if (no == 2) {
			printReservationList(memNo);
			printLn(4);
			int ticketPayNo = ScanUtil.nextInt("취소시킬 예매번호를 선택해주세요.");
			printLn(10);
			List<Object> param = new ArrayList<Object>();
			param.add(memNo);
			param.add(ticketPayNo);
			printReservationListByPay(param);
			int ticketNo = ScanUtil.nextInt("취소할 좌석번호를 선택해주세요. ");
			printLn(2);
			String yn = ScanUtil.nextLine(" 좌석번호 "  +green+ ticketNo+exit + "번의 취소를 원하면 [y]\r 돌아가려면 [n]을 눌러주세요 >>");
			printLn(10);
			if (yn.equalsIgnoreCase("n"))
				return View.MEM_TICKETING_LIST;
			if (yn.equalsIgnoreCase("y")) {
				ticketService.ticketDeleteBySeat(ticketNo);
				System.out.println("선택한 좌석번호의 취소가 완료되었습니다. ");
			}
		}
		return View.MEM_TICKETING_LIST;
	}

// --------------------------------식당조회--------------------------------------------------

	private View eatIsHappy() {
		printRes();
		int sel = ScanUtil.menu();

		switch (sel) {
		case 1:
			return View.RESTAURANT;
		case 2:
			return View.FOODCOURT;
		case 3:
			return View.MEMBER;
		}
		return eatIsHappy();
	}

	// 구장 안 식당메뉴
	private View restaurant() {
		printOutsideRes();
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.RES_LIST;
		case 2:
			return View.RES_SEARCH;
		case 3:
			return View.MEMBER;
		default:
			return View.RESTAURANT;
		}
	}

	// 구장 밖 식당 리스트
	private View resList() {
		int page = 1;
		if (MainController.sessionStorage.containsKey("page")) {
			page = (int) MainController.sessionStorage.get("page");
		}
		int start = 1 + (page - 1) * 6;
		int end = page * 6;
		int max = 30;
		List<Object> param = new ArrayList();
		param.add(start);
		param.add(end);

		List<RestaurantVo> resList = restaurantService.resList(param);
		printResList(resList);
		int sels = ScanUtil.menu();
		if (sels == 1) {
			page = page - 1;
			if (page < 1)
				page = 1;
			MainController.sessionStorage.put("page", page);
		}
		if (sels == 2) {
			if (end < max)
				page = page + 1;
			MainController.sessionStorage.put("page", page);
		}
		if (sels == 3) {
			int rn = ScanUtil.nextInt("상세조회할 식당번호");
			RestaurantVo rv = restaurantService.getResNo(rn);
			String resNo = rv.getRes_no();
			List<RestaurantVo> dList = restaurantService.resDetail(resNo);
			printResDetail(dList);
			String en = ScanUtil.nextLine("◁ 돌아가시려면 엔터를 눌러주세요 ▷");
		}
		if (sels == 4)
			return View.RESTAURANT;
		return View.RES_LIST;
	}

	// 구장 밖 식당검색
	private View resSearch() {
		printLongVar();
		printLn(13);
		System.out.println("1. 카테고리 검색\r\r\r");
		System.out.println("2. 가게이름 검색\r\r\r");
		System.out.println("3. 돌아가기\r\r\r");
		printLn(13);
		printLongVar2();
		int sel = ScanUtil.menu();
		if (sel == 1) {
			String ctg = ScanUtil
					.nextLine("A: 한식\tB: 중식\tC: 일식\tD: 양식\tE: 분식\tF: 치킨\tG: 고기\tH: 패스트푸드   I: 카페\r카테고리 선택 >> ");
			ctg = ctg.toUpperCase();
			List<RestaurantVo> resByCtr = restaurantService.resSearchByCategory(ctg);
			int i = 1;
			printLn(3);
			for (RestaurantVo restaurantVo : resByCtr) {
				String name = restaurantVo.getRes_name();
				String resTel = restaurantVo.getResTel();
				System.out.println(i + ". " + name + "\r   ☏ " + resTel);
				i++;
				printLn(1);
			}
			printLn(3);
			String enter = ScanUtil.nextLine("◁ 돌아가시려면 엔터를 눌러주세요 ▷");
		}
		if (sel == 2) {
			String resNm = ScanUtil.nextLine("가게이름 검색 >> ");
			List<RestaurantVo> resByName = restaurantService.resSearchByresName(resNm);
			printResDetail(resByName);
			String enter = ScanUtil.nextLine("◁ 돌아가시려면 엔터를 눌러주세요 ▷");
		}
		if(sel == 3) {
			return View.EAT_IS_HAPPY;
		}
		return View.EAT_IS_HAPPY;
	}

	// 구장 내부 매장
	private View foodcourt() {
		printInsideRes();

		printLn(2);
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.FCT_LIST;
		case 2:
			return View.FCT_SEARCH;
		case 3:
			return View.MEMBER;
		default:
			return View.FOODCOURT;
		}
	}

	// 구장 내부 매장리스트
	private View fctList() {
		int page = 1;
		if (MainController.sessionStorage.containsKey("page")) {
			page = (int) MainController.sessionStorage.get("page");
		}
		int start = 1 + (page - 1) * 5;
		int end = page * 5;
		int max = 13;
		List<Object> param = new ArrayList();
		param.add(start);
		param.add(end);

		List<RestaurantVo> resList = restaurantService.fctList(param);
		printResList(resList);
		int sels = ScanUtil.menu();
		if (sels == 1) {
			page = page - 1;
			if (page < 1)
				page = 1;
			MainController.sessionStorage.put("page", page);
		}
		if (sels == 2) {
			if (end <= max)
				page = page + 1;
			MainController.sessionStorage.put("page", page);
		}
		if (sels == 3) {
			int rn = ScanUtil.nextInt("상세조회할 매장번호");
			RestaurantVo rv = restaurantService.getFctNo(rn);
			String resNo = rv.getRes_no();
			List<RestaurantVo> dList = restaurantService.fctDetail(resNo);
			printResDetail(dList);
			String enter = ScanUtil.nextLine("◁ 돌아가시려면 엔터를 눌러주세요 ▷");
		}
		if (sels == 4)
			return View.FOODCOURT;
		return View.FCT_LIST;
	}

	// 구장 내부 매장검색
	private View fctSearch() {
		printLongVar();
		printLn(13);
		System.out.println("1. 위치별 검색\r\r\r");
		System.out.println("2. 매장명 검색\r\r\r");
		System.out.println("3. 돌아가기\r\r\r");
		printLn(12);
		printLongVar2();
		int sel = ScanUtil.menu();
		if (sel == 1) {
			String loc = ScanUtil.nextLine("구역 선택(1루/중앙/3루) >>");
			sessionStorage.put("loc", loc);
			List<RestaurantVo> fctByLoc = restaurantService.fctSearchByloc(loc);
			printFctListByLoc(fctByLoc);
			printLn(3);
			System.out.println("1. 상세매장 조회\r\r\r\r");
			System.out.println("2. 돌아가기\r\r\r\r");
			printLongVar2();
			int sel2 = ScanUtil.menu();
			if (sel2 == 1) {
				int rn = ScanUtil.nextInt("매장번호 검색 >> ");
				RestaurantVo fct = restaurantService.getFctNoByLoc(loc, rn);
				String resNo = fct.getRes_no();
				List<RestaurantVo> dList = restaurantService.fctDetail(resNo);
				printResDetail(dList);
				String en = ScanUtil.nextLine("◁ 돌아가시려면 엔터를 눌러주세요 ▷");
			}
			if (sel2 == 2) {
				return View.FOODCOURT;
			}
		}
		if (sel == 2) {
			String fctNm = ScanUtil.nextLine("매장명 검색 >> ");
			List<RestaurantVo> fctByName = restaurantService.fctSerarchByfctName(fctNm);
			printResDetail(fctByName);
			String en = ScanUtil.nextLine("◁ 돌아가시려면 엔터를 눌러주세요 ▷");
		}
		return View.EAT_IS_HAPPY;
	}

}
