package com.zio.il_viaggio.datamodels;

public class StandardPassenger extends Passenger {

    public StandardPassenger(String passengerName, double passengerNumber, double currentBalance) {
        super(passengerName, passengerNumber, currentBalance, PassengerType.STANDARD);
    }

    @Override
    public void enrollInActivity(Activity activity) {
        super.enrollInActivity(activity);

        double cost = activity.getCost() * 0.9;
        if (currentBalance < cost)
            throw new IllegalArgumentException("Insufficient balance to enroll in the activity");

        currentBalance -= cost;
        activity.addPassenger(this);
    }
}
