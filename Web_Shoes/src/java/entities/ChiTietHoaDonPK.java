/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DELL
 */
@Embeddable
public class ChiTietHoaDonPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaHoaDon")
    private int maHoaDon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaSanPham")
    private int maSanPham;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaSize")
    private int maSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaMau")
    private int maMau;

    public ChiTietHoaDonPK() {
    }

    public ChiTietHoaDonPK(int maHoaDon, int maSanPham, int maSize, int maMau) {
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.maSize = maSize;
        this.maMau = maMau;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getMaSize() {
        return maSize;
    }

    public void setMaSize(int maSize) {
        this.maSize = maSize;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maHoaDon;
        hash += (int) maSanPham;
        hash += (int) maSize;
        hash += (int) maMau;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietHoaDonPK)) {
            return false;
        }
        ChiTietHoaDonPK other = (ChiTietHoaDonPK) object;
        if (this.maHoaDon != other.maHoaDon) {
            return false;
        }
        if (this.maSanPham != other.maSanPham) {
            return false;
        }
        if (this.maSize != other.maSize) {
            return false;
        }
        if (this.maMau != other.maMau) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ChiTietHoaDonPK[ maHoaDon=" + maHoaDon + ", maSanPham=" + maSanPham + ", maSize=" + maSize + ", maMau=" + maMau + " ]";
    }
    
}
