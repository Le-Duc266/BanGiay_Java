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
 * @author PC
 */
@Entity
@Table(name = "SanPhamJoin")
public class SanPhamJoin  implements Serializable {

    @Id
    private int maSanPham;
    private int maDanhMuc;
    private int maNhanHang;
    private int maGioiTinh;
    private String tenSanPham;
    private String moTa;
     
    private String tenDanhMuc;
    private String tenNhanHang;
    private String tenGioiTinh;

    public SanPhamJoin() {
    }

    public SanPhamJoin(int maSanPham, int maDanhMuc, int maNhanHang, int maGioiTinh, String tenSanPham, String moTa, String tenDanhMuc, String tenNhanHang, String tenGioiTinh) {
        this.maSanPham = maSanPham;
        this.maDanhMuc = maDanhMuc;
        this.maNhanHang = maNhanHang;
        this.maGioiTinh = maGioiTinh;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.tenDanhMuc = tenDanhMuc;
        this.tenNhanHang = tenNhanHang;
        this.tenGioiTinh = tenGioiTinh;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public int getMaNhanHang() {
        return maNhanHang;
    }

    public void setMaNhanHang(int maNhanHang) {
        this.maNhanHang = maNhanHang;
    }

    public int getMaGioiTinh() {
        return maGioiTinh;
    }

    public void setMaGioiTinh(int maGioiTinh) {
        this.maGioiTinh = maGioiTinh;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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
