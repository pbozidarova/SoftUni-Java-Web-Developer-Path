package OOP06_SOLID.loggerLib.appenders.interfaces;


import OOP06_SOLID.loggerLib.enumerations.ReportLevel;

import java.io.IOException;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message) throws IOException;
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();
}
