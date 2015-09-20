package apollo.datastore.utils;

public enum FormVariable {
    USER_ID("user-id"),
    PASSWORD("password"),
    REMEMBER_ME("remember-me");

    private final String name;

    FormVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
