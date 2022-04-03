package de.telran.logentry;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Service {

    public Map<String, Long> getAttendanceByUrl(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl, counting()));
    }


    public Map<String, Integer> getUniqueUsersNumberByUrl(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl,
                        mapping(LogEntry::getLogin,
                                collectingAndThen(toSet(), Set::size)))
                );
    }

    public Map<String, Set<String>> getUniqueUsersNumberByUrlCollectors(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getLogin, mapping(LogEntry::getUrl,toSet())));

    }
 }
