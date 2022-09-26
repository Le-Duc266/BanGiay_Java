/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "KhuyenMai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhuyenMai.findAll", query = "SELECT k FROM KhuyenMai k"),
    @NamedQuery(name = "KhuyenMai.findByMaKhuyenMai", query = "SELECT k FROM KhuyenMai k WHERE k.maKhuyenMai = :maKhuyenMai"),
    @NamedQuery(name = "KhuyenMai.findByTenKhuyenMai", query = "SELECT k FROM KhuyenMai k WHERE k.tenKhuyenMai = :tenKhuyenMai"),
    @NamedQuery(name = "KhuyenMai.findByThoiGianBatDau", query = "SELECT k FROM KhuyenMai k WHERE k.thoiGianBatDau = :thoiGianBatDau"),
    @NamedQuery(name = "KhuyenMai.findByThoiGianKetThuc", query = "SELECT k FROM KhuyenMai k WHERE k.thoiGianKetThuc = :thoiGianKetThuc"),
    @NamedQuery(name = "KhuyenMai.findByMoTa", query = "SELECT k FROM KhuyenMai k WHERE k.moTa = :moTa"),
    @NamedQuery(name = "KhuyenMai.findByGiaGiam", query = "SELECT k FROM KhuyenMai k WHERE k.giaGiam = :giaGiam"),
    @NamedQuery(name = "KhuyenMai.findByStatus", query = "SELECT k FROM KhuyenMai k WHERE k.status = :status"),
    @NamedQuery(name = "KhuyenMai.findByKmtheo", query = "SELECT k FROM KhuyenMai k WHERE k.kmtheo = :kmtheo")})
public class KhuyenMai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhuyenMai")
    private Integer maKhuyenMai;
    @Size(max = 200)
    @Column(name = "TenKhuyenMai")
    private String tenKhuyenMai;
    @Column(name = "ThoiGianBatDau")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianBatDau;
    @Column(name = "ThoiGianKetThuc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianKetThuc;
    @Size(max = 2147483647)
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "GiaGiam")
    private Integer giaGiam;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "kmtheo")
    private Boolean kmtheo;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ChiTietKhuyenMai", joinColumns
            = @JoinColumn(name = "MaKhuyenMai"), inverseJoinColumns
            = @JoinColumn(name = "MaSanPham"))
    private Set<SanPham> sanPhamCollection = new HashSet<>();

    public KhuyenMai() {
    }

    public KhuyenMai(Integer maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public Integer getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(Integer maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(Integer giaGiam) {
        this.giaGiam = giaGiam;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getKmtheo() {
        return kmtheo;
    }

    public void setKmtheo(Boolean kmtheo) {
        this.kmtheo = kmtheo;
    }

    public Set<SanPham> getSanPhamCollection() {
        return sanPhamCollection;
    }

    public void setSanPhamCollection(Set<SanPham> sanPhamCollection) {
        this.sanPhamCollection = sanPhamCollection;
    }
 public void addKhuyenMai(SanPham sanPham) {
        this.sanPhamCollection.add(sanPham);
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKhuyenMai != null ? maKhuyenMai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhuyenMai)) {
            return false;
        }
        KhuyenMai other = (KhuyenMai) object;
        if ((this.maKhuyenMai == null && other.maKhuyenMai != null) || (this.maKhuyenMai != null && !this.maKhuyenMai.equals(other.maKhuyenMai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "maKhuyenMai=" + maKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc=" + thoiGianKetThuc + ", moTa=" + moTa + ", giaGiam=" + giaGiam + ", status=" + status + ", kmtheo=" + kmtheo + ", sanPhamCollection=" + sanPhamCollection + '}';
    }

   

}
