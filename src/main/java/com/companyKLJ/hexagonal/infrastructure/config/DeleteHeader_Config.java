package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.DeleteHeader_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.DeleteHeader_Service;
import com.companyKLJ.hexagonal.domain.repositories.DeleteHeader_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.DeleteHeader_AdapterRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Header_PortRepositoryJPA;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteHeader_Config {

    @Bean
    public DeleteHeader_Service deleteHeaderService(@Qualifier("deleteHeaderModelRepository")DeleteHeader_ModelRepository deleteHeader_modelRepository) {
        return DeleteHeader_Service.init(DeleteHeader_UseCaseAdapter.init(deleteHeader_modelRepository));
    }

    @Bean
    public DeleteHeader_ModelRepository deleteHeaderModelRepository(DeleteHeader_AdapterRepository deleteHeaderAdapterRepository){
        return deleteHeaderAdapterRepository;
    }

    @Bean
    public DeleteHeader_AdapterRepository deleteHeaderAdapterRepository(Header_PortRepositoryJPA headerPortRepositoryPanache){
        return DeleteHeader_AdapterRepository.init(headerPortRepositoryPanache);
    }
}
