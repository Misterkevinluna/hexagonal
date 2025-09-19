package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.DeleteBody_Service;
import com.companyKLJ.hexagonal.application.services.DeleteHeader_Service;
import com.companyKLJ.hexagonal.application.services.FindByBody_Service;
import com.companyKLJ.hexagonal.application.services.FindByHeader_Service;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/120021081221/deleteBy-body/")
public class DeleteBody_Controller {

    private final DeleteBody_Service deleteBody_service;
    private final FindByBody_Service findByBody_service;


    private DeleteBody_Controller(DeleteBody_Service deleteBodyService, FindByBody_Service findByBodyService) {
        deleteBody_service = deleteBodyService;
        findByBody_service = findByBodyService;
    }

    @DeleteMapping("ID/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        Body_Model eliminacion;
        if (findByBody_service.findById(id).isPresent()) {
            deleteBody_service.deleteById(id);
            eliminacion = findByBody_service.findById(id).orElse(null);
            return ResponseEntity.ok(eliminacion == null);
        }
        return ResponseEntity.notFound().build();
    }
}
