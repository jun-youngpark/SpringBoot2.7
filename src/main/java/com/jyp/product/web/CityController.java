package com.jyp.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                                .state(city.getState()).build()
        );

        return new ResponseEntity<>(HttpStatus.OK);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        List<City> list= cityService.get(id);
        System.out.println(list);
        return new ResponseEntity<List<City>>(list,HttpStatus.OK);
    }

}
