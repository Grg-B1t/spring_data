package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.City;
import com.example.demo.Service.SortAndPaging;

@RestController
@RequestMapping("/api1")
public class SortingAndPaginationController {
    
    @Autowired
    SortAndPaging sp;    

    @GetMapping("/getCityUsingPagination")
    public ResponseEntity<List<City>> getCityUsingPagination(@RequestParam(value = "offset", defaultValue = "1", required = false) Integer offset, 
                                                            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize){
        try {
            return new ResponseEntity<>(sp.getCityUsingPagination(offset, pageSize), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCityUsingPagination1")
    public ResponseEntity<List<City>> getCityUsingPagination1(@RequestParam(value = "offset", defaultValue = "1", required = false) Integer offset){
        try {
            return new ResponseEntity<>(sp.getCityUsingPagination1(offset), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sort")
    public ResponseEntity<List<City>> sortCities(){
        try {
            return new ResponseEntity<>(sp.sortCities(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/rangeAndSortCities")
    public ResponseEntity<List<City>> rangeAndSortCities(@RequestParam(value = "start", defaultValue = "1", required = false) Integer start, 
    @RequestParam(value = "end", defaultValue = "10", required = false) Integer end){
        try {
            return new ResponseEntity<>(sp.sortedCitiesInRange(start, end), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/rangeAndSort/{var}")
    public ResponseEntity<List<City>> rangeSortWithVar(@PathVariable(value = "var") String var,
        @RequestParam(value = "start", defaultValue = "1", required = false) Integer start,
    @RequestParam(value = "end", defaultValue = "10", required = false) Integer end){
        try {
            return new ResponseEntity<>(sp.sortedCitiesInRangewithVar(start, end, var), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
