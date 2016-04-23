package com.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public class ProcessRequest {

	public static Map<String, String> process(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		Map<String, String> result = new HashMap<String, String>();
		// System.out.println(map.size());
		for (String set : map.keySet()) {
			String[] strings = map.get(set);
			for (String s : strings) {
				result.put(set, s);
				System.out.println(set + "  string = " + s);
			}
		}
		return result;
	}

	public static JSONObject getJsonObject(HttpServletRequest request) {
		JSONObject jsonObject = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(
					request.getInputStream()));
			String content = br.readLine();
			System.out.println("json object is : " + content);
			jsonObject = JSONObject.fromObject(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
}
