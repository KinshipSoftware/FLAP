/**
 * Copyright (C) 2012 Max Planck Institute for Psycholinguistics
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package nl.mpi.flap.module;

import java.io.IOException;
import java.util.Properties;
import nl.mpi.flap.plugin.PluginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Document : AbstractBaseModule Created on : Sep 27, 2012, 11:30
 *
 * @author Peter Withers
 */
public abstract class AbstractBaseModule implements BaseModule {

    final private String nameString;
    final private String descriptionString;
    final private int majorVersionNumber;
    final private int minorVersionNumber;
    final private int buildVersionNumber;
    final private String compileDateString;
    final private String artifactVersionString;
    final private String lastCommitDate;
    final private Logger logger = LoggerFactory.getLogger(getClass());

    public AbstractBaseModule(String nameString, String descriptionString, String packageString) throws PluginException {
	this.nameString = nameString;
	this.descriptionString = descriptionString;

	Properties properties = new Properties();
	try {
	    String propertiesPath = packageString.replace(".", "/");
	    properties.load(getClass().getResourceAsStream("/" + propertiesPath + "/version.properties"));
	    majorVersionNumber = Integer.parseInt(properties.getProperty("plugin.majorVersion"));
	    logger.debug("Major version number: {}", majorVersionNumber);
	    minorVersionNumber = Integer.parseInt(properties.getProperty("plugin.minorVersion"));
	    logger.debug("Minor version number: {}", majorVersionNumber);
	    buildVersionNumber = Integer.parseInt(properties.getProperty("plugin.buildVersion"));
	    logger.debug("Build number: {}", majorVersionNumber);
	    lastCommitDate = properties.getProperty("plugin.lastCommitDate");
	    logger.debug("Last commit date: {}", majorVersionNumber);
	    compileDateString = properties.getProperty("plugin.compileDate");
	    logger.debug("Compile date: {}", majorVersionNumber);
	    artifactVersionString = properties.getProperty("plugin.projectVersion");
	    logger.debug("Artifact version: {}", majorVersionNumber);
	} catch (IOException ex) {
	    throw new PluginException("Version properties could not be read!", ex);
	} catch (NumberFormatException ex) {
	    throw new PluginException("Version numbers could not be parsed!", ex);
	}
    }

    public String getName() {
	return nameString;
    }

    public int getMajorVersionNumber() {
	return majorVersionNumber;
    }

    public int getMinorVersionNumber() {
	return minorVersionNumber;
    }

    public int getBuildVersionNumber() {
	return buildVersionNumber;
    }

    public String getCompileDate() {
	return compileDateString;
    }

    public String getLastCommitDate() {
	return lastCommitDate;
    }

    public String getArtifactVersion() {
	return artifactVersionString;
    }

    public String getDescription() {
	return descriptionString;
    }

    public boolean isMavenVersionCorrect() throws PluginException {
	// this tests that the correct build number is specified in the pom.xml based on the current svn version
	// either the correct build number or a snapshot version are valid
	final String errorMessage = "The maven version does not match either the snapshot nor the current svn build number.\n The pom.xml must be updated, please use either the correct build number or a snapshot version.";

	final String svnVersion = getMajorVersionNumber() + "." + getMinorVersionNumber() + "." + getBuildVersionNumber() + "-";
	// Printing to standard out for use in unit test!
	System.out.println("svnVersion: " + svnVersion + " ... ");

	final String snapshotVersion = getMajorVersionNumber() + "." + getMinorVersionNumber() + "-";
	// Printing to standard out for use in unit test!
	System.out.println("snapshotVersion: " + snapshotVersion + " ... " + "-SNAPSHOT");

	final String mavenBuildVersion = getArtifactVersion();
	// Printing to standard out for use in unit test!
	System.out.println("mavenBuildVersion: " + mavenBuildVersion);

	if (mavenBuildVersion.endsWith("-SNAPSHOT")) {
	    if (mavenBuildVersion.startsWith(snapshotVersion)) {
		return true;
	    } else {
		throw new PluginException(errorMessage);
	    }
	} else {
	    if (mavenBuildVersion.startsWith(svnVersion)) {
		return true;
	    } else {
		throw new PluginException(errorMessage);
	    }
	}
    }
}
