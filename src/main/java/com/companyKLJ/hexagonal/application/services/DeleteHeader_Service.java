package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.DeleteHeader_UseCasePort;

public class DeleteHeader_Service implements DeleteHeader_UseCasePort {
    private final DeleteHeader_UseCasePort deleteHeader_useCasePort;

    private DeleteHeader_Service(DeleteHeader_UseCasePort deleteHeaderUseCasePort) {
        deleteHeader_useCasePort = deleteHeaderUseCasePort;
    }
    public static DeleteHeader_Service init(DeleteHeader_UseCasePort deleteHeaderUseCasePort){
        return new DeleteHeader_Service(deleteHeaderUseCasePort);
    }
    @Override
    public boolean delete(Long id) {
        return deleteHeader_useCasePort.delete(id);
    }

    /*@Override
    public boolean deleteNoReference(String noReference) {
        return false;
    }*/
}
