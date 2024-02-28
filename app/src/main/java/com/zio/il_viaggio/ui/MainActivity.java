package com.zio.il_viaggio.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zio.il_viaggio.databinding.ActivityMainBinding;
import com.zio.il_viaggio.datamodels.Activity;
import com.zio.il_viaggio.datamodels.Destination;
import com.zio.il_viaggio.datamodels.GoldPassenger;
import com.zio.il_viaggio.datamodels.Passenger;
import com.zio.il_viaggio.datamodels.PremiumPassenger;
import com.zio.il_viaggio.datamodels.StandardPassenger;
import com.zio.il_viaggio.datamodels.TourPackage;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Destination destination1 = new Destination("Destination1");
        Destination destination2 = new Destination("Destination2");
        Destination destination3 = new Destination("Destination3");
        Destination destination4 = new Destination("Destination4");

        Activity activity1 = new Activity("activity1", destination1, "zip lining 100m", 300, 10);
        Activity activity2 = new Activity("activity2", destination1, "rope car 100m", 550, 6);
        Activity activity3 = new Activity("activity3", destination2, "sky diving 30min", 1400, 6);
        Activity activity4 = new Activity("activity4", destination3, "sky diving 30min", 1700, 2);
        Activity activity5 = new Activity("activity5", destination3, "golf ground 1hr", 2000, 4);
        Activity activity6 = new Activity("activity6", destination4, "children games 90min", 200, 2);
        Activity activity7 = new Activity("activity7", destination4, "trek 2.7km", 1500, 5);
        Activity activity8 = new Activity("activity8", destination4, "rope car 4km", 1000, 2);


        TourPackage tourPackage1 = new TourPackage("package1", 3, Arrays.asList(destination1, destination2, destination3));
        TourPackage tourPackage2 = new TourPackage("package2", 5, Arrays.asList(destination2, destination4));

        Passenger passenger1 = new GoldPassenger("p1", 9857, 3210);
        Passenger passenger2 = new GoldPassenger("p2", 9, 3500);
        Passenger passenger3 = new PremiumPassenger("p3", 97, 0);
        Passenger passenger4 = new StandardPassenger("p4", 887, 50);
        Passenger passenger5 = new StandardPassenger("p5", 917, 4500);

        //package 2
        passenger1.enrollInTourPackage(tourPackage2);
        passenger3.enrollInTourPackage(tourPackage2);
        passenger4.enrollInTourPackage(tourPackage2);

        passenger1.enrollInActivity(activity3);
        passenger1.enrollInActivity(activity7);
        passenger1.enrollInActivity(activity6);

        passenger3.enrollInActivity(activity3);
        passenger3.enrollInActivity(activity6);
        passenger3.enrollInActivity(activity7);
        passenger3.enrollInActivity(activity8);

        //package1
        passenger2.enrollInTourPackage(tourPackage1);
        passenger5.enrollInTourPackage(tourPackage1);

        passenger2.enrollInActivity(activity1);
        passenger2.enrollInActivity(activity3);
        passenger2.enrollInActivity(activity5);

        passenger5.enrollInActivity(activity5);
        passenger5.enrollInActivity(activity1);
        passenger5.enrollInActivity(activity4);

        RecyclerView toursView = binding.toursView;
        toursView.setAdapter(new AdapterTour(this, Arrays.asList(tourPackage1, tourPackage2)));

    }

    public void open1(View view) {
        startActivity(new Intent(this, MainActivity2.class));
        finish();
    }
}