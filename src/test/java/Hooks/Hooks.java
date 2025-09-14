package Hooks;
import adapters.WebDriverAccess;
import org.junit.After;
import org.junit.Before;

public class Hooks {
    WebDriverAccess webDriverAccess;
    @Before
    public void setup() {
       webDriverAccess.setDriver1();

    }

    @After
    public void tearDown() {

        webDriverAccess.close();
    }
}
