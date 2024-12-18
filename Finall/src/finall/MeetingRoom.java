package finall;

import java.util.Date;

public class MeetingRoom extends Room {  // Lớp MeetingRoom kế thừa từ lớp Room, đại diện cho phòng họp
    private int capacity;  // Sức chứa của phòng họp (số người có thể ngồi trong phòng)

    // Constructor (Hàm khởi tạo)
    public MeetingRoom(String id, String name, double baseCost, Date checkinDate, Date checkoutDate, int capacity) {
        super(id, name, baseCost, checkinDate, checkoutDate);  // Gọi hàm khởi tạo của lớp cha (Room) để khởi tạo các thuộc tính chung
        this.capacity = capacity;  // Khởi tạo sức chứa của phòng họp
    }

    // Getter và Setter cho thuộc tính capacity
    public int getCapacity() {  // Lấy sức chứa của phòng
        return capacity;
    }

    public void setCapacity(int capacity) {  // Cập nhật sức chứa của phòng
        this.capacity = capacity;
    }

    // Override phương thức calculateCost để tính chi phí phòng họp
    @Override
    public double calculateCost() {
        double finalCost = getBaseCost();  // Khởi tạo chi phí ban đầu là chi phí cơ bản của phòng

        // Nếu sức chứa phòng họp lớn hơn 50 người, tăng chi phí cơ bản lên 20%
        if (capacity > 50) {
            finalCost += getBaseCost() * 0.2;  // Tính thêm 20% vào chi phí cơ bản
        }

        // Tổng chi phí là chi phí cơ bản (sau khi điều chỉnh) nhân với số ngày ở lại
        return finalCost * dayStays();
    }

    // Override phương thức displayDetails để hiển thị chi tiết phòng họp
    @Override
    public void displayDetails() {
        System.out.println("Meeting Room Details:");  // Hiển thị thông báo bắt đầu chi tiết phòng họp
        System.out.println("ID: " + getId());  // Hiển thị mã phòng
        System.out.println("Name: " + getName());  // Hiển thị tên phòng
        System.out.println("Base Cost: " + getBaseCost());  // Hiển thị chi phí cơ bản của phòng
        System.out.println("Capacity: " + capacity);  // Hiển thị sức chứa của phòng
        System.out.println("Days Stayed: " + dayStays());  // Hiển thị số ngày khách đã ở lại
        System.out.println("Total Cost: " + calculateCost());  // Hiển thị tổng chi phí đã tính
    }
}
