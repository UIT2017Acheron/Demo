package cn.hyj.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hyj.web.factory.ServiceFactory;
import cn.hyj.web.model.AppointmentInfoModel;
import cn.hyj.web.model.PatientInfoModel;
import cn.hyj.web.service.IAppointmentService;

/**
* @author 作者
* @version 创建时间：2019年12月19日 下午8:58:45
* 类说明
*/
@WebServlet("/view/appointmenttomodify.do")
public class AppointmentToModifyController extends HttpServlet{
	IAppointmentService ps = ServiceFactory.getAppointmentsService(); 

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String appointment_id =req.getParameter("appointment_id");
		
		AppointmentInfoModel ss = null;
		try {
			ss = ps.searchAppointmentService(appointment_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ss!=null) {
			
			System.out.println("获取修改对象");
			req.setAttribute("ss",ss);
		
			
			req.getRequestDispatcher("/view/edit-appointment.jsp").forward(req, resp);
		}else {
			System.out.println("无法获取修改对象");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
