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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package nl.mpi.arbil.plugin;

import java.io.IOException;
import java.util.Properties;

/**
 * Document : AbstractBasePlugin Created on : Sep 27, 2012, 11:30
 *
 * @author Peter Withers
 */
public abstract class AbstractBasePlugin implements BasePlugin {

    final private String nameString;
    final private String descriptionString;
    final private int majorVersionNumber;
    final private int minorVersionNumber;
    final private int buildVersionNumber;
    final private String compileDateString;
    final private String artifactVersionString;
    final private String lastCommitDate;

    public AbstractBasePlugin(String nameString, String descriptionString, String packageString) throws PluginException {
        this.nameString = nameString;
        this.descriptionString = descriptionString;

        Properties properties = new Properties();
        try {
            String propertiesPath = packageString.replace(".", "/");
            properties.load(getClass().getResourceAsStream("/" + propertiesPath + "/version.properties"));
            majorVersionNumber = Integer.parseInt(properties.getProperty("plugin.majorVersion"));
            minorVersionNumber = Integer.parseInt(properties.getProperty("plugin.minorVersion"));
            buildVersionNumber = Integer.parseInt(properties.getProperty("plugin.buildVersion"));
            lastCommitDate = properties.getProperty("plugin.lastCommitDate");
            compileDateString = properties.getProperty("plugin.compileDate");
            artifactVersionString = properties.getProperty("plugin.projectVersion");
        } catch (IOException ex) {
            throw new PluginException("Version properties could not be read!");
        } catch (NumberFormatException exception) {
            throw new PluginException("Version numbers could not be parsed!");
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
        String errorMessage = "The maven version does not match either the snapshot nor the current svn build number.\n The pom.xml must be updated, please use either the correct build number or a snapshot version.";
        String svnVersion = getMajorVersionNumber() + "." + getMinorVersionNumber() + "." + getBuildVersionNumber() + "-";
        System.out.println("svnVersion: " + svnVersion + " ... ");
        String snapshotVersion = getMajorVersionNumber() + "." + getMinorVersionNumber() + "-";
        System.out.println("snapshotVersion: " + snapshotVersion + " ... " + "-SNAPSHOT");
        String mavenBuildVersion = getArtifactVersion();
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
