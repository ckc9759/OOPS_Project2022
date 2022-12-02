package Actors;

public class Driver extends User{
    private String vehicle;
    private boolean available;
    public Driver(String name, String id, long PhoneNumber,String vehicle,boolean available){
        super(name, id, PhoneNumber);
        this.vehicle=vehicle;
        this.available=available;
    }
    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

