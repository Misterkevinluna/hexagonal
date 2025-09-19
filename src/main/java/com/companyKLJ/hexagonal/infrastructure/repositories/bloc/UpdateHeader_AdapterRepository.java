package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.repositories.UpdateHeader_ModelRepository;


import java.util.Optional;

public class UpdateHeader_AdapterRepository implements UpdateHeader_ModelRepository {
    private final Header_PortRepositoryJPA header_portRepositoryPanache;
    private final SaveHeader_AdapterRepository saveHeader_adapterRepository;

    private UpdateHeader_AdapterRepository(Header_PortRepositoryJPA headerPortRepositoryPanache, SaveHeader_AdapterRepository saveHeaderAdapterRepository) {
        header_portRepositoryPanache = headerPortRepositoryPanache;
        saveHeader_adapterRepository = saveHeaderAdapterRepository;
    }

    public static UpdateHeader_AdapterRepository init(Header_PortRepositoryJPA headerPortRepositoryPanache, SaveHeader_AdapterRepository saveHeaderAdapterRepository){
        return new UpdateHeader_AdapterRepository(headerPortRepositoryPanache, saveHeaderAdapterRepository);
    }

    @Override
    public Optional<Header_Model> update(Header_Model header){
        if (header_portRepositoryPanache.existsById(header.getId())){
            Header_Model objectUpdated = saveHeader_adapterRepository.save(header);
            return Optional.of(objectUpdated);
        }
        return Optional.empty();
    }
}
