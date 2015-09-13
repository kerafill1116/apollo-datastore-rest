import static org.junit.Assert.*;

import apollo.datastore.UserActivationRequestDefaults;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserActivationRequestDefaultsTest {

    @Test
    public void testGetRequestDuration() {
        assertEquals(1L, UserActivationRequestDefaults.getRequestDuration());
    }

    @Test
    public void testSetRequestDuration() {
        assertEquals(1L, UserActivationRequestDefaults.getRequestDuration());
        long newRequestDuration = 3L;
        UserActivationRequestDefaults.setRequestDuration(newRequestDuration);
        assertEquals(newRequestDuration, UserActivationRequestDefaults.getRequestDuration());
    }
}
