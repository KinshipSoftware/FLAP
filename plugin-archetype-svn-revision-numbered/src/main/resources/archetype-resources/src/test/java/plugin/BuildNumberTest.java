/**
 * Copyright (C) 2012 Max Planck Institute for Psycholinguistics
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package $

{package}.plugin;

import junit.framework.TestCase;
import nl.mpi.flap.PluginException;
import nl.mpi.flap.module.BaseModule;

/**
 * Created on : Sep 27, 2012, 14:51
 *
 * @author Peter Withers
 */
public class BuildNumberTest extends TestCase {

    /**
     * Test the build number against the maven project version.
     */
    public void testBuildVersion() {
        System.out.println("testBuildVersion");
        try {
            AbstractBaseModule abstractBaseModule = new AbstractBaseModuleImpl();
            assertTrue(abstractBaseModule.isMavenVersionCorrect());
        } catch (PluginException exception) {
            fail(exception.getMessage());
        }
    }

    public class AbstractBaseModuleImpl extends AbstractBaseModule {
        /* 
         * Test that the build number (obtained from svn at compile time), matches the maven project version.
         */

        public AbstractBaseModuleImpl() throws PluginException {
            super("test name", "test description", "${groupId}.${artifactId}");
        }
    }
}
