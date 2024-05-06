
package entity;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author mac
 */
public class ChiTietDatBan extends Model{
    private Timestamp thoiGianDatBan;
    private HoaDon hoaDon;
   
    private DatBan datBan;

    public ChiTietDatBan(Timestamp thoiGianDatBan, HoaDon hoaDon, DatBan datBan) {
        this.thoiGianDatBan = thoiGianDatBan;
        this.hoaDon = hoaDon;
        this.datBan = datBan;
    }

    public ChiTietDatBan(Timestamp thoiGianDatBan, DatBan datBan) {
        this.thoiGianDatBan = thoiGianDatBan;
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
    
    public  static ChiTietDatBan getFromResultSet(ResultSet rs) throws SQLException
    {
        Timestamp thoiGianDatBan = rs.getTimestamp("thoiGianDatBan");
        String maDatBan = rs.getNString("maDatBan");
        int soLuongBan = rs.getInt("soLuongBan");
        String ghiChu = rs.getNString("ghiChu");
        String tenKhachHang = rs.getNString("tenKhachHang");
        String soDienThoai = rs.getNString("soDienThoai");
        KhachHang khachHang = new KhachHang(tenKhachHang, soDienThoai);
        DatBan datBan = new DatBan(maDatBan, soLuongBan, khachHang, ghiChu);
        
        ChiTietDatBan chiTietDatBan = new ChiTietDatBan(thoiGianDatBan, datBan);
        return chiTietDatBan;
        
        
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] toRowTable() {
     
            DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE.ofPattern("dd-MM-yyyy");
            LocalDateTime localDateTime = this.thoiGianDatBan.toLocalDateTime();
          
          return new Object[]{
            this.datBan.getMaBan(), this.datBan.getKhachHang().getTenKhachHang(),  this.datBan.getKhachHang().getSoDienThoai(), localDateTime.format(formatter) , 
              this.datBan.getSoLuongBan(), this.datBan.getGhiChu()
        };
    }
    
    
    
    

   
    
    
  
   
   

}
