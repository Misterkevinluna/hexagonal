package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.DeleteBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.repositories.DeleteBody_ModelRepository;

public class DeleteBody_UseCaseAdapter implements DeleteBody_UseCasePort {
    private final DeleteBody_ModelRepository deleteBody_modelRepository;

    private DeleteBody_UseCaseAdapter(DeleteBody_ModelRepository deleteBodyModelRepository) {
        deleteBody_modelRepository = deleteBodyModelRepository;
    }
    public static DeleteBody_UseCaseAdapter init(DeleteBody_ModelRepository deleteBodyModelRepository){
        return new DeleteBody_UseCaseAdapter(deleteBodyModelRepository);
    }
    @Override
    public boolean deleteById(Long id) {
        return deleteBody_modelRepository.deleteById(id);
    }
}
