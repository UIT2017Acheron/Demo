package cn.hyj.web.service.impl;

import java.util.List;

import cn.hyj.web.dao.IAppointmentDao;
import cn.hyj.web.factory.DaoFactory;
import cn.hyj.web.model.AppointmentInfoModel;
import cn.hyj.web.model.PatientInfoModel;
import cn.hyj.web.service.IAppointmentService;

/**
 * @author 作者
 * @version 创建时间：2019年12月19日 下午8:50:44 类说明
 */
public class AppointmentServiceImpl implements IAppointmentService {

	IAppointmentDao pd = DaoFactory.getAppointmentsDao(); 
			
	public List<AppointmentInfoModel> AppointmentShowService() throws Exception {
		List<AppointmentInfoModel> lu = pd.AppointmentShowDao();

		return lu;
	}

	public int deleteAppointmentService(String Appointment_id) throws Exception {
		int index = pd.deleteAppointmentDao(Appointment_id);

		return index;
	}

	public int addAppointmentService(AppointmentInfoModel p) throws Exception {
		int index = pd.addAppointmentDao(p);

		return index;
	}

	public int modifyAppointmentService(int Appointment_id, AppointmentInfoModel s) throws Exception {
		int index = pd.modifyAppointmentDao(Appointment_id, s);

		return index;
	}

	public AppointmentInfoModel searchAppointmentService(String Appointment_id) throws Exception {
		AppointmentInfoModel s = pd.searchAppointmentDao(Appointment_id);

		return s;
	}

}
