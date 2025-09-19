package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.DeleteHeader_Service;
import com.companyKLJ.hexagonal.application.services.FindByHeader_Service;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/120021081221/deleteBy-header/")
public class DeleteHeader_Controller {

    private final DeleteHeader_Service deleteHeader_service;
    private final FindByHeader_Service findByHeader_service;

    public DeleteHeader_Controller(DeleteHeader_Service deleteHeaderService, FindByHeader_Service findByHeaderService) {
        deleteHeader_service = deleteHeaderService;
        findByHeader_service = findByHeaderService;
    }


    @DeleteMapping("ID/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id){
        Header_Model eliminacion;
        if (findByHeader_service.findById(id).isPresent()){
            deleteHeader_service.delete(id);
            eliminacion = findByHeader_service.findById(id).orElse(null);
            return ResponseEntity.ok(eliminacion == null);
        }
        return ResponseEntity.notFound().build();
    }
}
