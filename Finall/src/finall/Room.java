package finall;

import java.util.Date;

public abstract class Room implements IRoom {  // Lớp Room là lớp trừu tượng, triển khai giao diện IRoom
    private String id;  // Mã phòng, định danh duy nhất của phòng
    private String name;  // Tên phòng, ví dụ: "Phòng Deluxe", "Phòng Tiêu chuẩn"
    private double baseCost;  // Chi phí cơ bản của phòng trước khi tính thêm các chi phí khác
    private Date checkinDate;  // Ngày khách check-in (nhận phòng)
    private Date checkoutDate;  // Ngày khách check-out (trả phòng)

    // Constructor (Hàm khởi tạo)
    public Room(String id, String name, double baseCost, Date checkinDate, Date checkoutDate) {  
        this.id = id;  // Khởi tạo mã phòng
        this.name = name;  // Khởi tạo tên phòng
        this.baseCost = baseCost;  // Khởi tạo chi phí cơ bản của phòng
        this.checkinDate = checkinDate;  // Khởi tạo ngày check-in
        this.checkoutDate = checkoutDate;  // Khởi tạo ngày check-out
    }

    // Getters và Setters cho các thuộc tính của lớp
    public String getId() {  // Lấy mã phòng
        return id;
    }

    public void setId(String id) {  // Cập nhật mã phòng
        this.id = id;
    }

    public String getName() {  // Lấy tên phòng
        return name;
    }

    public void setName(String name) {  // Cập nhật tên phòng
        this.name = name;
    }

    public double getBaseCost() {  // Lấy chi phí cơ bản của phòng
        return baseCost;
    }

    public void setBaseCost(double baseCost) {  // Cập nhật chi phí cơ bản của phòng
        this.baseCost = baseCost;
    }

    public Date getCheckinDate() {  // Lấy ngày check-in
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {  // Cập nhật ngày check-in
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {  // Lấy ngày check-out
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {  // Cập nhật ngày check-out
        this.checkoutDate = checkoutDate;
    }

    // Phương thức tính số ngày khách ở lại phòng
    public long dayStays() {  
        long diffInMillis = checkoutDate.getTime() - checkinDate.getTime();  // Tính chênh lệch thời gian giữa check-out và check-in
        return diffInMillis / (1000 * 60 * 60 * 24);  // Chuyển đổi chênh lệch thời gian từ mili giây sang số ngày
    }

    // Các phương thức trừu tượng mà các lớp con phải triển khai
    @Override
    public abstract double calculateCost();  // Tính chi phí của phòng, các lớp con phải cung cấp cách tính chi phí cụ thể

    @Override
    public abstract void displayDetails();  // Hiển thị chi tiết về phòng, các lớp con phải cung cấp cách hiển thị chi tiết cụ thể
}
