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
package nl.mpi.pluginloader.ui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;
import nl.mpi.arbil.plugin.BasePlugin;
import nl.mpi.pluginloader.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Document : PluginMenuAction
 * Created on : Aug 13, 2012, 4:20:17 PM
 * Author : Peter Withers
 */
public class PluginMenuAction extends AbstractAction {

    private final static Logger logger = LoggerFactory.getLogger(PluginMenuAction.class);
    final private PluginManager pluginManager;
    final private BasePlugin kinOathPlugin;

    public PluginMenuAction(PluginManager pluginManager, BasePlugin kinOathPlugin) {
	super(kinOathPlugin.getName());
	this.pluginManager = pluginManager;
	this.kinOathPlugin = kinOathPlugin;

    }

    public void actionPerformed(ActionEvent e) {
	/* // TODO: when in webstart and the plugin is not signed the following exception will be thrown and should be handled 
	 * Exception in thread "AWT-EventQueue-0" java.lang.ExceptionInInitializerError
	 at nl.mpi.kinnate.plugins.export.ui.KinOathExportPanel.<init>(KinOathExportPanel.java:42)
	 at nl.mpi.kinnate.plugins.export.KinOathExport.getUiPanel(KinOathExport.java:24)
	 at nl.mpi.kinnate.ui.KinDiagramPanel.addPluginPanel(KinDiagramPanel.java:563)
	 at nl.mpi.kinnate.plugins.KinOathPluginManager.setPluginPanel(KinOathPluginManager.java:34)
	 at nl.mpi.kinnate.plugins.KinOathPluginManager.activatePlugin(KinOathPluginManager.java:41)
	 at nl.mpi.pluginloader.ui.PluginMenuAction.actionPerformed(PluginMenuAction.java:30)
	 at javax.swing.AbstractButton.fireActionPerformed(AbstractButton.java:2028)
	 at javax.swing.AbstractButton$Handler.actionPerformed(AbstractButton.java:2351)
	 at javax.swing.DefaultButtonModel.fireActionPerformed(DefaultButtonModel.java:387)
	 at javax.swing.JToggleButton$ToggleButtonModel.setPressed(JToggleButton.java:291)
	 at javax.swing.AbstractButton.doClick(AbstractButton.java:389)
	 at javax.swing.plaf.basic.BasicMenuItemUI.doClick(BasicMenuItemUI.java:809)
	 at com.apple.laf.AquaMenuItemUI.doClick(AquaMenuItemUI.java:137)
	 at javax.swing.plaf.basic.BasicMenuItemUI$Handler.mouseReleased(BasicMenuItemUI.java:850)
	 at java.awt.Component.processMouseEvent(Component.java:6382)
	 at javax.swing.JComponent.processMouseEvent(JComponent.java:3275)
	 at java.awt.Component.processEvent(Component.java:6147)
	 at java.awt.Container.processEvent(Container.java:2083)
	 at java.awt.Component.dispatchEventImpl(Component.java:4744)
	 at java.awt.Container.dispatchEventImpl(Container.java:2141)
	 at java.awt.Component.dispatchEvent(Component.java:4572)
	 at java.awt.LightweightDispatcher.retargetMouseEvent(Container.java:4619)
	 at java.awt.LightweightDispatcher.processMouseEvent(Container.java:4280)
	 at java.awt.LightweightDispatcher.dispatchEvent(Container.java:4210)
	 at java.awt.Container.dispatchEventImpl(Container.java:2127)
	 at java.awt.Window.dispatchEventImpl(Window.java:2489)
	 at java.awt.Component.dispatchEvent(Component.java:4572)
	 at java.awt.EventQueue.dispatchEventImpl(EventQueue.java:704)
	 at java.awt.EventQueue.access$400(EventQueue.java:82)
	 at java.awt.EventQueue$2.run(EventQueue.java:663)
	 at java.awt.EventQueue$2.run(EventQueue.java:661)
	 at java.security.AccessController.doPrivileged(Native Method)
	 at java.security.AccessControlContext$1.doIntersectionPrivilege(AccessControlContext.java:87)
	 at java.security.AccessControlContext$1.doIntersectionPrivilege(AccessControlContext.java:98)
	 at java.awt.EventQueue$3.run(EventQueue.java:677)
	 at java.awt.EventQueue$3.run(EventQueue.java:675)
	 at java.security.AccessController.doPrivileged(Native Method)
	 at java.security.AccessControlContext$1.doIntersectionPrivilege(AccessControlContext.java:87)
	 at java.awt.EventQueue.dispatchEvent(EventQueue.java:674)
	 at java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:296)
	 at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:211)
	 at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:201)
	 at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:196)
	 at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:188)
	 at java.awt.EventDispatchThread.run(EventDispatchThread.java:122)
	 Caused by: java.security.AccessControlException: access denied (java.io.FilePermission /Users/petwit2/.basex read)
	 at java.security.AccessControlContext.checkPermission(AccessControlContext.java:374)
	 at java.security.AccessController.checkPermission(AccessController.java:546)
	 at java.lang.SecurityManager.checkPermission(SecurityManager.java:532)
	 at java.lang.SecurityManager.checkRead(SecurityManager.java:871)
	 at java.io.File.exists(File.java:731)
	 at org.basex.core.AProp.<init>(AProp.java:58)
	 at org.basex.core.MainProp.<init>(MainProp.java:55)
	 at org.basex.core.Context.<init>(Context.java:64)
	 at nl.mpi.kinnate.entityindexer.CollectionExport.<clinit>(CollectionExport.java:22)
	 ... 45 more
	 */
	if (pluginManager.isActivated(kinOathPlugin)) {
	    pluginManager.deactivatePlugin(kinOathPlugin);
	} else {
	    pluginManager.activatePlugin(kinOathPlugin);
	}
	// we check if the plugin was actualy enabled and set the menu accordingly
	((JCheckBoxMenuItem) e.getSource()).setSelected(pluginManager.isActivated(kinOathPlugin));
	logger.debug("Plugin: " + kinOathPlugin.getName());
	logger.debug("Plugin: " + kinOathPlugin.getDescription());
	logger.debug("Plugin: " + kinOathPlugin.getMajorVersionNumber() + "." + kinOathPlugin.getMinorVersionNumber() + "." + kinOathPlugin.getBuildVersionNumber());
    }
}
