/**
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
package nl.mpi.pluginsamples;

import nl.mpi.flap.module.BaseModule;
import nl.mpi.flap.plugin.ActivatablePlugin;
import nl.mpi.flap.plugin.PluginDialogHandler;
import nl.mpi.flap.plugin.PluginException;
import nl.mpi.flap.plugin.PluginSessionStorage;
import nl.mpi.flap.plugin.PluginSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Document : PluginSample Created on : Dec 22, 2011, 3:58:34 PM
 *
 * @author Peter Withers
 */
public class PluginSampleActivate implements BaseModule, PluginSettings, ActivatablePlugin {

    private final static Logger logger = LoggerFactory.getLogger(PluginSampleActivate.class);
    private boolean isActivated = false;

    public String getName() {
        return "Sample Activate Plugin Name";
    }

    public String getDescription() {
        return "Sample Activate Plugin Description String";
    }

    public int getBuildVersionNumber() {
        return 3;
    }

    public int getMajorVersionNumber() {
        return 1;
    }

    public int getMinorVersionNumber() {
        return 2;
    }

    public void activatePlugin(PluginDialogHandler dialogHandler, PluginSessionStorage sessionStorage) throws PluginException {
	logger.info("Sample plugin activated");
        isActivated = true;
    }

    public void deactivatePlugin(PluginDialogHandler dialogHandler, PluginSessionStorage sessionStorage) throws PluginException {
	logger.info("Sample plugin deactivated");
        isActivated = false;
    }

    public boolean getIsActivated() throws PluginException {
        return isActivated;
    }
}
