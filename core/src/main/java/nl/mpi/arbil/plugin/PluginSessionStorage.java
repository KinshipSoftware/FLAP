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
package nl.mpi.arbil.plugin;

import java.io.File;

/**
 * Document : PluginSessionStorage <br> Created on Aug 15, 2012, 2:10:56 PM <br>
 *
 * @author Peter Withers <br>
 */
public interface PluginSessionStorage {

    /**
     * @return Application storage directory used to store all application
     * settings
     */
    public File getApplicationSettingsDirectory();

    /**
     * @return Current project directory used to store project configuration
     * files and project directories
     */
    public File getProjectDirectory();

    /**
     * @return Current project working directory used to store all users working
     * files
     */
    public File getProjectWorkingDirectory();
}
