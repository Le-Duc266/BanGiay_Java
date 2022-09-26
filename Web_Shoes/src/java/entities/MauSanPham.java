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
import javax.persistence.FetchType;
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
@Table(name = "MauSanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MauSanPham.findAll", query = "SELECT m FROM MauSanPham m"),
    @NamedQuery(name = "MauSanPham.findByMaMau", query = "SELECT m FROM MauSanPham m WHERE m.maMau = :maMau"),
    @NamedQuery(name = "MauSanPham.findByTenMau", query = "SELECT m FROM MauSanPham m WHERE m.tenMau = :tenMau"),
    @NamedQuery(name = "MauSanPham.findByHexCode", query = "SELECT m FROM MauSanPham m WHERE m.hexCode = :hexCode")})
public class MauSanPham implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaMau")
    private Integer maMau;
    @Size(max = 50)
    @Column(name = "TenMau")
    private String tenMau;
    @Size(max = 10)
    @Column(name = "HexCode")
    private String hexCode;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "mauSanPham")
    private Collection<ChiTietSanPham> chiTietSanPhamCollection;

    public MauSanPham() {
    }

    public MauSanPham(Integer maMau) {
        this.maMau = maMau;
    }

    public Integer getMaMau() {
        return maMau;
    }

    public void setMaMau(Integer maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    @XmlTransient
    public Collection<ChiTietSanPham> getChiTietSanPhamCollection() {
        return chiTietSanPhamCollection;
    }

    public void setChiTietSanPhamCollection(Collection<ChiTietSanPham> chiTietSanPhamCollection) {
        this.chiTietSanPhamCollection = chiTietSanPhamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMau != null ? maMau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MauSanPham)) {
            return false;
        }
        MauSanPham other = (MauSanPham) object;
        if ((this.maMau == null && other.maMau != null) || (this.maMau != null && !this.maMau.equals(other.maMau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MauSanPham[ maMau=" + maMau + " ]";
    }
    
}
