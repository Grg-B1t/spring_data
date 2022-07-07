package com.example.project1.Dao;

import java.util.List;

import com.example.project1.DTO.CountryPopulation;
import com.example.project1.DTO.NameDistrictCountry;
import com.example.project1.DTO.dataTransfer;
import com.example.project1.Entity.City;

public interface DaoInterface {
    List<City> getCities();
    City getCitiesbyId(Integer id);
    City createNewCity(City newCity);
    City updateCity(City updatedCity);
    String deleteCity(Integer id);
    List<dataTransfer> getDto();
    dataTransfer getDtobyId(Integer id);
    List<NameDistrictCountry> getNDC();
    List<CountryPopulation> getCountryPopulation(String countrycode);
}
