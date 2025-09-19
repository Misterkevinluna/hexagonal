package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.DeleteBody_UseCasePort;

public class DeleteBody_Service implements DeleteBody_UseCasePort {
    private final DeleteBody_UseCasePort deleteBody_useCasePort;

    private DeleteBody_Service(DeleteBody_UseCasePort deleteBodyUseCasePort) {
        deleteBody_useCasePort = deleteBodyUseCasePort;
    }
    public static DeleteBody_Service init(DeleteBody_UseCasePort deleteBodyUseCasePort){
        return new DeleteBody_Service(deleteBodyUseCasePort);
    }
    @Override
    public boolean deleteById(Long id) {
        return deleteBody_useCasePort.deleteById(id);
    }
}
