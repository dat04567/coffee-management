/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mac
 */
public enum HinhThucThanhToan {
    PAYMENT("pay", "Tiền mặt"),
    CREDIT("cre", "Chuyển khoản");
    
    private  String label;
    private String id;
    HinhThucThanhToan(String id,String label) {
        this.label = label;
        this.id = id;
    }

    @Override
    public String toString() {
        return label;
    }

    public String getLabel() {
        return label;
    }
    
    
    public static HinhThucThanhToan getById(String id) {
        for (HinhThucThanhToan e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return PAYMENT;
    }

    public static HinhThucThanhToan getByName(String name) {
        for (HinhThucThanhToan e : values()) {
            if (e.label.equals(name)) {
                return e;
            }
        }
        return PAYMENT;
    }
    
    
   
    
    
}
