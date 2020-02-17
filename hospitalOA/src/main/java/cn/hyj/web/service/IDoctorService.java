package cn.hyj.web.service;

import java.util.List;

import cn.hyj.web.model.DoctorInfoModel;



/**
* @author 作者
* @version 创建时间：2019年12月17日 下午4:13:30
* 类说明
*/
public interface IDoctorService {
	
	List<DoctorInfoModel> DoctorShowService() throws Exception;
	
	int deleteDoctorService(String Doctor_id) throws Exception;
	
	int addDoctorService(DoctorInfoModel p) throws Exception;
	
	int modifyDoctorService(int Doctor_id,DoctorInfoModel s) throws Exception;
	
	DoctorInfoModel searchDoctorService(String Doctor_id) throws Exception;
}
