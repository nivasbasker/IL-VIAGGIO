package com.zio.il_viaggio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zio.il_viaggio.datamodels.Activity;
import com.zio.il_viaggio.datamodels.Destination;
import com.zio.il_viaggio.datamodels.TourPackage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Destination destination1 = new Destination("Destination1");
        Destination destination2 = new Destination("Destination2");

        Activity activity1 = new Activity("activity1", destination1, "zip lining 100m", 300, 10);
        Activity activity2 = new Activity("activity2", destination1, "rope car 100m", 550, 6);
        Activity activity3 = new Activity("activity3", destination2, "sky diving 30min", 1400, 2);

        destination1.addActivity(activity1);
        destination1.addActivity(activity2);

        destination2.addActivity(activity3);

        List<Destination> destinationList = new ArrayList<>();
        destinationList.add(destination1);
        destinationList.add(destination2);
        TourPackage tourPackage = new TourPackage("package1", 10, destinationList);

    }
}