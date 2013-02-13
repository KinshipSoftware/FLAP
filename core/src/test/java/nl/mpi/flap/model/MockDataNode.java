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

    String nodeID = null;
    String label = null;
    AbstractDataNodeType dataNodeType = null;
    String nodeIconId = null;
    List<FieldGroup> fieldGroups;
    MockDataNode[] childArray;

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
    public AbstractDataNodeType getType() {
        return dataNodeType;
    }

    @Override
    public List<FieldGroup> getFieldGroups() {
        return fieldGroups;
    }

    @Override
    public MockDataNode[] getChildArray() {
        return childArray;
    }
}