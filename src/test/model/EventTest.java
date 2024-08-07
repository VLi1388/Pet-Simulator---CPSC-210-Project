package model;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

// code for this class came from the AlarmSystem project
public class EventTest {
    private Event event;
    private Date date;

    // NOTE: these tests might fail if time at which line (2) below is executed
    // is different from time that line (1) is executed. Lines (1) and (2) must
    // run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        event = new Event("New player created"); // (1)
        date = Calendar.getInstance().getTime(); // (2)
    }

    @Test
    public void testEvent() {
        assertEquals("New player created", event.getDescription());
        assertEquals(date, event.getDate());
    }

    @Test
    public void testToString() {
        assertEquals(date.toString() + "\n" + "New player created", event.toString());
    }

    @Test
    public void testEventEqualNull() {
        Event testEvent = null;
        
        assertFalse(event.equals(testEvent));
    }

    @Test
    public void testEventEqualfalse() {
        Event testEvent = new Event("event 2");
        
        assertFalse(event.equals(testEvent));
    }
}