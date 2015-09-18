package apollo.datastore;

import apollo.datastore.objectify.UserFactoryImpl;

public class UserFactoryAdapter {

    static {
        switch(DataAccessProperties.getInstance().getMethod()) {
            case USE_OBJECTIFY:
                interfaceImpl = new UserFactoryImpl();
                break;
            case USE_JDO:
                break;
            default:
                interfaceImpl = new UserFactoryImpl();
        }
    }

    private static UserFactoryInterface interfaceImpl;

    private UserFactoryAdapter() { }

    public static UserFactoryInterface getInstance() {
        return interfaceImpl;
    }
}
