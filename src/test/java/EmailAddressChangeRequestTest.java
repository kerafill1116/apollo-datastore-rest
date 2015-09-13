import static org.junit.Assert.*;

import apollo.datastore.EmailAddressChangeRequest;
import apollo.datastore.MiscFunctions;

import java.util.Date;

import org.junit.*;

public class EmailAddressChangeRequestTest {

    private String userId = "admin";
    private String newEmailAddress = "kerafill1116@gmail.com";

    @Test
    public void testStringString() {
        EmailAddressChangeRequest emailAddressChangeRequest = new EmailAddressChangeRequest(userId, newEmailAddress);
        assertEquals(userId, emailAddressChangeRequest.getUserId());
        assertEquals(newEmailAddress, emailAddressChangeRequest.getNewEmailAddress());
        String requestId = MiscFunctions.getEncryptedHash(String.valueOf(emailAddressChangeRequest.getDateRequested().getTime()) + userId, EmailAddressChangeRequest.REQUEST_ID_HASH_ALGORITHM);
        assertEquals(requestId, emailAddressChangeRequest.getRequestId());
    }
}
