package cn.hyj.web.service;

import java.util.List;

import cn.hyj.web.model.PatientInfoModel;


/**
* @author 作者
* @version 创建时间：2019年12月17日 下午4:13:18
* 类说明
*/
public interface IPatientService {
	
	List<PatientInfoModel> PatientShowService() throws Exception;
	
	int deletePatientService(String patient_id) throws Exception;
	
	int addPatientService(PatientInfoModel p) throws Exception;
	
	int modifyPatientService(int patient_id,PatientInfoModel s) throws Exception;
	
	PatientInfoModel searchPatientService(String patinet_id) throws Exception;
}
