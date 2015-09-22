package apollo.datastore.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/utils")
public class UtilsResource {

    @GET
    @Path("sign-in")
    @Produces(MediaType.TEXT_HTML)
    public Viewable signIn() {
        return new Viewable("/WEB-INF/jsp/pub/sign-in.jsp");
    }

    @POST
    @Path("sign-in")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signIn(SignInData data) {
        return Response.ok().build();
    }

    @JsonDeserialize(using = SignInData.Deserializer.class)
    public static class SignInData {

        private String userId;
        private String password;
        private boolean rememberMe;

        public SignInData(String userId, String password, boolean rememberMe) {
            this.userId = userId;
            this.password = password;
            this.rememberMe = rememberMe;
        }

        public String getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }

        public boolean isRememberMe() {
            return rememberMe;
        }

        public static class Deserializer extends JsonDeserializer<SignInData> {

            @Override
            public SignInData deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                    throws IOException, JsonProcessingException {

                String userId = null, password = null;
                boolean rememberMe = false;
                while(jsonParser.nextToken() != JsonToken.END_OBJECT) {
                    String propertyName = jsonParser.getCurrentName();
                    if(FormVariable.USER_ID.getName().equals(propertyName)) {
                        jsonParser.nextToken();
                        userId = jsonParser.getText();
                    }
                    if(FormVariable.PASSWORD.getName().equals(propertyName)) {
                        jsonParser.nextToken();
                        password = jsonParser.getText();
                    }
                    if(FormVariable.REMEMBER_ME.getName().equals(propertyName)) {
                        jsonParser.nextToken();
                        rememberMe = jsonParser.getBooleanValue();
                    }
                }

                if(userId.length() == 0)
                    throw new FormVariableException(Error.REQUIRED_USER_ID, jsonParser, userId, SignInData.class);

                return new SignInData(userId, password, rememberMe);
            }
        }
    }
}
