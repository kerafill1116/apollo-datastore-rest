package apollo.datastore;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class TimeZone {

    public static final String GMT_JAVA_TIME_ZONE_ID = "GMT";
    public static final String UTC_JAVA_TIME_ZONE_ID = "UTC";

    @Id
    private String timeZoneId;
    private String javaTimeZoneId;
    private long offset;

    private TimeZone() { }

    public TimeZone(String timeZoneId, String javaTimeZoneId, long offset) {
        this.timeZoneId = timeZoneId;
        this.javaTimeZoneId = javaTimeZoneId;
        this.offset = offset;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public String getJavaTimeZoneId() {
        return javaTimeZoneId;
    }

    public long getOffset() {
        return offset;
    }
}
