package com.jyp.product.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


    @Builder
    @Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    public class City implements Serializable {

        @Id
        @GeneratedValue
        private Integer id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String state;


    }



