package com.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class TimeScheduleUtil extends TimerTask {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private int timeout = 30 * 60 * 1000; // clear session object each 30mins

	// private int timeout = 10 * 1000; // testing 10s

	//
	// private static Map<String, Map<String, Object>> map;

	// private Map<String, Map<String, Object>> ssessionCache;
	public TimeScheduleUtil() {
		// new Timer().schedule(new TimeScheduleUtil(), 30 * 60 * 1000);

		// new Timer().schedule(new TimeScheduleUtil(), 1000); // test
	}

	// this.setTimeout(timeout);
	// new Timer().schedule(new TimeScheduleUtil(), 30 * 60 * 1000);

	// new Timer().schedule(new TimeScheduleUtil(map), 100); // test

	public void init() {
		TimerTask task = new TimeScheduleUtil();
		new Timer().schedule(task, 0, getTimeout());
	}

	// clear session each 30 mins
	@Override
	public void run() {
		System.out.println("run method has been invoke  "
				+ SessionCache.getSessionCache().isEmpty() + " or "
				+ (SessionCache.getSessionCache() == null));
		try {
			Set<String> keyMap = SessionCache.getSessionCache().keySet();
			Iterator<String> key = keyMap.iterator();
			while (key.hasNext() && !keyMap.isEmpty()) {
				Map<String, Object> value = SessionCache.getSessionCache().get(
						key.next());
				Set<String> date = value.keySet();
				for (String dateString : date) {
					if (new Date(new Date().getTime() - 30 * 60 * 1000)
							.before(sdf.parse(dateString))) {
						key.remove();
						keyMap.remove(key);
						SessionCache.getSessionCache().keySet().remove(key);
						System.out.println(key + "  has been remove");
						break;
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getTimeout() {
		return timeout;
	}

}
