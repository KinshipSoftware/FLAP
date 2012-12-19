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
package nl.mpi.arbil.plugin;

/**
 * Created on : Dec 19, 2012, 11:54:36 AM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
public interface PluginField {

    public String getKeyName();

    public String getLanguageId();

    public String getFieldValue();

    public void setFieldValue(String fieldValueToBe, boolean updateUI, boolean excludeFromUndoHistory);

    public void setLanguageId(String languageIdLocal, boolean updateUI, boolean excludeFromUndoHistory);

    public boolean setKeyName(String keyNameLocal, boolean updateUI, boolean excludeFromUndoHistory);
}
