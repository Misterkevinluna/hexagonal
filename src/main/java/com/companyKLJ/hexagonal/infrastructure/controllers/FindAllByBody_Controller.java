package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.FindAllByBody_Service;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/120021081221/findAllBy-body/")
public class FindAllByBody_Controller {

    private final FindAllByBody_Service findAllByBody_service;

    private FindAllByBody_Controller(FindAllByBody_Service findAllByBodyService) {
        findAllByBody_service = findAllByBodyService;
    }


    @GetMapping("idHeader/{idHeader}")
    public ResponseEntity<List<Body_Model>> findAllByidHeader_Model(@PathVariable("idHeader") Long idHeader){
        List<Body_Model> modelList = findAllByBody_service.findAllByidHeader_Model(idHeader);
        return new ResponseEntity<>(modelList, HttpStatus.OK);
    }
}
