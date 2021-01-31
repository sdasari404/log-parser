package digio.reporting;

import digio.logentry.LogEntry;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Reporting {

    public List<String> getUniqueIpAddr(List<LogEntry> logEntries) {
        return logEntries.stream()
                .map(item -> item.getIpAddr())
                .distinct()
                .collect(Collectors.toList());
    }

    private long getFrequencyOfAttribute(List<String> entries) {
        Map<String, Long> frequencyMap =
                entries.stream().collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        Optional<Map.Entry<String, Long>> maxEntry = frequencyMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        return maxEntry.get().getValue();
    }

    public long getMostFrequentIpAddr(List<LogEntry> logEntries) {
        return getFrequencyOfAttribute(logEntries.stream()
                .map(LogEntry::getIpAddr)
                .collect(Collectors.toList()));
    }

    public long getMostFrequentUrls(List<LogEntry> logEntries) {
        return getFrequencyOfAttribute(logEntries.stream()
                .map(LogEntry::getUrl)
                .collect(Collectors.toList()));
    }

}
