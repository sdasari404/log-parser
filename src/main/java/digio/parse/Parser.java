package digio.parse;

import digio.logentry.LogEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Parser {

    public List<LogEntry> parse(File file) throws FileNotFoundException {
        List<LogEntry> logEntries = new ArrayList<>();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            String logLine = scan.nextLine();
            System.out.println(logLine);
            String[] splits = StringUtils.split(logLine, "[] ");
            System.out.println(splits.length);
            Arrays.stream(splits).forEach(System.out::println);
        }
        return logEntries;
    }
}

