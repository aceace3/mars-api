package com.mars.mars_api.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "sessionFilter", urlPatterns = "/*")
public class SessionFilter implements Filter {

    /** 不需要过滤的URL */
    private String[] filterExclusionUrls = { "/login", "/index" };

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        System.out.println("inininininin");
        if (isFliter(url)) {
            System.out.println(session.getAttribute("users"));
            // session内容check
            if (session.getAttribute("users") != null) {
                chain.doFilter(request, response);
                return;
            } else {
                // session不存在的话，转到login页面
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/index");
                return;
            }
        } else {
            chain.doFilter(request, response);
            return;
        }

    }

    /**
     * 判断该url是否需要过滤
     *
     * @param url
     * @return
     */
    private boolean isFliter(String url) {
        for (String exclusion : filterExclusionUrls) {
            if (exclusion.equals(url)) {
                return false;
            }
        }
        return true;
    }

}