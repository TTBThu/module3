-- Bước 1: Tạo 4 bảng
CREATE TABLE tblPhim (
    PhimID INT PRIMARY KEY IDENTITY,
    Ten_phim NVARCHAR(30),
    Loai_phim NVARCHAR(25),
    Thoi_gian INT
);

CREATE TABLE tblPhong (
    PhongID INT PRIMARY KEY IDENTITY,
    Ten_phong NVARCHAR(20),
    Trang_thai TINYINT
);

CREATE TABLE tblGhe (
    GheID INT PRIMARY KEY IDENTITY,
    PhongID INT,
    So_ghe VARCHAR(10),
    FOREIGN KEY (PhongID) REFERENCES tblPhong(PhongID)
);

CREATE TABLE tblVe (
    PhimID INT,
    GheID INT,
    Ngay_chieu DATETIME,
    Trang_thai NVARCHAR(20),
    FOREIGN KEY (PhimID) REFERENCES tblPhim(PhimID),
    FOREIGN KEY (GheID) REFERENCES tblGhe(GheID)
);

-- Bước 3: Chèn dữ liệu vào các bảng
INSERT INTO tblPhim (Ten_phim, Loai_phim, Thoi_gian) VALUES
('Em bé Hà Nội', 'Tâm lý', 90),
('Nhiệm vụ bất khả thi', 'Hành động', 100),
('Dị nhân', 'Viễn tưởng', 90),
('Cuốn theo chiều gió', 'Tình cảm', 120);

INSERT INTO tblPhong (Ten_phong, Trang_thai) VALUES
('Phòng chiếu 1', 1),
('Phòng chiếu 2', 1),
('Phòng chiếu 3', 0);

INSERT INTO tblGhe (PhongID, So_ghe) VALUES
(1, 'A3'),
(1, 'B5'),
(2, 'A7'),
(2, 'D1'),
(3, 'T2');

INSERT INTO tblVe (PhimID, GheID, Ngay_chieu, Trang_thai) VALUES
(1, 1, '2008-10-20', 'Đã bán'),
(1, 3, '2008-11-20', 'Đã bán'),
(1, 4, '2008-12-23', 'Đã bán'),
(2, 1, '2009-02-14', 'Đã bán'),
(3, 1, '2009-02-14', 'Đã bán'),
(2, 5, '2009-03-08', 'Chưa bán'),
(2, 3, '2009-03-08', 'Chưa bán');
-- 2. Hiển thị danh sách các phim (sắp xếp theo trường Thoi_gian)
SELECT * FROM tblPhim ORDER BY Thoi_gian;

-- 3. Hiển thị Ten_phim có thời gian chiếu dài nhất
SELECT TOP 1 Ten_phim FROM tblPhim ORDER BY Thoi_gian DESC;

-- 4. Hiển thị Ten_Phim có thời gian chiếu ngắn nhất
SELECT TOP 1 Ten_phim FROM tblPhim ORDER BY Thoi_gian;

-- 5. Hiển thị danh sách So_Ghe bắt đầu bằng chữ ‘A’
SELECT So_ghe FROM tblGhe WHERE So_ghe LIKE 'A%';

-- 6. Sửa cột Trang_thai của bảng tblPhong sang kiểu nvarchar(25)
ALTER TABLE tblPhong ALTER COLUMN Trang_thai NVARCHAR(25);

-- 7. Cập nhật giá trị cột Trang_thai của bảng tblPhong
UPDATE tblPhong
SET Trang_thai = CASE 
                    WHEN Trang_thai = 0 THEN 'Đang sửa'
                    WHEN Trang_thai = 1 THEN 'Đang sử dụng'
                    ELSE 'Unknow'
                 END;

-- 8. Hiển thị danh sách tên phim có độ dài >15 và < 25 ký tự
SELECT Ten_phim FROM tblPhim WHERE LEN(Ten_phim) > 15 AND LEN(Ten_phim) < 25;

-- 9. Hiển thị Ten_Phong và Trang_Thai trong bảng tblPhong trong 1 cột với tiêu đề ‘Trạng thái phòng chiếu’
SELECT Ten_phong, Trang_thai AS 'Trạng thái phòng chiếu' FROM tblPhong;

-- 10. Tạo bảng mới có tên tblRank
CREATE TABLE tblRank (
    STT INT,
    TenPhim NVARCHAR(255),
    Thoi_gian INT
);

-- 11. Cập nhật và hiển thị bảng tblPhim sau khi cập nhật trường Mo_ta
ALTER TABLE tblPhim ADD Mo_ta NVARCHAR(MAX);
UPDATE tblPhim SET Mo_ta = 'Đây là bộ phim thể loại ' + Loai_phim;
SELECT * FROM tblPhim;
UPDATE tblPhim SET Mo_ta = REPLACE(Mo_ta, 'bộ phim', 'film');
SELECT * FROM tblPhim;

-- 12. Xóa tất cả các khóa ngoại trong các bảng
ALTER TABLE tblGhe DROP CONSTRAINT FK_tblGhe_tblPhong;
ALTER TABLE tblVe DROP CONSTRAINT FK_tblVe_tblPhim;
ALTER TABLE tblVe DROP CONSTRAINT FK_tblVe_tblGhe;

-- 13. Xóa dữ liệu ở bảng tblGhe
DELETE FROM tblGhe;

-- 14. Hiển thị ngày giờ hiện tại và ngày giờ hiện tại cộng thêm 5000 phút
SELECT GETDATE() AS 'Ngày giờ hiện tại', DATEADD(MINUTE, 5000, GETDATE()) AS 'Ngày giờ sau khi cộng thêm 5000 phút';
