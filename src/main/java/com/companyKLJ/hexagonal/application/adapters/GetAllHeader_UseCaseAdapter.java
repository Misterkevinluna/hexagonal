package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.GetAllHeader_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.repositories.GetAllHeader_ModelRepository;

import java.util.List;

public class GetAllHeader_UseCaseAdapter implements GetAllHeader_UseCasePort {
    private final GetAllHeader_ModelRepository getAllHeader_modelRepository;

    private GetAllHeader_UseCaseAdapter(GetAllHeader_ModelRepository getAllHeaderModelRepository) {
        getAllHeader_modelRepository = getAllHeaderModelRepository;
    }
    public static GetAllHeader_UseCaseAdapter init(GetAllHeader_ModelRepository getAllHeaderModelRepository){
        return new GetAllHeader_UseCaseAdapter(getAllHeaderModelRepository);
    }
    @Override
    public List<Header_Model> getAll() {
        return getAllHeader_modelRepository.getAll();
    }
}
