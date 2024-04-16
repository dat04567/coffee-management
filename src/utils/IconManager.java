package utils;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class IconManager {

    public static String resourcesPath = "";
    public static String iconsPath = "" + "icons/";

    public IconManager() {
    }

    public Icon getIcon(String name) {
//        getClass().getResource(iconsPath + name)
        ImageIcon imageIcon =  new ImageIcon(iconsPath + name);
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}
