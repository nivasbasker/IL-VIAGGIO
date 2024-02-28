package com.zio.il_viaggio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.itemtour, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTour.ViewHolder holder, int position) {

        holder.name.setText(tourPackageList.get(position).getPackageName());
    }

    @Override
    public int getItemCount() {
        return tourPackageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tourName);
        }
    }
}
