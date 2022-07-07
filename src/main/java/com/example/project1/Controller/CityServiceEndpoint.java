package com.example.project1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.DTO.NameDistrictCountry;
import com.example.project1.DTO.dataTransfer;
import com.example.project1.Entity.City;
import com.example.project1.Service.CityService;


@RestController
@RequestMapping("/api")
public class CityServiceEndpoint {
    
    @Autowired
    CityService cs;

    @GetMapping("/getAll")
    public ResponseEntity<List<City>> getAllCities(){
        try {
            return new ResponseEntity<>(cs.getAllCities(), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCityById/{id}")
    public ResponseEntity<City> getCitiesById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(cs.getCitiesbyId(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCitybyName")
    public ResponseEntity<List<City>> getCitybyName(@RequestParam(value = "name", defaultValue = "Boston", required = false) String name){
        try {
            return new ResponseEntity<>(cs.filterCitiesbyName(name), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filterByIdName")
    public ResponseEntity<List<List<City>>> filterCitiesByIdandName(@RequestBody City city){
        try {
            return new ResponseEntity<>(cs.filterbyIdName(city), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filterByCountrycode")
    public ResponseEntity<List<City>> filterbyCountrycode(@RequestParam String countrycode){
        try {
            return new ResponseEntity<>(cs.filterbyCountrycode(countrycode), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filterByDistrict")
    public ResponseEntity<List<City>> filterbyDistrict(@RequestParam String district)
    {
        try {
            return new ResponseEntity<>(cs.filterbyDistrict(district), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filterByPopulation")
    public ResponseEntity<List<City>> filterbyPopulation(@RequestParam Integer population)
    {
        try {
            return new ResponseEntity<>(cs.filterbyPopulation(population), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filterByName")
    public ResponseEntity<List<City>> filterbyName(@RequestParam String name)
   {
        try {
            return new ResponseEntity<>(cs.filterbyName(name), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Creating new city using PostMapping
    @PostMapping("/createNewCityPost")
    public ResponseEntity<City> createNewCityPost(@RequestBody City newCity){
        try {
            return new ResponseEntity<City>(cs.createNewCity(newCity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<City>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // Creating new city using GetMapping
    @GetMapping("/createNewCityGet")
    public ResponseEntity<City> createNewCityGet(@RequestBody City newCity){
        try {
            return new ResponseEntity<City>(cs.createNewCity(newCity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<City>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/updateCity")
    public ResponseEntity<City> updateCity(@RequestBody City updatedCity){
        try {
            return new ResponseEntity<City>(cs.updateCity(updatedCity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<City>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/deleteCity/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(cs.deleteCity(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/pagination")
    public ResponseEntity<List<City>> pagination(@RequestParam(value = "offset", defaultValue = "1", required = false) Integer offset,
                                                @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize ){
        try {
            return new ResponseEntity<>(cs.pagination(offset, pageSize), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/limitAndPagination/{start}/{end}")
    public ResponseEntity<List<City>> limitPagination(@PathVariable Integer start, @PathVariable Integer end,
    @RequestParam(value="offset", defaultValue = "1", required = false) Integer offset, @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize){
        try {
            return new ResponseEntity<>(cs.limitPagination(start, end, offset, pageSize), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sortLimitAndPagination/{start}/{end}")
    public ResponseEntity<List<City>> sortLimitPagination(@PathVariable Integer start, @PathVariable Integer end,
    @RequestParam(value="offset", defaultValue = "1", required = false) Integer offset, @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize){
        try {
            return new ResponseEntity<>(cs.sorLimitPagination(start, end, offset, pageSize), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCityNameAndDistrict")
    public ResponseEntity<List<dataTransfer>> getContactCityAndDistrict(){
        try {
            return new ResponseEntity<>(cs.getConcatCity(), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getDtoByid/{id}")
    public ResponseEntity<dataTransfer> getDtoByid(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(cs.getDtobyId(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getNDC")
    public ResponseEntity<List<NameDistrictCountry>> getNDC(){
        try {
            return new ResponseEntity<>(cs.getNDCList(), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cityNamebyCountry/{countrycode}")
    public ResponseEntity<List<City>> getCitiesbyCountry(@PathVariable String countrycode){
        try {
            return new ResponseEntity<>(cs.getCititesbyCountry(countrycode), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filterCities")
    public ResponseEntity<List<City>> getCitiesbyCountry(@RequestParam(value = "countrycode", required = false) String countrycode,
    @RequestParam(value="district", required = false) String district,
    @RequestParam(value="population", required = false) Integer population){
        try { 
            if(district != null){
                return new ResponseEntity<>(cs.getCititesbyDistrict(district), HttpStatus.FOUND);
            } 
            else if(countrycode != null){
                return new ResponseEntity<>(cs.getCititesbyCountry(countrycode), HttpStatus.FOUND);
            }
            
            else {
                return new ResponseEntity<>(cs.getCititesbyCPopulation(population), HttpStatus.FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCountryPopulation/{countrycode}")
    public ResponseEntity<Integer> getCountryPopulation(@PathVariable String countrycode){
        try {
            return new ResponseEntity<>(cs.getPopulationOfCountry(countrycode), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCountryPopulationBycountrycode/{countrycode}")
    public ResponseEntity<Integer> getCountryPopulationByCountrycode(@PathVariable String countrycode){
        try {
            return new ResponseEntity<>(cs.getPopulationbyCountryCode(countrycode), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
  

    


}
