package OOP06_SOLID.loggerLib.loggers.interfaces;

import java.io.IOException;

public interface Logger {
   void logInfo(String date, String message) throws IOException;
   void logWarning(String date, String message) throws IOException;
   void logError(String date, String message) throws IOException;
   void logCritial(String date, String message) throws IOException;
   void logFatal(String date, String message) throws IOException;
}
