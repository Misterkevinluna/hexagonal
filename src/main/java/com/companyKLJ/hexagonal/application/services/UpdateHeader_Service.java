package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.UpdateHeader_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Header_Model;

import java.util.Optional;

public class UpdateHeader_Service implements UpdateHeader_UseCasePort {
    private final UpdateHeader_UseCasePort updateHeader_useCasePort;

    private UpdateHeader_Service(UpdateHeader_UseCasePort updateHeaderUseCasePort) {
        updateHeader_useCasePort = updateHeaderUseCasePort;
    }

    public static  UpdateHeader_Service init(UpdateHeader_UseCasePort updateHeaderUseCasePort){
        return new UpdateHeader_Service(updateHeaderUseCasePort);
    }

    @Override
    public Optional<Header_Model> update(Header_Model header) {
        return updateHeader_useCasePort.update(header);
    }
}
