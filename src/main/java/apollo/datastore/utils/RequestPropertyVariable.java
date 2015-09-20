package apollo.datastore.utils;

public enum RequestPropertyVariable {
    SET_COOKIE("setCookie"),
    LANG("lang"),
    DEFAULT_LANG("defaultLang"),
    SUPPORTED_LANGUAGES_ARRAY("supportedLanguagesArray"),
    SUPPORTED_LANGUAGES_TEXT_ARRAY("supportedLanguagesTextArray");

    private final String name;

    RequestPropertyVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
