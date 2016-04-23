package com.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	private String jsessionid;
	private Map<String, Map<String, Object>> cache;

	public SessionUtil(HttpServletRequest request) {
		setJsessionid(CookieUtil.getCookieByName(request, "JSESSIONID") == null ? ""
				: CookieUtil.getCookieByName(request, "JSESSIONID").getValue());
		cache = SessionCache.getSessionCache();
	}

	public void setJsessionid(String jsessionid) {
		this.jsessionid = jsessionid;
	}

	public String getJsessionid() {
		return jsessionid;
	}

	public Object getAttribute(String name) {
		String key = jsessionid + name;
		if (cache.get(key) == null) {
			return null;
		}
		Set<String> dateStrings = cache.get(key).keySet();
		String dateString = dateStrings.iterator().next();
		return cache.get(key).get(dateString);
	}

	public void setAttribute(String name, Object object) {
		String key = jsessionid + name;
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new Date());
		// Date now= sdf.parse()
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(date, object);
		cache.put(key, map);
	}

	public void removeAttrtube(String name) {
		String key = jsessionid + name;
		cache.remove(key);
	}
}
