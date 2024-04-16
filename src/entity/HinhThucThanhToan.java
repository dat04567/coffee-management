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
    PAYMENT("Thanh toán khi nhận hàng"),
    CREDIT("Thẻ tín dụng");
    
    private  String label;
    
    HinhThucThanhToan(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
   
    
    
}
