USE [master]
GO
/****** Object:  Database [infomanage]    Script Date: 06/01/2022 10:49:37 ******/
CREATE DATABASE [infomanage] ON  PRIMARY 
( NAME = N'infomanage', FILENAME = N'D:\SQL2008R2\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\infomanage.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'infomanage_log', FILENAME = N'D:\SQL2008R2\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\infomanage_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [infomanage] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [infomanage].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [infomanage] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [infomanage] SET ANSI_NULLS OFF
GO
ALTER DATABASE [infomanage] SET ANSI_PADDING OFF
GO
ALTER DATABASE [infomanage] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [infomanage] SET ARITHABORT OFF
GO
ALTER DATABASE [infomanage] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [infomanage] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [infomanage] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [infomanage] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [infomanage] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [infomanage] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [infomanage] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [infomanage] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [infomanage] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [infomanage] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [infomanage] SET  DISABLE_BROKER
GO
ALTER DATABASE [infomanage] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [infomanage] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [infomanage] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [infomanage] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [infomanage] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [infomanage] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [infomanage] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [infomanage] SET  READ_WRITE
GO
ALTER DATABASE [infomanage] SET RECOVERY FULL
GO
ALTER DATABASE [infomanage] SET  MULTI_USER
GO
ALTER DATABASE [infomanage] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [infomanage] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'infomanage', N'ON'
GO
USE [infomanage]
GO
/****** Object:  Table [dbo].[sc]    Script Date: 06/01/2022 10:49:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sc](
	[serial] [varchar](10) NULL,
	[name] [varchar](20) NULL,
	[credits] [varchar](2) NULL,
	[nature] [varchar](10) NULL,
	[teach] [varchar](10) NULL,
	[grades] [varchar](3) NULL,
	[sno] [varchar](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[sc] ([serial], [name], [credits], [nature], [teach], [grades], [sno]) VALUES (N'0001', N'数据库系统概论', N'3', N'专业必修课', N'周月鹏', NULL, N'20125081024')
/****** Object:  Table [dbo].[move]    Script Date: 06/01/2022 10:49:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[move](
	[nid] [int] IDENTITY(1,1) NOT NULL,
	[oclass] [varchar](20) NULL,
	[oschool] [varchar](20) NULL,
	[ounit] [varchar](20) NULL,
	[nprofess] [varchar](20) NULL,
	[nclass] [varchar](20) NULL,
	[nunit] [varchar](20) NULL,
	[nschool] [varchar](10) NULL,
	[movetype] [varchar](10) NULL,
	[finalstate] [varchar](5) NULL,
	[sno] [varchar](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[move] ON
INSERT [dbo].[move] ([nid], [oclass], [oschool], [ounit], [nprofess], [nclass], [nunit], [nschool], [movetype], [finalstate], [sno]) VALUES (1, N'20大数据01', N'韶关学院', N'信息工程学院', N'数据科学与大数据技术', N'21大数据01', N'信息工程学院', N'韶关学院', N'更换班级', N'待审', N'20125081024')
SET IDENTITY_INSERT [dbo].[move] OFF
/****** Object:  Table [dbo].[award]    Script Date: 06/01/2022 10:49:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[award](
	[year] [varchar](5) NULL,
	[name] [varchar](20) NULL,
	[unit] [varchar](20) NULL,
	[rlevel] [varchar](10) NULL,
	[sno] [varchar](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[award] ([year], [name], [unit], [rlevel], [sno]) VALUES (N'2022', N'第十届泰迪杯', N'数据挖掘挑战赛委员会', N'国家一级', N'20125081024')
/****** Object:  Table [dbo].[user]    Script Date: 06/01/2022 10:49:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user](
	[username] [varchar](20) NOT NULL,
	[password] [varchar](50) NULL,
	[usertype] [varchar](2) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[user] ([username], [password], [usertype]) VALUES (N'114514', N'123456', N'2')
INSERT [dbo].[user] ([username], [password], [usertype]) VALUES (N'20125081024', N'123456', N'1')
INSERT [dbo].[user] ([username], [password], [usertype]) VALUES (N'20129996666', N'12346', N'1')
/****** Object:  Table [dbo].[ts]    Script Date: 06/01/2022 10:49:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ts](
	[class] [varchar](20) NULL,
	[sno] [varchar](20) NULL,
	[sname] [varchar](10) NULL,
	[course] [varchar](20) NULL,
	[tno] [varchar](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[ts] ([class], [sno], [sname], [course], [tno]) VALUES (N'20大数据01', N'20125081024', N'黄廉升', N'数据库概论', N'114514')
/****** Object:  Table [dbo].[stu]    Script Date: 06/01/2022 10:49:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[stu](
	[unit] [varchar](20) NULL,
	[profess] [varchar](20) NULL,
	[lenofschool] [varchar](2) NULL,
	[class] [varchar](20) NULL,
	[number] [varchar](20) NULL,
	[name] [varchar](20) NULL,
	[gender] [varchar](2) NULL,
	[spell] [varchar](25) NULL,
	[birth] [varchar](15) NULL,
	[marry] [varchar](5) NULL,
	[phone] [varchar](15) NULL,
	[layer] [varchar](10) NULL,
	[polistatus] [varchar](10) NULL,
	[native] [varchar](15) NULL,
	[ethnic] [varchar](10) NULL,
	[familynum] [varchar](15) NULL,
	[adress] [varchar](50) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[stu] ([unit], [profess], [lenofschool], [class], [number], [name], [gender], [spell], [birth], [marry], [phone], [layer], [polistatus], [native], [ethnic], [familynum], [adress]) VALUES (N'信息工程学院', N'数据科学与大数据技术', N'4', N'20大数据01', N'20125081024', N'黄廉升', N'男', N'HuangLianSheng', N'20020126', N'否', N'13129096335', N'本科', N'共青团员', N'广东 佛山', N'汉族', N'0757-88771942', NULL)
INSERT [dbo].[stu] ([unit], [profess], [lenofschool], [class], [number], [name], [gender], [spell], [birth], [marry], [phone], [layer], [polistatus], [native], [ethnic], [familynum], [adress]) VALUES (N'英东生物学院', N'食品安全', N'4', N'20食品01', N'20129996666', N'胖大海', N'男', N'PangDaHai', N'20021111', N'否', N'12345678977', N'本科', N'无', N'广东 韶关', N'汉族', N'无', N'科技楼')
/****** Object:  ForeignKey [FK_ts_user]    Script Date: 06/01/2022 10:49:37 ******/
ALTER TABLE [dbo].[ts]  WITH CHECK ADD  CONSTRAINT [FK_ts_user] FOREIGN KEY([tno])
REFERENCES [dbo].[user] ([username])
GO
ALTER TABLE [dbo].[ts] CHECK CONSTRAINT [FK_ts_user]
GO
/****** Object:  ForeignKey [FK_stu_user]    Script Date: 06/01/2022 10:49:37 ******/
ALTER TABLE [dbo].[stu]  WITH CHECK ADD  CONSTRAINT [FK_stu_user] FOREIGN KEY([number])
REFERENCES [dbo].[user] ([username])
GO
ALTER TABLE [dbo].[stu] CHECK CONSTRAINT [FK_stu_user]
GO
