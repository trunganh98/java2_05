CREATE DATABASE bookstore
GO
USE bookstore
GO

CREATE TABLE Customer (
	CustomerID int PRIMARY KEY,
	CustomerName varchar(50),
	Address varchar(100),
	Phone varchar(12),
    Email varchar(50)
	)
Go

CREATE TABLE Book (
	Bookcode varchar(4) PRIMARY KEY,
	Bookname varchar(50),
	Category varchar(20),
	Author varchar(50),
	Publisher varchar(50),
	Status varchar(20),
	Price int
	)


CREATE TABLE Orders (
	IDOrder varchar(4) PRIMARY KEY,
	CustomerID int,
	CONSTRAINT fk_order FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
	Name varchar(30),
	Phone varchar(10)
	)



CREATE TABLE OrderDetail (
	IDOrderDetail varchar(4) PRIMARY KEY,
	IDOrder varchar(4),
	CONSTRAINT fk_orders FOREIGN KEY (IDOrder) REFERENCES Orders(IDOrder),
	CustomerID int,
	CONSTRAINT fk_orderdetail FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
	BookCode varchar(4),
	CONSTRAINT fk FOREIGN KEY (BookCode) REFERENCES Book(BookCode),
	DateTrading datetime,
	Price int,
	Amount int,
	TotalPrice money
	)



CREATE TABLE Admin (
    Username varchar(20),
    Passworld varchar(20),
    Status varchar(10)
	)


INSERT INTO Customer VALUES (001 ,'Nguyen Trung Anh', 'Nam Hong, Dong Anh, Ha Noi', '0981111111', 'trunganh@gmail.com')
INSERT INTO Customer VALUES (002 ,'Pham Quoc Phuong', 'Hai Boi, Dong Anh, Ha Noi', '0982222222', 'phamphuong@gmail.com')
INSERT INTO Customer VALUES (003 ,'Nguyen Tuan Anh', 'Vong La, Dong Anh, Ha Noi', '0983333333', 'tuananh@gmail.com')
INSERT INTO Customer VALUES (004 ,'Tran Dang Hai', 'Minh Phu, Soc Son, Ha Noi', '0984444444', 'danghai@gmail.com')
INSERT INTO Customer VALUES (005 ,'Tran Thi A', 'Quan 4, tp Ho Chi Minh', '0985555555', 'thiB@gmail.com')

INSERT INTO Book VALUES ('AB02',  'Tam quoc dien ngia', 'tieu thuyet', 'La Quan Trung', 'Kim Dong', 'con hang', 20000)
INSERT INTO Book VALUES ('AB03',  'Naruto', 'manga', 'Masashi Kishimoto', 'Kim Dong', 'sap co', 30000)
INSERT INTO Book VALUES ('AB04',  'Onepiece', 'manga', 'Eiichiro Oda', 'Kim Dong', 'sap co', 30000)
INSERT INTO Book VALUES ('AB05',  'Y thien do long ki', 'tieu thuyet', 'Kim Dung', 'Kim Dong', 'con hang', 25000)
INSERT INTO Book VALUES ('AB06',  'Tay du ki', 'tieu thuyet', 'Ngo Thua An', 'Kim Dong', 'con hang', 26000)
INSERT INTO Book VALUES ('AB07',  'Huyen thoai hy lap', 'than thoai', 'Terry Deary', 'Kim Dong', 'con hang', 30000)
INSERT INTO Book VALUES ('AB08',  'Than thoai bac Au', 'than thoai', 'Shin, Young-Mi', 'Kim Dong', 'con hang', 30000)
INSERT INTO Book VALUES ('AB09',  'Tuoi tho du doi', 'Van hoc', 'Phung Quan', 'Kim Dong', 'con hang', 20000)
INSERT INTO Book VALUES ('AB10',  'So do', 'Van hoc', 'Vu Trong Phung', 'Kim Dong', 'con hang', 220000)
INSERT INTO Book VALUES ('AB11',  'Truyen Kieu', 'Van hoc','Nguyen Du', 'Kim Dong', 'con hang', 23000)
INSERT INTO Book VALUES ('AB12',  'Tat den', 'Van hoc', 'Ngo Tat To', 'Kim Dong', 'con hang', 220000)
INSERT INTO Book VALUES ('AB13',  'Chi Pheo', 'Van hoc', 'Nam Cao', 'Kim Dong', 'con hang', 240000)
INSERT INTO Book VALUES ('AB14',  'Dau pha thuong khung', 'tien hiep', 'Thien Tam Tho Dau', 'Kim Dong', 'con hang', 30000)
INSERT INTO Book VALUES ('AB15',  'Dau la dai luc', 'tien hiep', 'Duong Gia Tam Thieu', 'Kim Dong', 'con hang', 30000)
INSERT INTO Book VALUES ('AB16',  'Tuyet the duong mon', 'tieu thuyet', 'Duong Gia Tam Thieu', 'Kim Dong', 'con hang', 30000)

INSERT INTO Orders VALUES ('C001', 001, 'Nguyen Trung Anh', '0981111111')
INSERT INTO Orders VALUES ('C002', 002, 'Pham Quoc Phuong', '0982222222')
INSERT INTO Orders VALUES ('C003', 003, 'Nguyen Tuan Anh', '0983333333')
INSERT INTO Orders VALUES ('C004', 004, 'Tran Dang Hai', '0984444444')
INSERT INTO Orders VALUES ('C005', 005, 'Tran Thi A', '0985555555')

INSERT INTO OrderDetail VALUES ('D001', 'C001', 001, 'AB03', '11/08/20', 30000, 10, 300000)
INSERT INTO OrderDetail VALUES ('D002', 'C001', 001, 'AB04', '06/05/20', 30000, 5, 150000)
INSERT INTO OrderDetail VALUES ('D003', 'C002', 002, 'AB06', '11/12/20', 26000, 1, 260000)
INSERT INTO OrderDetail VALUES ('D004', 'C003', 003, 'AB08', '10/06/20', 30000, 2, 600000)
INSERT INTO OrderDetail VALUES ('D005', 'C004', 004, 'AB10', '12/11/20', 22000, 4, 880000)

INSERT INTO Admin VALUES ('trunganh', '123456', 'online')
INSERT INTO Admin VALUES ('tuananh', '111111', 'offline')
INSERT INTO Admin VALUES ('danghai', '333333', 'onnile')
