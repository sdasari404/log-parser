package digio.parse;

import digio.logentry.LogEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public List<LogEntry> parse(final File file) throws FileNotFoundException {

        final Scanner scan = new Scanner(file);
        List<LogEntry> logEntries = new ArrayList<>();

        while(scan.hasNextLine()) {
            String logLine = scan.nextLine();
            logEntries.add(new LogEntry(extractIPAddr(logLine), extractUrl(logLine)));
        }
        return logEntries;
    }

    /**
     * Method: extractIPAddr
     * Params: logLine
     *
     * This method parses the log line and extracts the IP address substring
     * */
    private String extractIPAddr(String logLine) {
        final String IPADDRESS_PATTERN =
                "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        final Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        final Matcher matcher = pattern.matcher(logLine);
        if (matcher.find()) {
            return matcher.group();
        }
        else{
            return "";
        }
    }


    /**
     * Method: extractUrl
     * Params: logLine (log line with the http method and url)
     *
     * This method parses the log line and extracts the url substring, ignoring the http method
     * */
    private String extractUrl(String logLine) {
        return
            logLine.contains("\"GET ") ? logLine.substring(logLine.indexOf("\"GET ") + 5, logLine.indexOf("HTTP/")-1) :
            logLine.contains("\"POST ") ? logLine.substring(logLine.indexOf("\"POST ") + 6, logLine.indexOf("HTTP/")-1) :
            logLine.contains("\"PUT ") ? logLine.substring(logLine.indexOf("\"PUT ") + 5, logLine.indexOf("HTTP/")-1) :
            logLine.contains("\"DELETE ") ? logLine.substring(logLine.indexOf("\"DELETE ") + 8, logLine.indexOf("HTTP/")-1) :
            logLine.contains("\"PATCH ") ? logLine.substring(logLine.indexOf("\"PATCH ") + 7, logLine.indexOf("HTTP/")-1): logLine;
    }

}

