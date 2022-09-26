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
@Table(name = "SizeSanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SizeSanPham.findAll", query = "SELECT s FROM SizeSanPham s"),
    @NamedQuery(name = "SizeSanPham.findByMaSize", query = "SELECT s FROM SizeSanPham s WHERE s.maSize = :maSize"),
    @NamedQuery(name = "SizeSanPham.findBySize", query = "SELECT s FROM SizeSanPham s WHERE s.size = :size")})
public class SizeSanPham implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSize")
    private Integer maSize;
    @Size(max = 20)
    @Column(name = "Size")
    private String size;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "sizeSanPham")
    private Collection<SoLuongSanPham> soLuongSanPhamCollection;

    public SizeSanPham() {
    }

    public SizeSanPham(Integer maSize) {
        this.maSize = maSize;
    }

    public Integer getMaSize() {
        return maSize;
    }

    public void setMaSize(Integer maSize) {
        this.maSize = maSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
        hash += (maSize != null ? maSize.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SizeSanPham)) {
            return false;
        }
        SizeSanPham other = (SizeSanPham) object;
        if ((this.maSize == null && other.maSize != null) || (this.maSize != null && !this.maSize.equals(other.maSize))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SizeSanPham[ maSize=" + maSize + " ]";
    }
    
}
