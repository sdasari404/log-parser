package digio.analytics;

import digio.logentry.LogEntry;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AnalyticsTest {

    final List<LogEntry> testEntries = Arrays.asList(
            new LogEntry("177.71.128.21", "/intranet-analytics/"),
            new LogEntry("177.71.128.21", "/intranet-analytics/"),
            new LogEntry("168.41.191.40", "http://example.net/faq/"),
            new LogEntry("168.41.191.40", "http://example.net/faq/"),
            new LogEntry("177.71.128.21", "/this/page/does/not/exist/"),
            new LogEntry("168.41.191.41", "/this/page/does/exist/"),
            new LogEntry("168.41.191.40", "/intranet-analytics/"),
            new LogEntry("168.41.191.41", "/this/page/does/not/exist/"),
            new LogEntry("168.41.191.41", "/this/page/does/not/exist/"),
            new LogEntry("168.41.191.42", "/this/page/exist/")
    );

    @Test
    public void testFindUniqueIpAddress() {

        final List<String> expectedList = Arrays.asList("177.71.128.21", "168.41.191.40", "168.41.191.41", "168.41.191.42");
        List<String> uniqueIPAddresses = new Analytics().getUniqueIpAddr(testEntries);

        assertTrue(CollectionUtils.isEqualCollection(expectedList, uniqueIPAddresses));
    }

    @Test
    public void testGetTop3FrequentIPAddr() {

        final List<String> expectedList = Arrays.asList("177.71.128.21", "168.41.191.40", "168.41.191.41");
        List<String> top3FrequentIPAddr = new Analytics().getTop3FrequentIPAddr(testEntries);

        assertTrue(CollectionUtils.isEqualCollection(expectedList, top3FrequentIPAddr));
    }

    @Test
    public void testGetTop3FrequentUrls() {

        final List<String> expectedList = Arrays.asList("/intranet-analytics/", "/this/page/does/not/exist/", "http://example.net/faq/");
        List<String> top3FrequentUrls = new Analytics().getTop3FrequentUrls(testEntries);

        assertTrue(CollectionUtils.isEqualCollection(expectedList, top3FrequentUrls));
    }

}