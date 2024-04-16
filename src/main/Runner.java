
package main;

import controllers.LoginController;
import gui.LoginView;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Ho Tan Dat
 */
public class Runner {
    
    
    public static void main(String[] args) {
        try {
               UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            System.out.println("Khởi tạo look and feel thành công!");
        } catch (Exception ex) {
            System.err.println("Khởi tạo look and feel thất bại!");
        }
       
        SwingUtilities.invokeLater(new Runnable() {
               @Override
               public void run() {
                    new LoginController(new LoginView());
               }
        });
        
    }
    
}
