package com.logger.app;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;

public class Product {
	
	private static Logger log= Logger .getLogger(Product.class);
	public static void main(String[] args) throws Exception {
		
/*		//SIMPLE LAYOUT
		Layout layout = new SimpleLayout();
		Appender ap = new ConsoleAppender(layout);
		
		log.addAppender(ap);
		log.info("Hello");
*/

/*		
		//HTML LAYOUT
		Layout layout =new HTMLLayout();
		Appender ap = new ConsoleAppender(layout);
		log.addAppender(ap);
		
		log.debug("Hello");
		log.info("Hello");
		log.warn("Hello");
		log.error("Hello");
		log.fatal("Hello");
*/

/*
 * 		//XML LAYOUT
		Layout layout = new XMLLayout();
		Appender ap = new ConsoleAppender(layout);
		log.addAppender(ap);
		log.debug("Hello");
		log.info("Hello");
		log.warn("Hello");
		log.error("Hello");
		log.fatal("Hello");
*/
		
/*		
		Layout layout = new HTMLLayout();
		Appender ap = new FileAppender(layout, "myapp.log");
		log.addAppender(ap);
		
		log.debug("Hello");
		log.info("Hello");
		log.warn("Hello");
		log.error("Hello");
		log.fatal("Hello");
*/
		
	
	}
}
