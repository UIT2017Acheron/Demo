package cn.hyj.web.controller;
/**
* @author 作者
* @version 创建时间：2019年12月19日 上午10:04:46
* 类说明
*/

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hyj.web.factory.ServiceFactory;
import cn.hyj.web.model.DoctorInfoModel;
import cn.hyj.web.service.IDoctorService;
@WebServlet("/view/doctortomain.do")
public class DoctorToMainController extends HttpServlet{
	
	IDoctorService ds = ServiceFactory.getDoctorService();
	
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		System.out.println("执行到doctorSHOW");
		List<DoctorInfoModel> lu = null;
		try {
			lu = ds.DoctorShowService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lu!=null){
			System.out.println("输出成功");
			req.setAttribute("lu",lu);
			
			req.getRequestDispatcher("/view/doctor.jsp").forward(req, resp);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
