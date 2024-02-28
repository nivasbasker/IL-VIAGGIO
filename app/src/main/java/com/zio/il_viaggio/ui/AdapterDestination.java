package com.zio.il_viaggio.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zio.il_viaggio.R;
import com.zio.il_viaggio.datamodels.Destination;

import java.util.List;

public class AdapterDestination extends RecyclerView.Adapter<AdapterDestination.ViewHolder> {

    private final Context context;
    private final List<Destination> destinationList;

    public AdapterDestination(Context context, List<Destination> destinationList) {
        this.context = context;
        this.destinationList = destinationList;
    }

    @NonNull
    @Override
    public AdapterDestination.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_destination, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDestination.ViewHolder holder, int position) {

        holder.name.setText(destinationList.get(position).getDestinationName());
        holder.recyclerView.setAdapter(
                new AdapterActivity(context, destinationList.get(position).getAvailableActivities(), true));
    }

    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.destinationName);
            recyclerView = itemView.findViewById(R.id.activityView);
        }
    }
}
