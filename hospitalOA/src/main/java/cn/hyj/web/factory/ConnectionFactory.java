package cn.hyj.web.factory;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
* @author 作者:Acheron
* @version 创建时间：2019年12月17日 下午12:04:59
* 类说明 工厂类
*/

public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
		Connection cn=null;
		try {
			System.out.println("执行connectionFactory");
			
			InitialContext ctx=new InitialContext();
			Context envCtx = (Context)ctx.lookup("java:comp/env");
			DataSource ds=(DataSource)envCtx.lookup("jdbc/mysqldb1");
			cn =  (Connection) ds.getConnection();

		}catch(Exception e) {
			throw new Exception("失败"+e.getMessage());
		}
		
		return cn;
	}
}
