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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created on : Dec 27, 2012, 2:51:24 PM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
@XmlRootElement(name = "FieldData")
public class DataField implements PluginField, Serializable {

    private String keyName = "";
    private String languageId = "";
    private String fieldValue = "";
    private String pathString = "";

    public String getKeyName() {
        return keyName;
    }

    @XmlAttribute(name = "KeyName")
    public void setKeyName(String keyNameLocal) {
        keyName = keyNameLocal;
    }

    public String getLanguageId() {
        return languageId;
    }

    @XmlAttribute(name = "LanguageId")
    public void setLanguageId(String languageIdLocal) {
        languageId = languageIdLocal;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    @XmlAttribute(name = "FieldValue")
    public void setFieldValue(String fieldValueToBe) {
        fieldValue = fieldValueToBe;
    }

    public String getPath() {
        return pathString;
    }

    @XmlAttribute(name = "Path")
    public void setPath(String xmlPath) {
        this.pathString = xmlPath;
    }
}
