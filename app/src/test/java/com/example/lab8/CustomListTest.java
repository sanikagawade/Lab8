package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return mocklist of type Arraylist
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * This checks if list is initially empty
     * Then adds a city to list
     * check if new added city exists in list
     * (extensive test) declares city_2 but not added to list
     * checks if city exists in list
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        assertEquals(0, list.getCount());

        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertTrue(list.hasCity(city));

        //only declared city_2
        // not added to list so hasCity should return false
        // city does not exist in list
        City city_2 = new City("Calgary", "Alberta");
        assertFalse(list.hasCity(city_2));
    }

    /**
     * This checks if list is initially empty
     * Then adds a city to list
     * check if new added city exists in list
     * deletes city from list
     * check if city successfully deleted
     */
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        assertEquals(0, list.getCount());

        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertEquals(1, list.getCount());

        try{
            list.delete(city);
        }catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(0, list.getCount());

    }

    /**
     * This checks if list is initially empty
     * Then adds a city to list
     * check if new added city exists in list
     * checks if number of cities in list matches our expected number = 1
     */
    @Test
    void testCountCities(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        //assertEquals(1, list.getCount());

        assertEquals(1, list.countCities());

    }
}
