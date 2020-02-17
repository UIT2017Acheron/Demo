package cn.hyj.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cn.hyj.web.util.sendMail;

/**
* @author 作者
* @version 创建时间：2019年12月20日 下午9:25:12
* 类说明
*/
@WebListener
public class ServiceListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServiceListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("服务器已关闭!");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	try {
			//sendMail.sendMail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("服务器已启动!");
    }

	
	
}
