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
package nl.mpi.flap.model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @since Jun 10, 2014 4:58:41 PM (creation date)
 * @author Peter Withers <peter.withers@mpi.nl>
 */
public class DataNodePermissions {

    private String label;
//    private String id;

    public enum AccessLevel {

        closed,
        external,
        open_everybody,
        open_registered_users,
        permission_needed,
        unknown;
    }
    private AccessLevel accessLevel = AccessLevel.unknown;

    public String getLabel() {
        return label;
    }

    @XmlAttribute(name = "Label")
    public void setLabel(String label) {
        this.label = label;
    }

//    public String getID() {
//        return id;
//    }
//
//    @XmlAttribute(name = "ID")
//    public void setID(String ID) {
//        this.id = ID;
//    }
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    @XmlAttribute(name = "AccessLevel")
    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
}
