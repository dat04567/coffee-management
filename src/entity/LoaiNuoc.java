/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author 
 */

public enum LoaiNuoc {
    COLD_DRINK("Nước giải khác"),
    COFFE("Cà phê"),
    BORN("Sinh tố");
    
    

    private  String label;

    
    LoaiNuoc(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
    

    @Override
    public String toString() {
        return label;
    }
    
    
      public static LoaiNuoc getByName(String name) {
        for (LoaiNuoc e : values()) {
            if (e.label.equals(name)) {
                return e;
            }
        }
        return COLD_DRINK;
    }
    
        
    
   
    
}