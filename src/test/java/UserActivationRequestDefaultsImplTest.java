import static org.junit.Assert.*;

import apollo.datastore.UserActivationRequestDefaultsImpl;
import apollo.datastore.UserActivationRequestDefaultsInterface;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserActivationRequestDefaultsImplTest {

    private UserActivationRequestDefaultsInterface defaults = new UserActivationRequestDefaultsImpl();

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
