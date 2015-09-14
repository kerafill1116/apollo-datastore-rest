import static org.junit.Assert.*;

import apollo.datastore.TimeZone;

import org.junit.*;

public class TimeZoneTest {

    @Test
    public void testStringStringLong() {
        // 32400;asia_tokyo;Asia/Tokyo
        String timeZoneId = "asia_tokyo";
        String javaTimeZoneId = "Asia/Tokyo";
        long offset = 32400L;
        TimeZone timeZone = new TimeZone(timeZoneId, javaTimeZoneId, offset);
        assertEquals(timeZoneId, timeZone.getTimeZoneId());
        assertEquals(javaTimeZoneId, timeZone.getJavaTimeZoneId());
        assertEquals(offset, timeZone.getOffset());
    }
}
