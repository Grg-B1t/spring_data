package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.DaoClassImplement;
import com.example.demo.Entity.City;

@Service
public class CityService implements CityServiceInterface {
    @Autowired
    DaoClassImplement daoImp;

    @Override
    public List<City> getCity() {
        List<City> cityList = daoImp.getCities();
        List<City> newCityList = new ArrayList<>();
        
        for (int i = 0; i < 100; i++) {
            newCityList.add(cityList.get(i));

        }
        return newCityList;
    }

    @Override
    public List<City> getCitybyRange(Integer start, Integer end) {
        List<City> cityList = daoImp.getCities();
        List<City> newCityList = new ArrayList<>();
        start--;
        for (int i = start; i < end; i++) {
            newCityList.add(cityList.get(i));

        }
        return newCityList;
    }

    @Override
    public List<City> getCitiesbyDistrict(String district) {
        
        return daoImp.getCitybyDistrict(district);
    }

    @Override
    public List<City> getCitiesbyCountry(String countryCode) {
        return daoImp.getCitybyCountry(countryCode);
    }

    @Override
    public City createCity(City newCity) {
        
        return daoImp.addCity(newCity);
    }

    @Override
    public City updateCitybyId(Integer id, City newCity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public City updateCitybyName(String name, City newCity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public City deleteCitybyId(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<City> deleteCitybyName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

  
    
}
