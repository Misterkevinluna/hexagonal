package com.companyKLJ.hexagonal.application.adapters;

import com.companyKLJ.hexagonal.application.ports.DeleteHeader_UseCasePort;
import com.companyKLJ.hexagonal.domain.repositories.DeleteHeader_ModelRepository;

public class DeleteHeader_UseCaseAdapter implements DeleteHeader_UseCasePort {
    private final DeleteHeader_ModelRepository deleteHeader_modelRepository;

    private DeleteHeader_UseCaseAdapter(DeleteHeader_ModelRepository deleteHeaderModelRepository) {
        deleteHeader_modelRepository = deleteHeaderModelRepository;
    }
    public static DeleteHeader_UseCaseAdapter init(DeleteHeader_ModelRepository deleteHeaderModelRepository){
        return new DeleteHeader_UseCaseAdapter(deleteHeaderModelRepository);
    }
    @Override
    public boolean delete(Long id) {
        return deleteHeader_modelRepository.delete(id);
    }

    /*@Override
    public boolean deleteNoReference(String noReference) {
        return false;
    }*/
}
