package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.City;


public interface SortAndPagingInterface {
    List<City> getCityUsingPagination(Integer offset, Integer pageSize);
    List<City> getCityUsingPagination1(Integer offset);
    List<City> sortCities();
    List<City> sortedCitiesInRange(Integer start, Integer end);
    List<City> sortedCitiesInRangewithVar(Integer start, Integer end, String var);
    List<City> getSortedCitiesbyName(Integer offset, Integer pageSize);
}
