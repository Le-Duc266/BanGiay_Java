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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Where;
import javax.persistence.FetchType;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "SanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s"),
    @NamedQuery(name = "SanPham.findByMaSanPham", query = "SELECT s FROM SanPham s WHERE s.maSanPham = :maSanPham"),
    @NamedQuery(name = "SanPham.findByTenSanPham", query = "SELECT s FROM SanPham s WHERE s.tenSanPham = :tenSanPham"),
    @NamedQuery(name = "SanPham.findByMoTa", query = "SELECT s FROM SanPham s WHERE s.moTa = :moTa")})
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaSanPham")
    private Integer maSanPham;
    @Size(max = 100)
    @Column(name = "TenSanPham")
    private String tenSanPham;
    @Size(max = 2147483647)
    @Column(name = "MoTa")
    private String moTa;
    @ManyToMany(fetch = FetchType.EAGER)
    @Where(clause = "status='True'")
    @JoinTable(name = "ChiTietKhuyenMai", joinColumns
            = @JoinColumn(name = "MaSanPham"), inverseJoinColumns
            = @JoinColumn(name = "MaKhuyenMai"))
    private Set<KhuyenMai> khuyenMaiCollection = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sanPham")
    private Collection<ChiTietSanPham> chiTietSanPhamCollection;
    @JoinColumn(name = "MaDanhMuc", referencedColumnName = "MaDanhMuc")
    @ManyToOne
    private DanhMucSanPham maDanhMuc;
    @JoinColumn(name = "MaGioiTinh", referencedColumnName = "MaGioiTinh")
    @ManyToOne
    private GioiTinh maGioiTinh;
    @JoinColumn(name = "MaNhanHang", referencedColumnName = "MaNhanHang")
    @ManyToOne
    private NhanHang maNhanHang;

    public SanPham() {
    }

    public SanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Set<KhuyenMai> getKhuyenMaiCollection() {
        return khuyenMaiCollection;
    }

    public void setKhuyenMaiCollection(Set<KhuyenMai> khuyenMaiCollection) {
        this.khuyenMaiCollection = khuyenMaiCollection;
    }

    @XmlTransient
    public Collection<ChiTietSanPham> getChiTietSanPhamCollection() {
        return chiTietSanPhamCollection;
    }

    public void setChiTietSanPhamCollection(Collection<ChiTietSanPham> chiTietSanPhamCollection) {
        this.chiTietSanPhamCollection = chiTietSanPhamCollection;
    }

    public DanhMucSanPham getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(DanhMucSanPham maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public GioiTinh getMaGioiTinh() {
        return maGioiTinh;
    }

    public void setMaGioiTinh(GioiTinh maGioiTinh) {
        this.maGioiTinh = maGioiTinh;
    }

    public NhanHang getMaNhanHang() {
        return maNhanHang;
    }

    public void setMaNhanHang(NhanHang maNhanHang) {
        this.maNhanHang = maNhanHang;
    }

    public int tinhTongMau() {
        
        return this.chiTietSanPhamCollection.size()-3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSanPham != null ? maSanPham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.maSanPham == null && other.maSanPham != null) || (this.maSanPham != null && !this.maSanPham.equals(other.maSanPham))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SanPham[ maSanPham=" + maSanPham + " ]";
    }

}
