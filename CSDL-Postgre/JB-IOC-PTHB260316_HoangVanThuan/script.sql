---PHẦN 1: Thao tác với dữ liệu các bảng

---1. Tạo 4 bảng Customer, Room, Booking, Payment
create table Customer(
customer_id	VARCHAR(5) primary key not null ,
customer_full_name	VARCHAR(100) not null ,
customer_email	VARCHAR(100) not null unique,
customer_phone	VARCHAR(15) not null ,
customer_address	VARCHAR(255)
);

create table Room(
room_id	VARCHAR(5) primary key not null ,
room_type	VARCHAR(50) not null ,
room_price	DECIMAL(10, 2) not null,
room_status	VARCHAR(20) not null ,
room_area	INT
);

create table Booking(
booking_id	INT primary key not null ,
customer_id	VARCHAR(5) not null ,
    foreign key (customer_id) references Customer(customer_id),
room_id	VARCHAR(5) not null ,
    foreign key (room_id) references Room(room_id),
check_in_date	DATE not null ,
check_out_date	DATE not null ,
total_amount	DECIMAL(10, 2)
);

create table Payment(
payment_id	INT not null primary key,
booking_id	INT not null ,
    foreign key (booking_id) references Booking(booking_id),
payment_method	VARCHAR(50) not null ,
payment_date	DATE not null ,
payment_amount	DECIMAL(10, 2) not null
);
--2.Thêm dữ liệu vào 4 bảng đã tạo
INSERT INTO customer (customer_id, customer_full_name, customer_email, customer_phone, customer_address) VALUES
                                                                                                              ('C001', 'Nguyen Anh Tu', 'tu.nguyen@example.com', '0912345678', 'Hanoi, Vietnam'),
                                                                                                              ('C002', 'Tran Thi Mai', 'mai.tran@example.com', '0923456789', 'Ho Chi Minh, Vietnam'),
                                                                                                              ('C003', 'Le Minh Hoang', 'hoang.le@example.com', '0934567890', 'Danang, Vietnam'),
                                                                                                              ('C004', 'Pham Hoang Nam', 'nam.pham@example.com', '0945678901', 'Hue, Vietnam'),
                                                                                                              ('C005', 'Vu Minh Thu', 'thu.vu@example.com', '0956789012', 'Hai Phong, Vietnam'),
                                                                                                              ('C006', 'Nguyen Thi Lan', 'lan.nguyen@example.com', '0967890123', 'Quang Ninh, Vietnam'),
                                                                                                              ('C007', 'Bui Minh Tuan', 'tuan.bui@example.com', '0978901234', 'Bac Giang, Vietnam'),
                                                                                                              ('C008', 'Pham Quang Hieu', 'hieu.pham@example.com', '0989012345', 'Quang Nam, Vietnam'),
                                                                                                              ('C009', 'Le Thi Lan', 'lan.le@example.com', '0990123456', 'Da Lat, Vietnam'),
                                                                                                              ('C010', 'Nguyen Thi Mai', 'mai.nguyen@example.com','0901234567','Can Tho, Vietnam');

INSERT INTO room (room_id, room_type, room_price, room_status, room_area) VALUES
                                                                               ('R001', 'Single', 100.0, 'Available', 25),
                                                                               ('R002', 'Double', 150.0, 'Booked', 40),
                                                                               ('R003', 'Suite', 250.0, 'Available', 60),
                                                                               ('R004', 'Single', 120.0, 'Booked', 30),
                                                                               ('R005', 'Double', 160.0, 'Available', 35);

INSERT INTO booking (booking_id, customer_id, room_id, check_in_date, check_out_date, total_amount) VALUES
                                                                                                       (1, 'C001', 'R001', '2025-03-01', '2025-03-05', 400.0),
                                                                                                         (2, 'C002', 'R002', '2025-03-02', '2025-03-06', 600.0),
                                                                                                         (3, 'C003', 'R003', '2025-03-03', '2025-03-07', 1000.0),
                                                                                                         (4, 'C004', 'R004', '2025-03-04', '2025-03-08', 480.0),
                                                                                                         (5, 'C005', 'R005', '2025-03-05', '2025-03-09', 800.0),
                                                                                                         (6, 'C006', 'R001', '2025-03-06', '2025-03-10', 400.0),
                                                                                                         (7, 'C007', 'R002', '2025-03-07', '2025-03-11', 600.0),
                                                                                                         (8, 'C008', 'R003', '2025-03-08', '2025-03-12', 1000.0),
                                                                                                         (9, 'C009', 'R004', '2025-03-09', '2025-03-13', 480.0),
                                                                                                         (10, 'C010', 'R005', '2025-03-10', '2025-03-14', 800.0);

INSERT INTO payment (payment_id, booking_id, payment_method, payment_date, payment_amount) VALUES
                                                                                                (1, 1, 'Cash', '2025-03-05', 400.0),
                                                                                                (2, 2, 'Credit Card', '2025-03-06', 600.0),
                                                                                                (3, 3, 'Bank Transfer', '2025-03-07', 1000.0),
                                                                                                (4, 4, 'Cash', '2025-03-08', 480.0),
                                                                                                (5, 5, 'Credit Card', '2025-03-09', 800.0),
                                                                                                (6, 6, 'Bank Transfer', '2025-03-10', 400.0),
                                                                                                (7, 7, 'Cash', '2025-03-11', 600.0),
                                                                                                (8, 8, 'Credit Card', '2025-03-12', 1000.0),
                                                                                                (9, 9, 'Bank Transfer', '2025-03-13', 480.0),
                                                                                                (10, 10, 'Cash', '2025-03-14', 800.0);

--3.Viết câu lệnh UPDATE để cập nhật lại total_amount...
UPDATE Booking
SET total_amount = r.room_price * (Booking.check_out_date - Booking.check_in_date)
FROM room r
WHERE Booking.room_id = r.room_id
  AND r.room_status = 'Booked'
  AND Booking.check_in_date < CURRENT_DATE;

--4.Viết câu lệnh DELETE để xóa các thanh toán trong bảng Payment nếu: ...
DELETE FROM payment
WHERE
    payment_method = 'Cash'
  AND payment_amount < 500;

---Phan 2 Truy vấn dữ liệu
--5. Lấy thông tin khách hàng
select
c.customer_id as "mã khách hàng",
c.customer_full_name as "họ tên",
c.customer_email as "email",
c.customer_phone as "số điện thoại ",
c.customer_address as "địa chỉ"
from Customer c
order by customer_id asc;

--6.Lấy thông tin các phòng khách sạn
select
    Room.room_id as "mã phòng",
    Room.room_type as "Loại phòng",
    Room.room_area as "Diện tích",
    Room.room_price as "Giá phòng"
from Room
order by room_id desc ;

--7.Lấy thông tin khách hàng và phòng khách sạn đã đặt
select
    C.customer_id as "ma khach hang",
    C.customer_full_name as "Ho ten",
    r.room_id as "ma phong",
    B.check_in_date as "Ngay nhan phong",
    B.check_out_date as "Ngay tra phong"
from Customer C
join Booking B on C.customer_id = B.customer_id
join Room R on R.room_id = B.room_id;

--8.Lấy danh sách khách hàng và tổng tiền đã thanh toán khi đặt phòng
select
    C.customer_id as "mã khách hàng",
    C.customer_full_name as "Họ tên",
    P.payment_method as "phương thức thanh toán",
    P.payment_amount as "số tiền thanh toán"
from Customer C
join Booking B on C.customer_id = B.customer_id
join Payment P on B.booking_id = P.booking_id
order by p.payment_amount desc ;

--9.Lấy thông tin khách hàng từ vị trí thứ 2 đến thứ 4 trong bảng Customer được sắp xếp theo tên khách hàng.
SELECT *
FROM customer
ORDER BY customer_full_name ASC
OFFSET 1 ROWS
    FETCH NEXT 3 ROWS ONLY;


-- Thêm các khách hàng mới để kiểm tra
INSERT INTO customer (customer_id, customer_full_name, customer_email, customer_phone, customer_address) VALUES
                                                                                                              ('C011', 'Trinh Van Quyet', 'quyet.tv@example.com', '0911111111', 'Vinh Phuc, Vietnam'),
                                                                                                              ('C012', 'Do Anh Tuan', 'tuan.da@example.com', '0922222222', 'Ha Noi, Vietnam'),
                                                                                                              ('C013', 'Nguyen Do Lang', 'lang.nd@example.com', '0933333333', 'Phu Tho, Vietnam'),
                                                                                                              ('C014', 'Dao Huu Huyen', 'huyen.dh@example.com', '0944444444', 'Hung Yen, Vietnam');

INSERT INTO room (room_id, room_type, room_price, room_status, room_area) VALUES
    ('R007', 'Budget', 50.0, 'Available', 20);

INSERT INTO booking (booking_id, customer_id, room_id, check_in_date, check_out_date, total_amount) VALUES
                                                                                                         (11, 'C011', 'R003', '2025-04-01', '2025-04-04', 750.0),  -- Phòng Suite giá 250, 3 đêm = 750
                                                                                                         (12, 'C011', 'R005', '2025-04-05', '2025-04-09', 640.0);  -- Phòng Double giá 160, 4 đêm = 640

INSERT INTO payment (payment_id, booking_id, payment_method, payment_date, payment_amount) VALUES
                                                                                                (11, 11, 'Credit Card', '2025-04-04', 750.0),
                                                                                                (12, 12, 'Credit Card', '2025-04-09', 640.0);

--10.Lấy danh sách khách hàng đã đặt ít nhất 2 phòng và có tổng số tiền thanh toán trên 1000
select
    C.customer_id as "Mã khách hàng",
    c.customer_full_name as "Họ tên",
    count(B.customer_id) as "Số phòng đã đặt"
from Customer C
join Booking B on C.customer_id = B.customer_id
JOIN
     payment p ON b.booking_id = p.booking_id
GROUP BY
    c.customer_id, c.customer_full_name
HAVING
    COUNT(DISTINCT b.booking_id) >= 2
   AND SUM(p.payment_amount) > 1000;

--11.Lấy danh sách các phòng có tổng số tiền thanh toán dưới 1000 và có ít nhất 3 khách hàng đặt
select
    R.room_id as "mã phòng",
    R.room_type as "loại phòng",
    R.room_price as "gía phòng",
    P.payment_amount
from Room R
join Booking B on R.room_id = B.room_id
join Payment P on B.booking_id = P.booking_id
group by  r.room_id, r.room_type, p.payment_amount
HAVING
    COUNT(DISTINCT b.booking_id) >= 3
   AND SUM(p.payment_amount) < 1000;

--12.Lấy danh sách các khách hàng có tổng số tiền thanh toán lớn hơn 1000, gồm mã khách hàng
SELECT
    c.customer_id,
    c.customer_full_name,
    b.room_id,
    b.total_amount
FROM
    customer c
        JOIN
    booking b ON c.customer_id = b.customer_id
WHERE
    c.customer_id IN (
        SELECT
            b.customer_id
        FROM
            payment p
                JOIN
            booking b ON p.booking_id = b.booking_id
        GROUP BY
            b.customer_id
        HAVING
            SUM(p.payment_amount) > 1000
    );

--13.Lấy danh sách các khách hàng Mmã KH, Họ tên, Email, SĐT) có họ tên chứa chữ "Minh" hoặc địa chỉ (address) ở "Hanoi". Sắp xếp kết quả theo họ tên tăng dần.
SELECT
    customer_id,
    customer_full_name,
    customer_email,
    customer_phone
FROM
    customer
WHERE
    customer_full_name LIKE '%Minh%'
   OR customer_address LIKE 'Hanoi%'
ORDER BY
    customer_full_name ASC;

--14.Lấy danh sách tất cả các phòng (Mã phòng, Loại phòng, Giá), sắp xếp theo giá phòng giảm dần...
SELECT
    room_id,
    room_type,
    room_price
FROM
    room
ORDER BY
    room_price DESC
OFFSET 5 ROWS
    FETCH NEXT 5 ROWS ONLY;

---PHẦN 3: Tạo View

--15. Hãy tạo một view để lấy thông tin các phòng và khách hàng đã đặt, với điều kiện ngày nhận phòng nhỏ hơn ngày 2025-03-10.
CREATE VIEW v_booking_details AS
SELECT
    r.room_id,
    r.room_type,
    c.customer_id,
    c.customer_full_name,
    b.check_in_date
FROM
    booking b
        JOIN
    room r ON b.room_id = r.room_id
        JOIN
    customer c ON b.customer_id = c.customer_id
WHERE
    b.check_in_date < '2025-03-10';

SELECT * FROM v_booking_details;


--16.Hãy tạo một view để lấy thông tin khách hàng và phòng đã đặt, với điều kiện diện tích phòng lớn hơn 30 m².
CREATE VIEW v_large_room_bookings AS
SELECT
    c.customer_id,
    c.customer_full_name,
    r.room_id,
    r.room_area
FROM
    booking b
        JOIN
    customer c ON b.customer_id = c.customer_id
        JOIN
    room r ON b.room_id = r.room_id
WHERE
    r.room_area > 30;

select *from v_large_room_bookings;

---Phan 4 Tạo Trigger
--17.Hãy tạo một trigger check_insert_booking
CREATE OR REPLACE FUNCTION check_booking_dates_function()
    RETURNS TRIGGER AS $$
BEGIN
    IF NEW.check_in_date > NEW.check_out_date THEN
        RAISE EXCEPTION 'Ngày đặt phòng không thể sau ngày trả phòng được !';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER check_insert_booking
    BEFORE INSERT ON booking
    FOR EACH ROW
EXECUTE FUNCTION check_booking_dates_function();

--18.Hãy tạo một trigger có tên là update_room_status_on_booking
CREATE OR REPLACE FUNCTION update_room_status_function()
    RETURNS TRIGGER AS $$
BEGIN
    UPDATE room
    SET room_status = 'Booked'
    WHERE room_id = NEW.room_id;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_room_status_on_booking
    AFTER INSERT ON booking
    FOR EACH ROW
EXECUTE FUNCTION update_room_status_function();

--PHẦN 5: Tạo Store Procedure
--19.Viết store procedure có tên add_customer

create or replace procedure add_customer(
    p_id varchar(5) ,
    p_name varchar(100),
    p_email	VARCHAR(100) ,
    p_phone	VARCHAR(15) ,
    p_address	VARCHAR(255)
) language plpgsql
as
    $$
    begin
        insert into customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
        values (p_id,
                p_name,
                p_email,
                p_phone,
                p_address);
    end;
    $$;

call add_customer(
               'C016',
               'Tran Van An',
               'an.tran@example.com',
               '0912345670',
               'Nha Trang, Vietnam'
       );

--20 Tạo một Stored Procedure  có tên là add_payment...
CREATE OR REPLACE FUNCTION add_payment(
    p_booking_id INT,
    p_payment_method VARCHAR(50),
    p_payment_amount DECIMAL(10, 2),
    p_payment_date DATE
)
    RETURNS void AS $$
BEGIN
    INSERT INTO payment (
        booking_id,
        payment_method,
        payment_amount,
        payment_date
    )
    VALUES (
               p_booking_id,
               p_payment_method,
               p_payment_amount,
               p_payment_date
           );
END;
$$ LANGUAGE plpgsql;
