package com.ziyun.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

public abstract class BaseController {

	private static final String RESP_CODE = "resp_code";

	private static final String RESP_MSG = "resp_msg";

	protected @ResponseBody String responseToJson(int code, String msg, Object... object) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(RESP_CODE, code);
		resultMap.put(RESP_MSG, msg);
		for (Object obj : object) {
			resultMap.put(ClassUtils.getShortName(obj.getClass()).toLowerCase(), obj);
		}
		return JSON.toJSONString(resultMap);
	}

}
