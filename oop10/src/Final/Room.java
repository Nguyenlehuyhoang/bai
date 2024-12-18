
package Final;

import java.util.Date;

// Abstract class Room implementing IRoom
abstract class Room implements IRoom {
    private String id;
    private String name;
    private double baseCost;
    private Date checkinDate;
    private Date checkoutDate;

    // Constructor
    public Room(String id, String name, double baseCost, Date checkinDate, Date checkoutDate) {
        this.id = id;
        this.name = name;
        this.baseCost = baseCost;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    // Method to calculate days stayed
    public long calculateDayStays() {
        if (checkinDate != null && checkoutDate != null) {
            long difference = checkoutDate.getTime() - checkinDate.getTime();
            return difference / (1000 * 60 * 60 * 24); // Convert milliseconds to days
        }
        return 0;
    }

    // Abstract method
    @Override
    public abstract double calculateCost();
}

