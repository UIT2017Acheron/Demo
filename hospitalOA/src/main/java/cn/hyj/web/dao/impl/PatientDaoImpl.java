package cn.hyj.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.hyj.web.dao.IPatientDao;
import cn.hyj.web.factory.ConnectionFactory;
import cn.hyj.web.model.PatientInfoModel;



public class PatientDaoImpl implements IPatientDao{

	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<PatientInfoModel> patientShowDao() throws Exception {
		Connection conn = ConnectionFactory.getConnection();

		List<PatientInfoModel> lu = new ArrayList<PatientInfoModel>();

		String sql = "select * from patients ";

		ps = conn.prepareStatement(sql);

		rs = ps.executeQuery();

		while (rs.next()) {

			PatientInfoModel u = new PatientInfoModel();

			u.setPatient_id(rs.getInt("patient_id"));
			u.setPatient_name(rs.getString("patient_name"));
			u.setPatient_age(rs.getString("patient_age"));
			u.setPatient_sex(rs.getString("patient_sex"));
			u.setPatient_phone(rs.getString("patient_phone"));
			u.setPatient_email(rs.getString("patient_email"));
			
			lu.add(u);
		}
		rs.close();
		ps.close();
		conn.close();

		return lu;
	}
	
	public int deletePatientDao(String patient_id) throws Exception {

		PreparedStatement ps = null;
		

		int index = 0;
		Connection conn = ConnectionFactory.getConnection();
		String sql = "delete from patients where patient_id=?";
	

		ps = conn.prepareStatement(sql);
		

		
		ps.setString(1, patient_id);

		index = ps.executeUpdate();
		
		ps.close();
		conn.close();

		return index;
	}

	@Override
	public int addPatientDao(PatientInfoModel p) throws Exception {
		PreparedStatement ps = null;
		
		int index = 0;

		Connection conn = ConnectionFactory.getConnection();

		String sql = "insert into patients values(default,?,?,?,?,?)";
	

		ps = conn.prepareStatement(sql);		

		ps.setString(1, p.getPatient_name());
		ps.setString(2, p.getPatient_age());
		ps.setString(3, p.getPatient_sex());
		ps.setString(4, p.getPatient_phone());
		ps.setString(5, p.getPatient_email());

		index = ps.executeUpdate();
		
		ps.close();
		conn.close();

		return index;
	}

	@Override
	public PatientInfoModel searchPatientDao(String patient_id) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		PatientInfoModel s = null;
		
		
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from patients where patient_id=? ";
		
		ps = conn.prepareStatement(sql);

		ps.setString(1, patient_id);
		

		rs = ps.executeQuery();

		while (rs.next()) {

			s = new PatientInfoModel();

			
			s.setPatient_id(rs.getInt("patient_id"));
			s.setPatient_name(rs.getString("patient_name"));
			s.setPatient_age(rs.getString("patient_age"));
			s.setPatient_sex(rs.getString("patient_sex"));
			s.setPatient_phone(rs.getString("patient_phone"));
			s.setPatient_email(rs.getString("patient_email"));
			
		

		}
		rs.close();
		ps.close();
		conn.close();
		return s;
	}

	@Override
	public int modifyPatientDao(int patient_id, PatientInfoModel s) throws Exception {
		PreparedStatement ps = null;
		

		int index = 0;
		Connection conn = ConnectionFactory.getConnection();

		String sql = "UPDATE patients SET patient_name=?,patient_age=?,patient_sex=?,patient_phone=?,patient_email=? WHERE patient_id=? ";
		
		ps = conn.prepareStatement(sql);
		

		ps.setString(1, s.getPatient_name());
		ps.setString(2, s.getPatient_age());
		ps.setString(3, s.getPatient_sex());
		ps.setString(4, s.getPatient_phone());
		ps.setString(5, s.getPatient_email());
		ps.setInt(6, patient_id);
		
		

		index = ps.executeUpdate();
		
		ps.close();
		conn.close();

		return index;
	}
}


