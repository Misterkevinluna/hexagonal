package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.GetAllHeader_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.GetAllHeader_Service;
import com.companyKLJ.hexagonal.domain.repositories.GetAllHeader_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.GetAllHeader_AdapterRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Header_PortRepositoryJPA;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllHeader_Config {

    @Bean
    public GetAllHeader_Service getAllHeader_service(@Qualifier("getAllHeader_modelRepository")GetAllHeader_ModelRepository getAllHeaderModelRepository){
        return GetAllHeader_Service.init(GetAllHeader_UseCaseAdapter.init(getAllHeaderModelRepository));
    }

    @Bean
    public GetAllHeader_ModelRepository getAllHeader_modelRepository(GetAllHeader_AdapterRepository getAllHeaderAdapterRepository){
        return getAllHeaderAdapterRepository;
    }

    @Bean
    public GetAllHeader_AdapterRepository getAllHeader_adapterRepository(Header_PortRepositoryJPA headerPortRepositoryJPA){
        return GetAllHeader_AdapterRepository.init(headerPortRepositoryJPA);
    }
}
