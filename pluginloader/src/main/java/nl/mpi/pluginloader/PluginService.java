package nl.mpi.pluginloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import nl.mpi.kinnate.plugin.BasePlugin;

/**
 * Created on : Dec 23, 2011, 10:20:52 AM
 *
 * @author Peter Withers
 */
public class PluginService {

    private ServiceLoader<BasePlugin> serviceLoader;

    public PluginService(URL[] pluginJarUrls) {
        for (URL inputURL : pluginJarUrls) {
            System.out.println("Plugin URL: " + inputURL.toString());
        }
        serviceLoader = ServiceLoader.load(BasePlugin.class, URLClassLoader.newInstance(pluginJarUrls, this.getClass().getClassLoader()));
    }

    public Iterator<BasePlugin> getPlugins() throws ServiceConfigurationError {
        return serviceLoader.iterator();
    }

    public void listPlugins() {
        try {
            Iterator<BasePlugin> pluginIterator = serviceLoader.iterator();
            while (pluginIterator.hasNext()) {
                BasePlugin d = pluginIterator.next();
                System.out.println("Name: " + d.getName());
            }
        } catch (ServiceConfigurationError serviceError) {
            serviceError.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new PluginService(new URL[]{new File(System.getProperty("user.home"), "TLA-Plugins").toURI().toURL(), new URL("file:///Users/petwit2/TLA-Plugins/sampleplugins-0.0.33986-pretesting.jar"), new URL("file:///Users/petwit2/TLA-Plugins/kinnate-plugins-export-0.0.33986-pretesting.jar")}).listPlugins();
        } catch (MalformedURLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
