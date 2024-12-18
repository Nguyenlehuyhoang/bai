package finall;

import java.util.Date;

public class BedRoom extends Room {  // Lớp BedRoom kế thừa từ lớp Room, đại diện cho phòng ngủ
    private int numberOfBeds;  // Số lượng giường trong phòng ngủ

    // Constructor (Hàm khởi tạo)
    public BedRoom(String id, String name, double baseCost, Date checkinDate, Date checkoutDate, int numberOfBeds) {
        super(id, name, baseCost, checkinDate, checkoutDate);  // Gọi hàm khởi tạo của lớp cha (Room) để khởi tạo các thuộc tính chung
        this.numberOfBeds = numberOfBeds;  // Khởi tạo số lượng giường trong phòng
    }

    // Getter và Setter cho thuộc tính numberOfBeds
    public int getNumberOfBeds() {  // Lấy số lượng giường trong phòng
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {  // Cập nhật số lượng giường trong phòng
        this.numberOfBeds = numberOfBeds;
    }

    // Override phương thức calculateCost để tính chi phí phòng ngủ
    @Override
    public double calculateCost() {
        double finalCost = getBaseCost();  // Lấy chi phí cơ bản của phòng

        // Nếu số giường trong phòng >= 3, tăng chi phí cơ bản lên 10%
        if (numberOfBeds >= 3) {
            finalCost += getBaseCost() * 0.1;  // Tăng 10% vào chi phí cơ bản
        }

        // Tính tổng chi phí là chi phí cơ bản (sau khi điều chỉnh) nhân với số ngày ở lại
        return finalCost * dayStays();
    }

    // Override phương thức displayDetails để hiển thị chi tiết phòng ngủ
    @Override
    public void displayDetails() {
        System.out.println("Bedroom Details:");  // Hiển thị thông báo bắt đầu chi tiết phòng ngủ
        System.out.println("ID: " + getId());  // Hiển thị mã phòng
        System.out.println("Name: " + getName());  // Hiển thị tên phòng
        System.out.println("Base Cost: " + getBaseCost());  // Hiển thị chi phí cơ bản của phòng
        System.out.println("Number of Beds: " + numberOfBeds);  // Hiển thị số lượng giường trong phòng
        System.out.println("Days Stayed: " + dayStays());  // Hiển thị số ngày khách đã ở lại
        System.out.println("Total Cost: " + calculateCost());  // Hiển thị tổng chi phí đã tính
    }
}
