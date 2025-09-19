package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.UpdateHeader_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.UpdateHeader_Service;
import com.companyKLJ.hexagonal.domain.repositories.UpdateHeader_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Header_PortRepositoryJPA;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.SaveHeader_AdapterRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.UpdateHeader_AdapterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateHeader_Config {

    @Bean
    public UpdateHeader_Service updateHeaderService(UpdateHeader_ModelRepository updateHeaderModelRepository){
        return UpdateHeader_Service.init(UpdateHeader_UseCaseAdapter.init(updateHeaderModelRepository));
    }

    @Bean
    public UpdateHeader_ModelRepository updateHeaderModelRepository(UpdateHeader_AdapterRepository updateHeaderAdapterRepository){
        return updateHeaderAdapterRepository;
    }

    @Bean
    public UpdateHeader_AdapterRepository updateHeaderAdapterRepository(Header_PortRepositoryJPA headerPortRepositoryPanache, SaveHeader_AdapterRepository saveHeaderAdapterRepository){
        return UpdateHeader_AdapterRepository.init(headerPortRepositoryPanache, saveHeaderAdapterRepository);
    }

}
