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

/**
* @author 作者
* @version 创建时间：2019年12月20日 下午9:19:34
* 类说明
*/

public class AdminFilter implements Filter {
	
    public void destroy() {
    	
    }
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        /*
         * 1. 得到session
         * 2. 判断session域中是否存在admin，如果存在，放行
         * 3. 判断session域中是否存在username，如果存在，放行，否则打回到login.jsp，并告诉它不要瞎留达
         */
        HttpServletRequest req = (HttpServletRequest) request;
        String name = (String)req.getSession().getAttribute("admin");
        if(name != null) {
            chain.doFilter(request, response);
        } else {
            req.setAttribute("msg", "您可能是个啥，但肯定不是管理员！");
            req.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
    
}