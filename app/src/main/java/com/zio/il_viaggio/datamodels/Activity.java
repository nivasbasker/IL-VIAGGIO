package com.zio.il_viaggio.datamodels;

import static java.lang.Integer.min;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Each activity object has a unique name, a optional description, Non-Negative cost and capacity.
 * Each activity is available at one destination only.
 * Once an activity has reached it's capacity no more passengers can sign up for it.
 * Passenger scan be added to the Activity's  passengerList only via methods of Passenger Class
 */
public class Activity {
    private final String activityName;
    private final String description;
    private final double cost;
    private final int capacity;
    private final Destination destination;
    private List<Passenger> passengerList;


    /**
     * Constructor for Activity, Registering this activity in the corresponding destination is done here itself.
     * No need to do it explicitly. An empty passenger List is also initialized.
     *
     * @param activityName Non empty, unique, string
     * @param destination  Non empty, Destination object
     * @param description  optional, string
     * @param cost         Non Negative
     * @param capacity     Non Negative
     */
    public Activity(String activityName, Destination destination, String description, double cost, int capacity) {
        this.activityName = activityName;
        this.destination = destination;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        passengerList = new ArrayList<>();
        destination.addActivity(this);
    }

    /**
     * Use this method to check weather a particular passenger can be added to this activity.
     *
     * @param passenger
     * @return true, only if, there is space left and the passenger is not already enrolled.
     */
    public boolean canAddPassenger(Passenger passenger) {
        return getRemainingCapacity() > 0 && !passengerList.contains(passenger);
    }

    /**
     * Intended to be used only by Passenger Class. use only if necessary after checking with canAddPassenger method
     *
     * @param passenger
     */
    void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
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
