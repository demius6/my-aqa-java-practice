package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstJUnitTest {
    @Test
    void simpleTest() {
        Assertions.assertTrue(2 < 3);
    }
}
