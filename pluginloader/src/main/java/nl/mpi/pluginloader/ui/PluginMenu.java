package nl.mpi.pluginloader.ui;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import nl.mpi.kinnate.plugin.BasePlugin;
import nl.mpi.pluginloader.PluginManager;
import nl.mpi.pluginloader.PluginService;

/**
 * Created on : Aug 13, 2012, 3:47:55 PM
 *
 * @author Peter Withers
 */
public class PluginMenu extends JMenu {

    final PluginService pluginService;

    public PluginMenu(PluginService pluginService, PluginManager pluginManager, boolean hideIfNoPluginsFound) {
        super("Plugins");
        this.pluginService = pluginService;
        Iterator<BasePlugin> pluginIterator = pluginService.getPlugins();
        boolean hasPlugins = false;
        while (pluginIterator.hasNext()) {
            try {
                hasPlugins = true;
                final BasePlugin kinOathPlugin = pluginIterator.next();
                System.out.println("Plugin: " + kinOathPlugin.getName());
                JCheckBoxMenuItem menuItem = new JCheckBoxMenuItem(new PluginMenuAction(pluginManager, kinOathPlugin));
                menuItem.setSelected(pluginManager.isActivated(kinOathPlugin));
                this.add(menuItem);
            } catch (ServiceConfigurationError serviceError) {
                this.add(new JLabel("<failed to load plugin>"));
            }
        }
        if (!hasPlugins) {
            this.add(new JLabel("<no plugins found>"));
            this.setVisible(!hideIfNoPluginsFound);
        }
    }
}
