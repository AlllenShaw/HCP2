package com.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.util.SessionUtil;

public class UserFilter implements Filter {

	private List<String> notCheckURLList = new ArrayList<String>();

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		SessionUtil sessionUtil = new SessionUtil(request);
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath();
		String path = basePath + "/user/login.do";
		String adminPath = basePath + "/admin/login.do";
		String loginPath = basePath + "/login/login.jsp";
		String patientRegisterPath = basePath + "/user/patient/register.do";
		String doctorRegisterPath = basePath + "/user/doctor/register.do";
		String getDoctor = basePath + "/user/patient/getDoctors.do";
		System.out.println("request" + request.getRequestURL().toString());

		String actUrl = request.getRequestURL().toString();
		// no filter with these url
		if (path.equals(actUrl) || patientRegisterPath.equals(actUrl)
				|| adminPath.equals(actUrl)
				|| doctorRegisterPath.equals(actUrl)
				|| getDoctor.equals(actUrl)) {
			// response.sendRedirect(path);
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		System.out.println("path = " + path);
		if (sessionUtil.getAttribute("USERMODEL") == null
				|| sessionUtil.getJsessionid().equals("")) {
			System.out.println("path1 = " + path);

			response.sendRedirect(loginPath);
			return;
		}
		chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		notCheckURLList.add("/user/login.do");
	}
}