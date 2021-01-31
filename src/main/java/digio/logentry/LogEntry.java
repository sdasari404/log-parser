package digio.logentry;

import java.util.Date;

public class LogEntry {

    private String ipAddr;
    private Date timestamp;
    private String url;
    private int response;
    private String headers;

    public LogEntry(String ipAddr, Date timestamp, String url, int response, String headers) {
        this.ipAddr = ipAddr;
        this.timestamp = timestamp;
        this.url = url;
        this.response = response;
        this.headers = headers;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUrl() {
        return url;
    }

    public int getResponse() {
        return response;
    }

    public String getHeaders() {
        return headers;
    }

}
