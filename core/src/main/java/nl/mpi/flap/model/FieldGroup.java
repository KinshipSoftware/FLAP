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
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created on : Dec 27, 2012, 2:09:41 PM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
public class FieldGroup implements Serializable {

    @XmlTransient
    private String fieldName;
    @XmlTransient
    private List<? extends AbstractField> fieldArray;

    private FieldGroup() {
    }

    public FieldGroup(String feildName, List<? extends AbstractField> fieldArray) {
        this.fieldName = feildName;
        this.fieldArray = fieldArray;
    }

    @XmlAttribute(name = "Label")
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFields(List<? extends AbstractField> fieldArray) {
        this.fieldArray = fieldArray;
    }

//    @XmlElement(name = "FieldData")
    public List<? extends AbstractField> getFields() {
        return fieldArray;
    }
}
