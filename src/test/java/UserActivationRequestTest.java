import static org.junit.Assert.*;

import apollo.datastore.MiscFunctions;
import apollo.datastore.UserActivationRequest;
import apollo.datastore.UserActivationRequestDefaultsImpl;
import apollo.datastore.UserActivationRequestDefaultsInterface;

import java.util.Date;

import org.junit.*;

public class UserActivationRequestTest {

    private String userId = "admin";
    private Date dateRequested = new Date();
    private UserActivationRequestDefaultsInterface defaults = new UserActivationRequestDefaultsImpl();

    @Test
    public void testString() {
        UserActivationRequest userActivationRequest = new UserActivationRequest(userId, dateRequested, defaults);
        assertEquals(userId, userActivationRequest.getUserId());
        assertEquals(dateRequested, userActivationRequest.getDateRequested());
        assertEquals(MiscFunctions.getEncryptedHash(String.valueOf(dateRequested.getTime()) + userId, UserActivationRequest.REQUEST_ID_HASH_ALGORITHM), userActivationRequest.getRequestId());
        assertEquals(defaults.getRequestDuration(), userActivationRequest.getRequestDuration());
    }
}
