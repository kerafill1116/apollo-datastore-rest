import static org.junit.Assert.*;

import apollo.datastore.MiscFunctions;
import apollo.datastore.PasswordResetRequestDefaultsImpl;
import apollo.datastore.PasswordResetRequestDefaultsInterface;
import apollo.datastore.PasswordResetRequest;

import java.util.Date;

import org.junit.*;

public class PasswordResetRequestTest {

    private String userId = "admin";
    private Date dateRequested = new Date();
    private PasswordResetRequestDefaultsInterface defaults = new PasswordResetRequestDefaultsImpl();

    @Test
    public void testString() {
        PasswordResetRequest passwordResetRequest = new PasswordResetRequest(userId, dateRequested, defaults);
        assertEquals(userId, passwordResetRequest.getUserId());
        assertEquals(dateRequested, passwordResetRequest.getDateRequested());
        assertEquals(MiscFunctions.getEncryptedHash(String.valueOf(dateRequested.getTime()) + userId, PasswordResetRequest.REQUEST_ID_HASH_ALGORITHM), passwordResetRequest.getRequestId());
        assertEquals(defaults.getRequestDuration(), passwordResetRequest.getRequestDuration());
    }
}
