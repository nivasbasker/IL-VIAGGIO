package com.zio.il_viaggio.datamodels;

public class GoldPassenger extends Passenger {
    public GoldPassenger(String passengerName, double passengerNumber, double currentBalance) {
        super(passengerName, passengerNumber, currentBalance, PassengerType.GOLD);
    }

    public void enrollInActivity(Activity activity) {
        super.enrollInActivity(activity);

        double cost = activity.getCost() * 0.9;
        if (currentBalance < cost)
            throw new IllegalArgumentException("Insufficient balance to enroll in the activity");

        currentBalance -= cost;
        activity.addPassenger(this);

    }
}
