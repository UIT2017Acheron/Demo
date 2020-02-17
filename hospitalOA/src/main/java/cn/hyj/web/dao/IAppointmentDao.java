package cn.hyj.web.dao;

import java.util.List;

import cn.hyj.web.model.AppointmentInfoModel;

/**
* @author 作者
* @version 创建时间：2019年12月19日 下午8:18:56
* 类说明
*/
public interface IAppointmentDao {
	
	int deleteAppointmentDao(String Appointment_id) throws Exception;
	
	List<AppointmentInfoModel> AppointmentShowDao() throws Exception;
	
	int addAppointmentDao(AppointmentInfoModel p) throws Exception;
	
	int modifyAppointmentDao(int Appointment_id,AppointmentInfoModel s) throws Exception;
	
	AppointmentInfoModel searchAppointmentDao(String Appointment_id) throws Exception;
}
