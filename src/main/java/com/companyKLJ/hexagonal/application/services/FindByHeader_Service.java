package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.FindByHeader_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Header_Model;

import java.util.Optional;

public class FindByHeader_Service implements FindByHeader_UseCasePort {
    private final FindByHeader_UseCasePort findByHeader_useCasePort;

    private FindByHeader_Service(FindByHeader_UseCasePort findByHeaderUseCasePort) {
        findByHeader_useCasePort = findByHeaderUseCasePort;
    }
    public static FindByHeader_Service init(FindByHeader_UseCasePort findByHeaderUseCasePort){
        return new FindByHeader_Service(findByHeaderUseCasePort);
    }

    @Override
    public Optional<Header_Model> findById(Long id) {
        return findByHeader_useCasePort.findById(id);
    }
}
