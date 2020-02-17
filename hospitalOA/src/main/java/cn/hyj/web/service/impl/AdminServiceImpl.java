package cn.hyj.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.hyj.web.dao.IAdminDao;
import cn.hyj.web.factory.DaoFactory;
import cn.hyj.web.model.AdminInfoModel;

import cn.hyj.web.service.IAdminService;

/**
* @author 作者:Acheron
* @version 创建时间：2019年12月17日 下午12:07:59
* 类说明 业务层用户实现类
*/

public class AdminServiceImpl implements IAdminService{

	Logger logger = Logger.getLogger(AdminServiceImpl.class);
	
	IAdminDao ud=DaoFactory.getAdminDao();
	
	public AdminInfoModel checkUserLoginService(String uname, String password) throws Exception {
		AdminInfoModel u = ud.checkUserLoginDao(uname, password);
		
		if(u!=null) {
			logger.debug(uname+"鐧婚檰鎴愬姛");
		}else {	
			logger.debug(uname+"鐧婚檰澶辫触");
		}
		
		return ud.checkUserLoginDao(uname, password);	
		
	}






	


}
