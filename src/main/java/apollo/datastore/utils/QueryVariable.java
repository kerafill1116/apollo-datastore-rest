package apollo.datastore.utils;

public enum QueryVariable {
    LANG(CookieVariable.LANG.getName());

    private final String name;

    QueryVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
