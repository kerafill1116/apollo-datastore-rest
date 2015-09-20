package apollo.datastore;

import apollo.datastore.objectify.SessionFactoryImpl;

public class SessionFactoryAdapter {

    static {
        switch(DataAccessProperties.getInstance().getMethod()) {
            case USE_OBJECTIFY:
                interfaceImpl = new SessionFactoryImpl();
                break;
            case USE_JDO:
                break;
            default:
                interfaceImpl = new SessionFactoryImpl();
        }
    }

    private static SessionFactoryInterface interfaceImpl;

    private SessionFactoryAdapter() { }

    public static SessionFactoryInterface getInstance() {
        return interfaceImpl;
    }
}
