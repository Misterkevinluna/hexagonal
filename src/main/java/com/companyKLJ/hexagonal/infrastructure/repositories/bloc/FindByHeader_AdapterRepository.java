package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.repositories.FindByHeader_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.mappers.HeaderMapper;

import java.util.Optional;

public class FindByHeader_AdapterRepository implements FindByHeader_ModelRepository {
    private Header_PortRepositoryJPA header_portRepositoryPanache;

    public FindByHeader_AdapterRepository() {
    }

    private FindByHeader_AdapterRepository(Header_PortRepositoryJPA headerPortRepositoryPanache) {
        header_portRepositoryPanache = headerPortRepositoryPanache;
    }

    public static FindByHeader_AdapterRepository init(Header_PortRepositoryJPA headerPortRepositoryPanache){
        return new FindByHeader_AdapterRepository(headerPortRepositoryPanache);
    }
    public static FindByHeader_AdapterRepository init(){
        return new FindByHeader_AdapterRepository();
    }

    @Override
    public Optional<Header_Model> findById(Long id) {

        return header_portRepositoryPanache.findById(id).map(HeaderMapper::toDomain);
    }
}
