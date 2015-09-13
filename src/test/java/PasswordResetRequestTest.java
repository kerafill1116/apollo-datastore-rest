import static org.junit.Assert.*;

import apollo.datastore.MiscFunctions;
import apollo.datastore.PasswordResetRequest;
import apollo.datastore.PasswordResetRequestDefaults;

import org.junit.*;

import java.util.Date;

public class PasswordResetRequestTest {

    private String userId = "admin";

    @Test
    public void testString() {
        PasswordResetRequest passwordResetRequest = new PasswordResetRequest(userId);
        assertEquals(userId, passwordResetRequest.getUserId());
        String requestId = MiscFunctions.getEncryptedHash(String.valueOf(passwordResetRequest.getDateRequested().getTime()) + userId, PasswordResetRequest.REQUEST_ID_HASH_ALGORITHM);
        assertEquals(requestId, passwordResetRequest.getRequestId());
        assertEquals(PasswordResetRequestDefaults.getRequestDuration(), passwordResetRequest.getRequestDuration());
    }
}
