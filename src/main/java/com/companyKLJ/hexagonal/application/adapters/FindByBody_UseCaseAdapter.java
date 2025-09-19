package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.FindByBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.repositories.FindByBody_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.util.CustomException;

import java.util.Optional;

public class FindByBody_UseCaseAdapter implements FindByBody_UseCasePort {
    private final FindByBody_ModelRepository findByBody_modelRepository;

    private FindByBody_UseCaseAdapter(FindByBody_ModelRepository findByBodyModelRepository) {
        findByBody_modelRepository = findByBodyModelRepository;
    }
    public static FindByBody_UseCaseAdapter init(FindByBody_ModelRepository findByBodyModelRepository){
        return new FindByBody_UseCaseAdapter(findByBodyModelRepository);
    }

    @Override
    public Optional<Body_Model> findById(Long id){
        return findByBody_modelRepository.findById(id);
    }
}
