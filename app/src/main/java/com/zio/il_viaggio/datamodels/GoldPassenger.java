package com.zio.il_viaggio.datamodels;

public class GoldPassenger extends Passenger {
    public GoldPassenger(String passengerName, int passengerNumber, double currentBalance) {
        super(passengerName, passengerNumber, currentBalance, PassengerType.GOLD);
    }

    /**
     * @param activity Non Null
     * @return 90% of the cost of activity (GOLD PASSENGER)
     */
    @Override
    public double getCostOfActivity(Activity activity) {
        return 0.9 * activity.getCost();
    }
}
