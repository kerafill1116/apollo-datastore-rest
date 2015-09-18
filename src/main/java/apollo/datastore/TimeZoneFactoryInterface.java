package apollo.datastore;

public interface TimeZoneFactoryInterface {
    TimeZone add(String timeZoneId, String javaTimeZoneId, long offset);
    TimeZone get(String timeZoneId);
    TimeZone save(TimeZone timeZone);
    TimeZone tAdd(String timeZoneId, String javaTimeZoneId, long offset);
}
