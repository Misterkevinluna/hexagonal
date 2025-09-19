package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.UpdateBody_Service;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/120021081221/update-body/")
public class UpdateBody_Controller {

    private final UpdateBody_Service updateBody_service;

    private UpdateBody_Controller(UpdateBody_Service updateBodyService) {
        updateBody_service = updateBodyService;
    }

    @PutMapping
    public ResponseEntity<Body_Model> update(@RequestBody Body_Model bodyModel){
        Optional<Body_Model> validatingInput = Optional.ofNullable(bodyModel);
        if (validatingInput.isPresent()){
            return updateBody_service.update(bodyModel).map(model -> new ResponseEntity<>(model, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
