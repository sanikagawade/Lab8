package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);
    }

    public boolean hasCity(City city){
        if (cities.contains(city)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This deletes the given city
     * @param city
     * This is a candidate city to delete
     * throws an exception if city does not exist in list
     */
    public boolean delete(City city) throws Exception {
        if (cities.contains(city)){
            cities.remove(city);
            return true;
        }else{
            throw new Exception("City not in list");
        }
    }

    /**
     * This counts the cities in the list
     * @return the number of cities in the list
     */
    int countCities(){
        return(cities.size());
    }

}