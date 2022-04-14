package com.jiajia.support.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {

    private static final Logger logger = LogManager.getLogger();

    public static void i(String msg) {
        logger.info(msg);
    }

    public static void d(String msg) {
        logger.debug(msg);
    }

    public static void e(String msg) {
        logger.error(msg);
    }

    public static void w(String msg) {
        logger.warn(msg);
    }


}
