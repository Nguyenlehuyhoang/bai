
package Final;

import java.util.Date;

public abstract class BedRoom extends Room {
    private int numberOfBeds;

    // Constructor
    public BedRoom(String id, String name, double baseCost, Date checkinDate, Date checkoutDate, int numberOfBeds) {
        super(id, name, baseCost, checkinDate, checkoutDate);
        this.numberOfBeds = numberOfBeds;
    }

    // Getter và Setter
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    // Override phương thức calculateCost
    @Override
    public double calculateCost() {
        double cost = getBaseCost();
        if (numberOfBeds >= 3) {
            cost *= 1.1; // Tăng baseCost thêm 10% nếu numberOfBeds >= 3
        }
        return cost * calculateDayStays();
    }

    // Override phương thức displayDetails
    @Override
    public void displayDetails() {
        System.out.println("Bed Room Details:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Base Cost: " + getBaseCost());
        System.out.println("Check-in Date: " + getCheckinDate());
        System.out.println("Check-out Date: " + getCheckoutDate());
        System.out.println("Number of Beds: " + numberOfBeds);
        System.out.println("Total Cost: " + calculateCost());
    }
}

