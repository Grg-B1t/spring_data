package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.DaoClassImplement;
import com.example.demo.Entity.City;

@Service
public class SortAndPaging implements SortAndPagingInterface {

    @Autowired
    DaoClassImplement daoImp;
    

    @Override
    public List<City> getCityUsingPagination(Integer offset, Integer pageSize) {
        List<City> cityList = daoImp.getCities();
        List<City> cityList1 = new ArrayList<>();
        Integer size = offset * pageSize;
        Integer newOffset = offset - 1;
        Integer startValue = newOffset * pageSize;

        for (int i = startValue; i < size; i++) {
            if (cityList.size() <= i) {
                break;
            } else {
                cityList1.add(cityList.get(i));
            }
        }
        return cityList1;
    }

    @Override
    public List<City> getCityUsingPagination1(Integer offset) {
        List<City> cityList = daoImp.getCities();
        List<City> newCityList = new ArrayList<>();
        Integer size = offset * 10;
        Integer startValue = 10 * (offset - 1);

        for (int i = startValue; i < size; i++) {
            if (cityList.size() <= i) {
                break;
            } else {
                newCityList.add(cityList.get(i));
            }
        }
        return newCityList;
    }

    @Override
    public List<City> sortCities() {
        List<City> allCities = daoImp.getCities();
        List<City> sortedCities = new ArrayList<>();
        sortedCities = allCities.stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).collect(Collectors.toList());
        
       return sortedCities;
             
    }

    @Override
    public List<City> sortedCitiesInRange(Integer start, Integer end) {
        List<City> cityList = daoImp.getCities();
        List<City> rangeCityList = new ArrayList<>();

        for (int i = start - 1; i < end; i++) {
            if(cityList.size() <= i){
                break;
            }
            else{
                rangeCityList.add(cityList.get(i));
            }    
        }
        List<City> newSortedList = rangeCityList.stream()
        .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
        .collect(Collectors.toList());
        
        return newSortedList;
    }

    @Override
    public List<City> sortedCitiesInRangewithVar(Integer start, Integer end, String var) {
        List<City> cityList = daoImp.getCities();
        List<City> newCityList = new ArrayList<>();

        String id = "id";
        String name = "name";
        String countrycode = "countrycode";
        String district = "district";
        String population = "population";
        
        for (int i = start - 1; i < end; i++) {
            if(cityList.size() <= i){
                break;
            }
            else{
                newCityList.add(cityList.get(i));
            }
        }
        List<City>sortedCities = new ArrayList<>();

        if(id.equals(var)){
            sortedCities = newCityList.stream()
            .sorted((c1, c2) -> c1.getId().compareTo(c2.getId()))
            .collect(Collectors.toList());
        }
        else if(name.equals(var)){
            sortedCities = newCityList.stream()
            .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
            .collect(Collectors.toList());
        }
        else if(countrycode.equals(var)){
            sortedCities = newCityList.stream()
            .sorted((c1, c2) -> c1.getCountrycode().compareTo(c2.getCountrycode()))
            .collect(Collectors.toList());
        }
        else if(district.equals(var)){
            sortedCities = newCityList.stream()
            .sorted((c1, c2) -> c1.getDistrict().compareTo(c2.getDistrict()))
            .collect(Collectors.toList());
        }
        else{
            sortedCities = newCityList.stream()
            .sorted((c1, c2) -> c1.getPopulation().compareTo(c2.getPopulation()))
            .collect(Collectors.toList());
        }
        return sortedCities;
    }
}
