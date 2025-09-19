package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.FindByHeader_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.repositories.FindByHeader_ModelRepository;

import java.util.Optional;

public class FindByHeader_UseCaseAdapter implements FindByHeader_UseCasePort {
    private final FindByHeader_ModelRepository findByHeader_modelRepository;

    private FindByHeader_UseCaseAdapter(FindByHeader_ModelRepository findByHeaderModelRepository) {
        findByHeader_modelRepository = findByHeaderModelRepository;
    }

    public static FindByHeader_UseCaseAdapter init(FindByHeader_ModelRepository findByHeaderModelRepository){
        return new FindByHeader_UseCaseAdapter(findByHeaderModelRepository);
    }

    @Override
    public Optional<Header_Model> findById(Long id) {
        return findByHeader_modelRepository.findById(id);
    }
}
