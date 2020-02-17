package cn.hyj.web.factory;



import cn.hyj.web.dao.IAdminDao;
import cn.hyj.web.dao.IAppointmentDao;
import cn.hyj.web.dao.IDoctorDao;
import cn.hyj.web.dao.IPatientDao;
import cn.hyj.web.dao.impl.AdminDaoImpl;
import cn.hyj.web.dao.impl.AppointmentDaoImpl;
import cn.hyj.web.dao.impl.DoctorDaoImpl;
import cn.hyj.web.dao.impl.PatientDaoImpl;

/**
* @author 作者:Acheron
* @version 创建时间：2019年12月17日 下午12:05:20
* 类说明 事务层工厂类
*/
public class DaoFactory {

	public static IAdminDao getAdminDao() {
		return new AdminDaoImpl();
	}
	
	public static IDoctorDao getDoctorDao() {
		return new DoctorDaoImpl();
	}
	
	public static IPatientDao getPatientDao() {
		return new PatientDaoImpl();
	}
	
	public static IAppointmentDao getAppointmentsDao() {
		return new AppointmentDaoImpl();
	}
	
}
