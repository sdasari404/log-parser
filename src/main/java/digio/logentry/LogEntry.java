package digio.logentry;

import java.util.Objects;

public class LogEntry {

    private final String ipAddr;
    private final String url;

    public LogEntry(final String ipAddr, final String url) {
        this.ipAddr = ipAddr;
        this.url = url;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(ipAddr, logEntry.ipAddr) && Objects.equals(url, logEntry.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddr, url);
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "ipAddr='" + ipAddr + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
