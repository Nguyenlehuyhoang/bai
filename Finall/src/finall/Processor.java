package finall;

import java.util.Date;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        RoomList roomList = new RoomList(); // Tạo đối tượng RoomList để quản lý danh sách phòng
        Scanner scanner = new Scanner(System.in);  // Tạo đối tượng Scanner để nhận dữ liệu từ người dùng

        int choice;
        do {
            // Hiển thị Menu cho người dùng
            System.out.println("\n===== Room Management System =====");
            System.out.println("1. Add a new Meeting Room");  // Thêm phòng họp mới
            System.out.println("2. Add a new Bedroom");  // Thêm phòng ngủ mới
            System.out.println("3. Update Room by ID");  // Cập nhật phòng theo ID
            System.out.println("4. Delete Room by ID");  // Xóa phòng theo ID
            System.out.println("5. Find Room by ID");  // Tìm phòng theo ID
            System.out.println("6. Display all Rooms");  // Hiển thị tất cả các phòng
            System.out.println("7. Find the most expensive Room");  // Tìm phòng đắt nhất
            System.out.println("8. Count the total number of Meeting Rooms and Bedrooms");  // Đếm tổng số phòng họp và phòng ngủ
            System.out.println("0. Exit");  // Thoát khỏi chương trình
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();  // Nhận lựa chọn của người dùng
            scanner.nextLine(); // Làm sạch bộ đệm

            switch (choice) {  // Thực hiện hành động tương ứng với lựa chọn của người dùng
                case 1:
                    addMeetingRoom(roomList, scanner);  // Thêm phòng họp mới
                    break;
                case 2:
                    addBedroom(roomList, scanner);  // Thêm phòng ngủ mới
                    break;
                case 3:
                    updateRoomById(roomList, scanner);  // Cập nhật phòng theo ID
                    break;
                case 4:
                    deleteRoomById(roomList, scanner);  // Xóa phòng theo ID
                    break;
                case 5:
                    findRoomById(roomList, scanner);  // Tìm phòng theo ID
                    break;
                case 6:
                    roomList.displayAllRooms();  // Hiển thị tất cả các phòng trong danh sách
                    break;
                case 7:
                    findMostExpensiveRoom(roomList);  // Tìm phòng đắt nhất
                    break;
                case 8:
                    roomList.countRooms();  // Đếm và hiển thị số lượng phòng họp và phòng ngủ
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");  // Thoát khỏi chương trình
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");  // Thông báo nếu người dùng nhập lựa chọn không hợp lệ
            }
        } while (choice != 0);  // Tiếp tục chương trình cho đến khi người dùng chọn thoát

        scanner.close();  // Đóng đối tượng Scanner sau khi sử dụng
    }

    // Phương thức để thêm phòng họp mới
    private static void addMeetingRoom(RoomList roomList, Scanner scanner) {
        System.out.println("\nEnter Meeting Room Details:");
        System.out.print("ID: ");
        String id = scanner.nextLine();  // Nhập ID phòng
        System.out.print("Name: ");
        String name = scanner.nextLine();  // Nhập tên phòng
        System.out.print("Base Cost: ");
        double baseCost = scanner.nextDouble();  // Nhập chi phí cơ bản
        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();  // Nhập sức chứa của phòng họp
        scanner.nextLine();  // Làm sạch bộ đệm

        // Tạo ngày check-in và check-out giả định
        Date checkInDate = new Date();  // Ngày check-in là ngày hiện tại
        Date checkOutDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 5);  // Ngày check-out là sau 5 ngày

        // Tạo đối tượng MeetingRoom và thêm vào danh sách
        MeetingRoom meetingRoom = new MeetingRoom(id, name, baseCost, checkInDate, checkOutDate, capacity);
        roomList.addRoom(meetingRoom);  // Thêm phòng họp vào danh sách phòng
        System.out.println("Meeting Room added successfully!");  // Thông báo thêm phòng thành công
    }

    // Phương thức để thêm phòng ngủ mới
    private static void addBedroom(RoomList roomList, Scanner scanner) {
        System.out.println("\nEnter Bedroom Details:");
        System.out.print("ID: ");
        String id = scanner.nextLine();  // Nhập ID phòng
        System.out.print("Name: ");
        String name = scanner.nextLine();  // Nhập tên phòng
        System.out.print("Base Cost: ");
        double baseCost = scanner.nextDouble();  // Nhập chi phí cơ bản
        System.out.print("Number of Beds: ");
        int numberOfBeds = scanner.nextInt();  // Nhập số lượng giường trong phòng
        scanner.nextLine();  // Làm sạch bộ đệm

        // Tạo ngày check-in và check-out giả định
        Date checkInDate = new Date();  // Ngày check-in là ngày hiện tại
        Date checkOutDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 3);  // Ngày check-out là sau 3 ngày

        // Tạo đối tượng BedRoom và thêm vào danh sách
        BedRoom bedRoom = new BedRoom(id, name, baseCost, checkInDate, checkOutDate, numberOfBeds);
        roomList.addRoom(bedRoom);  // Thêm phòng ngủ vào danh sách phòng
        System.out.println("Bedroom added successfully!");  // Thông báo thêm phòng thành công
    }

    // Phương thức để cập nhật phòng theo ID
    private static void updateRoomById(RoomList roomList, Scanner scanner) {
        System.out.print("\nEnter the Room ID to update: ");
        String id = scanner.nextLine();  // Nhập ID phòng cần cập nhật

        System.out.println("Enter New Room Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();  // Nhập tên mới của phòng
        System.out.print("Base Cost: ");
        double baseCost = scanner.nextDouble();  // Nhập chi phí cơ bản mới
        scanner.nextLine();  // Làm sạch bộ đệm

        // Tạo ngày check-in và check-out giả định
        Date checkInDate = new Date();
        Date checkOutDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 4);  // Ngày check-out là sau 4 ngày

        // Giả định cập nhật phòng họp mới
        Room updatedRoom = new MeetingRoom(id, name, baseCost, checkInDate, checkOutDate, 50);  // Cập nhật phòng họp
        boolean success = roomList.updateRoomById(id, updatedRoom);  // Cập nhật phòng trong danh sách
        if (success) {
            System.out.println("Room updated successfully!");  // Thông báo cập nhật thành công
        }
    }

    // Phương thức để xóa phòng theo ID
    private static void deleteRoomById(RoomList roomList, Scanner scanner) {
        System.out.print("\nEnter the Room ID to delete: ");
        String id = scanner.nextLine();  // Nhập ID phòng cần xóa

        boolean success = roomList.deleteRoomById(id);  // Xóa phòng theo ID
        if (success) {
            System.out.println("Room deleted successfully!");  // Thông báo xóa phòng thành công
        }
    }

    // Phương thức để tìm phòng theo ID
    private static void findRoomById(RoomList roomList, Scanner scanner) {
        System.out.print("\nEnter the Room ID to find: ");
        String id = scanner.nextLine();  // Nhập ID phòng cần tìm

        Room room = roomList.findRoomById(id);  // Tìm phòng theo ID
        if (room != null) {
            room.displayDetails();  // Hiển thị chi tiết phòng nếu tìm thấy
        }
    }

    // Phương thức để tìm phòng đắt nhất
    private static void findMostExpensiveRoom(RoomList roomList) {
        Room mostExpensiveRoom = roomList.findMostExpensiveRoom();  // Tìm phòng đắt nhất
        if (mostExpensiveRoom != null) {
            System.out.println("\nThe Most Expensive Room:");  // Thông báo phòng đắt nhất
            mostExpensiveRoom.displayDetails();  // Hiển thị chi tiết phòng đắt nhất
        }
    }
}
