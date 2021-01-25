package com.ketee_jishs.weather_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecViewWeatherDataAdapter extends RecyclerView.Adapter<RecViewWeatherDataAdapter.ViewHolder> {
    private ItemWeatherSource dataSource;

    public RecViewWeatherDataAdapter (ItemWeatherSource dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public RecViewWeatherDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_weather_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewWeatherDataAdapter.ViewHolder holder, int position) {
        ItemWeather itemWeather = dataSource.getItem(position);
        holder.setData(itemWeather.getNameOfDay(), itemWeather.getDayWeath(), itemWeather.getNightWeath());
    }

    @Override
    public int getItemCount() {
        return dataSource == null ? 0 : dataSource.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView dayView;
        private TextView degrDayView;
        private TextView degrNightView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayView = itemView.findViewById(R.id.titleRecyclerView);
            degrDayView = itemView.findViewById(R.id.degrDayView);
            degrNightView = itemView.findViewById(R.id.degrNightView);
        }

        public void setData (String day, String dayWeather, String nightWeather) {
            getDayView().setText(day);
            getDegrDayView().setText(dayWeather);
            getDegrNightView().setText(nightWeather);
        }

        public TextView getDayView() {
            return dayView;
        }

        public TextView getDegrDayView() {
            return degrDayView;
        }

        public TextView getDegrNightView() {
            return degrNightView;
        }
    }
}
