package apollo.datastore.objectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import apollo.datastore.Session;
import apollo.datastore.SessionLog;
import apollo.datastore.SessionLogFactoryInterface;

import com.googlecode.objectify.Key;

public class SessionLogFactoryImpl implements SessionLogFactoryInterface {

    @Override
    public SessionLog add(Session session) {
        Key<SessionLog> sessionLogKey = ofy().save().entity(new SessionLog(session)).now();
        return ofy().load().key(sessionLogKey).now();
    }

    @Override
    public SessionLog get(String sessionId) {
        return ofy().load().type(SessionLog.class).id(sessionId).now();
    }

    @Override
    public SessionLog save(SessionLog sessionLog) {
        Key<SessionLog> sessionLogKey = ofy().save().entity(sessionLog).now();
        return ofy().load().key(sessionLogKey).now();
    }
}
