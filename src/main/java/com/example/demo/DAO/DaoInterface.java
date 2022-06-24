package com.example.demo.DAO;

import java.util.List;

import com.example.demo.Entity.City;

public interface DaoInterface {
    List<City> getCities();
    List<City> getCitybyDistrict(String district);
    List<City> getCitybyCountry(String countrycode);
    City addCity(City newCity);
}
