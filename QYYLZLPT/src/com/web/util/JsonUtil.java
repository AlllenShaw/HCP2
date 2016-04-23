package com.web.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {

	public static Map<String, Boolean> jsonObject2Map(JSONObject jsonObject) {

		JSONArray array = jsonObject.getJSONArray("list");
		Map<String, Boolean> map = new HashMap<String, Boolean>();

		for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			map.put(object.getString("id"), object.getBoolean("value"));
		}

		Set<String> set = map.keySet();

		for (String string : set) {
			System.out.println(string + "   " + map.get(string));
		}

		return map;
	}

	public static JSONArray map2JsonObject(Map map) {
		Set<String> set = map.keySet();

		JSONArray array = new JSONArray();
		for (String string : set) {
			JSONObject object = new JSONObject();
			object.put("id", string);
			object.put("value", String.valueOf(map.get(string)));
			array.add(object);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", array);

		System.out.println("return map 2 object " + jsonObject.toString());
		return array;
	}

	public static void main(String[] args) {

		JSONArray array = new JSONArray();

		for (int i = 0; i < 5; i++) {
			JSONObject object = new JSONObject();
			object.put("id", i);
			object.put("value", 0);
			array.add(object);
		}

		System.out.println("array : " + array.toString());

		JSONObject object = new JSONObject();
		object.put("list", array);

		Map<String, Boolean> map = jsonObject2Map(object);

		JSONArray jsonObject = map2JsonObject(map);

		System.out.println("object : " + object.toString());

	}

}