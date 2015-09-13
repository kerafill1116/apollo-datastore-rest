import static org.junit.Assert.*;

import apollo.datastore.MiscFunctions;
import apollo.datastore.UserActivationRequest;
import apollo.datastore.UserActivationRequestDefaults;

import org.junit.*;

import java.util.Date;

public class UserActivationRequestTest {

    private String userId = "admin";

    @Test
    public void testString() {
        UserActivationRequest userActivationRequest = new UserActivationRequest(userId);
        assertEquals(userId, userActivationRequest.getUserId());
        Date dateRequested = new Date();
        String requestId = MiscFunctions.getEncryptedHash(String.valueOf(userActivationRequest.getDateRequested().getTime()) + userId, UserActivationRequest.REQUEST_ID_HASH_ALGORITHM);
        assertEquals(requestId, userActivationRequest.getRequestId());
        assertEquals(UserActivationRequestDefaults.getRequestDuration(), userActivationRequest.getRequestDuration());
    }
}
