package cn.hyj.web.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hyj.web.factory.ServiceFactory;
import cn.hyj.web.model.PatientInfoModel;
import cn.hyj.web.service.IPatientService;


/**
* @author 作者
* @version 创建时间：2019年12月17日 下午4:01:41
* 类说明
*/
@WebServlet("/view/patientstomain.do")
public class PatientToMainController extends HttpServlet{

	
	IPatientService ps = ServiceFactory.getPatientService(); 

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		System.out.println("执行到lu");
		List<PatientInfoModel> lu = null;
		try {
			lu = ps.PatientShowService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lu!=null){
			System.out.println("输出成功");
			req.setAttribute("lu",lu);
			
			req.getRequestDispatcher("/view/patients.jsp").forward(req, resp);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
