package com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Entity.City;

public class CityMapper implements RowMapper<City>{

    @Override
    public City mapRow(ResultSet rs, int CityId) throws SQLException {
        City city = new City();
        
        city.setId(rs.getLong("id"));
        city.setName(rs.getString("name"));
        city.setDistrict(rs.getString("district"));
        city.setCountrycode(rs.getString("countrycode"));
        city.setPopulation(rs.getInt("population"));
        
        return city;
    }
    
}
