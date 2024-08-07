package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// code for this class came from the AlarmSystem project
public class EventLogTest {
    private Event event1;
    private Event event2;
    private Event event3;
    private Event event4;
    private Event event5;

    @BeforeEach
    public void loadEvents() {
        event1 = new Event("event1");
        event2 = new Event("event2");
        event3 = new Event("event3");
        event4 = null;
        event5 = new Event("event5");
        EventLog el = EventLog.getInstance();
        el.logEvent(event1);
        el.logEvent(event2);
        el.logEvent(event3);
    }

    @Test
    public void testLogEvent() {
        List<Event> log = new ArrayList<Event>();

        EventLog eventLog = EventLog.getInstance();
        for (Event next : eventLog) {
            log.add(next);
        }

        assertTrue(log.contains(event1));
        assertTrue(log.contains(event2));
        assertTrue(log.contains(event3));
        assertFalse(log.contains(event4));
        assertFalse(log.contains(event5));
    }

    @Test
    public void testClear() {
        EventLog el = EventLog.getInstance();
        el.clear();
        Iterator<Event> itr = el.iterator();
        assertTrue(itr.hasNext()); // After log is cleared, the clear log event is added
        assertEquals("Event log cleared.", itr.next().getDescription());
        assertFalse(itr.hasNext());
    }
}
