/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "SoLuongSanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoLuongSanPham.findAll", query = "SELECT s FROM SoLuongSanPham s"),
    @NamedQuery(name = "SoLuongSanPham.findByMaSize", query = "SELECT s FROM SoLuongSanPham s WHERE s.soLuongSanPhamPK.maSize = :maSize"),
    @NamedQuery(name = "SoLuongSanPham.findByMaSanPham", query = "SELECT s FROM SoLuongSanPham s WHERE s.soLuongSanPhamPK.maSanPham = :maSanPham"),
    @NamedQuery(name = "SoLuongSanPham.findByMaMau", query = "SELECT s FROM SoLuongSanPham s WHERE s.soLuongSanPhamPK.maMau = :maMau"),
    @NamedQuery(name = "SoLuongSanPham.findBySoLuong", query = "SELECT s FROM SoLuongSanPham s WHERE s.soLuong = :soLuong"),
    @NamedQuery(name = "SoLuongSanPham.findByStatus", query = "SELECT s FROM SoLuongSanPham s WHERE s.status = :status")})
public class SoLuongSanPham implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SoLuongSanPhamPK soLuongSanPhamPK;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "soLuongSanPham")
    private Collection<ChiTietHoaDon> chiTietHoaDonCollection;
    @JoinColumns({
        @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham", insertable = false, updatable = false),
        @JoinColumn(name = "MaMau", referencedColumnName = "MaMau", insertable = false, updatable = false)})
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private ChiTietSanPham chiTietSanPham;
    @JoinColumn(name = "MaSize", referencedColumnName = "MaSize", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private SizeSanPham sizeSanPham;

    public SoLuongSanPham() {
    }

    public SoLuongSanPham(SoLuongSanPhamPK soLuongSanPhamPK, Integer soLuong) {
        this.soLuongSanPhamPK = soLuongSanPhamPK;
        this.soLuong = soLuong;
    }

    
    
    public SoLuongSanPham(SoLuongSanPhamPK soLuongSanPhamPK, Integer soLuong, boolean status) {
        this.soLuongSanPhamPK = soLuongSanPhamPK;
        this.soLuong = soLuong;
        this.status = status;
    }

    
    
    public SoLuongSanPham(SoLuongSanPhamPK soLuongSanPhamPK) {
        this.soLuongSanPhamPK = soLuongSanPhamPK;
    }

    public SoLuongSanPham(SoLuongSanPhamPK soLuongSanPhamPK, boolean status) {
        this.soLuongSanPhamPK = soLuongSanPhamPK;
        this.status = status;
    }

    public SoLuongSanPham(int maSize, int maSanPham, int maMau) {
        this.soLuongSanPhamPK = new SoLuongSanPhamPK(maSize, maSanPham, maMau);
    }

    public SoLuongSanPhamPK getSoLuongSanPhamPK() {
        return soLuongSanPhamPK;
    }

    public void setSoLuongSanPhamPK(SoLuongSanPhamPK soLuongSanPhamPK) {
        this.soLuongSanPhamPK = soLuongSanPhamPK;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<ChiTietHoaDon> getChiTietHoaDonCollection() {
        return chiTietHoaDonCollection;
    }

    public void setChiTietHoaDonCollection(Collection<ChiTietHoaDon> chiTietHoaDonCollection) {
        this.chiTietHoaDonCollection = chiTietHoaDonCollection;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public SizeSanPham getSizeSanPham() {
        return sizeSanPham;
    }

    public void setSizeSanPham(SizeSanPham sizeSanPham) {
        this.sizeSanPham = sizeSanPham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soLuongSanPhamPK != null ? soLuongSanPhamPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoLuongSanPham)) {
            return false;
        }
        SoLuongSanPham other = (SoLuongSanPham) object;
        if ((this.soLuongSanPhamPK == null && other.soLuongSanPhamPK != null) || (this.soLuongSanPhamPK != null && !this.soLuongSanPhamPK.equals(other.soLuongSanPhamPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SoLuongSanPham[ soLuongSanPhamPK=" + soLuongSanPhamPK + " ]";
    }
    
}
