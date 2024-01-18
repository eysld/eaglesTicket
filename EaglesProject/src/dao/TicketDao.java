package dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.GameVo;
import vo.TicketVo;

public class TicketDao {
	private static TicketDao instance = null;

	private TicketDao() {

	}

	public static TicketDao getInstance() {
		if (instance == null) {
			instance = new TicketDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	// 전체 경기내역 조회
	public List<GameVo> gameList(List<Object> param) {
		String sql = " select *\r\n" + 
						"from\r\n" + 
						"    (select rownum rn, A.* from\r\n" + 
						"        (select game_no, game_date, nvl(game_result, ' ') game_result, opt_name \r\n" + 
						"            from game, opponents\r\n" + 
						"            where game.opt_no=opponents.opt_no\r\n" + 
						"            order by 1) A )\r\n" + 
						"where rn between ? and ? ";
		return jdbc.selectList(sql, param, GameVo.class);
	}
	
	// 예매가능한 경기목록 리스트
	public List<GameVo> availGameList() {
		String sql = " select game.*, opt_name from game, opponents\r\n" + 
						"where game_date between to_date(sysdate, 'yy/mm/dd') and sysdate+7\r\n" + 
						"and opponents.opt_no = game.opt_no " +
						" order by 1";
		return jdbc.selectList(sql, GameVo.class);
	}
	
	// 선택경기의 좌석현황 조회
	public List<Map<String, Object>> seatList(int no, int gameNo) {
		String sql = " select seat.*,  ticket.game_no, to_char(ticket.tk_no) tk_no, nvl(cancel_yn, 'N') cancel_yn, pay_no\r\n" + 
						"from seat, (select * from ticket where game_no="+gameNo+") ticket\r\n" + 
						"where seat.seat_no=ticket.seat_no(+)\r\n" + 
						"and area_no="+no+" \r\n" + 
						"order by 1 ";
		return jdbc.selectList(sql);
	}
	
	// pay테이블에 pay_no를 갖고오기 위한 쿼리문
	public Map<String, Object> getPayNo() {
		String sql = " select max(pay_no)+1 pay_no from pay ";
		return jdbc.selectOne(sql);
	} 
	
	// 결제 진행
	public void pay(List<Object> param) {
		String sql = " insert into pay(pay_no, mem_no)\r\n" + 
						"values( ? , ? )";
		jdbc.update(sql, param);
	}
	
	public void ticketing(List<Object> param, BigDecimal payNo) {
		String sql = " insert into ticket(tk_no, game_no, seat_no, pay_no)\r\n" + 
						"values( ( select max(tk_no)+1 from ticket ), ? , \r\n" + 
						"        ( select seat_no from seat \r\n" + 
						"            where area_no= ?  \r\n" + 
						"            and block_no= ? \r\n" + 
						"            and seat_row= ? ), "+payNo.intValue()+" ) ";
		jdbc.update(sql, param);
	}
	
	// 경기수정
	public void gameUpdate(List<Object> param, int no) {
		String sql = " UPDATE GAME\r\n" + " SET GAME_RESULT = ?\r\n" + " WHERE GAME_NO = " + no;
		jdbc.update(sql, param);
	}
	
	// 예매내역 조회
	public List<TicketVo> ticketingList(int memNo) {
		String sql = " select r.*, decode(to_char(r.game_date, 'D'), 3, 1, 4, 1, 5, 1,2) || '구간' gugan_no, price_pay, cancel_yn \r\n" + 
							"from reservation r, price\r\n" + 
							"where price.area_no=r.area_no\r\n" + 
							"and price.gugan_no=decode(to_char(r.game_date, 'D'), 3, 1, 4, 1, 5, 1,2) \r\n" + 
							"and mem_no="+memNo+"\r\n" + 
							"order by 1, 3 ";
		return jdbc.selectList(sql, TicketVo.class);
	}
	// 예매번호별 예매취소
	public void ticketDelete(int payNo) {
		String sql=" update ticket \r\n" + 
						"set cancel_yn='Y'\r\n" + 
						"where pay_no= "+payNo;
		jdbc.update(sql);
	}
	// 예매번호별 예매내역 조회
	public List<TicketVo> ticketingListbyPay(List<Object> param){
		String sql = " select r.*, decode(to_char(r.game_date, 'D'), 3, 1, 4, 1, 5, 1,2) || '구간' gugan_no, price_pay \r\n" + 
						"from reservation r, price\r\n" + 
						"where price.area_no=r.area_no\r\n" + 
						"and price.gugan_no=decode(to_char(r.game_date, 'D'), 3, 1, 4, 1, 5, 1,2) \r\n" + 
						"and mem_no= ? \r\n" + 
						"and pay_no= ? \r\n" + 
						"order by 1, 3 ";
		return jdbc.selectList(sql, param, TicketVo.class);
	}
	
	public void ticketDeleteBySeat(int ticketNo) {
		String sql = " update ticket\r\n" + 
						"set cancel_yn='Y'\r\n" + 
						"where tk_no= "+ticketNo;
		jdbc.update(sql);
	}
	
	// 선택한 좌석리스트
	public List<Map<String, Object>> selectSeatList(List<Object> param) {
		String sql = " select distinct(game_date) game_date , area_name, block_nm||'블록' block_nm, seat_row||'열' seat_row\r\n" + 
						"from game, area, block, seat\r\n" + 
						"where game_no= ? \r\n" + 
						"and area.area_no= ? \r\n" + 
						"and block.block_no= ? \r\n" + 
						"and seat_row= ? ";
		return jdbc.selectList(sql, param);
	}

}
