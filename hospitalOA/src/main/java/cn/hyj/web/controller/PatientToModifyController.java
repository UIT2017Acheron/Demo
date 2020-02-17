package cn.hyj.web.controller;
/**
* @author 作者
* @version 创建时间：2019年12月18日 下午5:27:47
* 类说明
*/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hyj.web.factory.ServiceFactory;
import cn.hyj.web.model.PatientInfoModel;

import cn.hyj.web.service.IPatientService;

@WebServlet("/view/patienttomodify.do")
public class PatientToModifyController extends HttpServlet{
	
	IPatientService ps = ServiceFactory.getPatientService(); 

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String patient_id =req.getParameter("patient_id");
		
		PatientInfoModel ss = null;
		try {
			ss = ps.searchPatientService(patient_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ss!=null) {
			
			System.out.println("获取修改对象");
			req.setAttribute("ss",ss);
		
			
			req.getRequestDispatcher("/view/edit-patient.jsp").forward(req, resp);
		}else {
			System.out.println("无法获取修改对象");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
