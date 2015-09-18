package apollo.datastore;

import apollo.datastore.objectify.PermissionsFactoryImpl;

public class PermissionsFactoryAdapter {

    static {
        switch(DataAccessProperties.getInstance().getMethod()) {
            case USE_OBJECTIFY:
                interfaceImpl = new PermissionsFactoryImpl();
                break;
            case USE_JDO:
                break;
            default:
                interfaceImpl = new PermissionsFactoryImpl();
        }
    }

    private static PermissionsFactoryInterface interfaceImpl;

    private PermissionsFactoryAdapter() { }

    public static PermissionsFactoryInterface getInstance() {
        return interfaceImpl;
    }
}
