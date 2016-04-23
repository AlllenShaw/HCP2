package com.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigFilter implements Filter {
	static final Log log = LogFactory.getLog(ConfigFilter.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;

		// HttpServletResponse response = (HttpServletResponse) arg1;
		// HttpSession session = request.getSession();
		String projectWebPath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();

		request.setAttribute("path", projectWebPath.toString());

		Enumeration en = request.getParameterNames();
		StringBuffer sb = new StringBuffer();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			if (sb.length() == 0)
				sb.append("?");
			else
				sb.append("&");
			sb.append(key).append("=");// + request.getParameter(key);
			String[] arr = request.getParameterValues(key);
			StringBuffer value = new StringBuffer();
			for (int i = 0; i < arr.length; i++) {
				if (i > 0)
					value.append(",");
				value.append(arr[i]);
			}
			sb.append(value);
			request.setAttribute(key, value.toString());
		}

		// SessionUtil lsession = new SessionUtil(request);
		// String SFUserName = (String) lsession.getAttribute("FUSERNAME");
		// if (SFUserName != null) {
		// request.setAttribute("SFUserName", SFUserName);
		// }
		System.out.println("sb.string = " + "  "
				+ request.getRequestURL().toString() + sb.toString());
		log.info(request.getRequestURL() + sb.toString());
		// request.setAttribute("queryString", request.getQueryString());

		// chain.doFilter(new XSSRequestWrapper((HttpServletRequest) arg0),
		// arg1);
		// chain.doFilter(new RequestWrapper((HttpServletRequest) arg0), arg1);
		chain.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("fliter init");
	}

}
