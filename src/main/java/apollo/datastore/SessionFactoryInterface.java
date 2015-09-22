package apollo.datastore;

import apollo.datastore.utils.SessionHandlingException;

import java.util.Date;

public interface SessionFactoryInterface {
    Session add(User user, Date dateSignedIn);
    Session get(String sessionId);
    Session save(Session session);
    Session signIn(String userId, String password) throws SessionHandlingException;
}
