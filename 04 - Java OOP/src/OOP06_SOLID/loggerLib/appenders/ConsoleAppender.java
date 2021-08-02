package OOP06_SOLID.loggerLib.appenders;


import L6_SOLID.loggerLib.enumerations.ReportLevel;
import L6_SOLID.loggerLib.layouts.interfaces.Layout;


public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel){
        super(layout, reportLevel);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(this.format(date, reportLevel, message));
    }



}
