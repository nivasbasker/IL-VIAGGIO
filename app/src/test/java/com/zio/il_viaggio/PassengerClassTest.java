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
import com.zio.il_viaggio.datamodels.TourPackage;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PassengerClassTest {

    Passenger passenger1 = new GoldPassenger("p1", 987, 45);
    PremiumPassenger passenger2 = new PremiumPassenger("p2", 987, 0);
    StandardPassenger passenger3 = new StandardPassenger("p3", 987, 45);

    Destination destination = new Destination("TestDestination");
    Destination destination2 = new Destination("TestDestination1");
    Activity activity1 = new Activity("TestActivity", destination, "TestDescription", 50.0, 1);
    Activity activity2 = new Activity("TestActivity2", destination, "TestDescription", 54.0, 2);
    Activity activity3 = new Activity("TestActivity3", destination2, "TestDescription", 45.0, 2);
    List<Destination> itinerary = Arrays.asList(destination, destination2);
    TourPackage tourPackage1 = new TourPackage("TestPackage", 3, itinerary);
    TourPackage tourPackage2 = new TourPackage("TestPackage2", 1, Arrays.asList(destination));

    @Test
    public void checkInit() {
        //check for proper init
        assertEquals(passenger1.getType(), Passenger.PassengerType.GOLD);
        assertEquals(passenger2.getType(), Passenger.PassengerType.PREMIUM);
        assertEquals(passenger3.getType(), Passenger.PassengerType.STANDARD);
        assertEquals(0, passenger1.getEnrolledActivities().size());
        assertEquals(45.0, passenger1.getCurrentBalance(), 0.01);
        assertEquals(0, passenger1.getEnrolledActivities().size());
    }
    @Test
    public void enrollPackage() {
        //book package
        assertTrue(passenger1.enrollInTourPackage(tourPackage2));
        //over booking package
        assertFalse(passenger2.enrollInTourPackage(tourPackage2));
        //book more than one package
        assertFalse(passenger1.enrollInTourPackage(tourPackage1));
    }
    @Test
    public void enrollActivity() {
        //enroll activity before package
        try {
            passenger2.enrollInActivity(activity1);
            fail();
        } catch (IllegalArgumentException ignore) {
        }

        //activity out of package
        try {
            passenger1.enrollInActivity(activity3);
            fail();
        } catch (IllegalArgumentException ignore) {
        }

        //over booking activity
        assertTrue(passenger1.enrollInTourPackage(tourPackage2));
        passenger1.enrollInActivity(activity1);
        assertTrue(passenger2.enrollInTourPackage(tourPackage1));
        try {
            passenger2.enrollInActivity(activity1);
            fail();
        } catch (IllegalArgumentException ignore) {
        }
    }

    @Test
    public void checkBalances() {
        assertTrue(passenger1.enrollInTourPackage(tourPackage2));
        passenger1.enrollInActivity(activity1);
        assertTrue(passenger2.enrollInTourPackage(tourPackage1));

        // check balances after enrolling in activities
        assertEquals(0.0, passenger1.getCurrentBalance(), 0.01);
        assertEquals(1, passenger1.getEnrolledActivities().size());
        double bal_before = passenger2.getCurrentBalance();
        passenger2.enrollInActivity(activity2);
        assertEquals(bal_before, passenger2.getCurrentBalance(), 0.01);

        //no balance
        assertTrue(passenger3.enrollInTourPackage(tourPackage1));
        try {
            passenger3.enrollInActivity(activity2);
            fail();
        } catch (IllegalArgumentException ignore) {
        }
    }
}
