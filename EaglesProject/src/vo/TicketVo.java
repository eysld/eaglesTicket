package vo;

import java.util.Date;

import lombok.Data;

@Data
public class TicketVo {
	private int pay_no;
	private Date pay_date;
	private int tk_no;
	private Date game_date;
	private String opt_name;
	private int game_no;
	private int area_no;
	private String gugan_no;
	private String area_name;
	private String block_nm;
	private String seat_row;
	private int mem_no;
	private int price_pay;
	private String cancel_yn;
}
