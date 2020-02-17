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

/**
* @author 作者
* @version 创建时间：2019年12月19日 下午9:00:01
* 类说明
*/
@WebServlet("/view/appointmentmodify.do")
public class AppointmentModifyController extends HttpServlet{

	IAppointmentService ps = ServiceFactory.getAppointmentsService(); 

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		
			int index=0;
			
			AppointmentInfoModel p = new AppointmentInfoModel();
			p.setAppointment_id(Integer.parseInt(req.getParameter("appointment_id")));
			p.setAppointment_name(req.getParameter("appointment_name"));
			p.setAppointment_age(req.getParameter("appointment_age"));
			p.setAppointment_doctor(req.getParameter("appointment_doctor"));
			p.setAppointment_department(req.getParameter("appointment_department"));
			p.setAppointment_date(req.getParameter("appointment_date"));
			p.setAppointment_time(req.getParameter("appointment_time"));
			p.setAppointment_status(req.getParameter("appointment_status"));
			
			
			System.out.println("获取添加数据"+req.getParameter("patient_id"));
			
			try {
				 index= ps.modifyAppointmentService(p.getAppointment_id(), p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(index==1){
				System.out.println("修改成功");

				req.getRequestDispatcher("/view/appointmenttomain.do").forward(req, resp);
				return;
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
