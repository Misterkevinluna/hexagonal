package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.FindAllByBody_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.FindAllByBody_Service;
import com.companyKLJ.hexagonal.domain.repositories.FindAllByBody_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Body_PortRepositoryJPA;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.FindAllByBody_AdapterRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.FindByHeader_AdapterRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllByBody_Config {

    @Bean
    public FindAllByBody_Service findAllByBody_service(@Qualifier("findAllByBody_modelRepository") FindAllByBody_ModelRepository findAllByBodyModelRepository){
        return FindAllByBody_Service.init(FindAllByBody_UseCaseAdapter.init(findAllByBodyModelRepository));
    }
    @Bean
    public FindAllByBody_ModelRepository findAllByBody_modelRepository(FindAllByBody_AdapterRepository findAllByBodyAdapterRepository){
        return findAllByBodyAdapterRepository;
    }

    @Bean
    public FindAllByBody_AdapterRepository findAllByBody_adapterRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA, FindByHeader_AdapterRepository findByHeaderAdapterRepository){
        return FindAllByBody_AdapterRepository.init(bodyPortRepositoryJPA, findByHeaderAdapterRepository);
    }
}
