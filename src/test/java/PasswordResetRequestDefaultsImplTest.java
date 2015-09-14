import static org.junit.Assert.*;

import apollo.datastore.PasswordRequestDefaultsInterface;
import apollo.datastore.PasswordResetRequestDefaultsImpl;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PasswordResetRequestDefaultsImplTest {

    private PasswordRequestDefaultsInterface defaults = new PasswordResetRequestDefaultsImpl();

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
