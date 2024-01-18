package vo;


import java.util.Date;

import lombok.Data;

@Data
public class MemberVo {
	 private int mem_no;
	 private String mem_id;
	 private String mem_pw;
	 private String mem_name;
	 private Date mem_birth;
	 private String mem_phone;
	 private String del_yn;
}
