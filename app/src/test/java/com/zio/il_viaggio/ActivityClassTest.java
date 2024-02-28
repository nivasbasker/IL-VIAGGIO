package com.zio.il_viaggio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.zio.il_viaggio.datamodels.Activity;
import com.zio.il_viaggio.datamodels.Destination;
import com.zio.il_viaggio.datamodels.GoldPassenger;
import com.zio.il_viaggio.datamodels.Passenger;
import com.zio.il_viaggio.datamodels.PremiumPassenger;
import com.zio.il_viaggio.datamodels.StandardPassenger;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ActivityClassTest {

    Destination destination = new Destination("TestDestination");
    Activity activity = new Activity("TestActivity", destination, "TestDescription", 50.0, 1);
    GoldPassenger passenger = new GoldPassenger("p1", 987, 45);
    PremiumPassenger passenger3 = new PremiumPassenger("p2", 987, 0);
    StandardPassenger passenger2 = new StandardPassenger("p3", 987, 45);

    @Test
    public void checkInit() {

        //check for proper initialization
        assertEquals(activity.getDestination(), destination);
        assertEquals(1, activity.getCapacity());
        assertEquals(1, activity.getRemainingCapacity());
        assertEquals(50.0, activity.getCost(), 0.001);

    }

    @Test
    public void CanAddFun() {
        //canAddPassenger fun
        assertTrue(activity.canAddPassenger(passenger3));
        assertTrue(activity.canAddPassenger(passenger));
        assertTrue(activity.canAddPassenger(passenger2));
    }

    @Test
    public void setList() {
        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(passenger);
        passengerList.add(passenger2);

        //set longer list than capacity
        try {
            activity.setPassengerList(passengerList);
            fail();
        } catch (IllegalArgumentException e) {
        }

        //passenger list of correct size
        passengerList.remove(0);
        try {
            activity.setPassengerList(passengerList);
        } catch (IllegalArgumentException e) {
            fail();
        }

        //canAddPassenger fun
        assertFalse(activity.canAddPassenger(passenger));

        //capacity updated
        assertEquals(0, activity.getRemainingCapacity());
    }

    @Test
    public void listModify() {
        //unmodifiable list
        List<Passenger> passengerList = activity.getPassengerList();
        try {
            passengerList.add(passenger3);
            fail();
        } catch (UnsupportedOperationException ignored) {

        }
    }
}
