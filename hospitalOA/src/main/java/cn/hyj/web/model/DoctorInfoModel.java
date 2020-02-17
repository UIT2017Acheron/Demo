package cn.hyj.web.model;

import java.io.InputStream;

/**
* @author 作者
* @version 创建时间：2019年12月17日 下午12:06:56
* 类说明 医生实体类
*/
public class DoctorInfoModel {
	
	private int doctor_id;
	private String doctor_photo;
	private String doctor_name;
	private String doctor_position;
	private String doctor_place;
	
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	
	public String getDoctor_photo() {
		return doctor_photo;
	}
	public void setDoctor_photo(String doctor_photo) {
		this.doctor_photo = doctor_photo;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDoctor_position() {
		return doctor_position;
	}
	public void setDoctor_position(String doctor_position) {
		this.doctor_position = doctor_position;
	}
	public String getDoctor_place() {
		return doctor_place;
	}
	public void setDoctor_place(String doctor_place) {
		this.doctor_place = doctor_place;
	}
	
}
