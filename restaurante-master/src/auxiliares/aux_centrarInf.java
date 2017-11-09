
package auxiliares;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin CR
 */
public class aux_centrarInf {
    
    public static void MostrarYcentrarInf(JInternalFrame inf, JDesktopPane panel) {
        int x = (panel.getWidth() / 2) - inf.getWidth() / 2;
        int y = (panel.getHeight() / 2) - inf.getHeight() / 2;
        if (inf.isShowing()) {
            inf.setLocation(x, y);
        } else {
            panel.add(inf);
            inf.setLocation(x, y);
            inf.show();
        }
    }
    
    public static void Mensaje(){
        JOptionPane.showMessageDialog(null, "LA VENTANA YA SE ENCUENTRA ABIERTA");
    }
}
