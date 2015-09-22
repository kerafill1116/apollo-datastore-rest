package apollo.datastore.utils;

public enum jsonPropertyVariable {
    ERROR("error"),
    ERROR_MESSAGE("error-message");

    private final String name;

    jsonPropertyVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
