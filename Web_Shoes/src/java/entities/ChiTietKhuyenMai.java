/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ChiTietKhuyenMai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietKhuyenMai.findAll", query = "SELECT c FROM ChiTietKhuyenMai c"),
    @NamedQuery(name = "ChiTietKhuyenMai.findByMaSanPham", query = "SELECT c FROM ChiTietKhuyenMai c WHERE c.maSanPham = :maSanPham"),
    @NamedQuery(name = "ChiTietKhuyenMai.findByMaKhuyenMai", query = "SELECT c FROM ChiTietKhuyenMai c WHERE c.maKhuyenMai = :maKhuyenMai"),})
public class ChiTietKhuyenMai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaSanPham")
    private int maSanPham;
    @Id

    @Basic(optional = false)
    @NotNull
    @Column(name = "MaKhuyenMai")
    private int maKhuyenMai;

//    @EmbeddedId
//    protected ChiTietKhuyenMaiPk chiTietKhuyenMaiPk;
//
//    public ChiTietKhuyenMai() {
//    }
//
//    public ChiTietKhuyenMai(ChiTietKhuyenMaiPk chiTietKhuyenMaiPk) {
//        this.chiTietKhuyenMaiPk = chiTietKhuyenMaiPk;
//    }
//
//    public ChiTietKhuyenMaiPk getChiTietKhuyenMaiPk() {
//        return chiTietKhuyenMaiPk;
//    }
//
//    public void setChiTietKhuyenMaiPk(ChiTietKhuyenMaiPk chiTietKhuyenMaiPk) {
//        this.chiTietKhuyenMaiPk = chiTietKhuyenMaiPk;
//    }
//
//    
//   
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (chiTietKhuyenMaiPk != null ? chiTietKhuyenMaiPk.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ChiTietKhuyenMai)) {
//            return false;
//        }
//        ChiTietKhuyenMai other = (ChiTietKhuyenMai) object;
//        if ((this.chiTietKhuyenMaiPk == null && other.chiTietKhuyenMaiPk != null) || (this.chiTietKhuyenMaiPk != null && !this.chiTietKhuyenMaiPk.equals(other.chiTietKhuyenMaiPk))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "entities.ChiTietKhuyenMai[ chiTietKhuyenMaiPk=" + chiTietKhuyenMaiPk + " ]";
//    }
    public ChiTietKhuyenMai() {
    }

    public ChiTietKhuyenMai(int maSanPham, int maKhuyenMai) {
        this.maSanPham = maSanPham;
        this.maKhuyenMai = maKhuyenMai;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    @Override
    public String toString() {
        return "ChiTietKhuyenMai{" + "maSanPham=" + maSanPham + ", maKhuyenMai=" + maKhuyenMai + '}';
    }

}
