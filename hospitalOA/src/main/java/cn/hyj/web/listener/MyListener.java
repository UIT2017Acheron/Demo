package cn.hyj.web.listener;


import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements ServletRequestListener,ServletRequestAttributeListener,HttpSessionListener,HttpSessionAttributeListener,ServletContextListener,ServletContextAttributeListener{

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("销毁");
		
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("初始化");
		
	}
	
	
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		
		System.out.println("request添加-"+srae.getName()+":"+srae.getValue());
		
	}
	
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}
	
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}
/*------------------------------------------------------------------------------*/
	
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session创建");
		
	}
	
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session销毁");
		
	}
	
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("session添加"+event.getName()+":"+event.getValue());
	}
	
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
/*------------------------------------------------------------------------------*/
	
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("application初始化");
		
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application销毁");
		
	}
	
	
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("application创建:"+event.getName()+":"+event.getValue());
		
	}
	
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}
		
	
}
