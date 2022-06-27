package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    public City updateCitybyId(Integer id, City updatedCity) {
        return daoImp.updateCitybyId(id, updatedCity);
    }

    @Override
    public City updateCity(City updatedCity) {
        return daoImp.updateCity(updatedCity);
    }

    @Override
    public City updateCitybyNCD(String name, String countrycode, String district, City updatedCity) {
        return daoImp.updateCitybyNCD(name, countrycode, district, updatedCity);
    }

    @Override
    public String deleteCitybyId(Integer id) {
        return daoImp.deleteCitybyId(id);
    }

    @Override
    public String deleteCitybyNCD(String name, String countrycode, String district) {
        return daoImp.deleteCitybyNCD(name, countrycode, district);
    }



    

}
