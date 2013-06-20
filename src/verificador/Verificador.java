/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador;

import java.awt.Desktop;
import consoleView.Console;
import guiView.Gui;
/**
 *
 * @author franz
 */
public class Verificador {
    
    static private Console console;
    static private Gui gui;
    static Dbase dbase;
    
    public static void main(String[] args) throws ClassNotFoundException {
        int debug = 1; //1-> Forzar el uso de la Consola, 2->Forzar el uso del Escritorio, 3-> Ejecución normal del programa
        
        dbase = new Dbase();
        boolean bdConnection = dbase.makeConnection();
        
        if(debug == 1){
            //CONSOLA
            console = new Console(bdConnection);
            console.makeConsole();
        }
        else if(debug == 2)
        {
            //ESCRITORIO
            gui = new Gui(bdConnection);
        }
        else{
            try{
                //ESCRITORIO
                Desktop desktop = Desktop.getDesktop();
                gui = new Gui(bdConnection);
            }catch(Exception e){
                //CONSOLA
                console = new Console(bdConnection);
                console.makeConsole();
            }
        }
    }
}
