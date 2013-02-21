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

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created on : Feb 13, 2013, 4:01:56 PM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
public class MockDataNode extends AbstractDataNode {

    private String nodeID = null;
    private String label = null;
    private DataNodeType dataNodeType = null;
    private List<FieldGroup> fieldGroups;
    private List<String> childIds;
    private List<? extends PluginDataNode> childNodes;

    @Override
    public void setID(String id) {
        nodeID = id;
    }

    @Override
    public String getID() {
        return nodeID;
    }

    @XmlAttribute(name = "Label")
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public DataNodeType getType() {
        return dataNodeType;
    }

    @Override
    public void setType(DataNodeType dataNodeType) {
        this.dataNodeType = dataNodeType;
    }

    @Override
    public void setFieldGroups(List<FieldGroup> fieldGroups) {
        this.fieldGroups = fieldGroups;
    }

    @Override
    public List<FieldGroup> getFieldGroups() {
        return fieldGroups;
    }

    @Override
    public List<String> getChildIds() {
        return childIds;
    }

    public void setChildIds(List<String> childIds) {
        this.childIds = childIds;
    }

    @Override
    public List<? extends PluginDataNode> getChildList() {
        return childNodes;
    }

    @Override
    public void setChildList(List<? extends AbstractDataNode> childNodes) {
        this.childNodes = childNodes;
    }
}