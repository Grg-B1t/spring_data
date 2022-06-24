package com.example.demo.Controller;

import java.net.http.WebSocket.Listener;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
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

import com.example.demo.Entity.City;
import com.example.demo.Service.CityService;
import com.example.demo.Service.CityServiceInterface; 

@RestController
@RequestMapping("/api")
public class EndPoint {

    @Autowired
    CityService cs;

    @GetMapping("/getCity") // , produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    public ResponseEntity<List<City>> getCity(){
        try {
            return new ResponseEntity<>(cs.getCity(), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCitybyRange") // , produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    public ResponseEntity<List<City>> getCitybyRange(@RequestParam Integer start, @RequestParam Integer end){
        try {
            return new ResponseEntity<>(cs.getCitybyRange(start, end), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getCitybyDistrict")
    public ResponseEntity<List<City>> getCitybyDistrict(@RequestParam String district){
        try {
            return new ResponseEntity<>(cs.getCitiesbyDistrict(district), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCitybyCountry")
    public ResponseEntity<List<City>> getCitybyCountry(@RequestParam String countrycode){
        try {
            return new ResponseEntity<>(cs.getCitiesbyCountry(countrycode), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addCity")
    public ResponseEntity<City> addNewCity(@RequestBody City newCity){
        try {
            return new ResponseEntity<City>(cs.createCity(newCity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<City>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/updateCitybyId")
    public ResponseEntity<City> updateCitybyId(@RequestParam Integer id, @RequestBody City updatedCity){
        try {
            return new ResponseEntity<City>(cs.updateCitybyId(id, updatedCity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<City>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/updateCitybyName/{cityName}")
    public ResponseEntity<City> updateCitybyName(@PathVariable String cityName, @RequestBody City updatedCity){
        try {
            return new ResponseEntity<City>(cs.updateCitybyName(cityName, updatedCity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<City>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/deleteCitybyId")
    public ResponseEntity<City> deleteCitybyId(@RequestParam Integer id){
        try {
            return new ResponseEntity<City>(cs.deleteCitybyId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<City>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/deleteCitybyName/{cityName}")
    public ResponseEntity<List<City>> deleteCitybyName(@PathVariable String cityName){
        try {
            return new ResponseEntity<>(cs.deleteCitybyName(cityName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    
    }
}
