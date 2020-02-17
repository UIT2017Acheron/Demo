package cn.hyj.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.hyj.web.factory.ConnectionFactory;
import cn.hyj.web.model.AdminInfoModel;

/**
* @author 作者
* @version 创建时间：2019年12月24日 上午8:16:24
* 类说明
*/
@MultipartConfig  
@WebServlet("/view/imageadd.do")
public class imageaddController extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		AdminInfoModel admin = null; 
		admin = new AdminInfoModel();

		Part part = request.getPart("photo");
		
		
		
		String fileName=part.getSubmittedFileName();    

		
		System.out.println(fileName);
		String contentType=part.getContentType(); 
		System.out.println(contentType);
		
		String [] sz=fileName.split("/");
		System.out.println();
		
		ServletContext application=request.getServletContext();
		String hzm = fileName.substring(fileName.indexOf("."));
		System.out.println(hzm);
        InputStream in=part.getInputStream(); 
      
		admin.setIn(in);
		
		Connection conn;
		try {
			conn = ConnectionFactory.getConnection();
			String sql="UPDATE admin SET photo=? WHERE admin_id=?";
			
			ps=conn.prepareStatement(sql);
			
			
			
			ps.setBinaryStream(1, admin.getIn(),admin.getIn().available());
			ps.setInt(2, 1);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/view/index.html").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
