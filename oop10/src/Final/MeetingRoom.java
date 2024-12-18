
package Final;

import java.util.Date;

public abstract class MeetingRoom extends Room {
    private int capacity;

    // Constructor
    public MeetingRoom(String id, String name, double baseCost, Date checkinDate, Date checkoutDate, int capacity) {
        super(id, name, baseCost, checkinDate, checkoutDate);
        this.capacity = capacity;
    }

    // Getter và Setter
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Override phương thức calculateCost
    @Override
    public double calculateCost() {
        double cost = getBaseCost();
        if (capacity > 50) {
            cost *= 1.2; // Tăng baseCost thêm 20% nếu capacity > 50
        }
        return cost * calculateDayStays();
    }

    // Override phương thức displayDetails
    @Override
    public void displayDetails() {
        System.out.println("Meeting Room Details:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Base Cost: " + getBaseCost());
        System.out.println("Check-in Date: " + getCheckinDate());
        System.out.println("Check-out Date: " + getCheckoutDate());
        System.out.println("Capacity: " + capacity);
        System.out.println("Total Cost: " + calculateCost());
    }
}

