package com.zio.il_viaggio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.zio.il_viaggio.datamodels.Activity;
import com.zio.il_viaggio.datamodels.Destination;
import com.zio.il_viaggio.datamodels.GoldPassenger;
import com.zio.il_viaggio.datamodels.PremiumPassenger;
import com.zio.il_viaggio.datamodels.StandardPassenger;
import com.zio.il_viaggio.datamodels.TourPackage;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TourPackageTest {

    Destination destination = new Destination("TestDestination");
    Destination destination2 = new Destination("TestDestination1");

    Activity activity1 = new Activity("TestActivity", destination, "TestDescription", 50.0, 1);
    Activity activity2 = new Activity("TestActivity2", destination, "TestDescription", 54.0, 2);
    Activity activity3 = new Activity("TestActivity3", destination2, "TestDescription", 54.0, 2);

    List<Destination> itinerary = Arrays.asList(destination, destination2);
    TourPackage tourPackage = new TourPackage("TestPackage", 3, itinerary);

    GoldPassenger passenger1 = new GoldPassenger("p1", 987, 45);
    PremiumPassenger passenger3 = new PremiumPassenger("p2", 987, 0);
    StandardPassenger passenger2 = new StandardPassenger("p3", 987, 45);

    @Test
    public void checkInit() {

        //check for proper init
        assertEquals("TestPackage", tourPackage.getPackageName());
        assertEquals(2, tourPackage.getTotalDestinations());
        assertEquals(3, tourPackage.getPassengerCapacity());
        assertTrue(tourPackage.getItinerary().contains(destination2));
        assertTrue(tourPackage.getItinerary().contains(destination));

    }

    @Test public void checkAndEnroll(){
        //check possibility for passenger and enroll
        assertTrue(tourPackage.canAddPassenger(passenger1));
        assertTrue(passenger1.enrollInTourPackage(tourPackage));
        assertTrue(tourPackage.getPassengerList().contains(passenger1));

        assertTrue(tourPackage.canAddPassenger(passenger2));
        assertTrue(passenger2.enrollInTourPackage(tourPackage));
        assertTrue(tourPackage.getPassengerList().contains(passenger2));

        //duplicate entry
        assertEquals(1, tourPackage.getRemainingCapacity());
        assertFalse(tourPackage.canAddPassenger(passenger1));
        assertFalse(tourPackage.canAddPassenger(passenger2));
    }

    @Test public void CheckCapacity(){
        assertTrue(passenger1.enrollInTourPackage(tourPackage));
        assertTrue(passenger2.enrollInTourPackage(tourPackage));

        //fill out capacity
        assertTrue(tourPackage.canAddPassenger(passenger3));
        assertTrue(passenger3.enrollInTourPackage(tourPackage));
        assertTrue(tourPackage.getPassengerList().contains(passenger3));

        //check current state after enrollment
        assertEquals(0, tourPackage.getRemainingCapacity());
        assertFalse(tourPackage.canAddPassenger(passenger2));
    }
}
