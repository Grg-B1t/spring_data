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
    City updateCitybyId(Integer id, City newCity);
    City updateCitybyName(String name, City newCity);
    City deleteCitybyId(Integer id);
    List<City> deleteCitybyName(String name);
}
