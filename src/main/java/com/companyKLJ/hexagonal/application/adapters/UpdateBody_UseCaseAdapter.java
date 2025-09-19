package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.UpdateBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.repositories.UpdateBody_ModelRepository;

import java.util.Optional;

public class UpdateBody_UseCaseAdapter implements UpdateBody_UseCasePort {
    private final UpdateBody_ModelRepository updateBody_modelRepository;

    private UpdateBody_UseCaseAdapter(UpdateBody_ModelRepository updateBodyModelRepository) {
        updateBody_modelRepository = updateBodyModelRepository;
    }

    public static UpdateBody_UseCaseAdapter init(UpdateBody_ModelRepository updateBodyModelRepository){
        return new UpdateBody_UseCaseAdapter(updateBodyModelRepository);
    }

    @Override
    public Optional<Body_Model> update(Body_Model body) {
        return updateBody_modelRepository.update(body);
    }
}
