package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.UpdateHeader_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.repositories.UpdateHeader_ModelRepository;

import java.util.Optional;

public class UpdateHeader_UseCaseAdapter implements UpdateHeader_UseCasePort {
    private final UpdateHeader_ModelRepository updateHeader_modelRepository;

    private UpdateHeader_UseCaseAdapter(UpdateHeader_ModelRepository updateHeaderModelRepository) {
        updateHeader_modelRepository = updateHeaderModelRepository;
    }

    public static UpdateHeader_UseCaseAdapter init(UpdateHeader_ModelRepository updateHeaderModelRepository){
        return new UpdateHeader_UseCaseAdapter(updateHeaderModelRepository);
    }

    @Override
    public Optional<Header_Model> update(Header_Model header) {
        return updateHeader_modelRepository.update(header);
    }
}
