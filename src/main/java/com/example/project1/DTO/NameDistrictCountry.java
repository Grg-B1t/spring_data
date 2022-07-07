package com.example.project1.DTO;

public class NameDistrictCountry {
    private String name;
    private String district;
    private String countrycode;

    public NameDistrictCountry() {
    }
    
    public NameDistrictCountry(String name, String district, String countrycode) {
        this.name = name;
        this.district = district;
        this.countrycode = countrycode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getCountrycode() {
        return countrycode;
    }
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    
}
