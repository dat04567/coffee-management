package utils;



import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;


public class ErrorPopup {


    static PrintStream ps;
    
    public static void show(Exception e) {
        try {
            
            if (ps == null) {
                ps = new PrintStream(new FileOutputStream("log.txt", true));
            }
            e.printStackTrace(ps);

            JOptionPane.showMessageDialog(null, e.getMessage() , "Có lỗi xảy ra ", JOptionPane.ERROR_MESSAGE);
            
        }
        catch (Exception ex) {
            

        }

    }
}
