package nl.mpi.pluginloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import nl.mpi.arbil.plugin.ActivatablePlugin;
import nl.mpi.arbil.plugin.PluginException;
import nl.mpi.kinnate.plugin.BasePlugin;
import nl.mpi.pluginloader.ui.PluginMenu;

/**
 * Created on : Nov 07, 2012, 12:01:34 PM
 *
 * @author Peter Withers
 */
public class ApplicationSample extends JFrame {

    public static void main(String[] args) {
        JFrame jFrame = new ApplicationSample();
        jFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        JMenuBar jMenuBar = new JMenuBar();
        final JTextArea jTextArea = new JTextArea();
        PluginManager pluginManager = new PluginManager() {
            public boolean isActivated(BasePlugin kinOathPlugin) {
                try {
                    if (kinOathPlugin instanceof ActivatablePlugin) {
                        return ((ActivatablePlugin) kinOathPlugin).getIsActivated();
                    }
                } catch (PluginException exception) {
                    System.err.println("error getting plugin state:" + exception.getMessage());
                }
                return false;
            }

            public void activatePlugin(BasePlugin kinOathPlugin) {
                try {
                    if (kinOathPlugin instanceof ActivatablePlugin) {
                        ((ActivatablePlugin) kinOathPlugin).activatePlugin(null, null);
                        jTextArea.setText("activate: \n" + kinOathPlugin.getName() + "\n" + kinOathPlugin.getMajorVersionNumber() + "." + kinOathPlugin.getMinorVersionNumber() + "." + kinOathPlugin.getBuildVersionNumber() + "\n" + kinOathPlugin.getDescription());
                    } else {
                        jTextArea.setText("non activateable plugin: \n" + kinOathPlugin.getName() + "\n" + kinOathPlugin.getMajorVersionNumber() + "." + kinOathPlugin.getMinorVersionNumber() + "." + kinOathPlugin.getBuildVersionNumber() + "\n" + kinOathPlugin.getDescription());
                    }
                } catch (PluginException exception) {
                    jTextArea.setText("Error activating plugin: \n" + kinOathPlugin.getName() + "\n" + kinOathPlugin.getMajorVersionNumber() + "." + kinOathPlugin.getMinorVersionNumber() + "." + kinOathPlugin.getBuildVersionNumber() + "\n" + kinOathPlugin.getDescription());
                }
            }

            public void deactivatePlugin(BasePlugin kinOathPlugin) {
                try {
                    if (kinOathPlugin instanceof ActivatablePlugin) {
                        ((ActivatablePlugin) kinOathPlugin).deactivatePlugin(null, null);
                        jTextArea.setText("deactivate: \n" + kinOathPlugin.getName() + "\n" + kinOathPlugin.getMajorVersionNumber() + "." + kinOathPlugin.getMinorVersionNumber() + "." + kinOathPlugin.getBuildVersionNumber() + "\n" + kinOathPlugin.getDescription());
                    } else {
                        jTextArea.setText("non deactivateable plugin: \n" + kinOathPlugin.getName() + "\n" + kinOathPlugin.getMajorVersionNumber() + "." + kinOathPlugin.getMinorVersionNumber() + "." + kinOathPlugin.getBuildVersionNumber() + "\n" + kinOathPlugin.getDescription());
                    }
                } catch (PluginException exception) {
                    jTextArea.setText("error deactivating plugin: \n" + kinOathPlugin.getName() + "\n" + kinOathPlugin.getMajorVersionNumber() + "." + kinOathPlugin.getMinorVersionNumber() + "." + kinOathPlugin.getBuildVersionNumber() + "\n" + kinOathPlugin.getDescription());
                }
            }
        };
        try {
            jMenuBar.add(new PluginMenu(new PluginService(new URL[]{new File(System.getProperty("user.home"), "TLA-Plugins").toURI().toURL(), new URL("file:///Users/petwit2/TLA-Plugins/")}), pluginManager, false));
        } catch (MalformedURLException exception) {
            jMenuBar.add(new JLabel(exception.getMessage()));
        }
        jFrame.setJMenuBar(jMenuBar);
        jFrame.setContentPane(new JScrollPane(jTextArea));
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
