package apollo.datastore;

import apollo.datastore.objectify.SessionLogFactoryImpl;

public class SessionLogFactoryAdapter {

    static {
        switch(DataAccessProperties.getInstance().getMethod()) {
            case USE_OBJECTIFY:
                interfaceImpl = new SessionLogFactoryImpl();
                break;
            case USE_JDO:
                break;
            default:
                interfaceImpl = new SessionLogFactoryImpl();
        }
    }

    private static SessionLogFactoryInterface interfaceImpl;

    private SessionLogFactoryAdapter() { }

    public static SessionLogFactoryInterface getInstance() {
        return interfaceImpl;
    }
}
