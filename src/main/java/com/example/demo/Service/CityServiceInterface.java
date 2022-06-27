package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.City;

public interface CityServiceInterface {
    List<City> getCity();
    List<City> getCitybyRange(Integer start, Integer end);
    List<City> getCitiesbyDistrict(String district);
    List<City> getCitiesbyCountry(String countryCode);
    City createCity(City newCity);
    City updateCitybyId(Integer id, City updatedCity);
    City updateCity(City updatedCity);
    City updateCitybyNCD(String name, String countrycode, String district, City updatedCity);
    String deleteCitybyId(Integer id);
    String deleteCitybyNCD(String name, String countrycode, String district);
}
