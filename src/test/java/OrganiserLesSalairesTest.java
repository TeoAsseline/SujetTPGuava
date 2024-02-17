import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.google.common.base.Preconditions.checkArgument;

public class OrganiserLesSalairesTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void test1() throws Exception{
        int i=-1;
        checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
    }
}