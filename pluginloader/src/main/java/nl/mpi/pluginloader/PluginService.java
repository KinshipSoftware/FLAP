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
package nl.mpi.pluginloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import nl.mpi.flap.module.BaseModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on : Dec 23, 2011, 10:20:52 AM
 *
 * @author Peter Withers
 */
public class PluginService {

    private final static Logger logger = LoggerFactory.getLogger(PluginService.class);
    private ServiceLoader<BaseModule> serviceLoader;

    public PluginService(URL[] pluginJarUrls) {
        if (logger.isDebugEnabled()) {
            for (URL inputURL : pluginJarUrls) {
                logger.debug("Plugin URL: " + inputURL.toString());
            }
        }
        serviceLoader = ServiceLoader.load(BaseModule.class, URLClassLoader.newInstance(pluginJarUrls, this.getClass().getClassLoader()));
    }

    public Iterator<BaseModule> getPlugins() throws ServiceConfigurationError {
        return serviceLoader.iterator();
    }
}
