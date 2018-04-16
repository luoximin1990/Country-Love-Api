package com.marykay.country.love.util;

import com.alibaba.fastjson.JSON;
import com.marykay.country.love.api.contract.dto.OutputMsg;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by yangliu on 2017/12/25.
 */
@Service
public class LogService {
	
//	@Value("${GIT_HASH}")
//	private String GIT_HASH;
//	@Value("${AppName}")
//	private String AppName;
//	@Value("${ENV}")
//	private String ENV;

	private String GIT_HASH="GIT_HASH123465";
	private String AppName="AppName123";
	private String ENV="ENV0";
	
	public void info(String message) {
		info(message, UUID.randomUUID());
	}

	public void info(String message, UUID tranId) {
		String hash = "EMPTY-HASH";
		if (StringUtils.isNotEmpty(GIT_HASH)) {
			hash = GIT_HASH;
		}
		String strOutputMessage = generateMessageBody(message, hash, "Info");
		System.out.println(strOutputMessage);
	}

	public void error(String message) {
		error(message, UUID.randomUUID());
	}

	public void error(String message, UUID tranId) {
		String hash = "EMPTY-HASH";
		if (!StringUtils.isNotEmpty(GIT_HASH)) {
			hash = GIT_HASH;
		}
		String strOutputMessage = generateMessageBody(message, hash, "Error");
		System.out.println(strOutputMessage);
	}

	private String generateMessageBody(String message, String hash, String LogLevel) {
		return generateMessageBody(message, hash, LogLevel, UUID.randomUUID());
	}

	private String generateMessageBody(String message, String hash, String logLevel, UUID tranId) {
		OutputMsg msg = new OutputMsg();
		msg.setApplication(AppName);
		msg.setENV(ENV);
		msg.setGitHash(hash);
		msg.setMessageBody(message);
		msg.setLogLevel(logLevel);
		msg.setTime(new Date());
		msg.setTransationId(tranId);
		String strOutputMessage = JSON.toJSONString(msg);
		return strOutputMessage;
	}

	public void writeInfo(String message, UUID tranId) {
		String hash = "EMPTY-HASH";
		if (StringUtils.isNotEmpty(GIT_HASH)) {
			hash = GIT_HASH;
		}
		String strOutputMessage = generateMessageBody(message, hash, "Info", tranId);
		System.out.println(strOutputMessage);
	}

	public void writeError(String message, UUID tranId) {
		String hash = "EMPTY-HASH";
		if (!StringUtils.isNotEmpty(GIT_HASH)) {
			hash = GIT_HASH;
		}
		String strOutputMessage = generateMessageBody(message, hash, "Error", tranId);
		System.out.println(strOutputMessage);
	}
}