package apollo.datastore;

import apollo.datastore.objectify.TimeZoneFactoryImpl;

public class TimeZoneFactoryAdapter {

    static {
        switch(DataAccessProperties.getInstance().getMethod()) {
            case USE_OBJECTIFY:
                interfaceImpl = new TimeZoneFactoryImpl();
                break;
            case USE_JDO:
                break;
            default:
                interfaceImpl = new TimeZoneFactoryImpl();
        }
    }

    private static TimeZoneFactoryInterface interfaceImpl;

    private TimeZoneFactoryAdapter() { }

    public static TimeZoneFactoryInterface getInstance() {
        return interfaceImpl;
    }
}
