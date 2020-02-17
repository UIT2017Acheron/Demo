package cn.hyj.web.dao;

import java.util.List;

import cn.hyj.web.model.PatientInfoModel;


public interface IPatientDao {

	int deletePatientDao(String patient_id) throws Exception;
	
	List<PatientInfoModel> patientShowDao() throws Exception;
	
	int addPatientDao(PatientInfoModel p) throws Exception;
	
	int modifyPatientDao(int patient_id,PatientInfoModel s) throws Exception;
	
	PatientInfoModel searchPatientDao(String patient_id) throws Exception;
}
