package cn.hyj.web.service.impl;

import java.util.List;

import cn.hyj.web.dao.IDoctorDao;
import cn.hyj.web.dao.IPatientDao;
import cn.hyj.web.factory.DaoFactory;
import cn.hyj.web.model.DoctorInfoModel;
import cn.hyj.web.model.PatientInfoModel;
import cn.hyj.web.service.IDoctorService;

/**
* @author 作者
* @version 创建时间：2019年12月17日 下午4:14:03
* 类说明
*/
public class DoctorServiceImpl implements IDoctorService{

	IDoctorDao pd = DaoFactory.getDoctorDao();
	@Override
	public List<DoctorInfoModel> DoctorShowService() throws Exception {
		
		List<DoctorInfoModel> lu=pd.DoctorShowDao();

		return lu;
	}

	@Override
	public int deleteDoctorService(String Doctor_id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addDoctorService(DoctorInfoModel p) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyDoctorService(int Doctor_id, DoctorInfoModel s) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DoctorInfoModel searchDoctorService(String Doctor_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
