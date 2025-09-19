package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.FindByBody_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.FindByBody_Service;
import com.companyKLJ.hexagonal.domain.repositories.FindByBody_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Body_PortRepositoryJPA;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.FindByBody_AdapterRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Header_PortRepositoryJPA;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindByBody_Config {

    @Bean
    public FindByBody_Service findByBodyService(@Qualifier("findByBody_modelRepository") FindByBody_ModelRepository findByBody_modelRepository){
        return FindByBody_Service.init(FindByBody_UseCaseAdapter.init(findByBody_modelRepository));
    }

    @Bean
    public FindByBody_ModelRepository findByBody_modelRepository(FindByBody_AdapterRepository findByBodyAdapterRepository){
        return findByBodyAdapterRepository;
    }

    @Bean
    public FindByBody_AdapterRepository findByBody_adapterRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA, Header_PortRepositoryJPA headerPortRepositoryJPA){
        return FindByBody_AdapterRepository.init(bodyPortRepositoryJPA, headerPortRepositoryJPA);
    }
}
