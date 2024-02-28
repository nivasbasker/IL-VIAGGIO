package com.zio.il_viaggio.datamodels;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Each passenger has a name and a passenger number.
 * A passenger can be a standard, gold or premium passenger.
 */
public abstract class Passenger {

    public enum PassengerType {
        STANDARD, GOLD, PREMIUM
    }

    protected final String passengerName;
    protected final double passengerNumber;
    protected final PassengerType type;
    protected double currentBalance;
    protected TourPackage enrolledTourPackage;

    public Passenger(String passengerName, double passengerNumber, double currentBalance, PassengerType type) {
        this.passengerName = passengerName;
        this.passengerNumber = passengerNumber;
        this.currentBalance = currentBalance;
        this.type = type;
        enrolledTourPackage = null;
    }

    public boolean enrollInTourPackage(TourPackage tourPackage) {
        if (enrolledTourPackage == null && tourPackage.canAddPassenger(this)) {
            this.enrolledTourPackage = tourPackage;
            tourPackage.addPassenger(this);
            return true;
        }
        return false;
    }

    public void enrollInActivity(Activity activity) throws IllegalArgumentException {
        if (this.enrolledTourPackage == null)
            throw new IllegalArgumentException("Passenger is not enrolled in any tour package");

        if (!this.enrolledTourPackage.getItinerary().contains(activity.getDestination()))
            throw new IllegalArgumentException("Activity is not part of the enrolled tour package itinerary");

        if (!activity.canAddPassenger(this))
            throw new IllegalArgumentException("Unable to enroll in the activity. No seat left or already enrolled.");
    }

    void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public PassengerType getType() {
        return type;
    }

    public TourPackage getEnrolledTourPackage() {
        return enrolledTourPackage;
    }

    public List<Activity> getEnrolledActivities() {
        if (enrolledTourPackage == null) return new ArrayList<>();

        List<Activity> enrolledActivities = new ArrayList<>();
        for (Destination destination : enrolledTourPackage.getItinerary())
            for (Activity activity : destination.getAvailableActivities()) {
                if (activity.getPassengerList().contains(this))
                    enrolledActivities.add(activity);
            }

        return enrolledActivities;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Passenger passenger = (Passenger) obj;
        return Objects.equals(passengerName, passenger.getPassengerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerName);
    }

}

