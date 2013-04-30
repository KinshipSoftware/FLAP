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
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import nl.mpi.flap.plugin.PluginException;

/**
 * Created on : April 29, 2013, 15:48
 *
 * @author Peter Withers <peter.withers@mpi.nl>
 */
@XmlRootElement(name = "DataNodeLink")
public class DataNodeLink implements Serializable {

    private String idString;
    private URI nodeUrl;

    public DataNodeLink() {
    }

    public DataNodeLink(URI nodeUrl) throws PluginException {
        this.nodeUrl = nodeUrl;
        this.idString = calculateHashId();
    }

    public String getIdString() {
        return idString;
    }

    @XmlAttribute(name = "ID")
    public void setIdString(String idString) {
        this.idString = idString;
    }

    public URI getNodeUri() {
        return nodeUrl;
    }

    @XmlAttribute(name = "url")
    public void setNodeUrl(URI nodeUrl) {
        this.nodeUrl = nodeUrl;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.idString != null ? this.idString.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataNodeLink other = (DataNodeLink) obj;
        if ((this.idString == null) ? (other.idString != null) : !this.idString.equals(other.idString)) {
            return false;
        }
        return true;
    }

    private String calculateHashId() throws PluginException {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            final String urlString = nodeUrl.toString();
            final byte[] urlBytes = urlString.getBytes();
            digest.update(urlBytes, 0, urlBytes.length);
            StringBuilder hexString = new StringBuilder();
            byte[] md5sum = digest.digest();
            for (int byteCounter = 0; byteCounter < md5sum.length; ++byteCounter) {
                hexString.append(Integer.toHexString(0x0100 + (md5sum[byteCounter] & 0x00FF)).substring(1));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException algorithmException) {
            throw new PluginException(algorithmException);
        }
    }
}
