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
package nl.mpi.flap.plugin;

import java.io.File;
import java.util.Map;
import javax.swing.JComponent;

/**
 * Document : PluginDialogHandler <br> Created on Aug 15, 2012, 1:49:59 PM <br>
 *
 * @author Peter Withers <br>
 */
public interface PluginDialogHandler {

    static enum DialogueType {

        open, save, custom
    };

    void addMessageDialogToQueue(String messageString, String messageTitle);

    boolean showConfirmDialogBox(String messageString, String messageTitle);

    int showDialogBox(String message, String title, int optionType, int messageType);

    int showDialogBox(String message, String title, int optionType, int messageType, Object[] options, Object initialValue);

    File[] showFileSelectBox(String titleText, boolean directorySelectOnly, boolean multipleSelect, Map<String, javax.swing.filechooser.FileFilter> fileFilterMap, DialogueType dialogueType, JComponent customAccessory);
}
