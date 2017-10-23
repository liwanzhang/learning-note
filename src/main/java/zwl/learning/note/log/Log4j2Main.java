package zwl.learning.note.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Main {
    private static final Logger logger = LoggerFactory.getLogger(Log4j2Main.class);
    public static void main(String[] args) {
        logger.trace("main run");

    }

}