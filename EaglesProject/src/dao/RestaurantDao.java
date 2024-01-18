package dao;

import java.util.List;

import util.JDBCUtil;
import vo.RestaurantVo;

public class RestaurantDao {
   private static RestaurantDao instance = null;

   private RestaurantDao() {

   }

   public static RestaurantDao getInstance() {
      if (instance == null) {
         instance = new RestaurantDao();
      }
      return instance;
   }
   JDBCUtil jdbc = JDBCUtil.getInstance();
   
   public List<RestaurantVo> resList(List<Object> param) {
      String sql = " select * from\r\n" + 
                "(\r\n" + 
                "    select rownum rn, A.* from\r\n" + 
                "        (select res_name, res_location from restaurant\r\n" + 
                "            where res_no like 'A%'\r\n" + 
                "            order by 1) A )\r\n" + 
                "where rn between ? and ? ";
       return jdbc.selectList(sql, param, RestaurantVo.class); 
   }
   
   public List<RestaurantVo> resDetail(String resNo) {
      String sql = " select * from eatlist\r\n" + 
      				"where res_no= '"+resNo+"'";
      return jdbc.selectList(sql, RestaurantVo.class);
      
   }
   
   public RestaurantVo getResNo(int rn) {
	   String sql = " SELECT * FROM\r\n" + 
		   		"(\r\n" + 
		   		"    SELECT ROWNUM RN, A.* FROM \r\n" + 
		   		"        (SELECT RES_NAME, RES_LOCATION, RES_TEL, RES_DISTANCE, RES_REMARK, RES_NO FROM RESTAURANT\r\n" + 
		   		"            WHERE RES_NO LIKE 'A%'\r\n" + 
		   		"            ORDER BY 1) A)\r\n" + 
		   		"WHERE RN = "+rn+"\r\n" ;
	   return jdbc.selectOne(sql, RestaurantVo.class);
		   		
   }
   
   public List<RestaurantVo> resSearchByCategory(String ctr) {
	   String sql = " select DISTINCT(res_name) res_name, nvl(res_tel, '정보없음') resTel from eatlist\r\n" + 
				   		"where res_no like 'A"+ctr+"%'\r\n" + 
				   		"order by 1 ";
	   return jdbc.selectList(sql, RestaurantVo.class);
   }
   
   public List<RestaurantVo> resSearchByresName(String resNm) {
	   String sql = " select * from eatlist\r\n" + 
				"where res_no like 'A%'\r\n" + "and res_name like '%" + resNm + "%'\r\n" + "order by 1 ";
		return jdbc.selectList(sql, RestaurantVo.class);

	}

	public List<RestaurantVo> fctList(List<Object> param) {
		String sql = " select * from\r\n" + "(\r\n" + "    select rownum rn, A.* from\r\n"
						+ "        (select res_name, res_location from restaurant\r\n"
						+ "            where res_no like 'B%'\r\n" + "            order by 1) A )\r\n"
						+ "where rn between ? and ? ";
		return jdbc.selectList(sql, param, RestaurantVo.class);
	}

	public List<RestaurantVo> fctDetail(String resNo) {
		String sql = " select * from eatlist\r\n" + "where res_no= '" + resNo + "'";
		return jdbc.selectList(sql, RestaurantVo.class);
	}

	public RestaurantVo getFctNo(int rn) {
		String sql = " SELECT * FROM\r\n" + "(\r\n" + "    SELECT ROWNUM RN, A.* FROM \r\n"
				+ "        (SELECT RES_NAME, RES_LOCATION, RES_TEL, RES_DISTANCE, RES_REMARK, RES_NO FROM RESTAURANT\r\n"
				+ "            WHERE RES_NO LIKE 'B%'\r\n" + "            ORDER BY 1) A)\r\n" + "WHERE RN = " + rn
				+ "\r\n";
		return jdbc.selectOne(sql, RestaurantVo.class);
	}
	
	public List<RestaurantVo> fctSearchByloc(String loc) {
		String sql = " select * from\r\n" + 
						"(\r\n" + 
						"    select rownum rn, A.* from\r\n" + 
						"        (select DISTINCT(res_name) res_name, res_distance, res_no from eatlist\r\n" + 
						"where res_no like 'B%'\r\n" + 
						"and res_distance like '%"+loc+"%'\r\n" + 
						"order by 1) A ) ";
		return jdbc.selectList(sql, RestaurantVo.class);
	}
	
	public List<RestaurantVo> fctSerarchByfctName(String fctNm) {
		String sql = " select * from eatlist\r\n" + 
						"where res_no like 'B%'\r\n" + 
						"and res_name like '%"+fctNm+"%'\r\n" + 
						"order by 10 desc ";
		return jdbc.selectList(sql, RestaurantVo.class);
	}
	
	public RestaurantVo getFctNoByLoc(String loc, int rn) {
		String sql = " select * from\r\n" + 
						"(\r\n" + 
						"    select rownum rn, A.* from\r\n" + 
						"        (select DISTINCT(res_name) res_name, res_distance, res_no from eatlist\r\n" + 
						"where res_no like 'B%'\r\n" + 
						"and res_distance like '%"+loc+"%'\r\n" + 
						"order by 1) A )\r\n" + 
						"where rn =  "+rn;
		return jdbc.selectOne(sql, RestaurantVo.class);
	}

}