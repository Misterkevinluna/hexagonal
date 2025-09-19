package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.repositories.UpdateBody_ModelRepository;

import java.util.Optional;

public class UpdateBody_AdapterRepository implements UpdateBody_ModelRepository {
    private final Body_PortRepositoryJPA body_portRepositoryJPA;
    private final SaveBody_AdapterRepository saveBody_adapterRepository;

    private UpdateBody_AdapterRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA, SaveBody_AdapterRepository saveBodyAdapterRepository) {
        body_portRepositoryJPA = bodyPortRepositoryJPA;
        saveBody_adapterRepository = saveBodyAdapterRepository;
    }

    public static UpdateBody_AdapterRepository init(Body_PortRepositoryJPA bodyPortRepositoryJPA, SaveBody_AdapterRepository saveBodyAdapterRepository){
        return new UpdateBody_AdapterRepository(bodyPortRepositoryJPA, saveBodyAdapterRepository);
    }

    @Override
    public Optional<Body_Model> update(Body_Model body) {
        if (body_portRepositoryJPA.existsById(body.getId())){
            Body_Model objectUpdate = saveBody_adapterRepository.save(body);
            return Optional.of(objectUpdate);
        }
        return Optional.empty();
    }
}
