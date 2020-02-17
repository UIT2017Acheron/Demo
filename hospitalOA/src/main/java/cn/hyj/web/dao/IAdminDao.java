package cn.hyj.web.dao;

import java.util.List;

import cn.hyj.web.model.AdminInfoModel;


/**
* @author 作者:Acheron
* @version 创建时间：2019年12月17日 下午12:10:08
* 类说明 事务层用户接口
*/
public interface IAdminDao {


		AdminInfoModel checkUserLoginDao(String uname,String pwd) throws Exception;

	
		
}
