package apollo.datastore.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class FormVariableException extends InvalidFormatException {

    private Error error;

    public FormVariableException(Error error, JsonParser jp, Object value, Class<?> targetType) {
        super("", jp.getTokenLocation(), value, targetType);
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
