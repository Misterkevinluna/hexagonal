package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.FindByBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.infrastructure.repositories.util.CustomException;

import java.util.Optional;

public class FindByBody_Service implements FindByBody_UseCasePort {
    private final FindByBody_UseCasePort findByBody_useCasePort;

    private FindByBody_Service(FindByBody_UseCasePort findByBodyUseCasePort) {
        findByBody_useCasePort = findByBodyUseCasePort;
    }
    public static FindByBody_Service init(FindByBody_UseCasePort findByBodyUseCasePort){
        return new FindByBody_Service(findByBodyUseCasePort);
    }
    @Override
    public Optional<Body_Model> findById(Long id){
        return findByBody_useCasePort.findById(id);
    }
}
