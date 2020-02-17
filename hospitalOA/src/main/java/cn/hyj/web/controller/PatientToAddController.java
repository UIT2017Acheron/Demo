package cn.hyj.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hyj.web.model.PatientInfoModel;

/**
* @author 作者
* @version 创建时间：2019年12月19日 下午9:21:39
* 类说明
*/
@WebServlet("/view/patienttoadd.do")
public class PatientToAddController extends HttpServlet{
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");

			req.getRequestDispatcher("/view/add-patient.jsp").forward(req, resp);
			return;
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
