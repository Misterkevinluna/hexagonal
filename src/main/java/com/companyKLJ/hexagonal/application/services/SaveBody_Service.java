package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.SaveBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Body_Model;

public class SaveBody_Service implements SaveBody_UseCasePort {
    private final SaveBody_UseCasePort saveBody_useCasePort;

    private SaveBody_Service(SaveBody_UseCasePort saveBodyUseCasePort) {
        saveBody_useCasePort = saveBodyUseCasePort;
    }
    public static SaveBody_Service init(SaveBody_UseCasePort saveBodyUseCasePort){
        return new SaveBody_Service(saveBodyUseCasePort);
    }
    @Override
    public Body_Model save(Body_Model body) {
        return saveBody_useCasePort.save(body);
    }
}
