package apollo.datastore;

public class TimeZone {

    public static final String GMT_JAVA_TIME_ZONE_ID = "GMT";
    public static final String UTC_JAVA_TIME_ZONE_ID = "UTC";

    private String timeZoneId;
    private String javaTimeZoneId;
    private long offset;

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
