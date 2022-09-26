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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import unit.XuLyTien;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ChiTietSanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietSanPham.findAll", query = "SELECT c FROM ChiTietSanPham c"),
    @NamedQuery(name = "ChiTietSanPham.findByMaSanPham", query = "SELECT c FROM ChiTietSanPham c WHERE c.chiTietSanPhamPK.maSanPham = :maSanPham"),
    @NamedQuery(name = "ChiTietSanPham.findByMaMau", query = "SELECT c FROM ChiTietSanPham c WHERE c.chiTietSanPhamPK.maMau = :maMau"),
    @NamedQuery(name = "ChiTietSanPham.findByGiaTien", query = "SELECT c FROM ChiTietSanPham c WHERE c.giaTien = :giaTien"),
    @NamedQuery(name = "ChiTietSanPham.findByNgayTao", query = "SELECT c FROM ChiTietSanPham c WHERE c.ngayTao = :ngayTao"),
    @NamedQuery(name = "ChiTietSanPham.findByStatus", query = "SELECT c FROM ChiTietSanPham c WHERE c.status = :status"),
    @NamedQuery(name = "ChiTietSanPham.findByAnhChinh", query = "SELECT c FROM ChiTietSanPham c WHERE c.anhChinh = :anhChinh")})
public class ChiTietSanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChiTietSanPhamPK chiTietSanPhamPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GiaTien")
    private Double giaTien;
    @Size(max = 50)
    @Column(name = "NgayTao")
    private String ngayTao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Size(max = 200)
    @Column(name = "AnhChinh")
    private String anhChinh;
    @JoinColumn(name = "MaMau", referencedColumnName = "MaMau", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private MauSanPham mauSanPham;
    @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SanPham sanPham;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "chiTietSanPham")
    private Collection<AnhSanPham> anhSanPhamCollection;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "chiTietSanPham")
    private Collection<SoLuongSanPham> soLuongSanPhamCollection;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(ChiTietSanPhamPK chiTietSanPhamPK, Double giaTien, String ngayTao, boolean status, String anhChinh) {
        this.chiTietSanPhamPK = chiTietSanPhamPK;
        this.giaTien = giaTien;
        this.ngayTao = ngayTao;
        this.status = status;
        this.anhChinh = anhChinh;
    }

    public ChiTietSanPham(ChiTietSanPhamPK chiTietSanPhamPK, boolean status) {
        this.chiTietSanPhamPK = chiTietSanPhamPK;
        this.status = status;
    }

    public ChiTietSanPham(int maSanPham, int maMau) {
        this.chiTietSanPhamPK = new ChiTietSanPhamPK(maSanPham, maMau);
    }

    public ChiTietSanPham(ChiTietSanPhamPK chiTietSanPhamPK) {
        this.chiTietSanPhamPK = chiTietSanPhamPK;
    }

    public ChiTietSanPhamPK getChiTietSanPhamPK() {
        return chiTietSanPhamPK;
    }

    public void setChiTietSanPhamPK(ChiTietSanPhamPK chiTietSanPhamPK) {
        this.chiTietSanPhamPK = chiTietSanPhamPK;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAnhChinh() {
        return anhChinh;
    }

    public void setAnhChinh(String anhChinh) {
        this.anhChinh = anhChinh;
    }

    public MauSanPham getMauSanPham() {
        return mauSanPham;
    }

    public void setMauSanPham(MauSanPham mauSanPham) {
        this.mauSanPham = mauSanPham;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public double tinhtien() {
        for (KhuyenMai anhSanPhamCollection1 : sanPham.getKhuyenMaiCollection()) {

            return this.giaTien - ((this.giaTien / 100) * anhSanPhamCollection1.getGiaGiam());
        }
        return this.giaTien;
    }

    public double tinhTong() {

        return this.giaTien;
    }

    public String getGiaString() {
        return XuLyTien.dinhDangTien(tinhTong());
    }

    public String getGiaKmString() {
        return XuLyTien.dinhDangTien(tinhtien());
    }

    public double tinhtien1() {
        for (KhuyenMai anhSanPhamCollection1 : sanPham.getKhuyenMaiCollection()) {

            return this.giaTien - ((this.giaTien / 100) * anhSanPhamCollection1.getGiaGiam());
        }
        return this.giaTien;
    }

    public double tinhTong1() {

        return this.giaTien;
    }

    public String getGiaString1() {
        return XuLyTien.dinhDangTien1(tinhTong1());
    }

    public String getGiaKmString1() {
        return XuLyTien.dinhDangTien(tinhtien1());
    }

    @XmlTransient
    public Collection<AnhSanPham> getAnhSanPhamCollection() {
        return anhSanPhamCollection;
    }

    public void setAnhSanPhamCollection(Collection<AnhSanPham> anhSanPhamCollection) {
        this.anhSanPhamCollection = anhSanPhamCollection;
    }

    @XmlTransient
    public Collection<SoLuongSanPham> getSoLuongSanPhamCollection() {
        return soLuongSanPhamCollection;
    }

    public void setSoLuongSanPhamCollection(Collection<SoLuongSanPham> soLuongSanPhamCollection) {
        this.soLuongSanPhamCollection = soLuongSanPhamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietSanPhamPK != null ? chiTietSanPhamPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietSanPham)) {
            return false;
        }
        ChiTietSanPham other = (ChiTietSanPham) object;
        if ((this.chiTietSanPhamPK == null && other.chiTietSanPhamPK != null) || (this.chiTietSanPhamPK != null && !this.chiTietSanPhamPK.equals(other.chiTietSanPhamPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ChiTietSanPham[ chiTietSanPhamPK=" + chiTietSanPhamPK + " ]";
    }

}
