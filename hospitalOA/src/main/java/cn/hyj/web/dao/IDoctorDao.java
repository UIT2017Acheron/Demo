package cn.hyj.web.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import cn.hyj.web.model.DoctorInfoModel;



public interface IDoctorDao {
	
	int deleteDoctorDao(String doctor_id) throws Exception;
	
	List<DoctorInfoModel> DoctorShowDao() throws Exception;
	
	int addDoctorDao(DoctorInfoModel p) throws Exception;
	
	int modifyDoctorDao(int Doctor_id,DoctorInfoModel s) throws Exception;
	
	DoctorInfoModel searchDoctorDao(String Doctor_id) throws Exception;
	
	
}
