package com.companyKLJ.hexagonal.application.services;

import com.companyKLJ.hexagonal.application.ports.GetAllHeader_UseCasePort;
import com.companyKLJ.hexagonal.domain.models.Header_Model;

import java.util.List;

public class GetAllHeader_Service implements GetAllHeader_UseCasePort {
    private final GetAllHeader_UseCasePort getAllHeader_useCasePort;

    private GetAllHeader_Service(GetAllHeader_UseCasePort getAllHeaderUseCasePort) {
        getAllHeader_useCasePort = getAllHeaderUseCasePort;
    }
    public static GetAllHeader_Service init(GetAllHeader_UseCasePort getAllHeaderUseCasePort){
        return new GetAllHeader_Service(getAllHeaderUseCasePort);
    }
    @Override
    public List<Header_Model> getAll() {
        return getAllHeader_useCasePort.getAll();
    }
}
