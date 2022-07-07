package com.example.project1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.DTO.CountryPopulation;
import com.example.project1.DTO.NameDistrictCountry;
import com.example.project1.DTO.dataTransfer;
import com.example.project1.Dao.Dao;
import com.example.project1.Entity.City;

@Service
public class CityService implements CityServiceInterface {
    
    @Autowired
    Dao ds;

    @Override
    public List<City> getAllCities() {
        return ds.getCities();
    }

    @Override
    public City getCitiesbyId(Integer id) {
        return ds.getCitiesbyId(id);
    }

    @Override
    public List<City> filterCitiesbyName(String name) {
       List<City> cities = ds.getCities();
        return cities.stream().filter(a -> a.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<List<City>> filterbyIdName(City city) {
        List<City> allCities = ds.getCities();
       
        
        List<City> idList = new ArrayList<>();
        List<City> nameList = new ArrayList<>();
        List<City> countrycodeList = new ArrayList<>();
        List<City> districtList = new ArrayList<>();
        List<City> popuList = new ArrayList<>();

        for (City newCity : allCities) {
            if (newCity.getId().equals(city.getId())) {
                idList.add(newCity);
            } 
        else if(newCity.getName().equals(city.getName())) {
                nameList.add(newCity);
            }
        else if(newCity.getCountrycode().equals(city.getCountrycode())){
                countrycodeList.add(newCity);
        }
        else if(newCity.getDistrict().equals(city.getDistrict())){
            districtList.add(newCity);
        }
        else if(newCity.getPopulation() <= city.getPopulation()){
            popuList.add(newCity);
        }
        }

        List<List<City>> lists = new ArrayList<>();
        lists.add(idList);
        lists.add(nameList);
        lists.add(countrycodeList);
        lists.add(districtList);
        lists.add(popuList);


        return lists;
    }

    @Override
    public List<City> filterbyCountrycode(String countrycode) {
        City city = new City(0, null, countrycode, null, 0);
        List<List<City>> cityList = filterbyIdName(city);
        return cityList.get(2);
    }

    @Override
    public List<City> filterbyName(String name) {
        City city = new City(0, name, null, null, 0);
        List<List<City>> cityList = filterbyIdName(city);
        return cityList.get(1);
    }

    @Override
    public List<City> filterbyPopulation(Integer population) {
        City city = new City(0, null, null, null, population);
        List<List<City>> cityList = filterbyIdName(city);
        return cityList.get(4);
    }

    @Override
    public List<City> filterbyDistrict(String district) {
        City city = new City(0, null, null, district, 0);
        List<List<City>> cityList = filterbyIdName(city);
        return cityList.get(3);
    }

    @Override
    public City createNewCity(City newCity) {
        return ds.createNewCity(newCity);
    }

    @Override
    public City updateCity(City updatedCity) {
        return ds.updateCity(updatedCity);
    }

    @Override
    public String deleteCity(Integer id) {
        return ds.deleteCity(id);
    }

    @Override
    public List<City> pagination(Integer offset, Integer pageSize) {
        return ServiceLogic.pagination(offset, pageSize, ds.getCities());
    }

    @Override
    public List<City> limitPagination(Integer start, Integer end, Integer offset, Integer pageSize) {
        List<City> cityList = ds.getCities();
        List<City> limitedList = new ArrayList<>();
       
        for (int i = start; i <= end; i++) {
            limitedList.add(cityList.get(i));
        }

        return ServiceLogic.pagination(offset, pageSize, limitedList);
    }

    @Override
    public List<City> sorLimitPagination(Integer start, Integer end, Integer offset, Integer pageSize) {
        List<City> cityList = ds.getCities();
        List<City> limitedList = new ArrayList<>();
       
        for (int i = start; i <= end; i++) {
            limitedList.add(cityList.get(i));
        }

        List<City> sortedList = limitedList.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
        
        return ServiceLogic.pagination(offset, pageSize, sortedList);
    }

    @Override
    public List<dataTransfer> getConcatCity() {
        return ds.getDto();
    }

    @Override
    public dataTransfer getDtobyId(Integer id) {
        
        return ds.getDtobyId(id);
    }

    @Override
    public List<NameDistrictCountry> getNDCList() {
        
      return ServiceLogic.paginationNDC(1, 10, ds.getNDC());
    }

    @Override
    public List<City> getCititesbyCountry(String countrycode) {

        return ServiceLogic.filterCitiesByCountry(countrycode, ds.getCities());
    }

    @Override
    public List<City> getCititesbyDistrict(String district) {

        return ServiceLogic.filterCitiesByDistrict(district, ds.getCities());
    }

    @Override
    public List<City> getCititesbyCPopulation(Integer population) {

        return ServiceLogic.filterCitiesByPopulation(population, ds.getCities());
    }

    @Override
    public Integer getPopulationOfCountry(String countrycode) {
        List<CountryPopulation> cityList = ds.getCountryPopulation(countrycode);
        Integer population = 0;
        for (int i = 0; i < cityList.size(); i++) {
            population += cityList.get(i).getPopulation();
        }
        return population;
    }
 
    @Override
    public Integer getPopulationbyCountryCode(String countrycode) {
        List<Integer> cityList = ds.getCities().stream().filter(a -> a.getCountrycode().equals(countrycode)).map(a -> a.getPopulation()).collect(Collectors.toList());
        Integer population = 0;
        for (int i = 0; i < cityList.size(); i++) {

            population += cityList.get(i);
            // if(countrycode.equals(cityList.get(i).getCountrycode())){
            //     population += cityList.get(i).getPopulation();
            // }
        }
        return population;
    }
}
