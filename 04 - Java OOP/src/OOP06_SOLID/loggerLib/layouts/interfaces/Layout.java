package OOP06_SOLID.loggerLib.layouts.interfaces;

import L6_SOLID.loggerLib.enumerations.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
}
