package com.zio.il_viaggio.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Each destination has a name, and a list of the activities available at that destination.
 */
public class Destination {

    private final String destinationName;
    private List<Activity> availableActivities;

    public Destination(String destinationName) {
        this.destinationName = destinationName;
        this.availableActivities = new ArrayList<>();
    }

    public boolean addActivity(Activity activity) {
        if (activity.getDestination().equals(this) && !availableActivities.contains(activity)) {
            availableActivities.add(activity);
            return true;
        }
        return false;
    }

    public void setAvailableActivities(List<Activity> availableActivities) {
        this.availableActivities = availableActivities;
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

}
