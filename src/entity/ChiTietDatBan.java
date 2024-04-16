
package entity;

import java.time.LocalDate;

/**
 *
 * @author mac
 */
public class ChiTietDatBan {
   private String tenKH,maBan, ghiChu;
   private int soLuongBan;
   private int sdt;
   private LocalDate thoiGian, ngayThang;
   private ChiTietDatBan chiTietDatBan;

    public ChiTietDatBan(String tenKH, String maBan, String ghiChu, int soLuongBan, int sdt, LocalDate thoiGian, LocalDate ngayThang, ChiTietDatBan chiTietDatBan) {
        this.tenKH = tenKH;
        this.maBan = maBan;
        this.ghiChu = ghiChu;
        this.soLuongBan = soLuongBan;
        this.sdt = sdt;
        this.thoiGian = thoiGian;
        this.ngayThang = ngayThang;
        this.chiTietDatBan = chiTietDatBan;
    }
   
   

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public LocalDate getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDate thoiGian) {
        this.thoiGian = thoiGian;
    }

    public LocalDate getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(LocalDate ngayThang) {
        this.ngayThang = ngayThang;
    }

    public ChiTietDatBan getChiTietDatBan() {
        return chiTietDatBan;
    }

    public void setChiTietDatBan(ChiTietDatBan chiTietDatBan) {
        this.chiTietDatBan = chiTietDatBan;
    }
   
   
   
   

}
