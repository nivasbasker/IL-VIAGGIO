package com.zio.il_viaggio.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Each destination object has a unique name, and a list of the activities available at that destination.
 * Activities can be added to the Destination's  ActivityList only via methods of Activity Class
 */
public class Destination {

    private final String destinationName;
    private List<Activity> availableActivities;

    /**
     * Only constructor for Destination.
     *
     * @param destinationName Non empty, unique string
     */
    public Destination(String destinationName) {
        this.destinationName = destinationName;
        this.availableActivities = new ArrayList<>();
    }

    /**
     * Intended to be used only by Activity Class,
     * Usually activities are added to the activitiesList automatically via the constructor of Activity Class
     *
     * @param activity
     * @return true if activity is not created with another destination and activity is not added already
     * @see Activity
     */
    boolean addActivity(Activity activity) {
        if (activity.getDestination().equals(this) && !availableActivities.contains(activity)) {
            availableActivities.add(activity);
            return true;
        }
        return false;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public List<Activity> getAvailableActivities() {
        return Collections.unmodifiableList(new ArrayList<>(availableActivities));
    }

    public int getTotalActivities() {
        return availableActivities.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Destination destination = (Destination) obj;
        return Objects.equals(destinationName, destination.getDestinationName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationName);
    }


    /**
     * Print the details of all the activities that still have spaces available,
     * including how many spaces are available.
     */
    public void printAvailableActivities() {
        System.out.println("Available Activities at " + destinationName + ":");

        for (Activity activity : availableActivities) {
            int remainingCapacity = activity.getRemainingCapacity();

            if (remainingCapacity > 0) {
                System.out.println("  Activity: " + activity.getActivityName());
                System.out.println("    Remaining Capacity: " + remainingCapacity);
                System.out.println("    Cost: Rs" + activity.getCost());
                System.out.println("    Description: " + activity.getDescription());
            }
        }
    }

}
