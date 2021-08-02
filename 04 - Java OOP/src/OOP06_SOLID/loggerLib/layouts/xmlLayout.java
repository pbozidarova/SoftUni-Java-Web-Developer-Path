package OOP06_SOLID.loggerLib.layouts;


import OOP06_SOLID.loggerLib.enumerations.ReportLevel;
import OOP06_SOLID.loggerLib.layouts.interfaces.Layout;

public class xmlLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("<log>\r\n" +
                "   <date>%s</date>\r\n" +
                "   <level>%s</level>\r\n" +
                "   <message>%s</message>\r\n" +
                "</log>\r\n", date, reportLevel.toString(), message);
    }
}
