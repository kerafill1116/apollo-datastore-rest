import static org.junit.Assert.*;

import apollo.datastore.EmailAddressChangeRequest;
import apollo.datastore.MiscFunctions;

import java.util.Date;

import org.junit.*;

public class EmailAddressChangeRequestTest {

    private String userId = "admin";
    private String newEmailAddress = "kerafill1116@gmail.com";
    private Date dateRequested = new Date();

    @Test
    public void testStringString() {

        EmailAddressChangeRequest emailAddressChangeRequest = new EmailAddressChangeRequest(userId, newEmailAddress, dateRequested);
        assertEquals(userId, emailAddressChangeRequest.getUserId());
        assertEquals(newEmailAddress, emailAddressChangeRequest.getNewEmailAddress());
        assertEquals(dateRequested, emailAddressChangeRequest.getDateRequested());
        assertEquals(MiscFunctions.getEncryptedHash(String.valueOf(dateRequested.getTime()) + userId, EmailAddressChangeRequest.REQUEST_ID_HASH_ALGORITHM), emailAddressChangeRequest.getRequestId());
    }
}
