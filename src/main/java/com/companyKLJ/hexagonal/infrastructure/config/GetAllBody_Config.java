package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.GetAllBody_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.adapters.GetAllHeader_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.GetAllBody_Service;
import com.companyKLJ.hexagonal.application.services.GetAllHeader_Service;
import com.companyKLJ.hexagonal.domain.repositories.GetAllBody_ModelRepository;
import com.companyKLJ.hexagonal.domain.repositories.GetAllHeader_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Body_PortRepositoryJPA;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.GetAllBody_AdapterRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.GetAllHeader_AdapterRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Header_PortRepositoryJPA;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllBody_Config {

    @Bean
    public GetAllBody_Service getAllBody_service(@Qualifier("getAllBody_modelRepository") GetAllBody_ModelRepository getAllBodyModelRepository){
        return GetAllBody_Service.init(GetAllBody_UseCaseAdapter.init(getAllBodyModelRepository));
    }

    @Bean
    public GetAllBody_ModelRepository getAllBody_modelRepository(GetAllBody_AdapterRepository getAllBodyAdapterRepository){
        return getAllBodyAdapterRepository;
    }

    @Bean
    public GetAllBody_AdapterRepository getAllBody_adapterRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA, Header_PortRepositoryJPA headerPortRepositoryJPA){
        return GetAllBody_AdapterRepository.init(bodyPortRepositoryJPA, headerPortRepositoryJPA);
    }
}
