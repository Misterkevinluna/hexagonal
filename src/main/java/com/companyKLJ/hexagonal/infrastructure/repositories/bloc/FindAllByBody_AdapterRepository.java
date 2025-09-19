package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.repositories.FindAllByBody_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.entities.Body_Entity;
import com.companyKLJ.hexagonal.infrastructure.mappers.BodyMapper;
import com.companyKLJ.hexagonal.infrastructure.mappers.HeaderMapper;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllByBody_AdapterRepository implements FindAllByBody_ModelRepository {
    private final Body_PortRepositoryJPA body_portRepositoryJPA;
    private final FindByHeader_AdapterRepository findByHeader_adapterRepository;

    public FindAllByBody_AdapterRepository(Body_PortRepositoryJPA body_portRepositoryJPA, FindByHeader_AdapterRepository findByHeader_adapterRepository) {
        this.body_portRepositoryJPA = body_portRepositoryJPA;
        this.findByHeader_adapterRepository = findByHeader_adapterRepository;
    }

    public static FindAllByBody_AdapterRepository init(Body_PortRepositoryJPA bodyPortRepositoryJPA, FindByHeader_AdapterRepository findByHeaderAdapterRepository){
        return new FindAllByBody_AdapterRepository(bodyPortRepositoryJPA, findByHeaderAdapterRepository);
    }

    @Override
    public List<Body_Model> findAllByidHeader_Model(Long idHeader) {
        List<Body_Entity> listBodyEntity = body_portRepositoryJPA.findAllByidHeader_Model(idHeader);
        List<Body_Model> listBody =  listBodyEntity.stream().map(BodyMapper::toDomain).collect(Collectors.toList());
        listBodyEntity.forEach(e ->{
            Header_Model validatingExistence =  findByHeader_adapterRepository.findById(e.getIdHeader_Model())
                    .orElse(null);
            if (validatingExistence != null){
                listBody.stream().forEach(c -> c.setIdHeader_Model(validatingExistence));
            }else {
                listBody.stream().forEach(c -> c.setIdHeader_Model(null));
            }
        });
        //List<Body_Entity> listBodyEntity = body_portRepositoryJPA.findAll();
        //List<Body_Model> listBody = body_portRepositoryJPA.findAll().stream().map(BodyMapper::toDomain).collect(Collectors.toList());
        return listBody;
    }
}
