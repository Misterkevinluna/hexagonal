package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.GetAllBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Body_Model;

import java.util.List;

public class GetAllBody_Service implements GetAllBody_UseCasePort {
    private final GetAllBody_UseCasePort getAllBodyUseCasePort;

    private GetAllBody_Service(GetAllBody_UseCasePort getAllBodyUseCasePort) {
        this.getAllBodyUseCasePort = getAllBodyUseCasePort;
    }
    public static GetAllBody_Service init(GetAllBody_UseCasePort getAllBodyUseCasePort){
        return new GetAllBody_Service(getAllBodyUseCasePort);
    }
    @Override
    public List<Body_Model> getAll() {
        return getAllBodyUseCasePort.getAll();
    }
}
