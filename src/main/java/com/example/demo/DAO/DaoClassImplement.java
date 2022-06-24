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
    protected static final Connection connection = null;
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

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                try (PreparedStatement ps = con.prepareStatement(addCityQuery, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setLong(1, newCity.getId());
                    ps.setString(2, newCity.getName());
                    ps.setString(3, newCity.getCountrycode());
                    ps.setString(4, newCity.getDistrict());
                    ps.setInt(5, newCity.getPopulation());

                    return ps;
                }
                catch(SQLException sqle){
                    System.out.println(sqle.toString());
                    return null;
                }
            }
       
        };

        KeyHolder kh = new GeneratedKeyHolder();

        jt.update(psc, kh);
        newCity.setId(kh.getKey().longValue());

        return newCity;
    }
    
}
