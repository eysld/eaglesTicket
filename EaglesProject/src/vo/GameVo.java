package vo;

import java.util.Date;

import lombok.Data;

@Data
public class GameVo {
	 private int game_no;
	 private Date game_date;
	 private String game_result;
	 private int opt_no;
	 private String opt_name;
}
