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

    public AdapterActivity(Context context, List<Activity> activityList) {
        this.context = context;
        this.activityList = activityList;
        this.type = true;
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

        Activity activity = activityList.get(position);

        holder.name.setText(activity.getActivityName());
        holder.desc.setText(activity.getDescription());
        if (type) {
            holder.seats.setText("Seats left : " + activity.getRemainingCapacity());
            holder.cost.setText("Costs : " + activity.getCost());
        } else {
            holder.cost.setText(activity.getDestination().getDestinationName());
            holder.seats.setText("paid : " + passenger.getCostOfActivity(activity));
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
            desc = itemView.findViewById(R.id.activityDesc);
            cost = itemView.findViewById(R.id.activityCost);
            seats = itemView.findViewById(R.id.activitySeat);
        }
    }
}
