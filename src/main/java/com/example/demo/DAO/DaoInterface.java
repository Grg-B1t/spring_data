package com.example.demo.DAO;

import java.util.List;

import com.example.demo.Entity.City;

public interface DaoInterface {
    List<City> getCities();
    List<City> getCitybyDistrict(String district);
    List<City> getCitybyCountry(String countrycode);
    City addCity(City newCity);
    City updateCitybyId(Integer id, City updatedCity);
    City updateCity(City updatedCity);
    City updateCitybyNCD(String name, String countrycode, String district, City updatedCity);
    String deleteCitybyId(Integer id);
    String deleteCitybyNCD(String name, String countrycode, String district);
}
