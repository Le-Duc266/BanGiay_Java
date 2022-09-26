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
@Table(name = "AnhSanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnhSanPham.findAll", query = "SELECT a FROM AnhSanPham a"),
    @NamedQuery(name = "AnhSanPham.findByMaAnhSP", query = "SELECT a FROM AnhSanPham a WHERE a.anhSanPhamPK.maAnhSP = :maAnhSP"),
    @NamedQuery(name = "AnhSanPham.findByLinkAnh", query = "SELECT a FROM AnhSanPham a WHERE a.linkAnh = :linkAnh"),
    @NamedQuery(name = "AnhSanPham.findByMaSanPham", query = "SELECT a FROM AnhSanPham a WHERE a.anhSanPhamPK.maSanPham = :maSanPham"),
    @NamedQuery(name = "AnhSanPham.findByMaMau", query = "SELECT a FROM AnhSanPham a WHERE a.anhSanPhamPK.maMau = :maMau")})
public class AnhSanPham implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnhSanPhamPK anhSanPhamPK;
    @Size(max = 200)
    @Column(name = "LinkAnh")
    private String linkAnh;
    @JoinColumns({
        @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham", insertable = false, updatable = false),
        @JoinColumn(name = "MaMau", referencedColumnName = "MaMau", insertable = false, updatable = false)})
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private ChiTietSanPham chiTietSanPham;

    public AnhSanPham() {
    }

    public AnhSanPham(AnhSanPhamPK anhSanPhamPK) {
        this.anhSanPhamPK = anhSanPhamPK;
    }

    public AnhSanPham(int maAnhSP, int maSanPham, int maMau) {
        this.anhSanPhamPK = new AnhSanPhamPK(maAnhSP, maSanPham, maMau);
    }
    

    

    public AnhSanPham(AnhSanPhamPK anhSanPhamPK, String linkAnh) {
        this.anhSanPhamPK = anhSanPhamPK;
        this.linkAnh = linkAnh;
    }

    public AnhSanPhamPK getAnhSanPhamPK() {
        return anhSanPhamPK;
    }

    public void setAnhSanPhamPK(AnhSanPhamPK anhSanPhamPK) {
        this.anhSanPhamPK = anhSanPhamPK;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anhSanPhamPK != null ? anhSanPhamPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnhSanPham)) {
            return false;
        }
        AnhSanPham other = (AnhSanPham) object;
        if ((this.anhSanPhamPK == null && other.anhSanPhamPK != null) || (this.anhSanPhamPK != null && !this.anhSanPhamPK.equals(other.anhSanPhamPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AnhSanPham[ anhSanPhamPK=" + anhSanPhamPK + " ]";
    }
    
}
