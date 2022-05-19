package demo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import java.io.File;

public class LoggerHelper {

    private static boolean root = false;
    private static  String filePath = "/src/main/resource/log4j2.properties";
    static File loggerPropertiesFilePath = new File(filePath);

    public static Logger getLogger(Class <?> cls)
    {
        if(root){
            return LogManager.getLogger(cls);
        }
        readLoggerConfiguration();
        root = true;
        return LogManager.getLogger(cls);
    }

    private static void readLoggerConfiguration()
    {
        LoggerContext context = (LoggerContext)LogManager.getContext(false);
        context.setConfigLocation(loggerPropertiesFilePath.toURI());
    }
}
