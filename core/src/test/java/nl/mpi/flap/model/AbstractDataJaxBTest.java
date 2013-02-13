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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created on : Feb 13, 2013, 11:33:15 AM
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
public class AbstractDataJaxBTest {

    public AbstractDataJaxBTest() {
    }

    /**
     * Test of getID method, of class AbstractDataNode.
     */
    @Test
    public void testAllAbstractClassForJaxB() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(AbstractDataNode.class, AbstractField.class, FieldGroup.class, AbstractDataNodeType.class, MockDataNode.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        final String testNodeName = "Test Node";
        final String testNodeId = "hdl:1839/00-0000-0000-0001-2A9A-4";
        String dataXmlString = "<DataNode Label=\"" + testNodeName + "\" ID=\"" + testNodeId + "\"/>";
        System.out.println("dataXmlString: " + dataXmlString);
        MockDataNode dataNode = (MockDataNode) unmarshaller.unmarshal(new StreamSource(new StringReader(dataXmlString)), MockDataNode.class).getValue();
        assertEquals(dataNode.getLabel(), testNodeName);
        assertEquals(dataNode.getID(), testNodeId);
    }
}
