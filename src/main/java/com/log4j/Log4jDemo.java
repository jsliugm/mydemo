package com.log4j;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Log4jDemo {

	public static void main(String[] args) {
		// 记录debug级别的信息
		log.debug("This is debug message.");
		// 记录info级别的信息
		log.info("This is info message.");
		// 记录error级别的信息
		log.error("This is error message.");
	}
}
