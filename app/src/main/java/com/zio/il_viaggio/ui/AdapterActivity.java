package com.zio.il_viaggio.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zio.il_viaggio.R;
import com.zio.il_viaggio.datamodels.Activity;
import com.zio.il_viaggio.datamodels.Passenger;

import java.util.List;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.ViewHolder> {

    private final Context context;
    private final List<Activity> activityList;
    private final boolean type;
    private final Passenger passenger;

    public AdapterActivity(Context context, List<Activity> activityList, boolean type) {
        this.context = context;
        this.activityList = activityList;
        this.type = type;
        passenger = null;
    }

    public AdapterActivity(Context context, List<Activity> activityList, Passenger passenger) {
        this.context = context;
        this.activityList = activityList;
        this.type = false;
        this.passenger = passenger;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_activity, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(activityList.get(position).getActivityName());
        holder.desc.setText(activityList.get(position).getDescription());
        if (type) {
            holder.seats.setText("Seats left : " + activityList.get(position).getRemainingCapacity());
            holder.cost.setText("Costs : " + activityList.get(position).getCost());
        } else {
            holder.cost.setText(activityList.get(position).getDestination().getDestinationName());
            holder.seats.setText("paid : " + passenger.getCostOfActivity(activityList.get(position)));
        }

    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, seats, desc, cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.activityName);
            seats = itemView.findViewById(R.id.activitySeat);
            seats = itemView.findViewById(R.id.activitySeat);
            desc = itemView.findViewById(R.id.activityDesc);
            cost = itemView.findViewById(R.id.activityCost);
        }
    }
}
