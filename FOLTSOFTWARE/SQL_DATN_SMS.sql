USE [master]
GO
/****** Object:  Database [DATN]    Script Date: 12/11/2020 2:26:29 PM ******/
CREATE DATABASE [DATN]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DATN', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\DATN.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'DATN_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\DATN_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [DATN] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DATN].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DATN] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DATN] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DATN] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DATN] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DATN] SET ARITHABORT OFF 
GO
ALTER DATABASE [DATN] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [DATN] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DATN] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DATN] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DATN] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DATN] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DATN] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DATN] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DATN] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DATN] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DATN] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DATN] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DATN] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DATN] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DATN] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DATN] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DATN] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DATN] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DATN] SET  MULTI_USER 
GO
ALTER DATABASE [DATN] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DATN] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DATN] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DATN] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [DATN] SET DELAYED_DURABILITY = DISABLED 
GO
USE [DATN]
GO
/****** Object:  Table [dbo].[giaSP]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[giaSP](
	[MaSP] [varchar](50) NOT NULL,
	[ngay] [date] NOT NULL,
	[gia] [float] NULL,
 CONSTRAINT [PK_giaSP] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC,
	[ngay] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[hoaDon]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[hoaDon](
	[MaHDon] [varchar](50) NOT NULL,
	[MaSP] [varchar](50) NULL,
	[tenSP] [nvarchar](255) NULL,
	[soLuong] [nvarchar](50) NULL,
	[gia] [float] NULL,
	[thanhtien] [float] NULL,
	[khachHang] [varchar](255) NULL,
	[soDT] [varchar](11) NULL,
	[Username] [varchar](50) NULL,
 CONSTRAINT [PK__hoaDon__141697F0D0D5D027] PRIMARY KEY CLUSTERED 
(
	[MaHDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[hopDong]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[hopDong](
	[MaHD] [varchar](50) NOT NULL,
	[MaNV] [varchar](50) NULL,
	[loaiHD] [varchar](50) NULL,
	[ngayBD] [date] NULL,
	[ngayKT] [date] NULL,
 CONSTRAINT [PK__hopDong__2725A6E00D1CCF81] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[luong]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[luong](
	[MaLuong] [varchar](50) NOT NULL,
	[MaNV] [varchar](50) NULL,
	[heSoLuong] [float] NULL,
	[luongCoBan] [float] NULL,
	[tongLuong] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[nhaCungCap]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[nhaCungCap](
	[MaNCC] [varchar](50) NOT NULL,
	[tenNCC] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[nhanVien]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[nhanVien](
	[MaNV] [varchar](50) NOT NULL,
	[tenNV] [nvarchar](255) NULL,
	[Username] [varchar](50) NULL,
	[gioiTinh] [bit] NULL,
	[diaChi] [nvarchar](255) NULL,
	[SDT] [varchar](11) NULL,
	[Email] [varchar](255) NULL,
 CONSTRAINT [PK__nhanVien__2725D70A1C5908C3] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[sanPham]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sanPham](
	[MaSP] [varchar](50) NOT NULL,
	[tenSP] [nvarchar](255) NULL,
	[soLuong] [int] NULL,
	[MaNCC] [varchar](50) NULL,
 CONSTRAINT [PK__sanPham__2725081C43812412] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[taiKhoan]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[taiKhoan](
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NULL,
	[Role] [bit] NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK__taiKhoan__536C85E5D66A4ACE] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[giaSP] ([MaSP], [ngay], [gia]) VALUES (N'IP1', CAST(N'2020-10-05' AS Date), 10490000)
INSERT [dbo].[giaSP] ([MaSP], [ngay], [gia]) VALUES (N'IP14', CAST(N'2020-10-22' AS Date), 17990000)
INSERT [dbo].[giaSP] ([MaSP], [ngay], [gia]) VALUES (N'IP2', CAST(N'2020-10-05' AS Date), 13490000)
INSERT [dbo].[giaSP] ([MaSP], [ngay], [gia]) VALUES (N'IP21', CAST(N'2020-10-05' AS Date), 29990000)
INSERT [dbo].[giaSP] ([MaSP], [ngay], [gia]) VALUES (N'IP22', CAST(N'2020-10-05' AS Date), 32590000)
INSERT [dbo].[giaSP] ([MaSP], [ngay], [gia]) VALUES (N'IP3', CAST(N'2020-10-05' AS Date), 10790000)
INSERT [dbo].[giaSP] ([MaSP], [ngay], [gia]) VALUES (N'IP4', CAST(N'2020-10-05' AS Date), 11390000)
INSERT [dbo].[giaSP] ([MaSP], [ngay], [gia]) VALUES (N'IP5', CAST(N'2020-10-05' AS Date), 15490000)
INSERT [dbo].[giaSP] ([MaSP], [ngay], [gia]) VALUES (N'IP6', CAST(N'2020-10-05' AS Date), 15890000)
INSERT [dbo].[giaSP] ([MaSP], [ngay], [gia]) VALUES (N'IP7', CAST(N'2020-10-05' AS Date), 17590000)
INSERT [dbo].[hoaDon] ([MaHDon], [MaSP], [tenSP], [soLuong], [gia], [thanhtien], [khachHang], [soDT], [Username]) VALUES (N'HD01', N'IP4', N'Iphone 8 512gb', N'3', 11390000, 34170000, N'truong', N'0912270963', N'trung3')
INSERT [dbo].[hoaDon] ([MaHDon], [MaSP], [tenSP], [soLuong], [gia], [thanhtien], [khachHang], [soDT], [Username]) VALUES (N'HD02', N'IP21', N'Iphone 12 64gb', N'7', 29990000, 209930000, N'truong', N'0912270963', N'trung3')
INSERT [dbo].[hoaDon] ([MaHDon], [MaSP], [tenSP], [soLuong], [gia], [thanhtien], [khachHang], [soDT], [Username]) VALUES (N'HD03', N'IP6', N'Iphone 8 Plus 512gb', N'10', 15890000, 158900000, N'truong', N'0912270963', N'trung3')
INSERT [dbo].[hopDong] ([MaHD], [MaNV], [loaiHD], [ngayBD], [ngayKT]) VALUES (N'HD01', N'NV01', N'Dai han', CAST(N'2020-02-10' AS Date), CAST(N'2025-02-10' AS Date))
INSERT [dbo].[hopDong] ([MaHD], [MaNV], [loaiHD], [ngayBD], [ngayKT]) VALUES (N'HD02', N'NV02', N'Ngan han', CAST(N'2020-02-10' AS Date), CAST(N'2021-02-10' AS Date))
INSERT [dbo].[hopDong] ([MaHD], [MaNV], [loaiHD], [ngayBD], [ngayKT]) VALUES (N'HD03', N'NV03', N'Ngan han', CAST(N'2020-02-10' AS Date), CAST(N'2021-02-10' AS Date))
INSERT [dbo].[luong] ([MaLuong], [MaNV], [heSoLuong], [luongCoBan], [tongLuong]) VALUES (N'L01', N'NV01', 3, 3000000, 9000000)
INSERT [dbo].[luong] ([MaLuong], [MaNV], [heSoLuong], [luongCoBan], [tongLuong]) VALUES (N'L02', N'NV02', 2, 3000000, 6000000)
INSERT [dbo].[luong] ([MaLuong], [MaNV], [heSoLuong], [luongCoBan], [tongLuong]) VALUES (N'L03', N'NV03', 2, 3000000, 6000000)
INSERT [dbo].[nhaCungCap] ([MaNCC], [tenNCC]) VALUES (N'APE', N'Apple')
INSERT [dbo].[nhaCungCap] ([MaNCC], [tenNCC]) VALUES (N'HHH', N'Huy')
INSERT [dbo].[nhaCungCap] ([MaNCC], [tenNCC]) VALUES (N'HTC', N'HTC')
INSERT [dbo].[nhaCungCap] ([MaNCC], [tenNCC]) VALUES (N'NKA', N'Nokia')
INSERT [dbo].[nhaCungCap] ([MaNCC], [tenNCC]) VALUES (N'OPO', N'Oppo')
INSERT [dbo].[nhaCungCap] ([MaNCC], [tenNCC]) VALUES (N'REM', N'Real Me')
INSERT [dbo].[nhaCungCap] ([MaNCC], [tenNCC]) VALUES (N'SSM', N'SAMSUNG')
INSERT [dbo].[nhaCungCap] ([MaNCC], [tenNCC]) VALUES (N'SXP', N'Sony Xperia')
INSERT [dbo].[nhaCungCap] ([MaNCC], [tenNCC]) VALUES (N'VSM', N'VSmart')
INSERT [dbo].[nhaCungCap] ([MaNCC], [tenNCC]) VALUES (N'XAM', N'Xiao Me')
INSERT [dbo].[nhanVien] ([MaNV], [tenNV], [Username], [gioiTinh], [diaChi], [SDT], [Email]) VALUES (N'NV01', N'Nguyen Phu Trung', N'trung', 1, N'Hau GIang', N'0963456189', N'trung@gmail.com')
INSERT [dbo].[nhanVien] ([MaNV], [tenNV], [Username], [gioiTinh], [diaChi], [SDT], [Email]) VALUES (N'NV02', N'Nguyen Xuan Truong', N'trung2', 1, N'Can Tho', N'0999988877', N'truong@gmail.com')
INSERT [dbo].[nhanVien] ([MaNV], [tenNV], [Username], [gioiTinh], [diaChi], [SDT], [Email]) VALUES (N'NV03', N'huy', N'trung3', 0, N'hhh', N'0909090989', N'hhh@gmail.com')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP1', N'Iphone 8 128gb', 45, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP10', N'Iphone X 512gb', 40, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP11', N'Iphone XS 128gb', 30, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP12', N'Iphone XS 512gb', 40, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP13', N'Iphone XS max 64gb', 70, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP14', N'Iphone XS max 512gb', 120, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP15', N'Iphone 11 64gb', 200, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP16', N'Iphone 11 pro 64gb', 80, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP17', N'Iphone 11 pro max 64gb', 200, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP18', N'Iphone 11 512gb', 200, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP19', N'Iphone pro 512gb', 80, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP2', N'Iphone 8 Plus 128gb', 50, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP20', N'Iphone pro max 512gb', 300, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP21', N'Iphone 12 64gb', 181, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP22', N'Iphone 12 Pro max 128gb', 116, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP3', N'Iphone 8 256gb', 33, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP4', N'Iphone 8 512gb', 42, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP5', N'Iphone 8 Plus 256gb', 40, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP6', N'Iphone 8 Plus 512gb', 238, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP7', N'Iphone X 64gb', 50, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP8', N'Iphone X 128gb', 30, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'IP9', N'Iphone X 256gb', 50, N'APE')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'SS1', N'Samsung Galaxy A51', 50, N'SSM')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'SS2', N'Samsung Note 20 Ultra 5G', 50, N'SSM')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'SS3', N'Samsung Galaxy Note 10', 100, N'SSM')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'SS4', N'Samsung Galaxy S20 Ultra', 200, N'SSM')
INSERT [dbo].[sanPham] ([MaSP], [tenSP], [soLuong], [MaNCC]) VALUES (N'SS5', N'Samsung Galaxy A90 ', 150, N'SSM')
INSERT [dbo].[taiKhoan] ([Username], [Password], [Role], [Status]) VALUES (N'hhh', N'123', 0, 1)
INSERT [dbo].[taiKhoan] ([Username], [Password], [Role], [Status]) VALUES (N'phuc', N'123', 0, 1)
INSERT [dbo].[taiKhoan] ([Username], [Password], [Role], [Status]) VALUES (N'trung', N'123', 1, 1)
INSERT [dbo].[taiKhoan] ([Username], [Password], [Role], [Status]) VALUES (N'trung2', N'123', 0, 0)
INSERT [dbo].[taiKhoan] ([Username], [Password], [Role], [Status]) VALUES (N'trung3', N'123', 0, 1)
INSERT [dbo].[taiKhoan] ([Username], [Password], [Role], [Status]) VALUES (N'trung4', N'123', 0, 0)
ALTER TABLE [dbo].[giaSP]  WITH CHECK ADD  CONSTRAINT [FK_giaSP_sanPham1] FOREIGN KEY([MaSP])
REFERENCES [dbo].[sanPham] ([MaSP])
GO
ALTER TABLE [dbo].[giaSP] CHECK CONSTRAINT [FK_giaSP_sanPham1]
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD  CONSTRAINT [FK__hoaDon__MaSP__1ED998B2] FOREIGN KEY([MaSP])
REFERENCES [dbo].[sanPham] ([MaSP])
GO
ALTER TABLE [dbo].[hoaDon] CHECK CONSTRAINT [FK__hoaDon__MaSP__1ED998B2]
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD  CONSTRAINT [FK__hoaDon__Username__1FCDBCEB] FOREIGN KEY([Username])
REFERENCES [dbo].[taiKhoan] ([Username])
GO
ALTER TABLE [dbo].[hoaDon] CHECK CONSTRAINT [FK__hoaDon__Username__1FCDBCEB]
GO
ALTER TABLE [dbo].[hopDong]  WITH CHECK ADD  CONSTRAINT [FK__hopDong__MaNV__20C1E124] FOREIGN KEY([MaNV])
REFERENCES [dbo].[nhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[hopDong] CHECK CONSTRAINT [FK__hopDong__MaNV__20C1E124]
GO
ALTER TABLE [dbo].[luong]  WITH CHECK ADD  CONSTRAINT [FK__luong__MaNV__21B6055D] FOREIGN KEY([MaNV])
REFERENCES [dbo].[nhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[luong] CHECK CONSTRAINT [FK__luong__MaNV__21B6055D]
GO
ALTER TABLE [dbo].[nhanVien]  WITH CHECK ADD  CONSTRAINT [FK__nhanVien__Userna__22AA2996] FOREIGN KEY([Username])
REFERENCES [dbo].[taiKhoan] ([Username])
GO
ALTER TABLE [dbo].[nhanVien] CHECK CONSTRAINT [FK__nhanVien__Userna__22AA2996]
GO
ALTER TABLE [dbo].[sanPham]  WITH CHECK ADD  CONSTRAINT [FK_sanPham_nhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[nhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[sanPham] CHECK CONSTRAINT [FK_sanPham_nhaCungCap]
GO
/****** Object:  StoredProcedure [dbo].[tk_hoaDon]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[tk_hoaDon] as
begin
select * from hoaDon
end

GO
/****** Object:  StoredProcedure [dbo].[tk_hopDong]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tk_hopDong] as
select h.MaHD, h.loaiHD, h.MaNV, n.tenNV, n.diaChi, n.Email, n.SDT, h.ngayBD, h.ngayKT
		from hopDong h, nhanVien n
		where h.MaNV = n.MaNV
		group by h.MaHD, h.loaiHD, h.MaNV, n.tenNV, n.diaChi, n.Email, n.SDT, h.ngayBD, h.ngayKT


GO
/****** Object:  StoredProcedure [dbo].[tk_nhanVien]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tk_nhanVien] as 
begin
select * from nhanVien nv, luong l, taiKhoan tk
where nv.MaNV = l.MaNV and nv.Username = tk.Username
end;

GO
/****** Object:  StoredProcedure [dbo].[tk_sanPham]    Script Date: 12/11/2020 2:26:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tk_sanPham] as
select s.MaSP, s.tenSP, s.soLuong, g.gia, g.ngay, s.MaNCC, n.tenNCC
		from sanPham s, giaSP g, nhaCungCap n
		where s.MaSP = g.MaSP and s.MaNCC = n.MaNCC
		group by s.MaSP, s.tenSP, s.soLuong, g.gia, g.ngay, s.MaNCC, n.tenNCC


GO
USE [master]
GO
ALTER DATABASE [DATN] SET  READ_WRITE 
GO
