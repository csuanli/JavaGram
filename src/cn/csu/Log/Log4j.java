package cn.csu.Log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j {

	public static void main(String[] args) {
	    PropertyConfigurator.configure("C:/Users/Administrator/git/JavaGram/src/log4j.properties");
	    Logger logger = Logger.getLogger(Log4j.class);
	    logger.debug("why 1");
	    logger.error("why 2");
	    logger.info("why 3");
	}

}
