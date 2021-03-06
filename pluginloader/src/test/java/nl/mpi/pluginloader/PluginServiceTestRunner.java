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
import nl.mpi.flap.module.BaseModule;
import nl.mpi.flap.plugin.PluginException;

/**
 * Created on : Aug 13, 2012, 3:47:55 PM
 *
 * @author Peter Withers
 * @author Twan Goosen <twan.goosen@mpi.nl>
 */
public class PluginServiceTestRunner extends PluginTestRunner {

    public static void main(String[] args) {
        try {
            final PluginService pluginService = new PluginService(new URL[]{new URL("file:///<samplePluginsBuildOutput>/sampleplugins/target/sampleplugins-1.1-pretesting-SNAPSHOT.jar")});
            listPlugins(pluginService);
        } catch (MalformedURLException exception) {
            System.out.println(exception.getMessage());
        } catch (PluginException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void listPlugins(PluginService pluginService) throws PluginException {
        try {
            Iterator<BaseModule> pluginIterator = pluginService.getPlugins();
            while (pluginIterator.hasNext()) {
                BaseModule d = pluginIterator.next();
                System.out.println("Name: " + d.getName());
            }
        } catch (ServiceConfigurationError serviceError) {
            serviceError.printStackTrace(System.out);
        }
    }
}
