package com.example.project1.Service;

import java.util.List;

import com.example.project1.DTO.NameDistrictCountry;
import com.example.project1.DTO.dataTransfer;
import com.example.project1.Entity.City;

public interface CityServiceInterface {
    List<City> getAllCities();
    City getCitiesbyId(Integer id);
    List<City> filterCitiesbyName(String name);
    List<List<City>> filterbyIdName(City city);
    List<City> filterbyCountrycode(String countrycode);
    List<City> filterbyName(String name);
    List<City> filterbyPopulation(Integer population);
    List<City> filterbyDistrict(String district);
    City createNewCity(City newCity);
    City updateCity(City updatedCity);
    String deleteCity(Integer id);
    List<City> pagination(Integer offset, Integer pageSize);
    List<City> limitPagination(Integer start, Integer end, Integer offset, Integer pageSize);
    List<City> sorLimitPagination(Integer start, Integer end, Integer offset, Integer pageSize);
    List<dataTransfer> getConcatCity();
    dataTransfer getDtobyId(Integer id);
    List<NameDistrictCountry> getNDCList();
    List<City> getCititesbyCountry(String countrycode);
    List<City> getCititesbyDistrict(String district);
    List<City> getCititesbyCPopulation(Integer population);
    Integer getPopulationOfCountry(String countrycode);
    Integer getPopulationbyCountryCode(String countrycode);
}
