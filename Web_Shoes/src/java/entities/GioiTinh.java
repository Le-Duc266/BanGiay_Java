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
@Table(name = "GioiTinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GioiTinh.findAll", query = "SELECT g FROM GioiTinh g"),
    @NamedQuery(name = "GioiTinh.findByMaGioiTinh", query = "SELECT g FROM GioiTinh g WHERE g.maGioiTinh = :maGioiTinh"),
    @NamedQuery(name = "GioiTinh.findByTenGioiTinh", query = "SELECT g FROM GioiTinh g WHERE g.tenGioiTinh = :tenGioiTinh")})
public class GioiTinh implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaGioiTinh")
    private Integer maGioiTinh;
    @Size(max = 50)
    @Column(name = "TenGioiTinh")
    private String tenGioiTinh;
    @OneToMany(mappedBy = "maGioiTinh")
    private Collection<SanPham> sanPhamCollection;

    public GioiTinh() {
    }

    public GioiTinh(Integer maGioiTinh) {
        this.maGioiTinh = maGioiTinh;
    }

    public Integer getMaGioiTinh() {
        return maGioiTinh;
    }

    public void setMaGioiTinh(Integer maGioiTinh) {
        this.maGioiTinh = maGioiTinh;
    }

    public String getTenGioiTinh() {
        return tenGioiTinh;
    }

    public void setTenGioiTinh(String tenGioiTinh) {
        this.tenGioiTinh = tenGioiTinh;
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
        hash += (maGioiTinh != null ? maGioiTinh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GioiTinh)) {
            return false;
        }
        GioiTinh other = (GioiTinh) object;
        if ((this.maGioiTinh == null && other.maGioiTinh != null) || (this.maGioiTinh != null && !this.maGioiTinh.equals(other.maGioiTinh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GioiTinh[ maGioiTinh=" + maGioiTinh + " ]";
    }
    
}
