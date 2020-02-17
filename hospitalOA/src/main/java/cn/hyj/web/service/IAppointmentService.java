package cn.hyj.web.service;

import java.util.List;

import cn.hyj.web.model.AppointmentInfoModel;

/**
* @author 作者
* @version 创建时间：2019年12月19日 下午8:23:39
* 类说明
*/
public interface IAppointmentService {
	
	List<AppointmentInfoModel> AppointmentShowService() throws Exception;
	
	int deleteAppointmentService(String Appointment_id) throws Exception;
	
	int addAppointmentService(AppointmentInfoModel p) throws Exception;
	
	int modifyAppointmentService(int Appointment_id,AppointmentInfoModel s) throws Exception;
	
	AppointmentInfoModel searchAppointmentService(String Appointment_id) throws Exception;
}
