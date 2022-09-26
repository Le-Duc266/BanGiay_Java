USE master
GO
CREATE DATABASE dbShoesStore;
GO
USE dbShoesStore;
GO
CREATE TABLE ChucVu (
  MaChucVu int IDENTITY,
  TenChucVu nvarchar(50),
  PRIMARY KEY (MaChucVu)
);

CREATE TABLE NhanVien (
  MaNhanVien int IDENTITY,
  HoTen nvarchar(50),
  DiaChi nvarchar(100),
  GioiTinh nvarchar(50),
  Cmnd nvarchar(20),
  SoDT varchar(12),
  MaChucVu int,
  Email varchar(50),
  TenDangNhap varchar(50),
  MatKhau varchar(50),
  PRIMARY KEY (MaNhanVien),
  CONSTRAINT FK_ChucVu FOREIGN KEY (MaChucVu) REFERENCES ChucVu (MaChucVu)

);

CREATE TABLE DanhMucSanPham (
  MaDanhMuc int IDENTITY,
  TenDanhMuc nvarchar(100),
  PRIMARY KEY (MaDanhMuc)

);

CREATE TABLE NhanHang (
  MaNhanHang int IDENTITY,
  TenNhanHang nvarchar(100),
  HinhNhanHang nvarchar(max),
  PRIMARY KEY (MaNhanHang)

);

CREATE TABLE MauSanPham (
  MaMau int IDENTITY,
  TenMau nvarchar(50),
  HexCode varchar(10),
  PRIMARY KEY (MaMau)
);

CREATE TABLE GioiTinh (
  MaGioiTinh int IDENTITY,
  TenGioiTinh nvarchar(50),
  PRIMARY KEY (MaGioiTinh)
);
CREATE TABLE SanPham (
  MaSanPham int not null,
  MaDanhMuc int,
  MaNhanHang int,
  MaGioiTinh int,
  TenSanPham nvarchar(100),
  MoTa nvarchar(max),
  PRIMARY KEY (MaSanPham),
  CONSTRAINT FK_SanPham_DanhMuc FOREIGN KEY (MaDanhMuc) REFERENCES DanhMucSanPham (MaDanhMuc),

  CONSTRAINT FK_GioiTinh FOREIGN KEY (MaGioiTinh) REFERENCES GioiTinh (MaGioiTinh),
  CONSTRAINT FK_SanPham_NhanHang FOREIGN KEY (MaNhanHang) REFERENCES NhanHang (MaNhanHang)
);

CREATE TABLE SizeSanPham (
  MaSize int IDENTITY,
  Size nvarchar(20),
  PRIMARY KEY (MaSize)
);

CREATE TABLE ChiTietSanPham (
  MaSanPham int,
  MaMau int,
  GiaTien float,
  NgayTao nvarchar(50),
  [status] bit not null,
  AnhChinh nvarchar(200),
  PRIMARY KEY (MaSanPham, MaMau),
  CONSTRAINT FK_CHITET_SanPham FOREIGN KEY (MaSanPham) REFERENCES SanPham (MaSanPham),
  CONSTRAINT FK_ChiTiet_Mau FOREIGN KEY (MaMau) REFERENCES MauSanPham (MaMau),
);

CREATE TABLE AnhSanPham (
  MaAnhSP int IDENTITY,
  LinkAnh varchar(200),
  MaSanPham int,
  MaMau int,
  PRIMARY KEY (MaAnhSP, MaSanPham, MaMau),
  CONSTRAINT FK_AnhSP_ChiTietSanPham FOREIGN KEY (MaSanPham, MaMau) REFERENCES ChiTietSanPham (MaSanPham, MaMau)
);

CREATE TABLE SoLuongSanPham (
  MaSize int,
  MaSanPham int,
  MaMau int,
  SoLuong int,
  [status] bit not null,
  PRIMARY KEY (MaSanPham, MaSize, MaMau),
  CONSTRAINT FK_SizeSP FOREIGN KEY (MaSize) REFERENCES SizeSanPham (MaSize),
  CONSTRAINT FK_SoLuong_ChiTietSanPham FOREIGN KEY (MaSanPham, MaMau) REFERENCES ChiTietSanPham (MaSanPham, MaMau)
);

CREATE TABLE KhuyenMai (
  MaKhuyenMai int IDENTITY,
  TenKhuyenMai nvarchar(200),
  ThoiGianBatDau datetime,
  ThoiGianKetThuc datetime,
  MoTa nvarchar(max),
  GiaGiam int,
  status bit,
  kmtheo bit,
  PRIMARY KEY (MaKhuyenMai)
);

CREATE TABLE ChiTietKhuyenMai (
  MaKhuyenMai int,
  MaSanPham int,
  PRIMARY KEY (MaKhuyenMai, MaSanPham),
  CONSTRAINT FK_CTKM FOREIGN KEY (MaSanPham) REFERENCES SanPham (MaSanPham),
  CONSTRAINT FK_CTKM1 FOREIGN KEY (MaKhuyenMai) REFERENCES KhuyenMai (MaKhuyenMai)
);

CREATE TABLE HoaDon (
  MaHoaDon int IDENTITY,
  TenKhachHang nvarchar(100),
  SoDT char(12),
  DiaChiGiaoHang nvarchar(200),
  TinhTrang int,
  NgayLap date,
  tongTien float,
  MaNhanVien int,
  CONSTRAINT FK_NhanVien FOREIGN KEY (MaNhanVien) REFERENCES NhanVien (MaNhanVien),
  PRIMARY KEY (MaHoaDon)
);

CREATE TABLE ChiTietHoaDon (
  MaHoaDon int,
  MaSanPham int,
  MaSize int,
  MaMau int,
  SoLuong int,
  GiaTien float,
  ThanhTien float,
  PRIMARY KEY (MaHoaDon, MaSanPham, MaSize, MaMau),
  CONSTRAINT FK_CTHD FOREIGN KEY (MaHoaDon) REFERENCES HoaDon (MaHoaDon),
  CONSTRAINT FK_ChiTietSanPham_SanPham FOREIGN KEY (MaSanPham, MaSize, MaMau) REFERENCES SoLuongSanPham (MaSanPham, MaSize, MaMau)
);
CREATE TABLE Banner (
  MaBanner int IDENTITY,
  AnhBanner nvarchar(100),
  ViTri int,
  PRIMARY KEY (MaBanner)
);