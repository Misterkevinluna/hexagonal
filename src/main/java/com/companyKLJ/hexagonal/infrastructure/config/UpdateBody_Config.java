package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.UpdateBody_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.UpdateBody_Service;
import com.companyKLJ.hexagonal.domain.repositories.UpdateBody_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Body_PortRepositoryJPA;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.SaveBody_AdapterRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.UpdateBody_AdapterRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateBody_Config {

    @Bean
    public UpdateBody_Service updateBody_service(@Qualifier("updateBody_modelRepository") UpdateBody_ModelRepository updateBodyModelRepository){
        return UpdateBody_Service.init(UpdateBody_UseCaseAdapter.init(updateBodyModelRepository));
    }

    @Bean
    public UpdateBody_ModelRepository updateBody_modelRepository(UpdateBody_AdapterRepository updateBodyAdapterRepository){
        return updateBodyAdapterRepository;
    }

    @Bean
    public UpdateBody_AdapterRepository updateBody_adapterRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA, SaveBody_AdapterRepository saveBodyAdapterRepository){
        return UpdateBody_AdapterRepository.init(bodyPortRepositoryJPA, saveBodyAdapterRepository);
    }
}
