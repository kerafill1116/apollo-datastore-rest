package apollo.datastore.utils;

import java.util.Arrays;
import java.util.List;

public class SupportedLocales {

    private SupportedLocales() { }

    public static final List<String> LANGUAGES = Arrays.asList("en", "ja");
    public static final List<String> LANGUAGES_TEXT = Arrays.asList("English", "日本語");
    public static final String DEFAULT_LANGUAGE = "en";
}
