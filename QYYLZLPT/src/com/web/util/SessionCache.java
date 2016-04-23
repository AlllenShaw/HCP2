package com.web.util;

import java.util.HashMap;
import java.util.Map;

public class SessionCache {
	private static Map<String, Map<String, Object>> sessionCache = null;

	static {
		sessionCache = new HashMap<String, Map<String, Object>>();
	}

	private SessionCache() {

	}

	public static Map<String, Map<String, Object>> getSessionCache() {
		return sessionCache;
	}
}
