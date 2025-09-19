package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.FindByHeader_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.FindByHeader_Service;
import com.companyKLJ.hexagonal.domain.repositories.FindByHeader_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.FindByHeader_AdapterRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Header_PortRepositoryJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindByHeader_Config {

    @Bean
    public FindByHeader_Service findByHeaderService(FindByHeader_ModelRepository findByHeaderModelRepository){
        return FindByHeader_Service.init(FindByHeader_UseCaseAdapter.init(findByHeaderModelRepository));
    }

    @Bean
    public FindByHeader_ModelRepository findByHeaderModelRepository(FindByHeader_AdapterRepository findByHeaderAdapterRepository){
        return findByHeaderAdapterRepository;
    }

    @Bean
    public FindByHeader_AdapterRepository findByHeaderAdapterRepository(Header_PortRepositoryJPA headerPortRepositoryPanache){
        return FindByHeader_AdapterRepository.init(headerPortRepositoryPanache);
    }
}
