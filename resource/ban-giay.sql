USE master

-- tao lai DATABASE BanGiay neu da ton tai
IF (EXISTS (SELECT * FROM sys.databases WHERE name = 'BanGiay'))
BEGIN
	DROP DATABASE BanGiay
END

CREATE DATABASE BanGiay
GO

USE BanGiay
GO

CREATE TABLE KhachHang (
	id INT PRIMARY KEY IDENTITY(1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	ten NVARCHAR(1000) NOT NULL,
	gioi_tinh NVARCHAR(10) NOT NULL,
	dia_chi NTEXT NOT NULL,
	ngay_sinh DATE NOT NULL,
	so_dien_htoai VARCHAR(50) NOT NULL,
	trang_thai VARCHAR(100) NOT NULL,
)
GO

INSERT INTO KhachHang (ma, ten, gioi_tinh, dia_chi, ngay_sinh, so_dien_htoai, trang_thai)
VALUES ('kh001', 'Thinh', 'nam', 'Ha Noi', '12-11-2003', '0982072884', 'ON'),
	('kh002', 'Long', 'nam', 'Quang Ninh', '8-11-2003', '0987654321', 'ON')
GO

CREATE TABLE ChucVu (
	id INT PRIMARY KEY IDENTITY(1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	ten NVARCHAR(100) NOT NULL UNIQUE,
)
GO

INSERT INTO ChucVu (ma, ten)
VALUES ('cv001', 'nhan vien'),
	('cv002', 'quan ly')

CREATE TABLE NhanVien (
	id INT PRIMARY KEY IDENTITY(1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	ten NVARCHAR(1000) NOT NULL,
	gioi_tinh NVARCHAR(10) NOT NULL,
	dia_chi NTEXT NOT NULL,
	email VARCHAR(100) NOT NULL,
	ngay_sinh DATE NOT NULL,
	so_dien_thoai VARCHAR(50) NOT NULL,
	mat_khau VARCHAR(100) NOT NULL,
	trang_thai VARCHAR(100) NOT NULL,
	id_chuc_vu INT FOREIGN KEY REFERENCES ChucVu(id)
)
GO

INSERT INTO NhanVien
	(ma, ten, gioi_tinh, email, so_dien_thoai, dia_chi, ngay_sinh, mat_khau, trang_thai, id_chuc_vu)
VALUES ('nv001', 'thinh nguyen', 'Nam', 'thinhntph24396@fpt.edu.vn', '0766344717', 'Ha Noi', '11-25-2003', '?Thinh999', 'dang hoat dong', 1)
-- san pham

CREATE TABLE SanPham (
	id INT PRIMARY KEY IDENTITY (1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	ten NVARCHAR (1000) NOT NULL,
	trang_thai VARCHAR (100) NOT NULL
)
GO

CREATE TABLE Size (
	id INT PRIMARY KEY IDENTITY(1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	ten NVARCHAR (1000) NOT NULL,
	trang_thai VARCHAR(100) NOT NULL
)
GO

CREATE TABLE MauSac (
	id INT PRIMARY KEY IDENTITY(1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	ten NVARCHAR (1000) NOT NULL,
	trang_thai VARCHAR(100) NOT NULL
)
GO

CREATE TABLE ChatLieu (
	id INT PRIMARY KEY IDENTITY(1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	ten NVARCHAR (1000) NOT NULL,
	trang_thai VARCHAR(100) NOT NULL
)
GO

CREATE TABLE NhaSanXuat (
	id INT PRIMARY KEY IDENTITY(1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	ten NVARCHAR (1000) NOT NULL,
	trang_thai VARCHAR(100) NOT NULL
)
GO

CREATE TABLE DongSanPham (
	id INT PRIMARY KEY IDENTITY(1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	ten NVARCHAR (1000) NOT NULL,
	trang_thai VARCHAR(100) NOT NULL
)
GO

CREATE TABLE ChiTietSanPham(
	id INT PRIMARY KEY IDENTITY(1, 1),
	id_SanPham INT FOREIGN KEY REFERENCES SanPham(id),
	id_NhaSanXuat INT FOREIGN KEY REFERENCES NhaSanXuat(id),
	id_MauSac INT FOREIGN KEY REFERENCES MauSac(id),
	id_DongSanPham INT FOREIGN KEY REFERENCES DongSanPham(id),
	id_ChatLiau INT FOREIGN KEY REFERENCES ChatLieu(id),
	id_Size INT FOREIGN KEY REFERENCES SIZE(id),
	mo_ta NTEXT NOT NULL,
	so_luong int NOT NULL,
	gia_nhap MONEY NOT NULL,
	gia_ban MONEY NOT NULL,
	trang_thai VARCHAR(100) NOT NULL
)
GO

-- khuyen mai

CREATE TABLE KhuyenMai (
	id INT PRIMARY KEY IDENTITY (1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	ten NVARCHAR(30) NOT NULL,
	ngay_bat_dau DATE NOT NULL,
	ngay_ket_thuc DATE NOT NULL,
	giam_gia MONEY NOT NULL,
	don_vi BIT NOT NULL,
	mo_ta NVARCHAR(max) NOT NULL,
	trang_thai VARCHAR(100) NOT NULL
)
GO

-- hoa don

CREATE TABLE HoaDon (
	id INT PRIMARY KEY IDENTITY (1, 1),
	ma VARCHAR(100) NOT NULL UNIQUE,
	id_KhachHang INT FOREIGN KEY REFERENCES KhachHang(id),
	id_NhanVien INT FOREIGN KEY REFERENCES NhanVien(id),
	ngay_tao DATE NOT NULL,
	ngay_thanh_toan DATE NOT NULL,
	id_KhuyenMai INT FOREIGN KEY REFERENCES KhuyenMai(id),
	trang_thai VARCHAR(100) NOT NULL
)
GO

CREATE TABLE ChiTietHoaDon (
	id INT PRIMARY KEY IDENTITY(1, 1),
	id_HoaDon INT FOREIGN KEY REFERENCES HoaDon(id),
	id_ChitietSanPham int FOREIGN KEY REFERENCES ChitietSanPham(id),
	so_luong INT NOT NULL,
	gia_san_pham MONEY NOT NULL
)
GO