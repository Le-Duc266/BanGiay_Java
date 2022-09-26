/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.joins;

import entities.SoLuongSanPhamPK;
import javax.persistence.EmbeddedId;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "SoLuongSanPhamJoin")
public class SoLuongSanPhamJoin {

    @EmbeddedId
    protected SoLuongSanPhamPK soLuongSanPhamPK;
    private Integer soLuong;
    private boolean status;
    //thêm
    private String size;

    public SoLuongSanPhamJoin() {
    }

    public SoLuongSanPhamJoin(SoLuongSanPhamPK soLuongSanPhamPK, Integer soLuong, boolean status, String size) {
        this.soLuongSanPhamPK = soLuongSanPhamPK;
        this.soLuong = soLuong;
        this.status = status;
        this.size = size;
    }

    public SoLuongSanPhamPK getSoLuongSanPhamPK() {
        return soLuongSanPhamPK;
    }

    public void setSoLuongSanPhamPK(SoLuongSanPhamPK soLuongSanPhamPK) {
        this.soLuongSanPhamPK = soLuongSanPhamPK;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
