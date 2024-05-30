package com.mirea.kt.ribo.plant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class rcAdapter extends RecyclerView.Adapter<rcAdapter.PlantViewHolder> {

    private List<Plant> plants;

    public rcAdapter(List<Plant> plants) {
        this.plants = plants;
    }

    @Override
    public PlantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plant, parent, false);
        return new PlantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlantViewHolder holder, int position) {
        Plant plant = plants.get(position);
        holder.tv_Name.setText(plant.getName());
        holder.tv_Type.setText(plant.getType());
        if (plant.isGreenhouse()) {
            holder.tv_Greenhouse.setText("Тепличное растение");
        } else {
            holder.tv_Greenhouse.setText("Не тепличное растение");
        }
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    public static class PlantViewHolder extends RecyclerView.ViewHolder {
        TextView tv_Name;
        TextView tv_Type;
        TextView tv_Greenhouse;

        public PlantViewHolder(View itemView) {
            super(itemView);
            tv_Name = itemView.findViewById(R.id.tvName);
            tv_Type = itemView.findViewById(R.id.tvType);
            tv_Greenhouse = itemView.findViewById(R.id.tvGreenhouse);
        }
    }
}
