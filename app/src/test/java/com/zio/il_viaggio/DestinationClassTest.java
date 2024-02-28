package com.zio.il_viaggio;

import org.junit.Test;

import static org.junit.Assert.*;

import com.zio.il_viaggio.datamodels.Activity;
import com.zio.il_viaggio.datamodels.Destination;
import com.zio.il_viaggio.datamodels.GoldPassenger;
import com.zio.il_viaggio.datamodels.Passenger;
import com.zio.il_viaggio.datamodels.PremiumPassenger;
import com.zio.il_viaggio.datamodels.StandardPassenger;

import java.util.ArrayList;
import java.util.List;

public class DestinationClassTest {

    Destination destination = new Destination("TestDestination");
    Destination destination2 = new Destination("TestDestination1");

    Activity activity1 = new Activity("TestActivity", destination, "TestDescription", 50.0, 1);
    Activity activity2 = new Activity("TestActivity2", destination, "TestDescription", 54.0, 2);
    Activity activity3 = new Activity("TestActivity3", destination2, "TestDescription", 54.0, 2);

    @Test
    public void testDestinationCass() {

        //check for proper initialization
        assertEquals(2, destination.getTotalActivities());
        assertEquals("TestDestination", destination.getDestinationName());

        //duplicate entry
        assertFalse(destination.addActivity(activity1));
        assertEquals(2, destination.getTotalActivities());

        //add activity from another destination
        assertFalse(destination.addActivity(activity3));
    }

}