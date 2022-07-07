package com.example.project1.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.project1.DTO.CountryPopulation;
import com.example.project1.DTO.NameDistrictCountry;
import com.example.project1.DTO.dataTransfer;
import com.example.project1.Entity.City;

public class Citymapper implements RowMapper<City>{

	@Override
	public City mapRow(ResultSet rs, int rowNum) throws SQLException {
		City city = new City();
		city.setId(rs.getInt("id"));
		city.setName(rs.getString("name"));
		city.setCountrycode(rs.getString("countrycode"));
		city.setDistrict(rs.getString("district"));
		city.setPopulation(rs.getInt("population"));

		return city;
	}
	
	
}

class DTOMapper implements RowMapper<dataTransfer>{

	@Override
	public dataTransfer mapRow(ResultSet rs, int rowNum) throws SQLException {
		dataTransfer dto = new dataTransfer();
		dto.setId(rs.getInt("id"));
		dto.setNameAndDistrict(rs.getString("nameAndDistrict"));
		dto.setPopulation(rs.getInt("population"));
		return dto;
	}

}

class NameDistrictCountryMapper implements RowMapper<NameDistrictCountry>{

	@Override
	public NameDistrictCountry mapRow(ResultSet rs, int rowNum) throws SQLException {
		NameDistrictCountry ndc = new NameDistrictCountry();
		ndc.setName(rs.getString("name"));
		ndc.setDistrict(rs.getString("district"));
		ndc.setCountrycode(rs.getString("countrycode"));
		return ndc;
	}

}

class CountryPopulationMapper implements RowMapper<CountryPopulation>{

	@Override
	public CountryPopulation mapRow(ResultSet rs, int rowNum) throws SQLException {
		CountryPopulation cp = new CountryPopulation();
		cp.setPopulation(rs.getInt("population"));
		return cp;
	}

}
