package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.SaveHeader_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import org.springframework.stereotype.Service;

@Service
public class SaveHeader_Service implements SaveHeader_UseCasePort {
    private final SaveHeader_UseCasePort saveHeader_useCasePort;

    private SaveHeader_Service(SaveHeader_UseCasePort saveHeaderUseCasePort) {
        saveHeader_useCasePort = saveHeaderUseCasePort;
    }
    public static SaveHeader_Service init(SaveHeader_UseCasePort saveHeaderUseCasePort){
        return new SaveHeader_Service(saveHeaderUseCasePort);
    }

    @Override
    public Header_Model save(Header_Model header) {
        return saveHeader_useCasePort.save(header);
    }
}
