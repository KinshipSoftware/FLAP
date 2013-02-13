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

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created on : Feb 13, 2013, 11:33:15 AM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
public class AbstractDataJaxBTest {

    final String testNodeId = "hdl:1839/00-0000-0000-0001-2A9A-4";
    final String testGroupName = "Test Group";

    public AbstractDataJaxBTest() {
    }

    /**
     * Test of deserializing the AbstractDataNode.
     */
    @Test
    public void testDataNodeForJaxB() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MockDataNode.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String dataXmlString = "<DataNode Label=\"Test Node\" ID=\"" + testNodeId + "\"/>";
        System.out.println("dataXmlString: " + dataXmlString);
        MockDataNode dataNode = (MockDataNode) unmarshaller.unmarshal(new StreamSource(new StringReader(dataXmlString)), MockDataNode.class).getValue();
        assertEquals(dataNode.getLabel(), "Test Node");
        assertEquals(dataNode.getID(), testNodeId);
    }

    /**
     * Test of deserializing the AbstractFieldGroup.
     */
    @Test
    public void testFieldGroupForJaxB() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FieldGroup.class, MockDataNode.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String dataXmlString = "<DataNode Label=\"Test Node\" ID=\"" + testNodeId + "\"><FieldGroup Label=\"" + testGroupName + "\"/></DataNode>";
        System.out.println("dataXmlString: " + dataXmlString);
        MockDataNode dataNode = (MockDataNode) unmarshaller.unmarshal(new StreamSource(new StringReader(dataXmlString)), MockDataNode.class).getValue();
        assertEquals(dataNode.fieldGroups.get(0).fieldName, testGroupName);
    }

    /**
     * Test of deserializing the DataField.
     */
    @Test
    public void testDataFieldForJaxB() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FieldGroup.class, MockDataNode.class, MockDataField.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String dataXmlString = "<DataNode Label=\"Test Node\" ID=\"" + testNodeId + "\">"
                + "<FieldGroup Label=\"" + testGroupName + "\">"
                + "<FieldData XmlPath=\".METATRANSCRIPT.Corpus.Name\" FieldValue=\"Test Field\" KeyName=\"Test KeyName\" LanguageId= \"Test LanguageId\"/>"
                + "</FieldGroup>"
                + "</DataNode>";
        System.out.println("dataXmlString: " + dataXmlString);
        MockDataNode dataNode = (MockDataNode) unmarshaller.unmarshal(new StreamSource(new StringReader(dataXmlString)), MockDataNode.class).getValue();
        assertEquals(dataNode.fieldGroups.get(0).fieldArray.get(0).getFieldValue(), "Test Field");
        assertEquals(dataNode.fieldGroups.get(0).fieldArray.get(0).getKeyName(), "Test KeyName");
        assertEquals(dataNode.fieldGroups.get(0).fieldArray.get(0).getLanguageId(), "Test LanguageId");
        assertEquals(dataNode.fieldGroups.get(0).fieldArray.get(0).getXmlPath(), ".METATRANSCRIPT.Corpus.Name");
    }
}
