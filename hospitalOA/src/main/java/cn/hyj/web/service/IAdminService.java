package cn.hyj.web.service;
import java.util.List;

import cn.hyj.web.model.AdminInfoModel;

/**
* @author 作者:Acheron
* @version 创建时间：2019年12月17日 下午12:07:34
* 类说明  业务层用户接口
*/
public interface IAdminService {

		
	
		AdminInfoModel checkUserLoginService(String uname,String password) throws Exception;


		
		
		
}
