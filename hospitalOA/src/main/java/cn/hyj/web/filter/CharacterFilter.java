package cn.hyj.web.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
* @author 作者
* @version 创建时间：2019年12月20日 下午8:00:44
* 类说明
*/

/**
 * @WebFilter将一个实现了javax.servlet.Filte接口的类定义为过滤器组件
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 */
@WebFilter("/*")
public class CharacterFilter implements Filter {
 
	public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
          HttpServletRequest request2=(HttpServletRequest) request;
          HttpServletResponse response2=(HttpServletResponse) response;
          
          request2.setCharacterEncoding("UTF-8");  
          response2.setCharacterEncoding("UTF-8"); 
          
          chain.doFilter(request, response); 

    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 
}
