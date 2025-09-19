package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.UpdateBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Body_Model;

import java.util.Optional;

public class UpdateBody_Service implements UpdateBody_UseCasePort {
    private final UpdateBody_UseCasePort updateBody_useCasePort;

    private UpdateBody_Service(UpdateBody_UseCasePort updateBodyUseCasePort) {
        updateBody_useCasePort = updateBodyUseCasePort;
    }

    public static UpdateBody_Service init(UpdateBody_UseCasePort updateBodyUseCasePort){
        return new UpdateBody_Service(updateBodyUseCasePort);
    }

    @Override
    public Optional<Body_Model> update(Body_Model body) {
        return updateBody_useCasePort.update(body);
    }
}
