package $nl.mpi;

/**
 * Hello world plugin!
 *
 */
public class HelloWorldPlugin implements BasePlugin {

    boolean isActivated = false;

    public String getName() {
        return "Hello World Plugin";
    }

    public String getDescription() {
        return "A Sample Plugin";
    }

    public int getBuildVersionNumber() {
        return 0;
    }

    public int getMajorVersionNumber() {
        return 0;
    }

    public int getMinorVersionNumber() {
        return 0;
    }
}
