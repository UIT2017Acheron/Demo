package cn.hyj.web.service.impl;

import java.util.List;

import cn.hyj.web.dao.IAdminDao;
import cn.hyj.web.dao.IPatientDao;
import cn.hyj.web.factory.DaoFactory;
import cn.hyj.web.model.PatientInfoModel;

import cn.hyj.web.service.IPatientService;

/**
* @author 作者
* @version 创建时间：2019年12月17日 下午4:14:14
* 类说明
*/
public class PatientServiceImpl implements IPatientService{
	
	
	IPatientDao pd = DaoFactory.getPatientDao();
	
	public List<PatientInfoModel> PatientShowService() throws Exception {
		
		List<PatientInfoModel> lu=pd.patientShowDao();

		return lu;
	}

	public int deletePatientService(String patient_id) throws Exception {
		
		int index = pd.deletePatientDao(patient_id);
		
		return index;
	}

	@Override
	public int addPatientService(PatientInfoModel p) throws Exception {
		
		int index =pd.addPatientDao(p);
		
		return index;
	}

	@Override
	public PatientInfoModel searchPatientService(String patient_id) throws Exception {
		
		PatientInfoModel s = pd.searchPatientDao(patient_id);
		
		return s;
	}

	@Override
	public int modifyPatientService(int patient_id, PatientInfoModel s) throws Exception {
		
		int index = pd.modifyPatientDao(patient_id, s);
		
		return index;
	}



	
	
}
