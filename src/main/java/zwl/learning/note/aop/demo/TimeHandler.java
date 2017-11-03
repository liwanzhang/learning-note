package zwl.learning.note.aop.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangwanli
 * @description
 * @date 2017-10-24 上午11:48
 */
public class TimeHandler {
    public static final Logger LOGGER = LoggerFactory.getLogger(TimeHandler.class);
    public void printTime() {
        LOGGER.info("CurrentTime = " + System.currentTimeMillis());
    }
}
