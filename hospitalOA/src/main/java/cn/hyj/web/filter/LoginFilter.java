package cn.hyj.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        String username = (String) session.getAttribute("username");
 
        String path = servletRequest.getRequestURI();
        System.out.println("请求地址：" + path);
        if(path.equals("/web11/user/login.jsp") || path.equals("/web11/user/login.do")  ) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        System.out.println("filter_username：" + username + "\n");
        if (username == null || "".equals(username)) {
            servletResponse.sendRedirect("http://localhost:8080/hospitalOA/view/login.html");
        } else {
            chain.doFilter(request, response);
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}