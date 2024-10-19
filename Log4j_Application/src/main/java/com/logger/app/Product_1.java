package com.logger.app;

import org.apache.log4j.Logger;

public class Product_1 {
	
	private static Logger log=Logger.getLogger(Product_1.class);
	public static void main(String[] args) {
	
		log.debug("Hello");
		log.info("Hello");
		log.warn("Hello");
		log.error("Hello");
		log.fatal("Hello");
	}
}
