package com.zio.il_viaggio.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zio.il_viaggio.R;
import com.zio.il_viaggio.datamodels.Passenger;

import java.util.List;

public class AdapterPassenger extends RecyclerView.Adapter<AdapterPassenger.ViewHolder> {

    private final Context context;
    private final List<Passenger> passengerList;
    private final boolean type;

    public AdapterPassenger(Context context, List<Passenger> passengerList, boolean type) {
        this.context = context;
        this.passengerList = passengerList;
        this.type = type;
    }

    @NonNull
    @Override
    public AdapterPassenger.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_passenger, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPassenger.ViewHolder holder, int position) {

        holder.name.setText(passengerList.get(position).getPassengerName());
        holder.num.setText(String.valueOf(passengerList.get(position).getPassengerNumber()));

        if (type) {
            holder.bal.setText("Balance : " + passengerList.get(position).getCurrentBalance());
            holder.recyclerView.setAdapter(
                    new AdapterActivity(context, passengerList.get(position).getEnrolledActivities(), passengerList.get(position)));
        }

    }

    @Override
    public int getItemCount() {
        return passengerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, num, bal;
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.passName);
            num = itemView.findViewById(R.id.passNum);
            bal = itemView.findViewById(R.id.passBal);
            recyclerView = itemView.findViewById(R.id.activityView);

        }
    }
}
