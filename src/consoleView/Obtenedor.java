/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleView;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.terminal.TerminalSize;
import verificador.Stream;

/**
 *
 * @author franz
 */
public class Obtenedor {
    private GUIScreen parent;
    private Stream stream;
    
    public Obtenedor(GUIScreen parent){
        stream = new Stream();
        
        final Window obtenedorWindow = new Window("Obtener Data de Twitter");
        obtenedorWindow.setWindowSizeOverride(new TerminalSize(130,50));
        obtenedorWindow.setSoloWindow(false);
        Label temp = new Label("Temp");
        obtenedorWindow.addComponent(temp);
        
        obtenedorWindow.addComponent(new EmptySpace(50,50));
        
        Button buttonVolver;
        buttonVolver = new Button("Volver",new Action(){
            @Override
            public void doAction(){
                stream.closeStream();
                obtenedorWindow.close();
            }
        });
        buttonVolver.setAlignment(Component.Alignment.RIGHT_CENTER);
        obtenedorWindow.addComponent(buttonVolver, LinearLayout.GROWS_HORIZONTALLY);
        
        parent.showWindow(obtenedorWindow);
    }
}
