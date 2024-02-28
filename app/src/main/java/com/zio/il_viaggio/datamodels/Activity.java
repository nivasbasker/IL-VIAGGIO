package com.zio.il_viaggio.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Each activity has a name, a description, a cost and a capacity. Each activity is available at one destination only.
 * Once an activity has reached it's capacity no more passengers can sign up for it.
 */
public class Activity {
    private final String activityName;
    private final String description;
    private final double cost;
    private final int capacity;
    private final Destination destination;
    private List<Passenger> passengerList;


    public Activity(String activityName, Destination destination, String description, double cost, int capacity) {
        this.activityName = activityName;
        this.destination = destination;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        passengerList = new ArrayList<>();

        destination.addActivity(this);
    }

    public boolean canAddPassenger(Passenger passenger) {
        return getRemainingCapacity() > 0 && !passengerList.contains(passenger);
    }

    void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
    }

    public void setPassengerList(List<Passenger> passengerList) {
        if (passengerList.size() <= getRemainingCapacity())
            this.passengerList = passengerList;
        else
            throw new IllegalArgumentException("Provided passenger list exceeds the remaining capacity");
    }

    public List<Passenger> getPassengerList() {
        return Collections.unmodifiableList(new ArrayList<>(passengerList));
    }

    public int getRemainingCapacity() {
        return (this.capacity - this.passengerList.size());
    }

    public Destination getDestination() {
        return destination;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Activity activity = (Activity) obj;
        return Objects.equals(activityName, activity.getActivityName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityName);
    }
}
