
CREATE DATABASE [KIEMTRALTM]
GO
USE [KIEMTRALTM]
GO
/****** Object:  Table [dbo].[BANGDIEM]    Script Date: 7/23/2021 11:08:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BANGDIEM](
	[MASV] [char](10) NOT NULL,
	[LAN] [smallint] NULL,
	[DIEM] [float] NULL,
	[BAITHI] [ntext] NULL,
 CONSTRAINT [PK_BANGDIEM_1] PRIMARY KEY CLUSTERED 
(
	[MASV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BODE]    Script Date: 7/23/2021 11:08:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BODE](
	[CAUHOI] [int] NOT NULL,
	[TRINHDO] [char](1) NULL,
	[NOIDUNG] [ntext] NULL,
	[A] [ntext] NULL,
	[B] [ntext] NULL,
	[C] [ntext] NULL,
	[D] [ntext] NULL,
	[DAP_AN] [char](1) NULL,
 CONSTRAINT [PK_BODE] PRIMARY KEY CLUSTERED 
(
	[CAUHOI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SINHVIEN]    Script Date: 7/23/2021 11:08:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SINHVIEN](
	[MASV] [char](10) NOT NULL,
	[HOTEN] [nvarchar](50) NULL,
	[SODIENTHOAI] [char](10) NULL,
	[DIEM] [float] NULL,
	[NGAYTHI] [smalldatetime] NULL,
	[LAN] [nchar](10) NULL,
 CONSTRAINT [PK_SINHVIEN] PRIMARY KEY CLUSTERED 
(
	[MASV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (1, N'A', N' Trong lập trình Socket TCP, khi muốn gửi dữ liệu từ Client tới Server thông qua luồng xuất (OutputStream) thì ta sử dụng phương thức làm việc nào', N'send()', N'write()', N'read()', N'receive()', N'B')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (2, N'A', N'Trong lập trình Socket TCP/IP, Server muốn gửi dữ liệu đến Client thì phải sử dụng phương thức nào của luồng xuất (OutputStream) :', N'write()', N'read()', N' send()', N'receive()', N'A')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (3, N'A', N'Trong lập trình Socket TCP, khi muốn nhận dữ liệu từ Client gửi đến Server thông qua luồng nhập (InputStream) thì ta sử dụng phương thức làm việc nào:', N'write()', N'send()', N'read()', N'receive()', N'C')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (4, N'A', N'Trong lập trình Socket TCP/IP. Client muốn nhận dữ liệu được trả về từ Server thì sử dụng phương thức nào của luồng nhập (InputStream):', N'send()', N'write()', N'receive()', N'read()', N'D')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (5, N'A', N' Phương thức nào sau đây không thuộc lớp DatagramSocket', N'send()', N'receive()', N'close()', N'accept', N'D')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (6, N'B', N'Phương thức nào sau đây không thuộc lớp DatagramPacket :', N'getAddress()', N'getHostAddress()', N' getData()', N'getLength()', N'B')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (7, N'B', N'Phương thức nào sau đây không trả về đối tượng thuộc kiểu InetAddress ?', N'getAddress() của DatagramPacket', N'getInetAddress() của Socket', N'accept() của ServerSocket', N'Phương thức getLocalHost()', N'C')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (8, N'B', N'Lớp URL thuộc package nào?', N' java.util', N'java.lang', N'java.net', N'java.io', N'C')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (9, N'B', N'Phương thức khởi tạo của lớp URL có thể phát sinh ngoại lệ nào sau đây?', N'IOException', N'UnknownHostException', N'MalformedURLException', N'SocketException', N'C')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (10, N'B', N'Phương thức getContent() của đối tượng URL có thể có ngoại lệ phát sinh là gì?', N'UnknownHostException', N'IOException', N'SocketException', N'URLException', N'B')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (11, N'C', N'Chọn phát biểu đúng trong các phát biểu sau', N'Một thể hiện của lớp File có thể được dùng để truy cập các tập tin trong thư mục hiện hành', N'Khi một thể hiện của lớp File được tạo ra thì một tập tin tương ứng cũng được tạo ra trên đĩa', N'Các thể hiện của lớp File được dùng để truy cập đến các tập tin và thư mục trên đĩa', N'A va C dung', N'D')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (12, N'C', N'Chọn phát biểu đúng nhất:', N'(1) Lớp Writer có thể được dùng để ghi các ký tự có cách mã hóa khác nhau ra luồng xuất', N'(2) Lớp Writer có thể được dùng để ghi các ký tự Unicode ra luồng xuất', N'(3) Lớp Writer có thể được dùng để ghi giá trị các kiểu dữ liệu cơ sở ra luồng xuất', N'Câu (1) và (2) đúng', N'D')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (13, N'C', N'Chọn phát biểu đúng', N'Các event listeners là các interface qui định các phương thức cần phải cài đặt để xử lý các sự kiện liên quan khi sự kiện đó xảy ra', N'Một event adapter là một cung cấp các cài đặt mặc định cho các event listener tương ứng', N'Lớp WindowAdapter được dùng để xử lý các sự kiện liên quan đến cửa sổ màn hình', N'Tất cả các câu đều đúng', N'D')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (14, N'C', N'Chọn các component có phát sinh action event', N'Button', N'Label', N'Checkbox', N'Windows', N'A')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (15, N'C', N'Chọn phát biểu đúng :', N'(1) Thể hiện của TextField có thể phát sinh ActionEvent', N'(2) Thể hiện của TextArea có thể phát sinh ActionEvent', N'(3) Thể hiện của Button có thể phát sinh ActionEvent', N'Câu (1) và (3) đúng', N'D')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (16, N'A', N' Chọn phát biểu đúng :', N'MouseListener interface định nghĩa các phương thức để xử lý sự kiện nhấn chuột', N'MouseMotionListener interface định nghĩa các phương thức để xử lý sự kiện nhấn chuột', N'MouseClickListener interface định nghĩa các phương thức để xử lý sự kiện nhấn chuột', N'Tất các các câu trên đều đúng', N'A')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (17, N'B', N'Giả sử chúng ta có thể hiện e của bộ lắng nghe sự kiện TextEvent và thể hiện t của lớp TextArea. Cho biết cách để gắn bộ lắng nghe e vào t?', N't.addTextListener(e)', N'e.addTextListener(t)', N'addTextListener(e,t)', N'addTextListener(t,e)', N'A')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (18, N'C', N'Cho một component comp và một container cont có kiểu trình bày là BorderLayout. Cho biết cách để gắn comp vào vị trí đầu của cont.', N'addTop(cont,comp)', N'comp.add("North",cont)', N'cont.addTop(comp)', N'cont.add(comp,BorderLayout.NORTH)', N'D')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (19, N'A', N'Cho một component comp và một container cont có kiểu trình bày là FlowLayout. Cho biết cách để gắn comp vào cont.', N'cont.add(comp)', N'comp.add(cont)', N'cont.addComponent(comp)', N'cont.addAllComponents()', N'A')
INSERT [dbo].[BODE] ([CAUHOI], [TRINHDO], [NOIDUNG], [A], [B], [C], [D], [DAP_AN]) VALUES (20, N'B', N'Chọn phương thức dùng để xác định các trình bày của một khung chứa.', N'startLayout()', N'initLayout()', N' layoutContainer()', N'setLayout()', N'D')


GO
INSERT [dbo].[SINHVIEN] ([MASV], [HOTEN], [SODIENTHOAI], [DIEM], [NGAYTHI], [LAN]) VALUES (N'001       ', N'THO ', N'123     ', NULL, NULL, NULL)
INSERT [dbo].[SINHVIEN] ([MASV], [HOTEN], [SODIENTHOAI], [DIEM], [NGAYTHI], [LAN]) VALUES (N'002       ', N'HA', N'124     ', NULL, NULL, NULL)

GO
ALTER TABLE [dbo].[BANGDIEM]  WITH NOCHECK ADD  CONSTRAINT [FK_BANGDIEM_SINHVIEN1] FOREIGN KEY([MASV])
REFERENCES [dbo].[SINHVIEN] ([MASV])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[BANGDIEM] CHECK CONSTRAINT [FK_BANGDIEM_SINHVIEN1]
GO
ALTER TABLE [dbo].[BANGDIEM]  WITH NOCHECK ADD  CONSTRAINT [CK_DIEM] CHECK  (([DIEM]>=(0) AND [DIEM]<=(10)))
GO
ALTER TABLE [dbo].[BANGDIEM] CHECK CONSTRAINT [CK_DIEM]
GO
ALTER TABLE [dbo].[BANGDIEM]  WITH NOCHECK ADD  CONSTRAINT [CK_LANTHI] CHECK  (([LAN]>=(1) AND [LAN]<=(2)))
GO
ALTER TABLE [dbo].[BANGDIEM] CHECK CONSTRAINT [CK_LANTHI]
GO
ALTER TABLE [dbo].[BODE]  WITH NOCHECK ADD  CONSTRAINT [CK_BODE] CHECK  (([TRINHDO]='A' OR [TRINHDO]='B' OR [TRINHDO]='C'))
GO
ALTER TABLE [dbo].[BODE] CHECK CONSTRAINT [CK_BODE]
GO
ALTER TABLE [dbo].[BODE]  WITH NOCHECK ADD  CONSTRAINT [CK_DAPAN] CHECK  (([DAP_AN]='D' OR ([DAP_AN]='C' OR ([DAP_AN]='B' OR [DAP_AN]='A'))))
GO
ALTER TABLE [dbo].[BODE] CHECK CONSTRAINT [CK_DAPAN]
GO
