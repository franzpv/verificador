/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleView;

import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.terminal.TerminalSize;

/**
 *
 * @author franz
 */
public class Obtenedor {
    private GUIScreen parent;
    
    public Obtenedor(GUIScreen parent){
        Window obtenedorWindow = new Window("Obtener Data de Twitter");
        obtenedorWindow.setWindowSizeOverride(new TerminalSize(130,50));
        obtenedorWindow.setSoloWindow(true);
        Label temp = new Label("Temp");
        obtenedorWindow.addComponent(temp);
        parent.showWindow(obtenedorWindow);
    }
    
    
}
