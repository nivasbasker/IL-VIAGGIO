package com.zio.il_viaggio.datamodels;

public class StandardPassenger extends Passenger {

    public StandardPassenger(String passengerName, int passengerNumber, double currentBalance) {
        super(passengerName, passengerNumber, currentBalance, PassengerType.STANDARD);
    }

    @Override
    public double getCostOfActivity(Activity activity) {
        return activity.getCost();
    }
}
