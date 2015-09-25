package apollo.datastore.utils;

public enum JsonPropertyVariable {
    ERROR("error"),
    ERROR_MESSAGE("error-message");

    private final String name;

    JsonPropertyVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
