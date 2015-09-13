import static org.junit.Assert.*;

import apollo.datastore.TimeZone;

import org.junit.*;

public class TimeZoneTest {

    // 32400;asia_tokyo;Asia/Tokyo
    private String timeZoneId = "asia_tokyo";
    private String javaTimeZoneId = "Asia/Tokyo";
    private long offset = 32400L;

    @Test
    public void testStringStringLong() {
        TimeZone timeZone = new TimeZone(timeZoneId, javaTimeZoneId, offset);
        assertEquals(timeZoneId, timeZone.getTimeZoneId());
        assertEquals(javaTimeZoneId, timeZone.getJavaTimeZoneId());
        assertEquals(offset, timeZone.getOffset());
    }

    // 28800;asia_singapore;Asia/Singapore
    @Test
    public void testSetTimeZoneId() {
        TimeZone timeZone = new TimeZone(timeZoneId, javaTimeZoneId, offset);
        assertEquals(timeZoneId, timeZone.getTimeZoneId());
        String newTimeZoneId = "asia_singapore";
        timeZone.setTimeZoneId(newTimeZoneId);
        assertEquals(newTimeZoneId, timeZone.getTimeZoneId());
    }

    @Test
    public void testSetJavaTimeZoneId() {
        TimeZone timeZone = new TimeZone(timeZoneId, javaTimeZoneId, offset);
        assertEquals(javaTimeZoneId, timeZone.getJavaTimeZoneId());
        String newJavaTimeZoneId = "Asia/Singapore";
        timeZone.setJavaTimeZoneId(newJavaTimeZoneId);
        assertEquals(newJavaTimeZoneId, timeZone.getJavaTimeZoneId());
    }

    @Test
    public void testSetOffset() {
        TimeZone timeZone = new TimeZone(timeZoneId, javaTimeZoneId, offset);
        assertEquals(offset, timeZone.getOffset());
        long newOffset = 28800L;
        timeZone.setOffset(newOffset);
        assertEquals(newOffset, timeZone.getOffset());
    }
}
