package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.GetAllBody_Service;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/120021081221/getAll-body/")
public class GetAllBody_Controller {
    private final GetAllBody_Service getAllBody_service;

    private GetAllBody_Controller(GetAllBody_Service getAllBodyService) {
        getAllBody_service = getAllBodyService;
    }


    @GetMapping
    public ResponseEntity<List<Body_Model>> getAll(){
        List<Body_Model> modelList = getAllBody_service.getAll();
        return new ResponseEntity<>(modelList, HttpStatus.OK);
    }
}
