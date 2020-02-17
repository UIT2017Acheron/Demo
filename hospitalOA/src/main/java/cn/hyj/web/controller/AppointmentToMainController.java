package cn.hyj.web.controller;

import java.io.IOException;
import java.util.List;

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
* @version 创建时间：2019年12月19日 下午8:59:42
* 类说明
*/
@WebServlet("/view/appointmenttomain.do")
public class AppointmentToMainController extends HttpServlet{
	IAppointmentService ps = ServiceFactory.getAppointmentsService(); 

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		List<AppointmentInfoModel> lu = null;
		try {
			lu = ps.AppointmentShowService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lu!=null){
		
			req.setAttribute("lu",lu);
			
			req.getRequestDispatcher("/view/appointments.jsp").forward(req, resp);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
