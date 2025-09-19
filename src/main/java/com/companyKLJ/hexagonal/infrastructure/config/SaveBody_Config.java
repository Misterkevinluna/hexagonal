package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.SaveBody_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.SaveBody_Service;
import com.companyKLJ.hexagonal.domain.repositories.SaveBody_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Body_PortRepositoryJPA;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.SaveBody_AdapterRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveBody_Config {

    @Bean
    public SaveBody_Service saveBody_service(@Qualifier("saveHeader_modelRepository") SaveBody_ModelRepository saveBodyModelRepository){
        return SaveBody_Service.init(SaveBody_UseCaseAdapter.init(saveBodyModelRepository));
    }

    @Bean
    public SaveBody_ModelRepository saveHeader_modelRepository(SaveBody_AdapterRepository saveBodyAdapterRepository){
        return saveBodyAdapterRepository;
    }

    @Bean
    public SaveBody_AdapterRepository saveBody_adapterRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA){
        return SaveBody_AdapterRepository.init(bodyPortRepositoryJPA);
    }
}
