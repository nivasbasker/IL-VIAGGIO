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

import java.util.List;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.ViewHolder> {

    private final Context context;
    private final List<Activity> activityList;
    private final boolean type;

    public AdapterActivity(Context context, List<Activity> activityList, boolean type) {
        this.context = context;
        this.activityList = activityList;
        this.type = type;
    }

    @NonNull
    @Override
    public AdapterActivity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_activity, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterActivity.ViewHolder holder, int position) {

        holder.name.setText(activityList.get(position).getActivityName());
        holder.desc.setText(activityList.get(position).getDescription());
        if (type)
            holder.seats.setText("Seats left : " + activityList.get(position).getRemainingCapacity());

    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, seats, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.activityName);
            seats = itemView.findViewById(R.id.activitySeat);
            seats = itemView.findViewById(R.id.activitySeat);
            desc = itemView.findViewById(R.id.activityDesc);
        }
    }
}
