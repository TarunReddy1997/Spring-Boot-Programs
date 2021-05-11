package com.ojas.app;

import java.io.IOException;

import org.apache.log4j.Logger;

public class TestApp {
	

	private static Logger log = Logger.getLogger(TestApp.class);
	
	public static void main(String[] args) throws IOException{
		
		log.debug("from DEBUG");
		log.info("from INFO");
		log.warn("from WARN");
		log.error("from ERROR");
		log.fatal("from FATAL");
	}
} 
