package com.zio.il_viaggio.datamodels;

public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String passengerName, double passengerNumber, double currentBalance) {
        super(passengerName, passengerNumber, currentBalance, PassengerType.PREMIUM);
    }

    @Override
    public void enrollInActivity(Activity activity) {
        super.enrollInActivity(activity);
        activity.addPassenger(this);

    }
}
