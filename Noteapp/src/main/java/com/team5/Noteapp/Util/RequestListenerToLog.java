package com.team5.Noteapp.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Service
public class RequestListenerToLog {
	private static final Logger logger = LoggerFactory.getLogger(RequestListenerToLog.class);
	
	@EventListener
	public void handleRequest(ServletRequestHandledEvent event) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("Ip Address: ");
		stringBuilder.append(event.getClientAddress());
		stringBuilder.append("\tRequested Url: ");
		stringBuilder.append(event.getRequestUrl());
		stringBuilder.append("\tStatus Code: ");
		stringBuilder.append(event.getStatusCode());
		stringBuilder.append("\tProcessing Time: ");
		stringBuilder.append(event.getProcessingTimeMillis());
		logger.info(stringBuilder.toString());
	}
}
