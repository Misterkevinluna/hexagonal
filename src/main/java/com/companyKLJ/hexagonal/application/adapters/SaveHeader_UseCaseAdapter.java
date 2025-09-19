package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.SaveHeader_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.repositories.SaveHeader_ModelRepository;

public class SaveHeader_UseCaseAdapter implements SaveHeader_UseCasePort {
    private final SaveHeader_ModelRepository saveHeader_modelRepository;

    public SaveHeader_UseCaseAdapter(SaveHeader_ModelRepository saveHeaderModelRepository) {
        saveHeader_modelRepository = saveHeaderModelRepository;
    }
    public static SaveHeader_UseCaseAdapter init(SaveHeader_ModelRepository saveHeaderModelRepository){
        return new SaveHeader_UseCaseAdapter(saveHeaderModelRepository);
    }

    @Override
    public Header_Model save(Header_Model header) {
        return saveHeader_modelRepository.save(header);
    }
}
