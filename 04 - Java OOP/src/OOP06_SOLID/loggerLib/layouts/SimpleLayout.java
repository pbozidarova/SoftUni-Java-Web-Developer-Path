package OOP06_SOLID.loggerLib.layouts;

import OOP06_SOLID.loggerLib.enumerations.ReportLevel;
import OOP06_SOLID.loggerLib.layouts.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel.toString(), message);
    }
}
