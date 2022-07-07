package com.example.project1.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.project1.DTO.CountryPopulation;
import com.example.project1.DTO.NameDistrictCountry;
import com.example.project1.DTO.dataTransfer;
import com.example.project1.Entity.City;
import com.fasterxml.jackson.databind.BeanProperty;

@Repository
public class Dao implements DaoInterface{
    
    JdbcTemplate jt;

    @Autowired
    public void setDataSource(DataSource ds){
        this.jt = new JdbcTemplate(ds);
    }

    // Queries
    private static final String getAllCitiesQuery = "SELECT * FROM city";
    private static final String getCitybyIdQuery = "SELECT * FROM city WHERE id = ?";
    private static final String addNewCityQuery = "INSERT INTO city (id, name, countrycode, district, population) VALUES (?, ?, ?, ?, ?)";
    private static final String updateCityQuery = "UPDATE city SET name = ?, countrycode = ?, district = ?, population = ? WHERE id = ?";
    private static final String deleteCityQuiery = "DELETE FROM city WHERE id = ?";
    private static final String getDtoQuery = "SELECT id, CONCAT(name,' -> ', district) AS Name_and_District, population FROM city";
    private static final String getDtobyIdQuery = "SELECT id, CONCAT(name,' -> ', district) AS Name_and_District, population FROM city WHERE id=?";
    private static final String getNDCQuery = "SELECT name, district, countrycode FROM city";
    private static final String CPQuery = "SELECT population FROM city where countrycode = ?";



    @Override
    public List<City> getCities() {
        List<City> allCities = jt.query(getAllCitiesQuery, new Citymapper());
        return allCities;
    }


    @Override
    public City getCitiesbyId(Integer id) {
        Object[] obj = new Object[]{id};
        City city = jt.queryForObject(getCitybyIdQuery, BeanPropertyRowMapper.newInstance(City.class), obj);
        return city;
    }


    @Override
    public City createNewCity(City newCity) {
        Object[] obj = new Object[]{newCity.getId(), newCity.getName(), newCity.getCountrycode(), newCity.getDistrict(), newCity.getPopulation()};
        jt.update(addNewCityQuery, obj);
        return newCity;
    }


    @Override
    public City updateCity(City updatedCity) {
        Object[] cityObj = new Object[]{updatedCity.getName(), updatedCity.getCountrycode(), 
            updatedCity.getDistrict(), updatedCity.getPopulation(), updatedCity.getId()};
        jt.update(updateCityQuery, cityObj);
        return updatedCity;
    }


    @Override
    public String deleteCity(Integer id) {
        jt.update(deleteCityQuiery, id);
        return "City is removed from the databse.";
    }


    @Override
    public List<dataTransfer> getDto() {
       
        return  jt.query(getDtoQuery, new DTOMapper());
    }


    @Override
    public dataTransfer getDtobyId(Integer id) {
        Object[] obj = new Object[]{id};
        dataTransfer city = jt.queryForObject(getDtobyIdQuery, BeanPropertyRowMapper.newInstance(dataTransfer.class), obj);
        return city;
    }


    @Override
    public List<NameDistrictCountry> getNDC() {
        return jt.query(getNDCQuery, new NameDistrictCountryMapper());
    }


    @Override
    public List<CountryPopulation> getCountryPopulation(String countrycode) {
        
        return jt.query(CPQuery, new CountryPopulationMapper(), countrycode);
    }


    
}
