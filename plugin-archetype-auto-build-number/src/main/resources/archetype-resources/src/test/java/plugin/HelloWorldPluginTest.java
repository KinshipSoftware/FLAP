package ${packageName}.plugin;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple HelloWorldPlugin.
 */
public class HelloWorldPluginTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HelloWorldPluginTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(HelloWorldPluginTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testHelloWorldPlugin() {
        assertTrue(true);
    }
}
