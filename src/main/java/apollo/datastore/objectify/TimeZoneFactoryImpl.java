package apollo.datastore.objectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import apollo.datastore.TimeZone;
import apollo.datastore.TimeZoneFactoryInterface;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Work;

public class TimeZoneFactoryImpl implements TimeZoneFactoryInterface {

    @Override
    public TimeZone add(String timeZoneId, String javaTimeZoneId, long offset) {
        Key<TimeZone> timeZoneKey = ofy().save().entity(new TimeZone(timeZoneId, javaTimeZoneId, offset)).now();
        return ofy().load().key(timeZoneKey).now();
    }

    @Override
    public TimeZone get(String timeZoneId) {
        return ofy().load().type(TimeZone.class).id(timeZoneId).now();
    }

    @Override
    public TimeZone save(TimeZone timeZone) {
        Key<TimeZone> timeZoneKey = ofy().save().entity(timeZone).now();
        return ofy().load().key(timeZoneKey).now();
    }

    @Override
    public TimeZone tAdd(final String timeZoneId, final String javaTimeZoneId, final long offset) {
        return ofy().transact(new Work<TimeZone>() {
            public TimeZone run() {
                TimeZone timeZone = get(timeZoneId);
                if(timeZone == null) {
                    timeZone = add(timeZoneId, javaTimeZoneId, offset);
                }
                return timeZone;
            }
        });
    }
}
