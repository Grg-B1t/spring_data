package com.example.project1.DTO;

public class dataTransfer {
    private Integer id;
    private String nameAndDistrict;
    private Integer population;

    public dataTransfer() {
    }

    public dataTransfer(Integer id, String nameAndDistrict, Integer population) {
        this.id = id;
        this.nameAndDistrict = nameAndDistrict;
        this.population = population;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameAndDistrict() {
        return nameAndDistrict;
    }

    public void setNameAndDistrict(String nameAndDistrict) {
        this.nameAndDistrict = nameAndDistrict;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
    
   

    
}
