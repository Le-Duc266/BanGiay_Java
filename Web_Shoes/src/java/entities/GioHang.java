/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import unit.XuLyTien;

/**
 *
 * @author DELL
 */
public class GioHang {

    private Integer maSanPham;
    private String tenSanPham;
    private Integer maSize;
    private String size;
    private Integer maMau;

    private String tenMau;
    private String anh;
    private int giaTien;

    private int soluong;

    public GioHang() {
    }

    public GioHang(Integer maSanPham, String tenSanPham, Integer maSize, String size, Integer maMau, String tenMau, String anh, int giaTien, int soluong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.maSize = maSize;
        this.size = size;
        this.maMau = maMau;
        this.tenMau = tenMau;
        this.anh = anh;
        this.giaTien = giaTien;
        this.soluong = soluong;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
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

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int tinhTongtien() {

        return this.giaTien * soluong;
    }

    public int gia() {

        return this.giaTien;
    }

    public String getTinhTongtien() {
        return XuLyTien.dinhDangTien1(tinhTongtien());
    }

    public String getGiaString() {
        return XuLyTien.dinhDangTien1(gia());
    }

}
