package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.repositories.GetAllBody_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.entities.Body_Entity;
import com.companyKLJ.hexagonal.infrastructure.mappers.BodyMapper;
import com.companyKLJ.hexagonal.infrastructure.mappers.HeaderMapper;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllBody_AdapterRepository implements GetAllBody_ModelRepository {
    private final Body_PortRepositoryJPA body_portRepositoryJPA;
    private final Header_PortRepositoryJPA header_portRepositoryJPA;

    private GetAllBody_AdapterRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA, Header_PortRepositoryJPA headerPortRepositoryJPA) {
        body_portRepositoryJPA = bodyPortRepositoryJPA;
        header_portRepositoryJPA = headerPortRepositoryJPA;
    }
    public static GetAllBody_AdapterRepository init(Body_PortRepositoryJPA bodyPortRepositoryJPA, Header_PortRepositoryJPA headerPortRepositoryJPA){
        return new GetAllBody_AdapterRepository(bodyPortRepositoryJPA, headerPortRepositoryJPA);
    }
    @Override
    public List<Body_Model> getAll() {
        List<Body_Entity> listBodyEntity = body_portRepositoryJPA.findAll();
        List<Body_Model> listBody =  listBodyEntity.stream().map(BodyMapper::toDomain).collect(Collectors.toList());
        listBodyEntity.forEach(e ->{
            //int iterador =+1;
            Header_Model validatingExistence =  header_portRepositoryJPA.findById(e.getIdHeader_Model())
                    .map(HeaderMapper::toDomain).orElse(null);
            if (validatingExistence != null){
                listBody.stream().filter(a -> (a.getId() == e.getId())).forEach(c -> c.setIdHeader_Model(validatingExistence));
            }else {
                listBody.stream().filter(a -> (a.getId() == e.getId())).forEach(c -> c.setIdHeader_Model(null));
            }
        });
        //List<Body_Entity> listBodyEntity = body_portRepositoryJPA.findAll();
        //List<Body_Model> listBody = body_portRepositoryJPA.findAll().stream().map(BodyMapper::toDomain).collect(Collectors.toList());
        return listBody;
    }
}
