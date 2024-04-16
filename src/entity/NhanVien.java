package entity;



/**
 *
 * @author mac
 */
public class NhanVien {
    private String hoTen, username, password, cccd, diaChi, maNV;
    private int sdt;
    private boolean isNam;

    public NhanVien(String hoTen, String username, String password, String cccd, String diaChi, String maNV, int sdt, boolean isNam) {
        this.hoTen = hoTen;
        this.username = username;
        this.password = password;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.maNV = maNV;
        this.sdt = sdt;
        this.isNam = isNam;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public boolean isIsNam() {
        return isNam;
    }

    public void setIsNam(boolean isNam) {
        this.isNam = isNam;
    }
    
    
}
