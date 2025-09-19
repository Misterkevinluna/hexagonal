package com.companyKLJ.hexagonal.infrastructure.controllers;

import com.companyKLJ.hexagonal.application.services.SaveHeader_Service;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.models.enums.ColorsType;
import com.companyKLJ.hexagonal.domain.models.enums.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/120021081221/save-header/")
public class SaveHeader_Controller {

    private final SaveHeader_Service saveHeader_service;

    public SaveHeader_Controller(SaveHeader_Service saveHeaderService) {
        saveHeader_service = saveHeaderService;
    }

    @PostMapping
    public ResponseEntity<Header_Model> save(@RequestBody Header_Model model){

        Header_Model newHeader = saveHeader_service.save(model);
        return new ResponseEntity<>(newHeader, HttpStatus.CREATED);
    }

    /*
        @PostMapping("{typeContent}/{color}/objeto")
    public ResponseEntity<Header_Model> save(@PathVariable("typeContent") String typeContent, @PathVariable("color") String color, @RequestBody Header_Model model){
        System.out.println("-------------------------------------------------------------------------------------------\n" +
                "\n DATOS DE LA VARIABLE typeContent:  "+typeContent+"\n" +
                "\nDATOS DE LA VARIABLE color:  "+color);

        model.setContentTypeEnumByString(typeContent);
        model.setColorsTypeEnumByString(color);
        Header_Model newHeader = saveHeader_service.save(model);
        return new ResponseEntity<>(newHeader, HttpStatus.CREATED);
    }
    * */
}
