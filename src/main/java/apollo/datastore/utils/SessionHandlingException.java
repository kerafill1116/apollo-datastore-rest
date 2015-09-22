package apollo.datastore.utils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class SessionHandlingException extends WebApplicationException {

    private Error error;

    public SessionHandlingException(Error error) {
        super(Response.Status.BAD_REQUEST);
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
