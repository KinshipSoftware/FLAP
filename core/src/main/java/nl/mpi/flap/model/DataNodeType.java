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

    private String label;
    private String mimeType;
    private String typeIdString;
    public static final String IMDI_RESOURCE = "imdi.resource";

    public enum FormatType {

        xml,
        imdi_corpus,
        imdi_catalogue,
        imdi_session,
        imdi_info,
        cmdi,
        resource_annotation,
        resource_audio,
        resource_lexical,
        resource_other,
        resource_video;
    }
    private FormatType formatType;

    public DataNodeType() {
    }

    public DataNodeType(String label, String mimeType, String typeIdString, FormatType formatType) {
        this.label = label;
        this.mimeType = mimeType;
        this.typeIdString = typeIdString;
        this.formatType = formatType;
    }

    public String getLabel() {
        return label;
    }

    @XmlAttribute(name = "Label")
    public void setLabel(String label) {
        this.label = label;
    }

    public String getMimeType() {
        return mimeType;
    }

    @XmlAttribute(name = "MimeType")
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.label != null ? this.label.hashCode() : 0);
        hash = 67 * hash + (this.mimeType != null ? this.mimeType.hashCode() : 0);
        hash = 67 * hash + (this.typeIdString != null ? this.typeIdString.hashCode() : 0);
        hash = 67 * hash + (this.formatType != null ? this.formatType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataNodeType other = (DataNodeType) obj;
        if ((this.label == null) ? (other.label != null) : !this.label.equals(other.label)) {
            return false;
        }
        if ((this.mimeType == null) ? (other.mimeType != null) : !this.mimeType.equals(other.mimeType)) {
            return false;
        }
        if ((this.typeIdString == null) ? (other.typeIdString != null) : !this.typeIdString.equals(other.typeIdString)) {
            return false;
        }
        if (this.formatType != other.formatType) {
            return false;
        }
        return true;
    }    
}
