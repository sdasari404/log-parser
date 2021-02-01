package digio.parse;

import digio.logentry.LogEntry;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {

    @Test
    public void testFileParser() throws FileNotFoundException {

        List<LogEntry> testEntries = Arrays.asList(
                new LogEntry("177.71.128.21", "/intranet-analytics/"),
                new LogEntry("168.41.191.40", "http://example.net/faq/"),
                new LogEntry("168.41.191.41", "/this/page/does/not/exist/")
        );

        List<LogEntry> logEntries = new Parser().parse(new File("src/test/resources/test-1.log"));

        assertTrue(CollectionUtils.isEqualCollection(testEntries, logEntries));
    }

    @Test
    public void testFileParserWhenUrlIsWrong() throws FileNotFoundException {

        final List<LogEntry> expectedEntries = Arrays.asList(
                new LogEntry("177.71.128.21", "/intranet-analytics/"),
                new LogEntry("168.41.191.40", "http://example.net/faq/"),
                new LogEntry("168.41.191.41", "/this/page/does/not/does/not/exist/") //Wrong url
        );

        List<LogEntry> logEntries = new Parser().parse(new File("src/test/resources/test-1.log"));

        assertFalse(CollectionUtils.isEqualCollection(expectedEntries, logEntries));
    }

    @Test
    public void testFileParserWhenFileHasGibberish() throws FileNotFoundException {

        final List<LogEntry> expectedEntries = Arrays.asList(
                new LogEntry("177.71.128.21", "/intranet-analytics/"),
                new LogEntry("168.41.191.40", "http://example.net/faq/"),
                new LogEntry("168.41.191.41", "/this/page/does/not/exist/")
        );

        List<LogEntry> logEntries = new Parser().parse(new File("src/test/resources/test-2.log"));

        assertTrue(CollectionUtils.isEqualCollection(expectedEntries, logEntries));
    }

    @Test
    public void testFileParserWhenFileDoesNotExist() {

        Assertions.assertThrows(FileNotFoundException.class, () -> {
            new Parser().parse(new File("src/test/resources/test-3.log"));
        });
    }
}