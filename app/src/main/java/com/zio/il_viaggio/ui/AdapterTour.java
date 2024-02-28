package com.zio.il_viaggio.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zio.il_viaggio.R;
import com.zio.il_viaggio.datamodels.TourPackage;

import java.util.List;

public class AdapterTour extends RecyclerView.Adapter<AdapterTour.ViewHolder> {

    private final Context context;
    private final List<TourPackage> tourPackageList;

    public AdapterTour(Context context, List<TourPackage> tourPackageList1) {
        this.context = context;
        this.tourPackageList = tourPackageList1;
    }

    @NonNull
    @Override
    public AdapterTour.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tour, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTour.ViewHolder holder, int position) {

        TourPackage tourPackage = tourPackageList.get(position);

        holder.name.setText(tourPackage.getPackageName());
        holder.capacity.setText("Capacity : " + tourPackage.getPassengerCapacity());
        holder.enrolled.setText("Passengers Enrolled : " + tourPackage.getPassengerList().size());
        holder.destinationsView.setAdapter(new AdapterDestination(context, tourPackage.getItinerary()));
        holder.passengerView.setAdapter(new AdapterPassenger(context, tourPackage.getPassengerList(), false));
    }

    @Override
    public int getItemCount() {
        return tourPackageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, capacity, enrolled;
        RecyclerView destinationsView, passengerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tourName);
            capacity = itemView.findViewById(R.id.tourCapacity);
            enrolled = itemView.findViewById(R.id.enrolled);
            destinationsView = itemView.findViewById(R.id.destinationView);
            passengerView = itemView.findViewById(R.id.passengerView);
        }
    }
}
