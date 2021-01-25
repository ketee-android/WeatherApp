package com.ketee_jishs.weather_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecViewCitiesDataAdapter extends RecyclerView.Adapter<RecViewCitiesDataAdapter.ViewHolder>{
    private ArrayList<String> data;
    private OnItemCityClickInterface onItemCityClick;

    public RecViewCitiesDataAdapter(ArrayList<String> data, OnItemCityClickInterface onItemCityClick) {
        this.data = data;
        this.onItemCityClick = onItemCityClick;
    }

    @NonNull
    @Override
    public RecViewCitiesDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_city_layout, viewGroup, false);
        return new RecViewCitiesDataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setItemText(holder, data.get(position));
        setOnClickItem(holder, data.get(position));
    }

    private void setItemText(@NonNull ViewHolder holder, String city) {
        holder.cityView.setText(city);
    }

    private void setOnClickItem(@NonNull ViewHolder holder, String city) {
        holder.listRecyclerCitiesLayout.setOnClickListener(v -> {
            if (onItemCityClick != null) {
                onItemCityClick.onItemCityClick(city);
                ChoseAdditionalPapamsFragment.onClickAtmospherePressureCheckBox();
                ChoseAdditionalPapamsFragment.onClickWindSpeedCheckBox();
                ChoseAdditionalPapamsFragment.onClickAirHumidityCheckBox();
                ChoseAdditionalPapamsFragment.viewsSettingsForGone();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        static TextView cityView;
        static CardView listRecyclerCitiesLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listRecyclerCitiesLayout = itemView.findViewById(R.id.listRecyclerCitiesLayout);
            cityView = itemView.findViewById(R.id.cityView);
        }
    }
}
