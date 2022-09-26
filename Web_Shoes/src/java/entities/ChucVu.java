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
@Table(name = "ChucVu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChucVu.findAll", query = "SELECT c FROM ChucVu c"),
    @NamedQuery(name = "ChucVu.findByMaChucVu", query = "SELECT c FROM ChucVu c WHERE c.maChucVu = :maChucVu"),
    @NamedQuery(name = "ChucVu.findByTenChucVu", query = "SELECT c FROM ChucVu c WHERE c.tenChucVu = :tenChucVu")})
public class ChucVu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChucVu")
    private Integer maChucVu;
    @Size(max = 50)
    @Column(name = "TenChucVu")
    private String tenChucVu;
    @OneToMany(mappedBy = "maChucVu")
    private Collection<NhanVien> nhanVienCollection;

    public ChucVu() {
    }

    public ChucVu(Integer maChucVu) {
        this.maChucVu = maChucVu;
    }

    public Integer getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(Integer maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    @XmlTransient
    public Collection<NhanVien> getNhanVienCollection() {
        return nhanVienCollection;
    }

    public void setNhanVienCollection(Collection<NhanVien> nhanVienCollection) {
        this.nhanVienCollection = nhanVienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maChucVu != null ? maChucVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChucVu)) {
            return false;
        }
        ChucVu other = (ChucVu) object;
        if ((this.maChucVu == null && other.maChucVu != null) || (this.maChucVu != null && !this.maChucVu.equals(other.maChucVu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ChucVu[ maChucVu=" + maChucVu + " ]";
    }
    
}
