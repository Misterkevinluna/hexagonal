package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.repositories.DeleteBody_ModelRepository;

public class DeleteBody_AdapteRepository implements DeleteBody_ModelRepository {
    private final Body_PortRepositoryJPA body_portRepositoryJPA;

    private DeleteBody_AdapteRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA) {
        body_portRepositoryJPA = bodyPortRepositoryJPA;
    }
    public static DeleteBody_AdapteRepository init(Body_PortRepositoryJPA bodyPortRepositoryJPA){
        return new DeleteBody_AdapteRepository(bodyPortRepositoryJPA);
    }
    @Override
    public boolean deleteById(Long id) {
        if (body_portRepositoryJPA.existsById(id)){
            body_portRepositoryJPA.deleteById(id);
            return true;
        }
        return false;
    }
}
