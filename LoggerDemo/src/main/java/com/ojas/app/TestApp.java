package com.ojas.app;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;

public class TestApp {

	private static Logger log = Logger.getLogger(TestApp.class);
	
	public static void main(String[] args) throws IOException {
		//create layout
		//Layout layout = new SimpleLayout();
		
		//Layout layout = new HTMLLayout();
		
		//Layout layout = new XMLLayout();
		
		Layout layout = new PatternLayout("%p %d %C %M %n");
		
		//link appender+layout
		
		Appender appender= new ConsoleAppender(layout);
		//Appender appender = new FileAppender(layout, "C:/LoggerFile/data.log");
		//add appender to logger
		log.addAppender(appender);
		
		//print messages
		log.debug("From Debug");
		log.info("From Info");
		log.warn("From Warn");
		log.error("From Error");
		log.fatal("From Fatal");
		 
		
		
		
	}
}
