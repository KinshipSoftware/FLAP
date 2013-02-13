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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created on : Dec 27, 2012, 12:26:17 PM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
@XmlRootElement(name = "DataNode")
public abstract class AbstractDataNode implements PluginArbilDataNode, Serializable {

    @XmlAttribute(name = "ID")
    public abstract String getID();

    @XmlAttribute(name = "Label")
    public String getName() {
        return this.toString();
    }

    @XmlElement(name = "Type")
    public abstract AbstractDataNodeType getType();

    @XmlElement(name = "FieldGroup")
    public abstract List<FieldGroup> getFieldGroups();
//    private ArrayList<FieldArray> getFieldArray() {
//        ArrayList<FieldArray> fieldArrays = new ArrayList<FieldArray>();
//        for (PluginField[] currentEntry : getFields().entrySet()) {
//            fieldArrays.add(new FieldGroup(currentEntry.getKey(), currentEntry.getValue()));
//        }
//        return fieldArrays;
//    }
//    
//    @Override
//    public List<AbstractField[]> getPluginFields() {
//        List<AbstractField[]> fieldArrays = new ArrayList<AbstractField[]>();
//        for (AbstractField[] currentField : getFieldsSorted()) {
//            AbstractField[] copiedField = new AbstractField[currentField.length];
////            for (AbstractField currentField){
//    }
//            fieldArrays.add(copiedField);
//        }
//        return fieldArrays;
//    }
//    public abstract Hashtable<String, PluginField[]> getFields();
    // todo: we could return a xml ref here
//    @XmlElementWrapper(name = "DataNodeChildWrapper")
//    @XmlElement(name = "DataNode", type = AbstractDataNode.class)

    @XmlTransient
    public abstract AbstractDataNode[] getChildArray();

    @XmlElement(name = "ChildId")
    public List<String> getChildIds() {
        ArrayList<String> childIds = new ArrayList<String>();
        for (AbstractDataNode dataNode : getChildArray()) {
            childIds.add(dataNode.getID());
        }
        return childIds;
    }
}
