package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;


public class LogConfig {

    private static final Logger logger = LogManager.getLogger(LogConfig.class);

    public static void initializeLogging() {
        try {
            File logFolder = new File("logs");
            if (!logFolder.exists()) {
                boolean created = logFolder.mkdirs();
                if (created) {
                    logger.info("Log folder created successfully.");
                } else {
                    logger.info("Failed to create log folder.");
                }
            }
        }
        catch (Exception e) {
            logger.error("Error initializing logging for scenario: ", e);
        }
    }
}

