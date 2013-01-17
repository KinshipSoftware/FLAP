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
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import nl.mpi.arbil.plugin.BasePlugin;
import nl.mpi.arbil.plugin.PluginException;

/**
 * Created on : Aug 13, 2012, 3:47:55 PM
 *
 * @author Peter Withers
 * @author Twan Goosen <twan.goosen@mpi.nl>
 */
public class PluginServiceTestRunner {

    public static void main(String[] args) {
	try {
	    final PluginService pluginService = new PluginService(new URL[]{new File(System.getProperty("user.home"), "TLA-Plugins").toURI().toURL(), new URL("file:///Users/petwit2/TLA-Plugins/sampleplugins-0.0.33986-pretesting.jar"), new URL("file:///Users/petwit2/TLA-Plugins/kinnate-plugins-export-0.0.33986-pretesting.jar")});
	    listPlugins(pluginService);
	} catch (MalformedURLException exception) {
	    System.out.println(exception.getMessage());
	} catch (PluginException exception) {
	    System.out.println(exception.getMessage());
	}
    }

    public static void listPlugins(PluginService pluginService) throws PluginException {
	try {
	    Iterator<BasePlugin> pluginIterator = pluginService.getPlugins();
	    while (pluginIterator.hasNext()) {
		BasePlugin d = pluginIterator.next();
		System.out.println("Name: " + d.getName());
	    }
	} catch (ServiceConfigurationError serviceError) {
	    serviceError.printStackTrace();
	}
    }
}
