package cn.hyj.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hyj.web.factory.ServiceFactory;
import cn.hyj.web.service.IAppointmentService;
import cn.hyj.web.service.IPatientService;

/**
* @author 作者
* @version 创建时间：2019年12月19日 下午9:00:17
* 类说明
*/
@WebServlet("/view/appointmentdelete.do")
public class AppointmentDeleteController extends HttpServlet{
	IAppointmentService ps = ServiceFactory.getAppointmentsService(); 

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		
			String appointment_id =req.getParameter("appointment_id");

			int index = 0;
			try {
				index = ps.deleteAppointmentService(appointment_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(index==1) {
				System.out.println("刪除成功");
				
				req.getRequestDispatcher("/view/appointmenttomain.do").forward(req, resp);
				return;
			}
			
	}
}
