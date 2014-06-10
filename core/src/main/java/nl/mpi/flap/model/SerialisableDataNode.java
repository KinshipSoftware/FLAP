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
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created on : Dec 27, 2012, 12:26:17 PM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
@XmlRootElement(name = "DataNode")
public class SerialisableDataNode implements PluginDataNode, Serializable {

    // dataNodeLink should not be final otherwise it cannot be serialised later
    private DataNodeLink dataNodeLink = new DataNodeLink();
    private String label = null;
    private DataNodeType dataNodeType = null;
    private DataNodePermissions dataNodePermissions = null;
    private List<FieldGroup> fieldGroups;
    private List<DataNodeLink> childIds;
    private List<? extends SerialisableDataNode> childNodes;

    @XmlAttribute(name = "ID")
    public void setID(String id) {
        dataNodeLink.setIdString(id);
    }

    public String getID() throws ModelException {
        return dataNodeLink.getIdString();
    }

    @XmlAttribute(name = "URI")
    public void setURI(String uriString) {
        dataNodeLink.setNodeUriString(uriString);
    }

    public String getURI() throws ModelException {
        return dataNodeLink.getNodeUriString();
    }

    public String getArchiveHandle() {
        return dataNodeLink.getArchiveHandle();
    }

    @XmlAttribute(name = "ArchiveHandle")
    public void setArchiveHandle(String archiveHandle) {
        this.dataNodeLink.setArchiveHandle(archiveHandle);
    }

    @XmlAttribute(name = "Label")
    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public DataNodeType getType() {
        return dataNodeType;
    }

    @XmlElement(name = "Type")
    public void setType(DataNodeType dataNodeType) {
        this.dataNodeType = dataNodeType;
    }

    public DataNodePermissions getPermissions() {
        return dataNodePermissions;
    }

    @XmlElement(name = "Permissions")
    public void setPermissions(DataNodePermissions dataNodePermissions) {
        this.dataNodePermissions = dataNodePermissions;
    }

    @XmlElement(name = "FieldGroup")
    public void setFieldGroups(List<FieldGroup> fieldGroups) {
        this.fieldGroups = fieldGroups;
    }

    public List<FieldGroup> getFieldGroups() {
        return fieldGroups;
    }

    public List<DataNodeLink> getChildIds() throws ModelException {
        return childIds;
    }

    @XmlElement(name = "ChildLink")
    public void setChildIds(List<DataNodeLink> childIds) {
        this.childIds = childIds;
    }

    @XmlElement(name = "LinkCount")
    public Integer getLinkCount() {
        return null;
    }

    public List<? extends SerialisableDataNode> getChildList() {
        return childNodes;
    }

    @XmlElement(name = "DataNode")
    public void setChildList(List<? extends SerialisableDataNode> childNodes) {
        this.childNodes = childNodes;
    }
}
