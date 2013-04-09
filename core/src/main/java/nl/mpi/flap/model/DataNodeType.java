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

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created on : Feb 12, 2013, 4:34:32 PM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
public class DataNodeType implements PluginDataNodeType, Serializable {

    private String nameString;
    private String typeIdString;

    public enum FormatType {

        xml,
        imdi,
        cmdi;
    }
    private FormatType formatType;

    public DataNodeType() {
    }

    public String getName() {
        return nameString;
    }

    @XmlAttribute(name = "Name")
    public void setName(String name) {
        this.nameString = name;
    }

    public String getID() {
        return typeIdString;
    }

    @XmlAttribute(name = "ID")
    public void setID(String ID) {
        this.typeIdString = ID;
    }

    public FormatType getFormat() {
        return formatType;
    }

    @XmlAttribute(name = "Format")
    public void setFormat(FormatType formatType) {
        this.formatType = formatType;
    }
}
