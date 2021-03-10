package com.atqgh.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ProjectName: springbootprac
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/9/10 12:30
 */
public class Myfilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before====1111111111111");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("after====1111111111111");

    }

    @Override
    public void destroy() {

    }
}
