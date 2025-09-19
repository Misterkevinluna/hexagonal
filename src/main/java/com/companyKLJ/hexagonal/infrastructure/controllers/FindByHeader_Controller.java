package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.FindByHeader_Service;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/120021081221/findBy-header/")
public class FindByHeader_Controller {

    private final FindByHeader_Service findByHeader_service;

    public FindByHeader_Controller(FindByHeader_Service findByHeaderService) {
        findByHeader_service = findByHeaderService;
    }

    @GetMapping("ID/{headerId}")
    public ResponseEntity<Header_Model> findById(@PathVariable("headerId") Long headerId){
        return findByHeader_service.findById(headerId)
                .map(headerModel -> new ResponseEntity<>(headerModel, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
