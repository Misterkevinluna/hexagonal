package com.companyKLJ.hexagonal.infrastructure.config;

import com.companyKLJ.hexagonal.application.adapters.DeleteBody_UseCaseAdapter;
import com.companyKLJ.hexagonal.application.services.DeleteBody_Service;
import com.companyKLJ.hexagonal.domain.repositories.DeleteBody_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.Body_PortRepositoryJPA;
import com.companyKLJ.hexagonal.infrastructure.repositories.bloc.DeleteBody_AdapteRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteBody_Config {
    @Bean
    public DeleteBody_Service deleteBody_service(@Qualifier("deleteBody_modelRepository") DeleteBody_ModelRepository deleteBodyModelRepository){
        return DeleteBody_Service.init(DeleteBody_UseCaseAdapter.init(deleteBodyModelRepository));
    }

    @Bean
    public DeleteBody_ModelRepository deleteBody_modelRepository(DeleteBody_AdapteRepository deleteBodyAdapteRepository){
        return deleteBodyAdapteRepository;
    }

    @Bean
    public DeleteBody_AdapteRepository deleteBody_adapteRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA){
        return DeleteBody_AdapteRepository.init(bodyPortRepositoryJPA);
    }
}
