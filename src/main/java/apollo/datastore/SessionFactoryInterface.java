package apollo.datastore;

import java.util.Date;

public interface SessionFactoryInterface {
    Session add(User user, Date dateSignedIn);
    Session get(String sessionId);
    Session save(Session session);
}
