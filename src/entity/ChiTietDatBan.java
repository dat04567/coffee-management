
package entity;

import java.sql.Timestamp;


/**
 *
 * @author mac
 */
public class ChiTietDatBan {
    private Timestamp thoiGianDatBan;
    private HoaDon hoaDon;
    private DatBan datBan;

    public ChiTietDatBan(Timestamp thoiGianDatBan, HoaDon hoaDon, DatBan datBan) {
        this.thoiGianDatBan = thoiGianDatBan;
        this.hoaDon = hoaDon;
        this.datBan = datBan;
    }

    public Timestamp getThoiGianDatBan() {
        return thoiGianDatBan;
    }

    public void setThoiGianDatBan(Timestamp thoiGianDatBan) {
        this.thoiGianDatBan = thoiGianDatBan;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public DatBan getDatBan() {
        return datBan;
    }

    public void setDatBan(DatBan datBan) {
        this.datBan = datBan;
    }
    
    

   
    
    
  
   
   

}
