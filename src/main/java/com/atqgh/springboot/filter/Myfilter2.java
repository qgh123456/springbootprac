package com.atqgh.springboot.filter;

import java.io.IOException;
import java.util.logging.LogRecord;
import javax.servlet.*;

/**
 * @ProjectName: springbootprac
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/9/11 21:10
 */
public class Myfilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before====22222222===");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("after====22222222===");
        return;
    }

    @Override
    public void destroy() {

    }
}
