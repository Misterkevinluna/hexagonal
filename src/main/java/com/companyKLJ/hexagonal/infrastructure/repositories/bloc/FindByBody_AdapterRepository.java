package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.repositories.FindByBody_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.entities.Body_Entity;
import com.companyKLJ.hexagonal.infrastructure.mappers.BodyMapper;
import com.companyKLJ.hexagonal.infrastructure.mappers.HeaderMapper;
import com.companyKLJ.hexagonal.infrastructure.repositories.util.CustomException;
import org.aspectj.bridge.Message;

import javax.swing.*;
import java.util.Optional;

public class FindByBody_AdapterRepository implements FindByBody_ModelRepository {
    private final Body_PortRepositoryJPA body_portRepositoryJPA;
    private Header_PortRepositoryJPA header_PortRepositoryJPA;

    private FindByBody_AdapterRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA, Header_PortRepositoryJPA headerPortRepositoryJPA) {
        body_portRepositoryJPA = bodyPortRepositoryJPA;
        this.header_PortRepositoryJPA = headerPortRepositoryJPA;
    }
    public static FindByBody_AdapterRepository init(Body_PortRepositoryJPA bodyPortRepositoryJPA, Header_PortRepositoryJPA headerPortRepositoryJPA){
        return new FindByBody_AdapterRepository(bodyPortRepositoryJPA, headerPortRepositoryJPA);
    }

    @Override
    public Optional<Body_Model> findById(Long id){
        Body_Model bodyModel = null;
        if (body_portRepositoryJPA.existsById(id)){
            Body_Entity bodyEntity = body_portRepositoryJPA.findById(id).orElse(null);
            bodyModel= BodyMapper.toDomain(bodyEntity);
            if (header_PortRepositoryJPA.existsById(bodyEntity.getIdHeader_Model())){
                Header_Model header = header_PortRepositoryJPA.findById(bodyEntity.getIdHeader_Model()).map(HeaderMapper::toDomain).orElse(null);
                bodyModel.setIdHeader_Model(header);
                return Optional.ofNullable(bodyModel);
            }
            /*else {
                throw CustomException.call("ADVERTENCIA_OBJ0A01", "El objeto Header con el ID: "+ bodyEntity.getIdHeader_Model()+" No existe, por lo tanto el atributo IdHeader_Model de la clase Body sera NULL");
            }*/
        }


        //bodyModel.setIdHeader_Model(header);
        return Optional.ofNullable(bodyModel);
    }
}
