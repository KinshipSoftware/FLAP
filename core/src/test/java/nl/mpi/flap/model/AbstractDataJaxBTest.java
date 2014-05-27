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
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import nl.mpi.flap.plugin.PluginException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created on : Feb 13, 2013, 11:33:15 AM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
public class AbstractDataJaxBTest {

    public AbstractDataJaxBTest() {
    }

    /**
     * Test of deserializing the AbstractDataNode.
     */
    @Test
    public void testDataNodeForJaxB() throws JAXBException, ModelException {
        JAXBContext jaxbContext = JAXBContext.newInstance(SerialisableDataNode.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String dataXmlString = "<DataNode Label=\"Test Node\" ID=\"Test Group\" URI=\"Test URI\"><ChildLink ID=\"Test Child\"/></DataNode>";
        System.out.println("dataXmlString: " + dataXmlString);
        SerialisableDataNode dataNode = (SerialisableDataNode) unmarshaller.unmarshal(new StreamSource(new StringReader(dataXmlString)), SerialisableDataNode.class).getValue();
        assertEquals(dataNode.getLabel(), "Test Node");
        // todo: swap these test parameters to the correct order
        assertEquals(dataNode.getID(), "Test Group");
        assertEquals(dataNode.getURI(), "Test URI");
        assertEquals(dataNode.getChildIds().get(0).getIdString(), "Test Child");
    }

    /**
     * Test of deserializing the AbstractFieldGroup.
     */
    @Test
    public void testFieldGroupForJaxB() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FieldGroup.class, SerialisableDataNode.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String dataXmlString = "<DataNode Label=\"Test Node\" ID=\"Test Group\"><FieldGroup Label=\"Test Group Name\"/></DataNode>";
        System.out.println("dataXmlString: " + dataXmlString);
        SerialisableDataNode dataNode = (SerialisableDataNode) unmarshaller.unmarshal(new StreamSource(new StringReader(dataXmlString)), SerialisableDataNode.class).getValue();
        assertEquals(dataNode.getFieldGroups().get(0).getFieldName(), "Test Group Name");
    }

    /**
     * Test of deserializing the DataField.
     */
    @Test
    public void testDataFieldForJaxB() throws JAXBException, ModelException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FieldGroup.class, SerialisableDataNode.class, DataField.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String dataXmlString = "<DataNode Label=\"Test Node\" ID=\"Test Group\">"
                + "<FieldGroup Label=\"Test Group Name\">"
                + "<FieldData Path=\".METATRANSCRIPT.Corpus.Name\" FieldValue=\"Test Field\" KeyName=\"Test KeyName\" LanguageId= \"Test LanguageId\"/>"
                + "</FieldGroup>"
                + "<DataNode Label=\"Child Node\" ID=\"Test Child\"/>"
                + "</DataNode>";
        System.out.println("dataXmlString: " + dataXmlString);
        SerialisableDataNode dataNode = (SerialisableDataNode) unmarshaller.unmarshal(new StreamSource(new StringReader(dataXmlString)), SerialisableDataNode.class).getValue();
        assertEquals(dataNode.getFieldGroups().get(0).getFieldName(), "Test Group Name");
        System.out.println("fields: " + dataNode.getFieldGroups().get(0).getFields());
        assertEquals(dataNode.getFieldGroups().get(0).getFields().get(0).getFieldValue(), "Test Field");
        assertEquals(dataNode.getFieldGroups().get(0).getFields().get(0).getKeyName(), "Test KeyName");
        assertEquals(dataNode.getFieldGroups().get(0).getFields().get(0).getLanguageId(), "Test LanguageId");
        assertEquals(dataNode.getFieldGroups().get(0).getFields().get(0).getPath(), ".METATRANSCRIPT.Corpus.Name");
        assertEquals(dataNode.getChildList().get(0).getLabel(), "Child Node");
        assertEquals(dataNode.getChildList().get(0).getID(), "Test Child");
    }

    /**
     * Test of serializing the AbstractDataNode.
     */
    @Test
    public void testSerializeDataNodeForJaxB() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(SerialisableDataNode.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String dataXmlString = "<DataNode Label=\"Test Node\" ID=\"Test Group\"/>";
        System.out.println("dataXmlString: " + dataXmlString);
        SerialisableDataNode dataNode = (SerialisableDataNode) unmarshaller.unmarshal(new StreamSource(new StringReader(dataXmlString)), SerialisableDataNode.class).getValue();

        StringWriter stringWriter = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(dataNode, stringWriter);
        System.out.println("Marshaller Output:\n" + stringWriter.toString());
    }

    /**
     * Test of serializing the AbstractDataNode with fields.
     */
    @Test
    public void testSerializeDataNodeAndFieldsForJaxB() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FieldGroup.class, SerialisableDataNode.class, DataField.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String dataXmlString = "<DataNode Label=\"Test Node\" ID=\"Test Group\">"
                + "<FieldGroup Label=\"Test Group Name\">"
                + "<FieldData Path=\".METATRANSCRIPT.Corpus.Name\" FieldValue=\"Test Field\" KeyName=\"Test KeyName\" LanguageId= \"Test LanguageId\"/>"
                + "</FieldGroup>"
                + "<DataNode Label=\"Child Node\" ID=\"Test Child\"/>"
                + "</DataNode>";
        System.out.println("dataXmlString: " + dataXmlString);
        SerialisableDataNode dataNode = (SerialisableDataNode) unmarshaller.unmarshal(new StreamSource(new StringReader(dataXmlString)), SerialisableDataNode.class).getValue();
        StringWriter stringWriter = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(dataNode, stringWriter);
        System.out.println("Marshaller Output:\n" + stringWriter.toString());
    }

    /**
     * Test of serializing the AbstractDataNode with types.
     */
    @Test
    public void testSerializeDataNodeAndTypesForJaxB() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FieldGroup.class, SerialisableDataNode.class, DataField.class, DataNodeType.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String dataXmlString = "<DataNode Label=\"Test Node\" ID=\"Test Group\">"
                + "<Type MimeType=\"a test type\" ID=\"a test ID\" Format=\"cmdi\"/>"
                + "<DataNode Label=\"Child Node\" ID=\"Test Child\"/>"
                + "</DataNode>";
        System.out.println("dataXmlString: " + dataXmlString);
        SerialisableDataNode dataNode = (SerialisableDataNode) unmarshaller.unmarshal(new StreamSource(new StringReader(dataXmlString)), SerialisableDataNode.class).getValue();
        StringWriter stringWriter = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(dataNode, stringWriter);
        System.out.println("Marshaller Output:\n" + stringWriter.toString());
        assertEquals(dataNode.getType().getMimeType(), "a test type");
        assertEquals(dataNode.getType().getID(), "a test ID");
        assertEquals(dataNode.getType().getFormat(), DataNodeType.FormatType.cmdi);
    }
}
