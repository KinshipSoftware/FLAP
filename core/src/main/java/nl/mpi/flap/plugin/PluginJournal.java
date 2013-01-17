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
package nl.mpi.flap.plugin;

import java.util.Set;

/**
 * Created on : Dec 18, 2012, 2:00:21 PM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
public interface PluginJournal {

    /**
     * @return the list of changed files since the journal was at the point
     * defined by X journal file for the current project that is used to record
     * all changes
     */
    public long getChangedFiles(long lastChangeIndex, Set<String> changedURIs) throws PluginException;

    public void addJounalWatcher(JournalWatcherPlugin jounalWatcher);
}
