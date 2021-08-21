import view.*;
import java.awt.*;

/**
 * Persistencia Proyectos Construcción
 *
 */
public class App_19 {
    public static void main( String[] args ){   
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try{
                    VistaRequerimientosReto4 frame = new VistaRequerimientosReto4();
                    frame.setVisible(true);
                } catch(Exception e){
                    e.printStackTrace();
                }
                
            }
            
        });
    }
}
