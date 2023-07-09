Create database DuAn1
go
Use DuAn1
go

Create Table VaiTro(
	MaVaiTro UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	TenVaiTro nvarchar(100) not null,
)
go

Create Table NhanVien(
	MaNV nvarchar(50) Primary key,
	HoTen nvarchar(100) not null,
	GioiTinh nvarchar(20),
	SDT varchar(10) not null,
	NgaySinh date not null,
	DiaChi nvarchar(100) not null,
	Email nvarchar(100) not null,
	TinhTrang nvarchar(50),
	MatKhau varchar(Max),
	MaVaiTro UNIQUEIDENTIFIER foreign key references VaiTro(MaVaiTro),
)
go

Create table RAM(
	MaRAM UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	TenRAM nvarchar(100) not null,
	DungLuong varchar(100) not null,
	MoTa nvarchar(100)
)
go

Create table DongSP(
	MaDongSP UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	TenDongSP nvarchar(100) not null,
)
go

Create table NSX(
	MaNSX UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	TenNSX nvarchar(100) not null
)
go

Create table CPU(
	MaCPU UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	TenCPU nvarchar(100) not null,
	MoTa nvarchar(100)
)
go

Create table ManHinh(
	MaManHinh UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	TenManHinh nvarchar(100) not null,
	DoPhanGiai nvarchar(50) not null,
	KichThuoc nvarchar(50) not null,
	MoTa nvarchar(100)
)
go

Create table SanPham(
	MaSP nvarchar(50) PRIMARY KEY,
	TenSP nvarchar(100) not null,
	MauSac nvarchar(30) not null,
	HeDieuHanh nvarchar(30) not null,
	NamBH int not null, 
	TrongLuong decimal(20, 0) not null,
	XuatXu nvarchar(100) not null,
	TrangThai nvarchar(50),
	MoTa nvarchar(100)
)
go

Create table AnhSP(
	MaAnh UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	TenAnh nvarchar(100) not null,	
)
go

Create table KhuyenMai(
	MaKM UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	TenKM nvarchar(100) not null,
	HinhThucGiam nvarchar(50),
	GiamGia nvarchar(50),
	NgayBatDau date,
	NgayKetThuc date,
	TrangThai nvarchar(50),
	MoTa nvarchar(100)
	
)
go

go
Create table ChiTietSP(
	MaSP nvarchar(50) foreign key references SanPham(MaSP),
	MaDongSP UNIQUEIDENTIFIER foreign key references DongSP(MaDongSP),
	MaNSX UNIQUEIDENTIFIER foreign key references NSX(MaNSX),
	MaKM UNIQUEIDENTIFIER foreign key references KhuyenMai(MaKM),
	MaCPU UNIQUEIDENTIFIER foreign key references CPU(MaCPU),
	MaRAM UNIQUEIDENTIFIER foreign key references RAM(MaRAM),
	MaManHinh UNIQUEIDENTIFIER foreign key references ManHinh(MaManHinh),
	MaAnh UNIQUEIDENTIFIER foreign key references AnhSP(MaAnh),
	GiaNhap decimal(20, 0),
	GiaBan decimal(20, 0),
	SoLuong int,
	BarCode Nvarchar(100) not null unique,
	MoTa nvarchar(100),
	primary key(MaSP)
)
go
Create table Serial(
	MaSerial UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	TinhTrang nvarchar(50),
	MaSP nvarchar(50) foreign key references ChiTietSP(MaSP)
)
go
Create table KhachHang(
	MaKH nvarchar(50)primary key,
	TenKH nvarchar(100) not null,
	SDT varchar(12),
	GioiTinh nvarchar(10),
	Email nvarchar(max),
	DiaChi nvarchar(200)
)
go

Create table HoaDon(
	MaHD nvarchar(50) primary key,
	NgayTao date,
	NgayThanhToan date,
	TinhTrang nvarchar(50),
	MaKH nvarchar(50) foreign key references KhachHang(MaKH),
	MaNV nvarchar(50) foreign key references NhanVien(MaNV),
	ThanhTien money
	
)
go

Create table HoaDonChiTiet(
	MaHoaDonCT UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	MaHD nvarchar(50) foreign key references HoaDon(MaHD), 
	MaSP nvarchar(50) foreign key references ChiTietSP(MaSP),
	SoLuong int,
	DonGia decimal(20, 0),
	TienGiamGia decimal(20, 0)
	
)
go
Create table SerialDaBan(
	MaSerial nvarchar(100) PRIMARY KEY ,
	TinhTrang nvarchar(50),
	MaHoaDonCT UNIQUEIDENTIFIER foreign key references HoaDonChiTiet(MaHoaDonCT)
)