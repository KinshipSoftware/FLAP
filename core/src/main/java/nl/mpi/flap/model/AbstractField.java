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
 * Created on : Dec 27, 2012, 2:51:24 PM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
public abstract class AbstractField implements PluginField {

    public AbstractField() {
    }

    @XmlAttribute(name = "KeyName")
    public abstract String getKeyName();

    public abstract String getLanguageId();

    @XmlAttribute(name = "FieldValue")
    public abstract String getFieldValue();

    public abstract void setFieldValue(String fieldValueToBe, boolean updateUI, boolean excludeFromUndoHistory);

    public abstract void setLanguageId(String languageIdLocal, boolean updateUI, boolean excludeFromUndoHistory);

    public abstract boolean setKeyName(String keyNameLocal, boolean updateUI, boolean excludeFromUndoHistory);

    @XmlAttribute(name = "FullXmlPath")
    public abstract String getFullXmlPath();
}
