import static org.junit.Assert.*;

import apollo.datastore.PasswordResetRequestDefaultsImpl;
import apollo.datastore.PasswordResetRequestDefaultsInterface;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PasswordResetRequestDefaultsImplTest {

    private PasswordResetRequestDefaultsInterface defaults = new PasswordResetRequestDefaultsImpl();

    @Test
    public void testGetRequestDuration() {
        assertEquals(1L, defaults.getRequestDuration());
    }

    @Test
    public void testSetRequestDuration() {
        assertEquals(1L, defaults.getRequestDuration());
        long newRequestDuration = 3L;
        defaults.setRequestDuration(newRequestDuration);
        assertEquals(newRequestDuration, defaults.getRequestDuration());
    }
}
