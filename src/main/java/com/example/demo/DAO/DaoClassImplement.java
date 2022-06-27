package com.example.demo.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.City;

@Repository
public class DaoClassImplement implements DaoInterface {
    private static final String getAllQuery = "select * from city";
    private static final String getCitybyDistrictQuery = "select * from city where district = ?";
    private static final String getCitybyCountryQuery = "select * from city where countrycode = ?";
    private static final String addCityQuery = "insert into city (id, name, countrycode, district, population) values (?, ?, ?, ?, ?)";
    private static final String updateCitybyIdQuery = "update city set name=?, countrycode=?, district=?, population=? where id=?";
    private static final String updateCityQuery = "update city set name=?, countrycode=?, district=?, population=? where id=?";
    private static final String updateCitybyNCDQuery = "update city set name=?, countrycode=?, district=?, population=? where name = ? and countrycode = ? and district = ?";
    private static final String deleteCitybyIdQuery = "delete from city where id = ?";
    private static final String deleteCitybyNCDQuery = "delete from city where name = ? and countrycode = ? and district = ?";
    private JdbcTemplate jt;

    @Autowired
    public void setDataSource(DataSource ds){
        this.jt = new JdbcTemplate(ds);
    }

    @Override
    public List<City> getCities() {
        List<City> cities = jt.query(getAllQuery, new CityMapper());
        return cities; 
    }

    @Override
    public List<City> getCitybyDistrict(String district) {
       List<City> cList = jt.query(getCitybyDistrictQuery, new CityMapper(), district);

       return cList;
    }

    @Override
    public List<City> getCitybyCountry(String countrycode) {
        
        return jt.query(getCitybyCountryQuery, new CityMapper(), countrycode);
    }

    @Override
    public City addCity(City newCity) {

       Object[] objArray = new Object[]{newCity.getId(), 
        newCity.getName(), 
        newCity.getCountrycode(),
        newCity.getDistrict(), 
        newCity.getPopulation()};

        jt.update(addCityQuery, objArray);

        return newCity;
    }

    @Override
    public City updateCitybyId(Integer id, City updatedCity) {
        Object[] objArray = new Object[]{ 
            updatedCity.getName(), 
            updatedCity.getCountrycode(),
            updatedCity.getDistrict(), 
            updatedCity.getPopulation(), id};

            jt.update(updateCitybyIdQuery, objArray);
        
            return updatedCity;
    }

    @Override
    public City updateCity(City updatedCity) {
        
        Object[] objArray = new Object[]{ 
            updatedCity.getName(), 
            updatedCity.getCountrycode(),
            updatedCity.getDistrict(), 
            updatedCity.getPopulation(), updatedCity.getId()};

            jt.update(updateCityQuery, objArray);
        
            return updatedCity;
    }

    @Override
    public City updateCitybyNCD(String name, String countrycode, String district, City updatedCity) {
        Object[] objArray = new Object[]{ 
            updatedCity.getName(), 
            updatedCity.getCountrycode(),
            updatedCity.getDistrict(), 
            updatedCity.getPopulation(), name, countrycode, district};

            jt.update(updateCitybyNCDQuery, objArray);
        
            return updatedCity;
    }

    @Override
    public String deleteCitybyId(Integer id) {
        jt.update(deleteCitybyIdQuery, id);
        return "Your record is removed successfully.";
    }

    @Override
    public String deleteCitybyNCD(String name, String countrycode, String district) {
        Object[] objArray = new Object[]{ name, countrycode, district};
        
        jt.update(deleteCitybyNCDQuery, objArray);    
        return "Your record is removed successfully.";
    }

    
    
}
