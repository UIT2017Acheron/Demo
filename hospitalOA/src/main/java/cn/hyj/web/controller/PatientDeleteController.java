package cn.hyj.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
* @version 创建时间：2019年12月17日 下午8:35:23
* 类说明
*/
@WebServlet("/view/patientdelete.do")
public class PatientDeleteController extends HttpServlet{
	
	IPatientService ps = ServiceFactory.getPatientService(); 

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		
			String patient_id =req.getParameter("patient_id");

			int index = 0;
			try {
				index = ps.deletePatientService(patient_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(index==1) {
				System.out.println("刪除成功");
				
				req.getRequestDispatcher("/view/patientstomain.do").forward(req, resp);
				return;
			}
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
