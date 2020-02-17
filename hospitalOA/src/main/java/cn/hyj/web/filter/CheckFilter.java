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
import javax.servlet.http.HttpSession;

/**
* @author 作者
* @version 创建时间：2019年12月20日 下午9:01:43
* 类说明
*/
@WebFilter(urlPatterns = {"/view/index.html"})
public class CheckFilter implements Filter{

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain arg2) throws IOException, ServletException {
        
        HttpServletRequest request=(HttpServletRequest) arg0;
        HttpServletResponse response=(HttpServletResponse) arg1;
        HttpSession session=request.getSession();
        
        String path=request.getRequestURI();
        
        Integer uid=(Integer)session.getAttribute("userid");
        
        if(path.indexOf("/login.jsp")>-1||path.indexOf("/checklogin.do")>-1){//登录页面不过滤
            arg2.doFilter(arg0, arg1);//递交给下一个过滤器
            return;
        }
        
        if(uid!=null){//已经登录
            arg2.doFilter(request, response);//放行，递交给下一个过滤器
            
        }else{
            response.sendRedirect("login.html");
        }

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
