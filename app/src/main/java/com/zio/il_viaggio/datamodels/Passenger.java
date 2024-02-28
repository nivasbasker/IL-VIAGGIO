package com.zio.il_viaggio.datamodels;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Each passenger object has a unique name and a passenger number.
 * A passenger can be of standard, gold or premium passenger-type only.
 */
public abstract class Passenger {


    public enum PassengerType {
        STANDARD, GOLD, PREMIUM
    }

    protected final String passengerName;
    protected final int passengerNumber;
    protected final PassengerType type;
    protected double currentBalance;
    protected TourPackage enrolledTourPackage;

    /**
     * Constructor of passenger, creates a fresh new passenger without any package enrolled
     *
     * @param passengerName   Non empty, Unique string
     * @param passengerNumber Non empty int
     * @param currentBalance  Non negative
     * @param type            one of the Three PassengerTypes
     */
    public Passenger(String passengerName, int passengerNumber, double currentBalance, PassengerType type) {
        this.passengerName = passengerName;
        this.passengerNumber = passengerNumber;
        this.currentBalance = currentBalance;
        this.type = type;
        enrolledTourPackage = null;
    }

    /**
     * Method to enroll Passenger in the passed TourPackage object, this will also add this passenger to the TourPackage's PassengerList.
     * A passenger can enroll in at-max 1 TourPackage.
     *
     * @param tourPackage Non Null
     * @return true, only if, not already enrolled in any package and the tourPackage object has space left to enroll.
     */
    public boolean enrollInTourPackage(TourPackage tourPackage) {
        if (enrolledTourPackage == null && tourPackage.canAddPassenger(this)) {
            this.enrolledTourPackage = tourPackage;
            tourPackage.addPassenger(this);
            return true;
        }
        return false;
    }

    /**
     * Method to enroll a passenger in the passed Activity object.
     *
     * @param activity Non null
     * @throws IllegalArgumentException if<br>
     *                                  1. passenger is not enrolled in any TourPackage<br>
     *                                  2. passenger's enrolled TourPackage doesn't includes passed activity<br>
     *                                  3. passed activity has reached max capacity<br>
     *                                  4. passenger doesn't have sufficient balance<br>
     */
    public void enrollInActivity(Activity activity) throws IllegalArgumentException {
        if (this.enrolledTourPackage == null)
            throw new IllegalArgumentException("Passenger is not enrolled in any tour package");

        if (!this.enrolledTourPackage.getItinerary().contains(activity.getDestination()))
            throw new IllegalArgumentException("Activity is not part of the enrolled tour package itinerary");

        if (!activity.canAddPassenger(this))
            throw new IllegalArgumentException("Unable to enroll in the activity. No seat left or already enrolled.");

        double cost = getCostOfActivity(activity);
        if (currentBalance < cost)
            throw new IllegalArgumentException("Insufficient balance to enroll in the activity");

        currentBalance -= cost;
        activity.addPassenger(this);
    }

    /**
     * Method to calculate minimum balance required to enroll in the passed activity.
     * differs for each type of Passenger. use it to verify affordability.
     *
     * @param activity Non Null
     * @return minimum balance required to enroll in the passed activity
     */
    public double getCostOfActivity(Activity activity) {
        return 0;
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

    public int getPassengerNumber() {
        return passengerNumber;
    }

    /**
     * Method to get a list of Activity's the passenger has enrolled in
     *
     * @return List of EnrolledActivities
     */
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

    /**
     * Print the details of an individual passenger including:
     * - Name
     * - Passenger number
     * - Balance (if applicable)
     * - List of each activity they have signed up for
     * - Destination
     * - Activity name
     * - Price paid for the activity
     */
    public void printDetails() {
        System.out.println("Passenger Details:");
        System.out.println("Name: " + passengerName);
        System.out.println("Passenger Number: " + passengerNumber);
        System.out.println("Balance: Rs" + currentBalance);

        List<Activity> enrolledActivities = getEnrolledActivities();
        if (!enrolledActivities.isEmpty()) {
            System.out.println("Enrolled Activities:");
            for (Activity activity : enrolledActivities) {
                System.out.println("  Destination: " + activity.getDestination().getDestinationName());
                System.out.println("  Activity: " + activity.getActivityName());
                System.out.println("  Price Paid: Rs" + getCostOfActivity(activity));
            }
        } else {
            System.out.println("No Enrolled Activities");
        }
    }

}

