package service;

import java.util.List;

import dao.RestaurantDao;
import vo.RestaurantVo;

public class RestaurantService {
	private static RestaurantService instance = null;

	private RestaurantService() {

	}

	public static RestaurantService getInstance() {
		if (instance == null) {
			instance = new RestaurantService();
		}
		return instance;
	}

	RestaurantDao dao = RestaurantDao.getInstance();

	public List<RestaurantVo> resList(List<Object> param) {
		return dao.resList(param);
	}

	public List<RestaurantVo> resDetail(String resNo) {
		return dao.resDetail(resNo);
	}

	public RestaurantVo getResNo(int rn) {
		return dao.getResNo(rn);
	}

	public List<RestaurantVo> resSearchByCategory(String ctr) {
		return dao.resSearchByCategory(ctr);
	}

	public List<RestaurantVo> resSearchByresName(String resNm) {
		return dao.resSearchByresName(resNm);
	}

	public List<RestaurantVo> fctList(List<Object> param) {
		return dao.fctList(param);
	}

	public List<RestaurantVo> fctDetail(String resNo) {
		return dao.fctDetail(resNo);
	}
	
	public List<RestaurantVo> fctSearchByloc(String loc) {
		return dao.fctSearchByloc(loc);
	}

	public RestaurantVo getFctNo(int rn) {
		return dao.getFctNo(rn);
	}
	
	public List<RestaurantVo> fctSerarchByfctName(String fctNm) {
		return dao.fctSerarchByfctName(fctNm);
	}
	
	public RestaurantVo getFctNoByLoc(String loc, int rn){
		return dao.getFctNoByLoc(loc, rn);
	}

}