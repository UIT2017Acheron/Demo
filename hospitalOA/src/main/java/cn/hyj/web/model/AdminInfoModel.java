package cn.hyj.web.model;

import java.io.InputStream;

/**
* @author 作者:Acheron
* @version 创建时间：2019年12月17日 下午12:06:13
* 类说明 用户实体类
*/
public class AdminInfoModel {

	private int Admin_id;
	private String Admin_name;
	private String Admin_password;
	private  String sex;
	private String phone;
	private String position;
	private InputStream in;
	
	public InputStream getIn() {
		return in;
	}
	public void setIn(InputStream in) {
		this.in = in;
	}
	public int getAdmin_id() {
		return Admin_id;
	}
	public void setAdmin_id(int admin_id) {
		Admin_id = admin_id;
	}
	public String getAdmin_name() {
		return Admin_name;
	}
	public void setAdmin_name(String admin_name) {
		Admin_name = admin_name;
	}
	public String getAdmin_password() {
		return Admin_password;
	}
	public void setAdmin_password(String admin_password) {
		Admin_password = admin_password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}

