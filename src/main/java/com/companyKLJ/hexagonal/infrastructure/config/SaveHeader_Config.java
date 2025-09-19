package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.SaveHeader_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.SaveHeader_Service;
import com.companyKLJ.hexagonal.domain.repositories.SaveHeader_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Header_PortRepositoryJPA;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.SaveHeader_AdapterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveHeader_Config {
    @Bean
    public SaveHeader_Service saveHeaderService(SaveHeader_ModelRepository saveHeaderModelRepository){
        return SaveHeader_Service.init(SaveHeader_UseCaseAdapter.init(saveHeaderModelRepository));
    }

    @Bean
    public SaveHeader_ModelRepository saveHeaderModelRepository(SaveHeader_AdapterRepository saveHeaderAdapterRepository){
        return saveHeaderAdapterRepository;
    }

    @Bean
    public SaveHeader_AdapterRepository saveHeaderAdapterRepository(Header_PortRepositoryJPA headerPortRepositoryPanache){
        return SaveHeader_AdapterRepository.init(headerPortRepositoryPanache);
    }
}
