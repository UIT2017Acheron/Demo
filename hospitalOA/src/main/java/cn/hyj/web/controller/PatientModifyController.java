package cn.hyj.web.controller;

import java.io.IOException;

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
* @version 创建时间：2019年12月18日 下午6:03:53
* 类说明
*/
@WebServlet("/view/patientmodify.do")
public class PatientModifyController extends HttpServlet{
	
	IPatientService ps = ServiceFactory.getPatientService(); 

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		
			int index=0;
			
			PatientInfoModel p = new PatientInfoModel();
			p.setPatient_id(Integer.parseInt(req.getParameter("patient_id")));
			p.setPatient_name(req.getParameter("patient_name"));
			p.setPatient_age(req.getParameter("patient_age"));
			p.setPatient_sex(req.getParameter("patient_sex"));
			p.setPatient_phone(req.getParameter("patient_phone"));
			p.setPatient_email(req.getParameter("patient_email"));
			
			
			System.out.println("获取添加数据"+req.getParameter("patient_id"));
			
			try {
				 index= ps.modifyPatientService(p.getPatient_id(), p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(index==1){
				System.out.println("修改成功");

				req.getRequestDispatcher("/view/patientstomain.do").forward(req, resp);
				return;
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
