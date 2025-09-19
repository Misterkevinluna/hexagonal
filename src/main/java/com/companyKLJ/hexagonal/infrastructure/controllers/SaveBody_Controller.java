package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.SaveBody_Service;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/120021081221/save-body/")
public class SaveBody_Controller {

    private final SaveBody_Service saveBody_service;

    public SaveBody_Controller(SaveBody_Service saveBodyService) {
        saveBody_service = saveBodyService;
    }

    @PostMapping
    public ResponseEntity<Body_Model> save(@RequestBody Body_Model body){
        System.out.println("-------------------------------------------------------------------------------------------\n" +
                "\n DATOS DE LA VARIABLE typeContent DESDE EL OBJETO BODY:  "+body.getIdHeader_Model().getContentTypeEnum().name()+"\n" +
                "\nDATOS DE LA VARIABLE color DESDE EL OBJETO BODY:  "+body.getIdHeader_Model().getColorsTypeEnum().name());

        Body_Model newBody = saveBody_service.save(body);
        return new ResponseEntity<>(newBody, HttpStatus.CREATED);
    }
}
