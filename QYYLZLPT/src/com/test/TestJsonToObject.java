package com.test;

import org.json.JSONArray;
import org.json.JSONException;

import net.sf.json.JSONObject;

public class TestJsonToObject {

	static final String json = "{\"id\":\"1\",\"name\":\"string\",\"password\":\"123\",\"itid\":\"111\",\"itname\":\"name\"}";

	public static void main(String[] args) throws JSONException {
		JSONObject jsonObject = JSONObject.fromObject(json);
		// System.out.println(jsonObject.get("id"));
		POJO pojo = (POJO) JSONObject.toBean(jsonObject, POJO.class);
		IT it = (IT) JSONObject.toBean(jsonObject, IT.class);

		System.out.println("intid" + it.toString());
		POJO p = new POJO();
		p.setId(123);
		p.setName("e");
		p.setPassword("12345");
		JSONObject jObject = JSONObject.fromObject(p);
		System.out.println(jObject.toString());

		JSONObject policy = new JSONObject();
		policy.put("trade", "1");
		JSONArray areaList = new JSONArray();
		areaList.put(0, "123");
		areaList.put(1, "12");
		areaList.put(2, "34");
		policy.put("area", areaList.toString());
		System.out.println(policy.toString());
	}
}
