package cn.hyj.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hyj.web.factory.ConnectionFactory;

/**
* @author 作者
* @version 创建时间：2019年12月24日 上午8:49:58
* 类说明
*/
@WebServlet("/view/photo.do")
public class PhotoModifyController extends HttpServlet{
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PreparedStatement ps=null;
	ResultSet rs=null;	
		OutputStream out = resp.getOutputStream();
		String sql ="select photo from admin";
		Connection conn;
		try {
			conn = ConnectionFactory.getConnection();
			ps=conn.prepareStatement(sql);
			rs= ps.executeQuery();
			if(rs.next()) {
				InputStream in =rs.getBinaryStream("photo");
				byte[] data = new byte[100];
				int len = 0;
				while((len = in.read(data))!=-1) {
					out.write(data,0,len);
				}
				in.close();
				out.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
