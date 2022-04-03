package de.telran.logentry;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    Service s =new Service();


    LogEntry logEntry1 = new LogEntry("Anton", "news.com");
    LogEntry logEntry3 = new LogEntry("Masha", "news.com");
    LogEntry logEntry4 = new LogEntry("Vasya", "news.com");
    LogEntry logEntry6 = new LogEntry("Vasya", "news.com");
    LogEntry logEntry2 = new LogEntry("Anton", "tut.by");
    LogEntry logEntry5 = new LogEntry("Petya", "tut.by");

    List<LogEntry> e = Arrays.asList(logEntry1, logEntry2, logEntry3, logEntry4, logEntry5, logEntry6);


    @Test
    public void getAttendanceByUrl_Test() {
        Map<String, Long> result = s.getAttendanceByUrl(e);
        assertEquals(4, result.get("news.com"));
        assertEquals(2, result.get("tut.by"));
    }
    @Test
    public void getAttendanceByUrl_zero_Test() {
        List<LogEntry> logEntries = Collections.emptyList();
        Map<String, Long> expected = Collections.emptyMap();

        assertEquals(expected, s.getAttendanceByUrl(logEntries));
    }

   @Test
    public void getUniqueUsersNumberByUr_Test() {
        Map<String, Integer> result = s.getUniqueUsersNumberByUrl(e);
        assertEquals(3, result.get("news.com"));
        assertEquals(2, result.get("tut.by"));
    }

    @Test
    public void getUniqueUsersByUrlCollectors_Test() {
        LogEntry l1 = new LogEntry("Anton", "githab.com");
        LogEntry l2 = new LogEntry("Anton", "tut.by");
        LogEntry l3= new LogEntry("Anton", "news.com");
        LogEntry l4 = new LogEntry("Petr", "githab.com");
        LogEntry l5= new LogEntry("Olga", "news.com");
        LogEntry l6 = new LogEntry("Ivan", "tut.by");
        List<LogEntry> l = Arrays.asList(l1,l2,l3,l4, l5, l6);

        Map<String,Set<String>> expected = new HashMap<>();
        expected.put("Anton", Set.of("githab.com", "tut.by","news.com"));
        expected.put("Olga", Collections.singleton("news.com"));
        expected.put("Petr", Collections.singleton("githab.com"));
        expected.put("Ivan", Collections.singleton("tut.by"));
        assertEquals(expected, s.getUniqueUsersNumberByUrlCollectors(l));
    }
}