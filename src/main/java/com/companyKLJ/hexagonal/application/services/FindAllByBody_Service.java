package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.FindAllByBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Body_Model;

import java.util.List;

public class FindAllByBody_Service implements FindAllByBody_UseCasePort {
    private final FindAllByBody_UseCasePort findAllByBody_useCasePort;

    private FindAllByBody_Service(FindAllByBody_UseCasePort findAllByBodyUseCasePort) {
        findAllByBody_useCasePort = findAllByBodyUseCasePort;
    }

    public static FindAllByBody_Service init(FindAllByBody_UseCasePort findAllByBodyUseCasePort){
        return new FindAllByBody_Service(findAllByBodyUseCasePort);
    }

    @Override
    public List<Body_Model> findAllByidHeader_Model(Long idHeader) {
        return findAllByBody_useCasePort.findAllByidHeader_Model(idHeader);
    }
}
