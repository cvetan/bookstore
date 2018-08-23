package com.github.cvetan.bookstore.filters;

import com.github.cvetan.bookstore.mb.session.AdminSessionMB;
import java.io.IOException;
import javax.inject.Inject;
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
 *
 * @author cvetan
 */
@WebFilter("/admin/*")
public class AdminSessionFilter implements Filter {
    
    @Inject
    private AdminSessionMB adminSessionMB;
    
    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {  
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        
        String loginUrl = httpServletRequest.getContextPath() + "/admin-login.xhtml";
        
        if (adminSessionMB.getAdministrator() == null) {
            httpServletResponse.sendRedirect(loginUrl);
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    
}
