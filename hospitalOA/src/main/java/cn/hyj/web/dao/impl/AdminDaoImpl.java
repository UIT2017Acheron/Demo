package cn.hyj.web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hyj.web.dao.IAdminDao;
import cn.hyj.web.factory.ConnectionFactory;
import cn.hyj.web.model.AdminInfoModel;


/**
* @author 作者:Acheron
* @version 创建时间：2019年12月17日 下午12:09:38
* 类说明 事务层用户实现类
*/
public class AdminDaoImpl implements IAdminDao {

	PreparedStatement ps = null;
	ResultSet rs = null;
	AdminInfoModel u = null;

	public AdminInfoModel checkUserLoginDao(String uname, String password) throws Exception {

		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from Admin where Admin_name=? and Admin_password=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, password);
		rs = ps.executeQuery();
		System.out.println("登陆成功");
		while (rs.next()) {
			u = new AdminInfoModel();
			u.setAdmin_id(rs.getInt("Admin_id"));
			u.setAdmin_name(rs.getString("Admin_name"));
			u.setAdmin_password(rs.getString("Admin_password"));
//			u.setSex(rs.getString("sex"));
//			u.setPhone(rs.getString("phone"));
//			u.setPosition(rs.getString("position"));

		}
		rs.close();
		ps.close();
		conn.close();
		return u;
	}







}
