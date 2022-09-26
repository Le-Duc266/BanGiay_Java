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
public class AnhSanPhamPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaAnhSP")
    private int maAnhSP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaSanPham")
    private int maSanPham;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaMau")
    private int maMau;

    public AnhSanPhamPK() {
    }

    

    public AnhSanPhamPK(int maAnhSP, int maSanPham, int maMau) {
        this.maAnhSP = maAnhSP;
        this.maSanPham = maSanPham;
        this.maMau = maMau;
    }

    public int getMaAnhSP() {
        return maAnhSP;
    }

    public void setMaAnhSP(int maAnhSP) {
        this.maAnhSP = maAnhSP;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
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
        hash += (int) maAnhSP;
        hash += (int) maSanPham;
        hash += (int) maMau;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnhSanPhamPK)) {
            return false;
        }
        AnhSanPhamPK other = (AnhSanPhamPK) object;
        if (this.maAnhSP != other.maAnhSP) {
            return false;
        }
        if (this.maSanPham != other.maSanPham) {
            return false;
        }
        if (this.maMau != other.maMau) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AnhSanPhamPK[ maAnhSP=" + maAnhSP + ", maSanPham=" + maSanPham + ", maMau=" + maMau + " ]";
    }
    
}
