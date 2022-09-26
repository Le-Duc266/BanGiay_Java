/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ChiTietHoaDon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietHoaDon.findAll", query = "SELECT c FROM ChiTietHoaDon c"),
    @NamedQuery(name = "ChiTietHoaDon.findByMaHoaDon", query = "SELECT c FROM ChiTietHoaDon c WHERE c.chiTietHoaDonPK.maHoaDon = :maHoaDon"),
    @NamedQuery(name = "ChiTietHoaDon.findByMaSanPham", query = "SELECT c FROM ChiTietHoaDon c WHERE c.chiTietHoaDonPK.maSanPham = :maSanPham"),
    @NamedQuery(name = "ChiTietHoaDon.findByMaSize", query = "SELECT c FROM ChiTietHoaDon c WHERE c.chiTietHoaDonPK.maSize = :maSize"),
    @NamedQuery(name = "ChiTietHoaDon.findByMaMau", query = "SELECT c FROM ChiTietHoaDon c WHERE c.chiTietHoaDonPK.maMau = :maMau"),
    @NamedQuery(name = "ChiTietHoaDon.findBySoLuong", query = "SELECT c FROM ChiTietHoaDon c WHERE c.soLuong = :soLuong"),
    @NamedQuery(name = "ChiTietHoaDon.findByGiaTien", query = "SELECT c FROM ChiTietHoaDon c WHERE c.giaTien = :giaTien")})
public class ChiTietHoaDon implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChiTietHoaDonPK chiTietHoaDonPK;
    @Column(name = "SoLuong")
    private Integer soLuong;
    
    @Column(name = "GiaTien")
    private double giaTien;
    @Column(name = "ThanhTien")
    private double thanhTien;
    @JoinColumn(name = "MaHoaDon", referencedColumnName = "MaHoaDon", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HoaDon hoaDon;
    @JoinColumns({
        @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham", insertable = false, updatable = false),
        @JoinColumn(name = "MaSize", referencedColumnName = "MaSize", insertable = false, updatable = false),
        @JoinColumn(name = "MaMau", referencedColumnName = "MaMau", insertable = false, updatable = false)})
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private SoLuongSanPham soLuongSanPham;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(ChiTietHoaDonPK chiTietHoaDonPK) {
        this.chiTietHoaDonPK = chiTietHoaDonPK;
    }

    public ChiTietHoaDon(int maHoaDon, int maSanPham, int maSize, int maMau) {
        this.chiTietHoaDonPK = new ChiTietHoaDonPK(maHoaDon, maSanPham, maSize, maMau);
    }

    public ChiTietHoaDonPK getChiTietHoaDonPK() {
        return chiTietHoaDonPK;
    }

    public void setChiTietHoaDonPK(ChiTietHoaDonPK chiTietHoaDonPK) {
        this.chiTietHoaDonPK = chiTietHoaDonPK;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SoLuongSanPham getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(SoLuongSanPham soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietHoaDonPK != null ? chiTietHoaDonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietHoaDon)) {
            return false;
        }
        ChiTietHoaDon other = (ChiTietHoaDon) object;
        if ((this.chiTietHoaDonPK == null && other.chiTietHoaDonPK != null) || (this.chiTietHoaDonPK != null && !this.chiTietHoaDonPK.equals(other.chiTietHoaDonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ChiTietHoaDon[ chiTietHoaDonPK=" + chiTietHoaDonPK + " ]";
    }
    
}
