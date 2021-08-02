package OOP06_SOLID.loggerLib.appenders;

import L6_SOLID.loggerLib.appenders.interfaces.Appender;
import L6_SOLID.loggerLib.enumerations.ReportLevel;
import L6_SOLID.loggerLib.layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender{
    private Layout layout;
    private ReportLevel reportLevel;
    private int loggedMessage;

    protected AppenderImpl(Layout layout){
        this.layout = layout;
        this.setReportLevel(reportLevel.INFO);
        this.loggedMessage = 0;
    }

    protected AppenderImpl(Layout layout, ReportLevel reportLevel){
        this(layout);
        this.setReportLevel(reportLevel);
        this.loggedMessage = 0;
    }

    protected String format(String date, ReportLevel reportLevel, String message){
       this.loggedMessage++;
       return this.layout.format(date, reportLevel, message);
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }
    @Override
    public ReportLevel getReportLevel(){
        return this.reportLevel;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %s, ",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.toString(),
                this.loggedMessage
                );
    }
}
