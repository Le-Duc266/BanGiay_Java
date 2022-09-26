/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.joins;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "AnhSanPhamJoin")
public class AnhSanPhamJoin implements Serializable {
    @Id
    private int maAnhSP;
    private int maSanPham;
    private int maMau;
    private String linkAnh;

    public AnhSanPhamJoin() {
    }

    public AnhSanPhamJoin(int maAnhSP, int maSanPham, int maMau, String linkAnh) {
        this.maAnhSP = maAnhSP;
        this.maSanPham = maSanPham;
        this.maMau = maMau;
        this.linkAnh = linkAnh;
    }

    public int getMaAnhSP() {
        return maAnhSP;
    }

    public void setMaAnhSP(int maAnhSP) {
        this.maAnhSP = maAnhSP;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }
    
    
}
