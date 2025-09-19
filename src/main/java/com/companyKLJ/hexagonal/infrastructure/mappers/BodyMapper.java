package com.companyKLJ.hexagonal.infrastructure.mappers;

import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.infrastructure.entities.Body_Entity;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Body_PortRepositoryJPA;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.FindByHeader_AdapterRepository;

public class BodyMapper {
   //private static Body_PortRepositoryJPA bo;
    public static Body_Model toDomain(Body_Entity entity){
        System.out.println(" ESTA ENTR5ANDO AL MAPPER ----------------------------------------");

        //Header_Model header = FindByHeader_AdapterRepository.init().findById(entity.getIdHeader_Model()).orElse(null);
        /*System.out.println("---------------------------------------------------------------\n" +
                "----------------------------------------------------------------------\n" +
                "VALOR DEL ID: "+ header.getTitleNote() + "DEL OBJETO HEADER DE LA CLASE ENTITY BODY");*/
        return Body_Model.init(entity.getId(), null, entity.getBodyNote(), entity.getNoReference()
        , entity.getCrationDate(), entity.getCrationTime(), entity.getCreationLocalDateTime());
    }
}
