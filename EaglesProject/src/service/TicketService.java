package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import controller.MainController;
import dao.TicketDao;
import vo.GameVo;
import vo.TicketVo;

public class TicketService {
	private static TicketService instance = null;

	private TicketService() {

	}

	public static TicketService getInstance() {
		if (instance == null) {
			instance = new TicketService();
		}
		return instance;
	}
	TicketDao dao = TicketDao.getInstance();
	
	// 전체 경기내역 조회
	public List<GameVo> gameList(List<Object> param) {
		return dao.gameList(param);
	}
	// 예매 가능한 경기리스트 조회
	public List<GameVo> availGameList() {
		return dao.availGameList();
	}
	
	// 선택한 경기의 좌석현황 조회
	public void seatList(int no, int gameNo) {
		List<Map<String, Object>> list = dao.seatList(no, gameNo);
		int i = 0-1;
		int num =1;
		System.out.println("  A B C D E F G H I J");
		System.out.print(num+" ");
		for (Map<String, Object> map : list) {
			String seat = (String) map.get("TK_NO");
			String yn = (String) map.get("CANCEL_YN");
//			System.out.println(yn);
			if(i==9) {
				System.out.println();
				num++;
				System.out.print(num+" ");
				i = 0;
			}
			else  i++;
			if(seat!=null)  {
				if(yn.equals("Y"))
					System.out.print("□ ");
				else System.out.print("■ ");
			}else  {
				System.out.print("□ ");
			}
		}
		System.out.println("\n");
	}
	
	// 결제번호 가져오기
	public Map<String, Object> getPayNo() {
		return dao.getPayNo();
	}
	
	// 결제
	public void pay(List<Object> param) {
		dao.pay(param);
	}
	
	// 티켓예매
	public void ticketing(List<Object> param, BigDecimal payNo) {
		dao.ticketing(param, payNo);
	}
	
	// 경기정보 수정
	public void gameUpdate(List<Object> param, int no) {
		dao.gameUpdate(param, no);
	}
	
	// 예매내역 조회
	public List<TicketVo> ticketingList(int memNo) {
		return dao.ticketingList(memNo);
	}
	
	public void ticketDelete(int payNo) {
		dao.ticketDelete(payNo);
	}
	
	public List<TicketVo> ticketingListbyPay(List<Object> param){
		return dao.ticketingListbyPay(param);
	}
	
	public void ticketDeleteBySeat(int ticketNo) {
		dao.ticketDeleteBySeat(ticketNo);
	}
	
	public List<Map<String, Object>> selectSeatList(List<Object> param) {
		return dao.selectSeatList(param);
	}

}
