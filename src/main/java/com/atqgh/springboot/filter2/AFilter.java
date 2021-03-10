package com.atqgh.springboot.filter2;


import javax.servlet.*;
import java.io.IOException;

/**
 * @ProjectName: springbootprac
 * @Description:
 * @Author: qiguohui
 * @Date: 2021/2/19 20:47
 */
public class AFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------ A init ------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----A doFilter ----- ");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("------ A destroy ------");
    }
}
