package com.companyKLJ.hexagonal.domain.repositories;

import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.infrastructure.repositories.util.CustomException;

import java.util.Optional;

public interface FindByBody_ModelRepository {

    Optional<Body_Model> findById(Long id);
}
