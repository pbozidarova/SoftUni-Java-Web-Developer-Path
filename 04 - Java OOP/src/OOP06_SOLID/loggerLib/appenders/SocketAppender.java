package OOP06_SOLID.loggerLib.appenders;


import OOP06_SOLID.loggerLib.enumerations.ReportLevel;
import OOP06_SOLID.loggerLib.layouts.interfaces.Layout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketAppender extends AppenderImpl {
    private Socket client;
    private PrintWriter out;
    private BufferedReader in;

    protected SocketAppender(Layout layout) throws IOException {
        super(layout);
        InetAddress address = InetAddress.getLocalHost();
        this.client = new Socket(address, 21);
        this.startConnection("127.0.0.1", 21);
    }

    public void startConnection(String ip, int port) throws IOException {
        client = new Socket(ip, port);
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    protected SocketAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) throws IOException {
        this.sendMessage(this.format(date, reportLevel,message));
    }
}
