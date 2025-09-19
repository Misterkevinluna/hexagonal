package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.GetAllHeader_Service;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/120021081221/getAll-header/")
public class GetAllHeader_Controller {

    private final GetAllHeader_Service getAllHeader_service;

    private GetAllHeader_Controller(GetAllHeader_Service getAllHeaderService) {
        getAllHeader_service = getAllHeaderService;
    }

    @GetMapping
    public ResponseEntity<List<Header_Model>> getAll(){
        List<Header_Model> modelList = getAllHeader_service.getAll();
        return new ResponseEntity<>(modelList, HttpStatus.OK);
    }
}
