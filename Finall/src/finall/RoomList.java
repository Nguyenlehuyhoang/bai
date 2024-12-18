package finall;

import java.util.ArrayList;

public class RoomList {
    private ArrayList<Room> roomList;  // Danh sách các phòng (Room) sẽ được quản lý trong lớp này

    // Constructor (Hàm khởi tạo)
    public RoomList() {
        this.roomList = new ArrayList<>();  // Khởi tạo danh sách phòng trống
    }

    // Getter
    public ArrayList<Room> getRoomList() {  // Phương thức để lấy danh sách các phòng
        return roomList;
    }

    // Setter
    public void setRoomList(ArrayList<Room> roomList) {  // Phương thức để thay đổi danh sách các phòng
        this.roomList = roomList;
    }

    // 1. Thêm một phòng mới vào danh sách
    public void addRoom(Room room) {
        roomList.add(room);  // Thêm phòng mới vào danh sách
        System.out.println("Room added successfully!");  // Thông báo thêm phòng thành công
    }

    // 2. Cập nhật thông tin phòng theo ID
    public boolean updateRoomById(String id, Room updatedRoom) {
        for (int i = 0; i < roomList.size(); i++) {  // Duyệt qua danh sách phòng
            if (roomList.get(i).getId().equals(id)) {  // Kiểm tra nếu phòng có ID trùng với id cần cập nhật
                roomList.set(i, updatedRoom);  // Cập nhật phòng tại vị trí i với thông tin phòng mới
                System.out.println("Room updated successfully!");  // Thông báo cập nhật thành công
                return true;  // Trả về true nếu cập nhật thành công
            }
        }
        System.out.println("Room with ID " + id + " not found!");  // Thông báo nếu không tìm thấy phòng
        return false;  // Trả về false nếu không tìm thấy phòng
    }

    // 3. Xóa phòng theo ID
    public boolean deleteRoomById(String id) {
        for (Room room : roomList) {  // Duyệt qua tất cả các phòng trong danh sách
            if (room.getId().equals(id)) {  // Kiểm tra nếu phòng có ID trùng với id cần xóa
                roomList.remove(room);  // Xóa phòng khỏi danh sách
                System.out.println("Room deleted successfully!");  // Thông báo xóa phòng thành công
                return true;  // Trả về true nếu xóa thành công
            }
        }
        System.out.println("Room with ID " + id + " not found!");  // Thông báo nếu không tìm thấy phòng
        return false;  // Trả về false nếu không tìm thấy phòng
    }

    // 4. Tìm phòng theo ID
    public Room findRoomById(String id) {
        for (Room room : roomList) {  // Duyệt qua tất cả các phòng trong danh sách
            if (room.getId().equals(id)) {  // Kiểm tra nếu phòng có ID trùng với id cần tìm
                return room;  // Trả về phòng tìm thấy
            }
        }
        System.out.println("Room with ID " + id + " not found!");  // Thông báo nếu không tìm thấy phòng
        return null;  // Trả về null nếu không tìm thấy phòng
    }

    // 5. Hiển thị tất cả các phòng trong danh sách
    public void displayAllRooms() {
        if (roomList.isEmpty()) {  // Kiểm tra nếu danh sách phòng rỗng
            System.out.println("No rooms available.");  // Thông báo không có phòng nào
        } else {
            System.out.println("\n===== Room List =====");  // In tiêu đề danh sách phòng
            for (Room room : roomList) {  // Duyệt qua tất cả các phòng trong danh sách
                room.displayDetails();  // Hiển thị chi tiết thông tin của từng phòng
                System.out.println("---------------------");  // In dấu phân cách giữa các phòng
            }
        }
    }

    // 6. Tìm phòng đắt nhất
    public Room findMostExpensiveRoom() {
        if (roomList.isEmpty()) {  // Kiểm tra nếu danh sách phòng rỗng
            System.out.println("No rooms available.");  // Thông báo không có phòng nào
            return null;  // Trả về null nếu không có phòng nào
        }

        Room mostExpensiveRoom = roomList.get(0);  // Giả định phòng đắt nhất là phòng đầu tiên trong danh sách
        for (Room room : roomList) {  // Duyệt qua tất cả các phòng trong danh sách
            if (room.calculateCost() > mostExpensiveRoom.calculateCost()) {  // Nếu phòng hiện tại đắt hơn phòng đắt nhất đã tìm
                mostExpensiveRoom = room;  // Cập nhật phòng đắt nhất
            }
        }
        return mostExpensiveRoom;  // Trả về phòng đắt nhất
    }

    // 7. Đếm tổng số MeetingRooms và BedRooms
    public void countRooms() {
        int meetingRoomCount = 0;  // Biến đếm số phòng họp
        int bedRoomCount = 0;  // Biến đếm số phòng ngủ

        for (Room room : roomList) {  // Duyệt qua tất cả các phòng trong danh sách
            if (room instanceof MeetingRoom) {  // Kiểm tra nếu phòng là phòng họp
                meetingRoomCount++;  // Tăng biến đếm phòng họp
            } else if (room instanceof BedRoom) {  // Kiểm tra nếu phòng là phòng ngủ
                bedRoomCount++;  // Tăng biến đếm phòng ngủ
            }
        }

        System.out.println("Total number of Meeting Rooms: " + meetingRoomCount);  // In tổng số phòng họp
        System.out.println("Total number of Bedrooms: " + bedRoomCount);  // In tổng số phòng ngủ
    }
}
