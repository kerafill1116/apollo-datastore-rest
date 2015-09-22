package apollo.datastore.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@JsonSerialize(using = ErrorJson.Serializer.class)
public class ErrorJson {

    private Error error;
    private String errorMessage;

    public ErrorJson(Error error, String lang) {
        this.error = error;
        ResourceBundle errorMessagesBundle = ResourceBundle.getBundle("apollo.datastore.utils.i18n.ErrorMessagesBundle", new Locale(lang));
        switch(error) {
            case REQUIRED_USER_ID:
                errorMessage = errorMessagesBundle.getString("required_user_id");
                break;
            default:
                errorMessage = errorMessagesBundle.getString("invalid_error");
        }
    }

    public Error getError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static class Serializer extends JsonSerializer<ErrorJson> {

        @Override
        public void serialize(ErrorJson errorJson, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField(jsonPropertyVariable.ERROR.getName(), errorJson.getError().getCode());
            jsonGenerator.writeStringField(jsonPropertyVariable.ERROR_MESSAGE.getName(), errorJson.getErrorMessage());
            jsonGenerator.writeEndObject();
        }
    }
}
