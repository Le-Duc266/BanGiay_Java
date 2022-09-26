/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.joins;

import entities.ChiTietSanPhamPK;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "ChiTietSanPhamJoin")
public class ChiTietSanPhamJoin implements Serializable {

    @EmbeddedId
    protected ChiTietSanPhamPK chiTietSanPhamPK;
    private Double giaTien;
    private String ngayTao;
    private boolean status;
    private String anhChinh;

    private String tenSanPham;
    private String tenMau;
    
    private String tenDanhMuc;
    private String tenNhanHang;
    private String tenGioiTinh;

    public ChiTietSanPhamJoin() {
    }

    public ChiTietSanPhamJoin(ChiTietSanPhamPK chiTietSanPhamPK, Double giaTien, String ngayTao, boolean status, String anhChinh, String tenSanPham, String tenMau) {
        this.chiTietSanPhamPK = chiTietSanPhamPK;
        this.giaTien = giaTien;
        this.ngayTao = ngayTao;
        this.status = status;
        this.anhChinh = anhChinh;
        this.tenSanPham = tenSanPham;
        this.tenMau = tenMau;
    }

    
    
    public ChiTietSanPhamJoin(ChiTietSanPhamPK chiTietSanPhamPK, Double giaTien, String ngayTao, boolean status, String anhChinh, String tenSanPham, String tenMau, String tenDanhMuc, String tenNhanHang, String tenGioiTinh) {
        this.chiTietSanPhamPK = chiTietSanPhamPK;
        this.giaTien = giaTien;
        this.ngayTao = ngayTao;
        this.status = status;
        this.anhChinh = anhChinh;
        this.tenSanPham = tenSanPham;
        this.tenMau = tenMau;
        this.tenDanhMuc = tenDanhMuc;
        this.tenNhanHang = tenNhanHang;
        this.tenGioiTinh = tenGioiTinh;
    }

    

    public ChiTietSanPhamPK getChiTietSanPhamPK() {
        return chiTietSanPhamPK;
    }

    public void setChiTietSanPhamPK(ChiTietSanPhamPK chiTietSanPhamPK) {
        this.chiTietSanPhamPK = chiTietSanPhamPK;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAnhChinh() {
        return anhChinh;
    }

    public void setAnhChinh(String anhChinh) {
        this.anhChinh = anhChinh;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getTenNhanHang() {
        return tenNhanHang;
    }

    public void setTenNhanHang(String tenNhanHang) {
        this.tenNhanHang = tenNhanHang;
    }

    public String getTenGioiTinh() {
        return tenGioiTinh;
    }

    public void setTenGioiTinh(String tenGioiTinh) {
        this.tenGioiTinh = tenGioiTinh;
    }

}
