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
package nl.mpi.pluginloader;

/**
 *  Document   : PluginEntity
 *  Created on : Dec 20, 2011, 3:03:29 PM
 *  Author     : Peter Withers
 */
public interface PluginEntity {

    public int versionMajor = 0;
    public int versionMinor = 0;
    public int versionRevision = 1;
    // todo: do we want to expose EntityData or offer a subset here?
}
