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
package ${package}.${artifactId};

import nl.mpi.flap.ActivatablePlugin;
import nl.mpi.flap.PluginDialogHandler;
import nl.mpi.flap.PluginException;
import nl.mpi.flap.PluginSessionStorage;
import nl.mpi.flap.module.BaseModule;
import nl.mpi.pluginloader.PluginSettings;

/**
 * Hello world activatable plugin
 */
public class HelloWorldActivatablePlugin implements BaseModule, PluginSettings, ActivatablePlugin {

    private boolean activated = false;

    public String getName() {
        return "Sample Activate Plugin Name (${artifactId})";
    }

    public String getDescription() {
        return "Sample Activate Plugin Description String\n${groupId}\n${artifactId}";
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
        activated = true;
    }

    public void deactivatePlugin(PluginDialogHandler dialogHandler, PluginSessionStorage sessionStorage) throws PluginException {
        activated = false;
    }

    public boolean getIsActivated() throws PluginException {
        return activated;
    }
}
