package com.jyp.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody City city) {
        cityService.save(City.builder()
                                .name(city.getName())
                                .state("R").build()
        );

        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PostMapping("/get/")
    public ResponseEntity<?> get(@RequestBody City city) {
        List<City> list= cityService.get(city.getId());
        return new ResponseEntity<List<City>>(list,HttpStatus.OK);
    }

}
