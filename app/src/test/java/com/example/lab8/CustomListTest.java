package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
    * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    /**
     * add a new city to the list and see
     * if the city is in the list through hasCity
     * hasCity should return a 1 if in list
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertEquals(1, list.hasCity(city));
    }

    /**
     * add a new city to the list and get size of list
     * then tries to delete the same city the list size
     * then compares
     */
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City city = new City("Calgary", "AB");
        list.addCity(city);
        list.deleteCity(city);
        assertEquals(0, list.getCount());
    }
    /**
     * Gets the starting list size, then adds four new cities
     * calls function and compares sizes of return to list+4
     */
    @Test
    public void countCitiesTest(){
        list = MockCityList();
        int prior = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        list.addCity(new City("Nova Scotia", "AB"));
        list.addCity(new City("Calgary", "AB"));
        list.addCity(new City("Leduc", "AB"));
        assertEquals(prior + 4, list.countCity());
    }


}
