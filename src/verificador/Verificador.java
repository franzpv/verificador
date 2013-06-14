/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador;

import java.awt.Desktop;
import views.Console;
import views.Gui;
/**
 *
 * @author franz
 */
public class Verificador {
    public static void main(String[] args) throws ClassNotFoundException {
        int debug = 0;
        
        Console console;
        Gui gui;
        
        Dbase dbase = new Dbase();
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
