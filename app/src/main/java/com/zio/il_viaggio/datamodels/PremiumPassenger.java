package com.zio.il_viaggio.datamodels;

public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String passengerName, int passengerNumber) {
        super(passengerName, passengerNumber, 0, PassengerType.PREMIUM);
    }
}
