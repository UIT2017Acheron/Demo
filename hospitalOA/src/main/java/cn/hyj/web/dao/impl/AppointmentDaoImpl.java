package cn.hyj.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.hyj.web.dao.IAppointmentDao;
import cn.hyj.web.factory.ConnectionFactory;
import cn.hyj.web.model.AppointmentInfoModel;
import cn.hyj.web.model.PatientInfoModel;

/**
 * @author 作者
 * @version 创建时间：2019年12月19日 下午8:20:44 类说明
 */
public class AppointmentDaoImpl implements IAppointmentDao {
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public int deleteAppointmentDao(String Appointment_id) throws Exception {

		int index = 0;
		Connection conn = ConnectionFactory.getConnection();
		String sql = "delete from appointments where appointment_id=?";

		ps = conn.prepareStatement(sql);

		ps.setString(1,	Appointment_id);

		index = ps.executeUpdate();

		ps.close();
		conn.close();

		return index;
	}

	@Override
	public List<AppointmentInfoModel> AppointmentShowDao() throws Exception {
		Connection conn = ConnectionFactory.getConnection();

		List<AppointmentInfoModel> lu = new ArrayList<AppointmentInfoModel>();

		String sql = "select * from appointments ";

		ps = conn.prepareStatement(sql);

		rs = ps.executeQuery();

		while (rs.next()) {

			AppointmentInfoModel u = new AppointmentInfoModel();

			u.setAppointment_id(rs.getInt("appointment_id"));
			u.setAppointment_name(rs.getString("appointment_name"));
			u.setAppointment_age(rs.getString("appointment_age"));
			u.setAppointment_doctor(rs.getString("appointment_doctor"));
			u.setAppointment_department(rs.getString("appointment_department"));
			u.setAppointment_date(rs.getString("appointment_date"));
			u.setAppointment_time(rs.getString("appointment_time"));
			u.setAppointment_status(rs.getString("appointment_status"));

			lu.add(u);
		}
		rs.close();
		ps.close();
		conn.close();

		return lu;
	}

	@Override
	public int addAppointmentDao(AppointmentInfoModel p) throws Exception {
		PreparedStatement ps = null;

		int index = 0;

		Connection conn = ConnectionFactory.getConnection();

		String sql = "insert into appointments values(default,?,?,?,?,?,?,?)";

		ps = conn.prepareStatement(sql);

		ps.setString(1, p.getAppointment_name());
		ps.setString(2, p.getAppointment_age());
		ps.setString(3, p.getAppointment_doctor());
		ps.setString(4, p.getAppointment_department());
		ps.setString(5, p.getAppointment_date());
		ps.setString(6, p.getAppointment_time());
		ps.setString(7, p.getAppointment_status());

		index = ps.executeUpdate();

		ps.close();
		conn.close();

		return index;
	}

	@Override
	public int modifyAppointmentDao(int Appointment_id, AppointmentInfoModel p) throws Exception {
		PreparedStatement ps = null;

		int index = 0;
		Connection conn = ConnectionFactory.getConnection();

		String sql = "UPDATE appointments SET appointment_name=?,appointment_age=?,appointment_doctor=?,appointment_department=?,appointment_date=?,appointment_time=?,appointment_status=? WHERE appointment_id=? ";

		ps = conn.prepareStatement(sql);

		ps.setString(1, p.getAppointment_name());
		ps.setString(2, p.getAppointment_age());
		ps.setString(3, p.getAppointment_doctor());
		ps.setString(4, p.getAppointment_department());
		ps.setString(5, p.getAppointment_date());
		ps.setString(6, p.getAppointment_time());
		ps.setString(7, p.getAppointment_status());
		ps.setInt(8, Appointment_id);

		index = ps.executeUpdate();

		ps.close();
		conn.close();

		return index;
	}

	@Override
	public AppointmentInfoModel searchAppointmentDao(String Appointment_id) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;

		AppointmentInfoModel s = null;

		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from appointments where appointment_id=? ";

		ps = conn.prepareStatement(sql);

		ps.setString(1, Appointment_id);

		rs = ps.executeQuery();

		while (rs.next()) {

			s = new AppointmentInfoModel();

			s.setAppointment_id(rs.getInt("appointment_id"));
			s.setAppointment_name(rs.getString("appointment_name"));
			s.setAppointment_age(rs.getString("appointment_age"));
			s.setAppointment_doctor(rs.getString("appointment_doctor"));
			s.setAppointment_department(rs.getString("appointment_department"));
			s.setAppointment_date(rs.getString("appointment_date"));
			s.setAppointment_time(rs.getString("appointment_time"));
			s.setAppointment_status(rs.getString("appointment_status"));

		}
		rs.close();
		ps.close();
		conn.close();
		return s;
	}

}
