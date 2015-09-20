package apollo.datastore;

public interface SessionLogFactoryInterface {
    SessionLog add(Session session);
    SessionLog get(String sessionId);
    SessionLog save(SessionLog sessionLog);
}
