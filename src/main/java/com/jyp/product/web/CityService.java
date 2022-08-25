package com.jyp.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService  {
    @Autowired
    private CityRepository cityRepository;
    public void save(City city){
        cityRepository.save(city);
    }
    public List<City> get(Integer id){
        return cityRepository.findAllById(id);
    }

}


