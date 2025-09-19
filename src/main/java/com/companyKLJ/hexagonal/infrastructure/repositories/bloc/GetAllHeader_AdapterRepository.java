package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.repositories.GetAllHeader_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.entities.Header_Entity;
import com.companyKLJ.hexagonal.infrastructure.mappers.HeaderMapper;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllHeader_AdapterRepository implements GetAllHeader_ModelRepository {
    private final Header_PortRepositoryJPA header_portRepositoryJPA;

    private GetAllHeader_AdapterRepository(Header_PortRepositoryJPA headerPortRepositoryJPA) {
        header_portRepositoryJPA = headerPortRepositoryJPA;
    }

    public static GetAllHeader_AdapterRepository init(Header_PortRepositoryJPA headerPortRepositoryJPA){
        return new GetAllHeader_AdapterRepository(headerPortRepositoryJPA);
    }
    @Override
    public List<Header_Model> getAll() {
        List<Header_Model> listModel = header_portRepositoryJPA.findAll().stream().map(HeaderMapper::toDomain)
                .collect(Collectors.toList());
        System.out.println("TAMAÑO LISTA: "+listModel.size());
        return listModel;
    }
}
