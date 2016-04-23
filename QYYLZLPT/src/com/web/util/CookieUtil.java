package com.web.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	private String jsessionid;

	public void delCookie(HttpServletRequest request) {
		Cookie cookie = getCookieByName(request, "JSESSIONID");
		if (cookie != null) {
			setJsessionid(cookie.getValue());
		} else {
			setJsessionid(java.util.UUID.randomUUID().toString());
		}
	}

	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	public static void addCookieMap(HttpServletResponse response,
			Map<String, String> map, int maxAge) {
		Set<Entry<String, String>> set = map.entrySet();
		Iterator<Entry<String, String>> i = set.iterator();
		while (i.hasNext()) {
			Map.Entry me = i.next();
			addCookie(response, me.getKey().toString(), me.getValue()
					.toString(), maxAge);
		}
	}

	public static void addCookie(HttpServletResponse response, String name,
			String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (maxAge > 0)
			cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	public void setJsessionid(String jsessionid) {
		this.jsessionid = jsessionid;
	}

	public String getJsessionid() {
		return jsessionid;
	}
}
