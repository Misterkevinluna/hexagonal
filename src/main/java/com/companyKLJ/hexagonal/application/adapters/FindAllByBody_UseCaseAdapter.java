package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.FindAllByBody_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.repositories.FindAllByBody_ModelRepository;

import java.util.List;

public class FindAllByBody_UseCaseAdapter implements FindAllByBody_UseCasePort {
    private final FindAllByBody_ModelRepository findAllByBody_modelRepository;

    private FindAllByBody_UseCaseAdapter(FindAllByBody_ModelRepository findAllByBodyModelRepository) {
        findAllByBody_modelRepository = findAllByBodyModelRepository;
    }

    public static FindAllByBody_UseCaseAdapter init(FindAllByBody_ModelRepository findAllByBodyModelRepository){
        return new FindAllByBody_UseCaseAdapter(findAllByBodyModelRepository);
    }

    @Override
    public List<Body_Model> findAllByidHeader_Model(Long idHeader) {
        return findAllByBody_modelRepository.findAllByidHeader_Model(idHeader);
    }
}
