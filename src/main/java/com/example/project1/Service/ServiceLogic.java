package com.example.project1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.project1.DTO.NameDistrictCountry;
import com.example.project1.Entity.City;

public class ServiceLogic {
    
    public static List<City> pagination(Integer offset, Integer pageSize, List<City> cityList){
        Integer start = (offset - 1) * pageSize;
        Integer end = offset * pageSize;

        List<City> newCityList = new ArrayList<>();

        for (int i = start; i < end; i++) {
            if(cityList.size() <= i){
                break;
            }
            else {
                newCityList.add(cityList.get(i));
            }
        }

        return newCityList;
    }

    public static List<NameDistrictCountry> paginationNDC(Integer offset, Integer pageSize, List<NameDistrictCountry> cityList){
        Integer start = (offset - 1) * pageSize;
        Integer end = offset * pageSize;

        List<NameDistrictCountry> newCityList = new ArrayList<>();

        for (int i = start; i < end; i++) {
            if(cityList.size() <= i){
                break;
            }
            else {
                newCityList.add(cityList.get(i));
            }
        }

        return newCityList;
    }

    public static List<City> filterCitiesByCountry(String filterKey, List<City> cityList){
        
            return cityList.stream().filter(a -> a.getCountrycode().equals(filterKey)).collect(Collectors.toList());
        }

    public static List<City> filterCitiesByDistrict(String filterKey, List<City> cityList){
        
            return cityList.stream().filter(a -> a.getDistrict().equals(filterKey)).collect(Collectors.toList());
        }

    public static List<City> filterCitiesByPopulation(Integer filterKey, List<City> cityList){
        
            return cityList.stream().filter(a -> a.getPopulation().equals(filterKey)).collect(Collectors.toList());
        }
        

}
