package digio.analytics;

import digio.logentry.LogEntry;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analytics {

    public List<String> getUniqueIpAddr(List<LogEntry> logEntries) {
        return logEntries.stream()
                .map(item -> item.getIpAddr())
                .distinct()
                .collect(Collectors.toList());
    }
    
    public List<String> getTop3FrequentIPAddr(List<LogEntry> logEntries) {
        return getMostFrequentItemsByLimit(logEntries.stream()
                .map(item -> item.getIpAddr()).collect(Collectors.toList()), 3);
    }

    public List<String> getTop3FrequentUrls(List<LogEntry> logEntries) {
        return getMostFrequentItemsByLimit(logEntries.stream()
                .map(item -> item.getUrl()).collect(Collectors.toList()), 3);
    }

    private List<String> getMostFrequentItemsByLimit(List<String> entries, long limit) {
        return entries.stream()
                // Generate a map with the frequency of each key in the list
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                //Sort in the reverse order to find the most frequent entries
                .sorted((val1, val2) -> Long.compare(val2.getValue(), val1.getValue()))
                .limit(limit) // Limit to the top n entries in the map
                .map(Map.Entry::getKey) // Map the keys into a stream
                .collect(Collectors.toList());
    }

}
