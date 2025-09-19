package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.GetAllBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.repositories.GetAllBody_ModelRepository;

import java.util.List;

public class GetAllBody_UseCaseAdapter implements GetAllBody_UseCasePort {
    private final GetAllBody_ModelRepository getAllBody_modelRepository;

    private GetAllBody_UseCaseAdapter(GetAllBody_ModelRepository getAllBodyModelRepository) {
        getAllBody_modelRepository = getAllBodyModelRepository;
    }
    public static GetAllBody_UseCaseAdapter init(GetAllBody_ModelRepository getAllBodyModelRepository){
        return new GetAllBody_UseCaseAdapter(getAllBodyModelRepository);
    }
    @Override
    public List<Body_Model> getAll() {
        return getAllBody_modelRepository.getAll();
    }
}
