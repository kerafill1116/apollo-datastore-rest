import static org.junit.Assert.*;

import apollo.datastore.PasswordResetRequestDefaults;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PasswordResetRequestDefaultsTest {

    @Test
    public void testGetRequestDuration() {
        assertEquals(1L, PasswordResetRequestDefaults.getRequestDuration());
    }

    @Test
    public void testSetRequestDuration() {
        assertEquals(1L, PasswordResetRequestDefaults.getRequestDuration());
        long newRequestDuration = 3L;
        PasswordResetRequestDefaults.setRequestDuration(newRequestDuration);
        assertEquals(newRequestDuration, PasswordResetRequestDefaults.getRequestDuration());
    }
}
