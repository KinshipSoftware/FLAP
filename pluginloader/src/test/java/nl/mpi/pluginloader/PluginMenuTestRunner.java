/*
 * Copyright (C) 2012 Max Planck Institute for Psycholinguistics
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package nl.mpi.pluginloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import nl.mpi.flap.plugin.ActivatablePlugin;
import nl.mpi.flap.plugin.BasePlugin;
import nl.mpi.flap.plugin.PluginException;
import nl.mpi.pluginloader.ui.PluginMenu;

/**
 * Created on : Aug 13, 2012, 3:47:55 PM
 *
 * @author Peter Withers
 * @author Twan Goosen <twan.goosen@mpi.nl>
 */
public class PluginMenuTestRunner extends PluginTestRunner {

    public static void main(String[] args) {
	JFrame jFrame = new JFrame();
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
	    jMenuBar.add(new PluginMenu(new PluginService(new URL[]{new File(System.getProperty("user.home"), "TLA-Plugins").toURI().toURL(), new URL("file:///Users/twagoo/svn/PluginsAndModules/framework/trunk/sampleplugins/target/sampleplugins-1.1-pretesting-SNAPSHOT.jar")}), pluginManager, false));
	} catch (MalformedURLException exception) {
	    jMenuBar.add(new JLabel(exception.getMessage()));
	}
	jFrame.setJMenuBar(jMenuBar);
	jFrame.setContentPane(new JScrollPane(jTextArea));
	jFrame.pack();
	jFrame.setVisible(true);
    }
}
