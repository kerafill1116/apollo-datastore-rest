package apollo.datastore.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class FormVariableExceptionMapper implements ExceptionMapper<FormVariableException> {

    @Override
    public Response toResponse(FormVariableException e) {

        String json = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(new ErrorJson(e.getError()));
        }
        catch(JsonProcessingException e1) {
            e1.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(json).build();
    }
}
