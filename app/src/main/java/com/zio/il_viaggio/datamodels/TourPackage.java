package com.zio.il_viaggio.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Each travel package has a name, a passenger capacity, an itinerary (list of destinations) and a list of it's passenger.
 */
public class TourPackage {
    private final String packageName;
    private final int passengerCapacity;
    private final List<Destination> itinerary;
    private List<Passenger> passengerList;

    public TourPackage(String packageName, int passengerCapacity, List<Destination> itinerary) {
        this.packageName = packageName;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = itinerary;
        this.passengerList = new ArrayList<>();
    }

    void addPassenger(Passenger passenger) {
        if (canAddPassenger(passenger)) {
            passengerList.add(passenger);

        } else
            throw new IllegalArgumentException("No seat left or Already enrolled");
    }

    public boolean canAddPassenger(Passenger passenger) {
        return getRemainingCapacity() > 0 && !passengerList.contains(passenger);
    }

    void setPassengerList(List<Passenger> passengerList) {
        if (passengerList.size() <= getRemainingCapacity())
            this.passengerList = passengerList;
        else
            throw new IllegalArgumentException("Provided passenger list exceeds the remaining capacity");
    }

    public int getRemainingCapacity() {
        return (passengerCapacity - this.passengerList.size());
    }

    public String getPackageName() {
        return packageName;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public List<Passenger> getPassengerList() {
        return Collections.unmodifiableList(new ArrayList<>(passengerList));
    }

    public int getTotalDestinations() {
        return itinerary.size();
    }
}
