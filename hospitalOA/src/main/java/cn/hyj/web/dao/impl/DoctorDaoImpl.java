package cn.hyj.web.dao.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.hyj.web.dao.IDoctorDao;
import cn.hyj.web.factory.ConnectionFactory;
import cn.hyj.web.model.DoctorInfoModel;


/**
* @author 作者:Acheron
* @version 创建时间：2019年12月17日 下午12:09:38
* 类说明 
*/
public class DoctorDaoImpl implements IDoctorDao{

	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public int deleteDoctorDao(String patient_id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public int addDoctorDao(DoctorInfoModel p) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyDoctorDao(int Doctor_id, DoctorInfoModel s) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DoctorInfoModel searchDoctorDao(String Doctor_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<DoctorInfoModel> DoctorShowDao() throws Exception {
		Connection conn = ConnectionFactory.getConnection();

		List<DoctorInfoModel> lu = new ArrayList<DoctorInfoModel>();

		String sql = "select * from doctor";

		ps = conn.prepareStatement(sql);

		rs = ps.executeQuery();

		while (rs.next()) {

			DoctorInfoModel u = new DoctorInfoModel();
		
			u.setDoctor_id(rs.getInt("doctor_id"));
			u.setDoctor_photo(rs.getString("doctor_photo"));
			u.setDoctor_name(rs.getString("doctor_name"));
			u.setDoctor_position(rs.getString("doctor_position"));
			u.setDoctor_place(rs.getString("doctor_place"));		
			lu.add(u);
		}
		rs.close();
		ps.close();
		conn.close();
		return lu;
	}

}
