package cn.hyj.web.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Application;

import cn.hyj.web.factory.ServiceFactory;
import cn.hyj.web.model.AdminInfoModel;
import cn.hyj.web.service.IAdminService;

/**
* @author 作者:Acheron
* @version 创建时间：2019年12月17日 下午12:00:48
* 类说明 登陆操作
*/
@WebServlet("/view/checklogin.do")
public class AdminCheckLoginController extends HttpServlet{
	
	IAdminService us=ServiceFactory.getAdminService();    //获取业务层对象
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String uname = req.getParameter("username");      //接收视图层 用户名和密码
		String password = req.getParameter("password");
		
		AdminInfoModel admin = null;
		try {
			admin = us.checkUserLoginService(uname, password);     //调用业务层 方法 来判断用户名和密码是否相同
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		if(admin!=null){           //是否存在输入用户 成功则跳转到主页面 失败则返回跳转到当前页面
			
			HttpSession hs=req.getSession();
			
			
			
			req.getSession().setAttribute("userid",admin);
			
			hs.setAttribute("user", admin);
			
			System.out.println("登陆成功");
			req.getRequestDispatcher("/view/index.html").forward(req, resp);
			
		}else{		
			resp.sendRedirect("/view/login.html"); 
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
