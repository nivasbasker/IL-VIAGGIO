package com.zio.il_viaggio.datamodels;

import static java.lang.Integer.min;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Each tour package object has a unique name, a positive passenger capacity, an itinerary (list of destinations) and a list of it's passenger.
 * Passengers can be added to the TourPackage's passengerList only via methods of Passenger Class.
 */
public class TourPackage {
    private final String packageName;
    private final int passengerCapacity;
    private final List<Destination> itinerary;
    private List<Passenger> passengerList;

    /**
     * Constructor, creates a new package with empty passengerList
     *
     * @param packageName       Non empty, Unique string
     * @param passengerCapacity positive int
     * @param itinerary         Non empty list of Destinations
     */
    public TourPackage(String packageName, int passengerCapacity, List<Destination> itinerary) {
        this.packageName = packageName;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = itinerary;
        this.passengerList = new ArrayList<>();
    }

    /**
     * Intended to be used only by passenger Class, use only if necessary after checking with canAddPassenger method
     *
     * @param passenger Non Null
     * @see TourPackage
     * @see Passenger
     */
    void addPassenger(Passenger passenger) {
        passengerList.add(passenger);

    }

    /**
     * Use this method to check weather a particular passenger can be added to this package.
     *
     * @param passenger Non null
     * @return true, only if, there is space left and the passenger is not already enrolled.
     */
    public boolean canAddPassenger(Passenger passenger) {
        return getRemainingCapacity() > 0 && !passengerList.contains(passenger);
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
        return Collections.unmodifiableList(new ArrayList<>(itinerary));
    }

    public List<Passenger> getPassengerList() {
        return Collections.unmodifiableList(new ArrayList<>(passengerList));
    }

    public int getTotalDestinations() {
        return itinerary.size();
    }

    /**
     * Print itinerary of the travel package including:
     * - Travel package name
     * - Destinations and details of the activities available at each destination
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + packageName);

        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getDestinationName());

            for (Activity activity : destination.getAvailableActivities()) {
                System.out.println("  Activity: " + activity.getActivityName());
                System.out.println("    Cost: Rs" + activity.getCost());
                System.out.println("    Capacity: " + activity.getCapacity());
                System.out.println("    Description: " + activity.getDescription());
            }
        }
    }

    /**
     * Print the passenger list of the travel package including:
     * - Package name
     * - Passenger capacity
     * - Number of passengers currently enrolled
     * - Name and number of each passenger
     */
    public void printPassengerList() {
        System.out.println("Travel Package: " + packageName);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengerList.size());

        System.out.println("Passenger List:");
        for (Passenger passenger : passengerList) {
            System.out.println("  Name: " + passenger.getPassengerName());
            System.out.println("  Number: " + passenger.getPassengerNumber());
        }
    }


}
