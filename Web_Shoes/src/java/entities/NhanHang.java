/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "NhanHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanHang.findAll", query = "SELECT n FROM NhanHang n"),
    @NamedQuery(name = "NhanHang.findByMaNhanHang", query = "SELECT n FROM NhanHang n WHERE n.maNhanHang = :maNhanHang"),
    @NamedQuery(name = "NhanHang.findByTenNhanHang", query = "SELECT n FROM NhanHang n WHERE n.tenNhanHang = :tenNhanHang"),
    @NamedQuery(name = "NhanHang.findByHinhNhanHang", query = "SELECT n FROM NhanHang n WHERE n.hinhNhanHang = :hinhNhanHang")})
public class NhanHang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhanHang")
    private Integer maNhanHang;
    @Size(max = 100)
    @Column(name = "TenNhanHang")
    private String tenNhanHang;
    @Size(max = 2147483647)
    @Column(name = "HinhNhanHang")
    private String hinhNhanHang;
    @OneToMany(mappedBy = "maNhanHang")
    private Collection<SanPham> sanPhamCollection;

    public NhanHang() {
    }

    public NhanHang(Integer maNhanHang) {
        this.maNhanHang = maNhanHang;
    }

    public Integer getMaNhanHang() {
        return maNhanHang;
    }

    public void setMaNhanHang(Integer maNhanHang) {
        this.maNhanHang = maNhanHang;
    }

    public String getTenNhanHang() {
        return tenNhanHang;
    }

    public void setTenNhanHang(String tenNhanHang) {
        this.tenNhanHang = tenNhanHang;
    }

    public String getHinhNhanHang() {
        return hinhNhanHang;
    }

    public void setHinhNhanHang(String hinhNhanHang) {
        this.hinhNhanHang = hinhNhanHang;
    }

    @XmlTransient
    public Collection<SanPham> getSanPhamCollection() {
        return sanPhamCollection;
    }

    public void setSanPhamCollection(Collection<SanPham> sanPhamCollection) {
        this.sanPhamCollection = sanPhamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNhanHang != null ? maNhanHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanHang)) {
            return false;
        }
        NhanHang other = (NhanHang) object;
        if ((this.maNhanHang == null && other.maNhanHang != null) || (this.maNhanHang != null && !this.maNhanHang.equals(other.maNhanHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NhanHang[ maNhanHang=" + maNhanHang + " ]";
    }
    
}
