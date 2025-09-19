package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.FindByHeader_Service;
import com.companyKLJ.hexagonal.application.services.UpdateHeader_Service;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/120021081221/update-header/")
public class UpdateHeader_Controller {
    private final UpdateHeader_Service updateHeader_service;

    private UpdateHeader_Controller(UpdateHeader_Service updateHeaderService) {
        updateHeader_service = updateHeaderService;
    }

    @PutMapping
    public ResponseEntity<Header_Model> update(@RequestBody Header_Model headerModel){
        Optional<Header_Model> validatingInput = Optional.ofNullable(headerModel);
        if (validatingInput.isPresent()){
            return updateHeader_service.update(headerModel).map(model -> new ResponseEntity<>(model, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
        @PutMapping("{typeContent}/{color}/objeto")
    public ResponseEntity<Header_Model> update(@PathVariable("typeContent") String typeContent, @PathVariable("color") String color, @RequestBody Header_Model headerModel){
        java.util.Optional<Header_Model> validatingInput = Optional.ofNullable(headerModel);
        if (validatingInput.isPresent()){
            headerModel.setContentTypeEnumByString(typeContent);
            headerModel.setColorsTypeEnumByString(color);
            return updateHeader_service.update(headerModel).map(model -> new ResponseEntity<>(model, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    * */
}
