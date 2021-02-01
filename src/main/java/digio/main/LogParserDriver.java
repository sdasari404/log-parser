package digio.main;

import digio.analytics.Analytics;
import digio.logentry.LogEntry;
import digio.parse.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class LogParserDriver {
    public static void main(String[] args) {
        try {
            List<LogEntry> logEntries = new Parser().parse(new File("src/main/resources/example.log"));

            Analytics analytics = new Analytics();

            System.out.println("The number of unique IP addresses:" + analytics.getUniqueIpAddr(logEntries).size());
            System.out.println("The top 3 most visited URLs:" + analytics.getTop3FrequentUrls(logEntries));
            System.out.println("The top 3 most active IP addresses:" + analytics.getTop3FrequentIPAddr(logEntries));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
