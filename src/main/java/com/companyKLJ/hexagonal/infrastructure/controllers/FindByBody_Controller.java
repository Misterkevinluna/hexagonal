package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.FindByBody_Service;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.infrastructure.repositories.util.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/120021081221/findBy-body/")
public class FindByBody_Controller {

    private final FindByBody_Service findByBody_service;

    public FindByBody_Controller(FindByBody_Service findByBodyService) {
        findByBody_service = findByBodyService;
    }


    @GetMapping("ID/{bodyId}")
    public ResponseEntity<Body_Model> findById(@PathVariable("bodyId") Long bodyId){
        String validacionObjetoHeaderNulo = findByBody_service.findById(bodyId).orElse(null).getIdHeader_Model() == null?
                "-------------------------------------------------------------------------------\n" +
                        "------------------------------------------------\n" +
                        "---------------------------\n" +
                        "-----------------\n" +
                        "\nEL ATRIBUTO idHeader_Model DE LA CLASE Body_Model ES NULO\n" +
                        "\nPOSIBLEMETE EL ID DEL ATRIBUTO idHeader_Model REGISTRADO EN Body_Entity NO SE ENCUENTRA EN Header_Entity"
                : "\n" +
                "-------------------------------------------------------------------------------------\n" +
                "\n----------------------- COINCIDENCIA EXITOSA ----------------------------\n" +
                "\nEL ID DEL ATRIBUTO idHeader_Model DE LA CLASE Body_Entity COINCIDIO CON EL ID DE UN REGISTRO DE LA CLASE Header_Entity";
        System.out.println(validacionObjetoHeaderNulo);
        return findByBody_service.findById(bodyId)
                .map(bodyModel -> new ResponseEntity<>(bodyModel, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
