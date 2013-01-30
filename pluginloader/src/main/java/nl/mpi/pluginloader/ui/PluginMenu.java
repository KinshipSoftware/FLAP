/**
 * Copyright (C) 2012 Max Planck Institute for Psycholinguistics
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package nl.mpi.pluginloader.ui;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import nl.mpi.flap.module.BaseModule;
import nl.mpi.pluginloader.PluginManager;
import nl.mpi.pluginloader.PluginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on : Aug 13, 2012, 3:47:55 PM
 *
 * @author Peter Withers
 */
public class PluginMenu extends JMenu {

    private final static Logger logger = LoggerFactory.getLogger(PluginMenu.class);
    final PluginService pluginService;

    public PluginMenu(PluginService pluginService, PluginManager pluginManager, boolean hideIfNoPluginsFound) {
        super("Plugins");
        this.pluginService = pluginService;
        Iterator<BaseModule> pluginIterator = pluginService.getPlugins();
        boolean hasPlugins = false;
        while (pluginIterator.hasNext()) {
            try {
                hasPlugins = true;
                final BaseModule kinOathPlugin = pluginIterator.next();
                logger.debug("Plugin: " + kinOathPlugin.getName());
                JCheckBoxMenuItem menuItem = new JCheckBoxMenuItem(new PluginMenuAction(pluginManager, kinOathPlugin));
                menuItem.setSelected(pluginManager.isActivated(kinOathPlugin));
                this.add(menuItem);
            } catch (ServiceConfigurationError serviceError) {
                logger.error("Error while listing plugins", serviceError);
                this.add(new JLabel("<failed to load plugin>"));
            }
        }
        if (!hasPlugins) {
            this.add(new JLabel("<no plugins found>"));
            this.setVisible(!hideIfNoPluginsFound);
        }
    }
}
