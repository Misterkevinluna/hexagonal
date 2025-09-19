package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.SaveBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.repositories.SaveBody_ModelRepository;

public class SaveBody_UseCaseAdapter implements SaveBody_UseCasePort {
    private final SaveBody_ModelRepository saveBody_modelRepository;

    private SaveBody_UseCaseAdapter(SaveBody_ModelRepository saveBodyModelRepository) {
        saveBody_modelRepository = saveBodyModelRepository;
    }
    public static SaveBody_UseCaseAdapter init(SaveBody_ModelRepository saveBodyModelRepository){
        return new SaveBody_UseCaseAdapter(saveBodyModelRepository);
    }

    @Override
    public Body_Model save(Body_Model body) {
        return saveBody_modelRepository.save(body);
    }
}
