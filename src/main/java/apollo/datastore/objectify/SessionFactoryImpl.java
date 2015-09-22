package apollo.datastore.objectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import apollo.datastore.Session;
import apollo.datastore.SessionFactoryInterface;
import apollo.datastore.User;
import apollo.datastore.utils.Error;
import apollo.datastore.utils.SessionHandlingException;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Work;

import java.util.Date;

public class SessionFactoryImpl implements SessionFactoryInterface {

    @Override
    public Session add(User user, Date dateSignedIn) {
        Key<Session> sessionKey = ofy().save().entity(new Session(user, dateSignedIn)).now();
        return ofy().load().key(sessionKey).now();
    }

    @Override
    public Session get(String sessionId) {
        return ofy().load().type(Session.class).id(sessionId).now();
    }

    @Override
    public Session save(Session session) {
        Key<Session> sessionKey = ofy().save().entity(session).now();
        return ofy().load().key(sessionKey).now();
    }

    @Override
    public Session signIn(final String userId, final String password)
            throws SessionHandlingException {

        return ofy().transact(new Work<Session>() {
            public Session run() {
                UserFactoryImpl userFactory = new UserFactoryImpl();
                User user = userFactory.get(userId);
                if(user == null)
                    throw new SessionHandlingException(Error.NON_EXISTENT_USER);

                return null;
            }
        });
    }
}
