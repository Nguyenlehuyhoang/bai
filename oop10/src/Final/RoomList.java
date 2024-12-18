
package Final;

import java.util.ArrayList;

public class RoomList {
    private ArrayList<IRoom> roomList; // Danh sách các phòng

    // Constructor
    public RoomList() {
        this.roomList = new ArrayList<>();
    }

    // Getter và Setter
    public ArrayList<IRoom> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<IRoom> roomList) {
        this.roomList = roomList;
    }

    // 1. Add a new Meeting Room
    public void addMeetingRoom(MeetingRoom room) {
        roomList.add(room);
        System.out.println("Meeting Room added successfully.");
    }

    // 2. Add a new Bedroom
    public void addBedroom(BedRoom room) {
        roomList.add(room);
        System.out.println("Bed Room added successfully.");
    }

    // 3. Update Room by ID
    public void updateRoomById(String id, Room updatedRoom) {
        for (IRoom room : roomList) {
            if (room instanceof Room && ((Room) room).getId().equals(id)) {
                ((Room) room).setName(updatedRoom.getName());
                ((Room) room).setBaseCost(updatedRoom.getBaseCost());
                ((Room) room).setCheckinDate(updatedRoom.getCheckinDate());
                ((Room) room).setCheckoutDate(updatedRoom.getCheckoutDate());
                System.out.println("Room updated successfully.");
                return;
            }
        }
        System.out.println("Room with ID " + id + " not found.");
    }

    // 4. Delete Room by ID
    public void deleteRoomById(String id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i) instanceof Room && ((Room) roomList.get(i)).getId().equals(id)) {
                roomList.remove(i);
                System.out.println("Room deleted successfully.");
                return;
            }
        }
        System.out.println("Room with ID " + id + " not found.");
    }

    // 5. Find Room by ID
    public Room findRoomById(String id) {
        for (IRoom room : roomList) {
            if (room instanceof Room && ((Room) room).getId().equals(id)) {
                return (Room) room;
            }
        }
        System.out.println("Room with ID " + id + " not found.");
        return null;
    }

    // 6. Display all Rooms
    public void displayAllRooms() {
        if (roomList.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        for (IRoom room : roomList) {
            room.displayDetails();
            System.out.println("----------------------------------");
        }
    }

    // 7. Find the most expensive Room
    public Room findMostExpensiveRoom() {
        if (roomList.isEmpty()) {
            System.out.println("No rooms available.");
            return null;
        }

        Room mostExpensiveRoom = null;
        double maxCost = 0.0;

        for (IRoom room : roomList) {
            if (room instanceof Room) {
                double currentCost = room.calculateCost();
                if (currentCost > maxCost) {
                    maxCost = currentCost;
                    mostExpensiveRoom = (Room) room;
                }
            }
        }
        return mostExpensiveRoom;
    }

    // 8. Count the total number of Meeting Rooms and BedRooms separately
    public void countRooms() {
        int meetingRoomCount = 0;
        int bedRoomCount = 0;

        for (IRoom room : roomList) {
            if (room instanceof MeetingRoom) {
                meetingRoomCount++;
            } else if (room instanceof BedRoom) {
                bedRoomCount++;
            }
        }

        System.out.println("Total Meeting Rooms: " + meetingRoomCount);
        System.out.println("Total Bed Rooms: " + bedRoomCount);
    }

    void addRoom(MeetingRoom meetingRoom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void addRoom(BedRoom bedRoom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

