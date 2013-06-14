package views;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.terminal.TerminalSize;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franz
 */
public class Console {
    boolean bdConnection;
    
    public Console(boolean bdConnection){
        this.bdConnection = bdConnection;
    }
    public void makeConsole(){
        final GUIScreen consoleScreen = TerminalFacade.createGUIScreen();
        final Window consoleWindow = new Window("Verificador");
        consoleWindow.setWindowSizeOverride(new TerminalSize(130,50));
        consoleWindow.setSoloWindow(true);
        if(bdConnection == true){
            Button buttonObtenerData = new Button("Obtener Data de Twitter");
            buttonObtenerData.setAlignment(Component.Alignment.LEFT_CENTER);
            consoleWindow.addComponent(buttonObtenerData, LinearLayout.GROWS_HORIZONTALLY);
        
            Button buttonAnalizarData = new Button("Analizar Data obtenida");
            buttonAnalizarData.setAlignment(Component.Alignment.LEFT_CENTER);
            consoleWindow.addComponent(buttonAnalizarData, LinearLayout.GROWS_HORIZONTALLY);
        }
        else{
            consoleWindow.addComponent(new EmptySpace(15,15));
            Label errorBD = new Label("Error al conectar a la base de datos!!");
            consoleWindow.addComponent(errorBD);
        }
        consoleWindow.addComponent(new EmptySpace(30,30));
        
        Button buttonSalir = new Button("Salir", new Action(){
            @Override
            public void doAction(){
                consoleWindow.close();
                consoleScreen.getScreen().stopScreen();
            }
        });
        buttonSalir.setAlignment(Component.Alignment.RIGHT_CENTER);
        consoleWindow.addComponent(buttonSalir, LinearLayout.GROWS_HORIZONTALLY);
        
        consoleScreen.getScreen().startScreen();
        consoleScreen.showWindow(consoleWindow);
    }
}