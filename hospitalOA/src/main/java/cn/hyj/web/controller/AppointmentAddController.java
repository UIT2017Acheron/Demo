package cn.hyj.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hyj.web.factory.ServiceFactory;
import cn.hyj.web.model.AppointmentInfoModel;
import cn.hyj.web.service.IAppointmentService;
import cn.hyj.web.service.IPatientService;

/**
* @author 作者
* @version 创建时间：2019年12月19日 下午9:00:28
* 类说明
*/
@WebServlet("/view/appointmentadd.do")
public class AppointmentAddController extends HttpServlet{
	
	IAppointmentService ps = ServiceFactory.getAppointmentsService(); 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		int index=0;
		
		AppointmentInfoModel p = new AppointmentInfoModel();
		
		
		p.setAppointment_name(req.getParameter("appointment_name"));
		p.setAppointment_age(req.getParameter("appointment_age"));
		p.setAppointment_doctor(req.getParameter("appointment_doctor"));
		p.setAppointment_department(req.getParameter("appointment_department"));
		p.setAppointment_date(req.getParameter("appointment_date"));
		p.setAppointment_time(req.getParameter("appointment_time"));
		p.setAppointment_status(req.getParameter("appointment_status"));
		
		
		
		System.out.println("获取添加数据");
		
		try {
			 index= ps.addAppointmentService(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(index==1){
			System.out.println("添加成功");

			req.getRequestDispatcher("/view/appointmenttomain.do").forward(req, resp);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
