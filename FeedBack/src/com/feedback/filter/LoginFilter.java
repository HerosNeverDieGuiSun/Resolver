package com.feedback.filter;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	private FilterConfig config = null;
    public LoginFilter() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if (session.getAttribute("user") == null) {
			System.out.println("null");
			PrintWriter writer = response.getWriter();
			writer.print("<script type=\"text/javascript\">alert(\"Please log in\");</script>");
			resp.sendRedirect("../Login.jsp");
		} else {
			chain.doFilter(req, resp);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}
}
