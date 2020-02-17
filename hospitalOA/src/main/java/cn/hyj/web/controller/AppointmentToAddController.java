package cn.hyj.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author 作者
* @version 创建时间：2019年12月19日 下午9:42:38
* 类说明
*/
@WebServlet("/view/appointmenttoadd.do")
public class AppointmentToAddController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("执行appot添加跳转");
		req.getRequestDispatcher("/view/add-appointment.jsp").forward(req, resp);
		return;
	
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
}
}
