package apollo.datastore.utils;

public enum QueryVariable {
    LANG("lang");

    private final String name;

    QueryVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
