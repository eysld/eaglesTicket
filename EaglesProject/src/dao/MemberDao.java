package dao;

import java.util.List;

import util.JDBCUtil;
import vo.MemberVo;

public class MemberDao {
	private static MemberDao instance = null;

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public MemberVo login(List<Object> param) {
		String sql = " 	select * from member\r\n" + 
						"where mem_id= ? and mem_pw= ? \r\n" + 
						"and del_yn='N' ";
		return jdbc.selectOne(sql, param, MemberVo.class);
	}
	
	public void memInsert(List<Object> param)  {
	      String sql = " INSERT INTO MEMBER(MEM_NO, MEM_ID, MEM_PW, MEM_NAME, MEM_BIRTH, MEM_PHONE)\r\n" + 
	            "VALUES( (SELECT MAX(mem_no)+1 FROM MEMBER),\r\n" + 
	            "        ? , ?, ?, TO_DATE( ?, 'YYYY/MM/DD'), ? )";
	      jdbc.update(sql, param);
	}
	
	public void pwUpdate(List<Object> param) {
	      String sql = " UPDATE MEMBER\r\n" + 
	                " SET MEM_PW = ?\r\n" + 
	                " WHERE MEM_ID = ? ";
	      jdbc.update(sql, param);
	      
	}
	
	public void phoneUpdate(List<Object> param) {
        String sql = " UPDATE MEMBER\r\n" + 
                  " SET MEM_PHONE = ?\r\n" + 
                  " WHERE MEM_ID = ? ";
        jdbc.update(sql, param);
   }
   
   public void memDelete(int memNo) {
      String sql = " UPDATE MEMBER\r\n" + 
                " SET DEL_YN = 'Y' \r\n" + 
                " WHERE MEM_NO = "+memNo;
      jdbc.update(sql);
   }
   
   public MemberVo myMemList(List<Object> param) {
      String sql = " SELECT MEM_ID, MEM_NAME, MEM_BIRTH, MEM_PHONE\r\n" + 
                " FROM MEMBER\r\n" + 
                " WHERE MEM_ID = ? " ;
      return jdbc.selectOne(sql, param, MemberVo.class);
   }
   
   public List<MemberVo> memList(){
      String sql = " SELECT *\r\n" + 
                " FROM MEMBER\r\n" + 
                " WHERE MEM_NO != '0'\r\n" + 
                " AND DEL_YN = 'N'";
      return jdbc.selectList(sql, MemberVo.class);
   }
}
