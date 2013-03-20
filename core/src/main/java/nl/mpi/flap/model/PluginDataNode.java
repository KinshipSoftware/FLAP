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
package nl.mpi.flap.model;

import java.util.List;

/**
 * Document : PluginDataNode <br> Created on Sep 10, 2012, 6:09:01 PM <br>
 *
 * @author Peter Withers <br>
 */
public interface PluginDataNode {

    /**
     * @return The string identifier for this node, please note that this is not
     * an archive handle and will only be relevant to the implementation.
     */
    public abstract String getID();

    /**
     * @return The note type object for this data node
     */
    public abstract PluginDataNodeType getType();

    /**
     * @return The display label for this data node
     */
    public abstract String getLabel();

    /**
     * @return all fields arranged into field group objects for this data node
     */
    public abstract List<FieldGroup> getFieldGroups();

    /**
     * Gets an array of the children of this node.
     *
     * @return An array of the next level child nodes.
     */
    public abstract List<? extends PluginDataNode> getChildList();
}
