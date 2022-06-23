# TCP_TTN
Cách thức hoạt động của client và server trong hệ thống Trắc nghiệm online
Client:
- Tạo giao diện cho phép nhập username và password của sql
gửi lên server để thực hiện kết nối csdl.
- Nhập thông tin gồm họ tên, mã sinh viên, sdt gửi lên server.
- Sau đó vào làm bài thi, 1 bài thi sẽ có 30 câu, mỗi câu chỉ 30 giây.
- Hiển thị kết quả đã làm bài thi.
Server:
- Nhận thông tin sql từ client và kết nối sql server.
- Nhận thông tin người dùng để lấy câu hỏi gửi về cho client thi.
- Sau khi kết thúc 30 câu hỏi thì sẽ server sẽ tính kết quả của người thi gửi về
cho client.
