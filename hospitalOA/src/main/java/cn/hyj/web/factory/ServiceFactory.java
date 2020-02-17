package cn.hyj.web.factory;

import cn.hyj.web.service.IAdminService;
import cn.hyj.web.service.IAppointmentService;
import cn.hyj.web.service.IDoctorService;
import cn.hyj.web.service.IPatientService;
import cn.hyj.web.service.impl.AdminServiceImpl;
import cn.hyj.web.service.impl.AppointmentServiceImpl;
import cn.hyj.web.service.impl.DoctorServiceImpl;
import cn.hyj.web.service.impl.PatientServiceImpl;


/**
* @author 作者:Acheron
* @version 创建时间：2019年12月17日 下午12:05:39
* 类说明 业务层工厂类
*/
public class ServiceFactory {
	
	public static IAdminService getAdminService() {
		return new AdminServiceImpl();
	}
	
	public static IPatientService getPatientService() {
		return new PatientServiceImpl();
	}
	
	public static IDoctorService getDoctorService() {
		return new DoctorServiceImpl();
	}
	
	public static IAppointmentService getAppointmentsService() {
		return new AppointmentServiceImpl();
	}
	
}
