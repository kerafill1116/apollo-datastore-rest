package apollo.datastore;

public class DataAccessProperties {

    private static DataAccessProperties instance = new DataAccessProperties();
    private DataAccessMethod method = DataAccessMethod.USE_OBJECTIFY;

    private DataAccessProperties() { }

    public static DataAccessProperties getInstance() {
        return instance;
    }

    public DataAccessMethod getMethod() {
        return method;
    }

    public enum DataAccessMethod {
        USE_OBJECTIFY("use-objectify"),
        USE_JDO("use-jdo");

        private final String method;

        DataAccessMethod(String method) {
            this.method = method;
        }

        public String getMethod() {
            return method;
        }
    }
}
